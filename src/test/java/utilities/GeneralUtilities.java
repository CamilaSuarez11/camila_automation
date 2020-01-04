package utilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GeneralUtilities extends BaseConfigSelenium {

  public Properties loadConstants = new Properties();

  /**
   * Method that load and get properties file.
   */
  public void getProperties() {
    ClassLoader loader = getClass().getClassLoader();

    try {

      InputStream inputStreamConstants = loader.getResourceAsStream("constants.properties");

      loadConstants.load(inputStreamConstants);

    } catch (IOException exc) {
      throw new RuntimeException("Properties files not found", exc);
    }

  }

  /**
   * Method that sleep a specific time.
   */
  public  void waitTime(int time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


  /**
   * Method that take screenshot
   *
   * @param webdriver
   * @param archiveName
   */
  public void takeSnapShot(WebDriver webdriver, String archiveName) {
    try {
      //Convert web driver object to TakeScreenshot
      String systemDir = System.getProperty("user.dir");
      TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

      //Call getScreenshotAs method to create image file

      File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

      //Move image file to new destination

      File DestFile = new File(systemDir + "/testOutFile");

      FileUtils.copyFile(SrcFile, new File(DestFile + "/" + archiveName + ".png"));

    } catch (Exception exc) {
      throw new RuntimeException("Route not found", exc);
    }
  }

  /**
   * Method to check if an element is visible on the screen.
   *
   * @return boolean
   */
  public boolean existElement(By id, WebDriver webDriver) {
    driver = webDriver;
    try {
      driver.findElement(id);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

}

