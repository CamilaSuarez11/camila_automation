package utilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseConfigSelenium {

  protected WebDriver driver;
  protected WebDriverWait wait;

  @BeforeEach
  public void init() throws IOException {
    configCapabilities("2");
  }

  @AfterEach
  public void teardown() {
    driver.close();
    driver.quit();
  }

  public void navigateTo(String url) {
    driver.get(url);
  }

  /**
   * @param flag values required = WinChrome (Chrome in Windows) MacChrome ( Chrome in Mac)
   * WinFirefox(Firefox in Windows) MacFirefox(Firefox in Mac
   */
  public void configCapabilities(String flag) throws IOException {
    ChromeOptions options = new ChromeOptions();
    options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));


    if (flag == "WinChrome") {
      System.setProperty("webdriver.chrome.driver", "chromedriverWIN.exe");
      driver = new ChromeDriver(options);
    } else if (flag == "MacChrome") {
      System.setProperty("webdriver.chrome.driver", "chromedriver");
      driver = new ChromeDriver(options);
    } else if (flag == "MacFirefox") {
      System.setProperty("webdriver.firefox.driver", "geckodriver");
      driver = new FirefoxDriver();
    } else if (flag == "WinFirefox") {
      System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
      driver = new FirefoxDriver();
    }else {
      DesiredCapabilities dc = DesiredCapabilities.chrome();
      driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
    }


    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().fullscreen();
    wait = new WebDriverWait(driver, 60);
  }

}
