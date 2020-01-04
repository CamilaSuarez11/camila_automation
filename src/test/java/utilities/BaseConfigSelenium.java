package utilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class  BaseConfigSelenium {

  protected WebDriver driver;
  private static ChromeDriverService service;
  protected WebDriverWait wait;

  @BeforeEach
  public void init() throws IOException {
    configCapabilities ("2");
    service = new ChromeDriverService.Builder()
        .usingDriverExecutable(new File("chromedriver"))
        .usingAnyFreePort()
        .build();
    service.start();
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
   * @param flag values required = WinChrome (Chrome in Windows) MacChrome ( Chrome in Mac) WinFirefox(Firefox in Windows) MacFirefox(Firefox in Mac
   * @throws MalformedURLException
   */
  public void configCapabilities(String flag) throws MalformedURLException {
    ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
    	options.addArguments("--headless");

    if(flag == "WinChrome") {
      System.setProperty("webdriver.chrome.driver", "chromedriverWIN.exe");
      driver = new ChromeDriver(options);
    } else if(flag == "MacChrome") {
      System.setProperty("webdriver.chrome.driver", "chromedriver");

      driver = new ChromeDriver(options);
    } else if(flag == "MacFirefox") {
      System.setProperty("webdriver.firefox.driver", "geckodriver");
      driver = new FirefoxDriver();
    }else if(flag == "WinFirefox") {
      System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
      driver = new FirefoxDriver();
    }else {
      driver = new RemoteWebDriver(service.getUrl(), new ChromeOptions());
    }

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().fullscreen();
     wait = new WebDriverWait(driver, 60);
  }

}
