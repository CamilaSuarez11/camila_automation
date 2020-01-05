package com.prueba.camila_automation.home;

import java.security.Key;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.GeneralUtilities;

public class HomePage {

  private WebDriver driver;
  private GeneralUtilities generalUtilities;
  private WebDriverWait wait;
  private By boxSoatLocator;
  private By licensePlateLocator;
  private By wantQuoteButtonLocator;
  private By giftLoadingLocator;
  private By checkboxAuthorizationLoctor;
  private By screenAboutVehicleLocator;
  private By errorAuthorizationLocator;

  public HomePage(WebDriver driver) {
    generalUtilities = new GeneralUtilities();
    this.driver = driver;
    wait = new WebDriverWait(driver, 60);
    boxSoatLocator = By.className("uk-container");
    licensePlateLocator = By.id("licence-plate");
    wantQuoteButtonLocator = By.className("uk-width-1-1");
    giftLoadingLocator = By.className("gift-loding");
    checkboxAuthorizationLoctor = By.className("material-checkbox");
    screenAboutVehicleLocator = By.id("SoapJourney");
    errorAuthorizationLocator = By.xpath("//*[@id=\"mod-tracker\"]/li[1]/div[1]/div[5]/div/div/div[2]/form/div/div/label[1]/div/small");
  }

  /**
   * Method that get url
   *
   * @return boolean
   */
  public String getBaseURL() {
    return getConstants("BASEURL");
  }

  /**
   * Method that displayed box soat
   *
   * @return boolean
   */
  public boolean displayedBoxSoat() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(boxSoatLocator));
    return driver.findElement(boxSoatLocator).isDisplayed();
  }

  /**
   * Method that send license plate
   */
  public void sendLicensePlate() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(licensePlateLocator));
    WebElement licenseElement = driver.findElement(licensePlateLocator);
    licenseElement.sendKeys(getConstants("LICENSE_PLATE"));
    licenseElement.sendKeys(Keys.TAB);
  }

  /**
   * Method that click checkbox authorization
   */
  public void clickCheckboxAuthorization() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(checkboxAuthorizationLoctor));
    driver.findElement(checkboxAuthorizationLoctor).click();
  }

  /**
   * Method that click want quote button
   */
  public void clickWantQuoteButton() {
    wait.until(ExpectedConditions.elementToBeClickable(wantQuoteButtonLocator));
    driver.findElement(wantQuoteButtonLocator).click();

    if(!driver.findElement(errorAuthorizationLocator).isDisplayed() || !driver.findElement(screenAboutVehicleLocator).isDisplayed() ){
      driver.findElement(wantQuoteButtonLocator).click();
    }
  }

  /**
   * Method that displayed gift loading
   *
   * @return boolean
   */
  public boolean displayedGiftLoading() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(giftLoadingLocator));
    return driver.findElement(giftLoadingLocator).isDisplayed();
  }

  /**
   * Method that displayed screen about vehicle
   *
   * @return boolean
   */
  public boolean displayedScreenAboutVehicle() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(screenAboutVehicleLocator));
    return driver.findElement(screenAboutVehicleLocator).isDisplayed();
  }

  /**
   * Method that displayed error authorization
   *
   * @return boolean
   */
  public boolean displayedErrorAuthorization() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(errorAuthorizationLocator));
    return driver.findElement(errorAuthorizationLocator).isDisplayed();
  }

  /**
   * Method that get properties constants
   *
   * @return string
   */
  public String getConstants(String constants) {
    generalUtilities.getProperties();
    return generalUtilities.loadConstants.getProperty(constants);
  }

  /**
   * Method that invisibility gift loading
   */
  public void waitInvisibilityGiftLoading() {
    wait.until(ExpectedConditions.invisibilityOfElementLocated(giftLoadingLocator));
  }

  /**
   * Method that take screenshot
   *
   * @param archiveName
   */
  public void getScreenshot(String archiveName) {
    generalUtilities.takeSnapShot(driver,archiveName) ;

  }
}
