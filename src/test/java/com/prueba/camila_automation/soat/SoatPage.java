package com.prueba.camila_automation.soat;

import com.prueba.camila_automation.home.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.GeneralUtilities;

public class SoatPage {

  private HomePage homePage;
  private GeneralUtilities generalUtilities;
  private WebDriver driver;
  private WebDriverWait wait;
  private By amountLocator;
  private By licencePlateLocator;
  private By yearOfModelLocator;
  private By brandVehicleLocator;
  private By cylindricalVehicleLocator;
  private By continueButtonLocator;
  private By soatCheckoutLocator;
  private By documentNumberLocator;
  private By namesLocator;
  private By surnameLocator;
  private By secondSurnameLocator;
  private By genderLocator;
  private By femaleLocator;
  private By birthDateLocator;
  private By monthLocator;
  private By yearLocator;
  private By dayLocator;
  private By cellPhoneLocator;
  private By directionLocator;
  private By emailLocator;
  private By checkoutStepThreeLocator;
  private By errorMessageIdLocator;
  private By errorMessageNameLocator;
  private By errorMessageSurnameLocator;
  private By errorMessageGenderLocator;
  private By errorMessageDateBirthLocator;
  private By errorMessagePhoneLocator;
  private By errorMessageAddressLocator;
  private By errorMessageEmailLocator;


  public SoatPage(WebDriver driver) {
    this.driver = driver;
    generalUtilities = new GeneralUtilities();
    homePage = new HomePage(driver);

    wait = new WebDriverWait(driver, 60);
    amountLocator = By.xpath("//*[@id=\"mod-tracker\"]/li[2]/div/div[2]/div/div[2]/div[1]/span[2]");
    licencePlateLocator = By.id("step1Data-licencePlate");
    yearOfModelLocator = By.id("step1Data-yearOfModel");
    brandVehicleLocator = By.id("step1Data-brand");
    cylindricalVehicleLocator = By.id("step1Data-displacement");
    continueButtonLocator = By.xpath("//*[@id=\"mod-tracker\"]/li[2]/div/div[1]/div[2]/div/div[3]/div[1]/button");
    soatCheckoutLocator = By.id("CheckoutStep_1");
    documentNumberLocator = By.id("identification-number");
    namesLocator = By.id("userdata-name");
    surnameLocator = By.id("userdata-lastname1");
    secondSurnameLocator = By.id("userdata-lastname2");
    genderLocator = By.id("select2-userdata-gender-container");
    femaleLocator = By.className("select2-search__field");
    birthDateLocator = By.id("birthDate");
    monthLocator = By.className("ui-datepicker-month");
    yearLocator = By.className("ui-datepicker-year");
    dayLocator = By.className("ui-state-default");
    cellPhoneLocator = By.id("userdata-phone");
    directionLocator = By.id("userdata-direction");
    emailLocator = By.id("userdata-email");
    checkoutStepThreeLocator = By.id("CheckoutStep_3");
    errorMessageIdLocator = By.xpath("//*[@id=\"CheckoutStep_1\"]/div/div/form/div[1]/div[2]/small");
    errorMessageNameLocator = By.xpath("//*[@id=\"CheckoutStep_1\"]/div/div/form/div[2]/div[1]/small");
    errorMessageSurnameLocator = By.xpath("//*[@id=\"CheckoutStep_1\"]/div/div/form/div[2]/div[3]/div/div[1]/small");
    errorMessageGenderLocator = By.xpath("//*[@id=\"CheckoutStep_1\"]/div/div/form/div[3]/div[1]/div/small");
    errorMessageDateBirthLocator = By.xpath("//*[@id=\"CheckoutStep_1\"]/div/div/form/div[3]/div[2]/div/small");
    errorMessagePhoneLocator = By.xpath("//*[@id=\"CheckoutStep_1\"]/div/div/form/div[4]/div[1]/small");
    errorMessageAddressLocator = By.xpath("//*[@id=\"CheckoutStep_1\"]/div/div/form/div[4]/div[2]/small");
    errorMessageEmailLocator = By.xpath("//*[@id=\"CheckoutStep_1\"]/div/div/form/div[5]/div[1]/small");
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
   * Method that get amount soat
   *
   * @return String
   */
  public String getAmountSoat() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(amountLocator));
    return driver.findElement(amountLocator).getText();
  }

  /**
   * Method that get constants amount soat
   *
   * @return String
   */
  public String getConstantsAmountSoat() {
    return getConstants("AMOUNT");
  }

  /**
   * Method steps go to screen
   */
  public void stepsGoToScreen() {
    homePage.sendLicensePlate();
    homePage.clickCheckboxAuthorization();
    homePage.clickWantQuoteButton();
  }

  /**
   * Method that get license plate
   *
   * @return String
   */
  public String getLicensePlate() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(licencePlateLocator));
    return driver.findElement(licencePlateLocator).getAttribute("value");
  }

  /**
   * Method that get constants license plate
   *
   * @return String
   */
  public String getConstantsLicensePlate() {
    return getConstants("LICENSE_PLATE");
  }

  /**
   * Methos that get yer of model
   *
   * @return String
   */
  public String getYearOfModel() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(yearOfModelLocator));
    return driver.findElement(yearOfModelLocator).getAttribute("value");
  }

  /**
   * Method that get constants year of model
   *
   * @return String
   */
  public String getConstantsYearOfModel() {
    return getConstants("YEARMODEL");
  }

  /**
   * Method that get brand vehicle
   *
   * @return String
   */
  public String getBrandVehicle() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(brandVehicleLocator));
    return driver.findElement(brandVehicleLocator).getAttribute("value");
  }

  /**
   * Method that get constants brand vehicle
   *
   * @return String
   */
  public String getConstantsBrandVehicle() {
    return getConstants("BRANDVEHICLE");
  }

  /**
   * Method that get cylindrical vehicle
   *
   * @return String
   */
  public String getCylindricalVehicle() {
    return driver.findElement(cylindricalVehicleLocator).getAttribute("value");
  }

  /**
   * Method that get constants cylindrica vehicle
   *
   * @return String
   */
  public String getConstantsCylindricalVehicle() {
    return getConstants("CYLINDRICAL");
  }

  /**
   * Method that click button continue
   */
  public void clickButtonContinue() {
    wait.until(ExpectedConditions.elementToBeClickable(continueButtonLocator));
    driver.findElement(continueButtonLocator).click();
  }

  /**
   * Method that soatCheckout
   *
   * @return boolean
   */
  public boolean soatCheckout() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(soatCheckoutLocator));
    return driver.findElement(soatCheckoutLocator).isDisplayed();
  }

  /**
   * Method that send identification number
   */
  public void sendIdentificationNumber() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(documentNumberLocator));
    WebElement identificationNumber = driver.findElement(documentNumberLocator);
    identificationNumber.sendKeys(getConstants("IDENTIFICATION_NUMBER"));
  }

  /**
   * Method that send names
   */
  public void sendNames() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(namesLocator));
    WebElement names = driver.findElement(namesLocator);
    names.sendKeys(getConstants("NAMES"));
  }

  /**
   * Method that send Surname
   */
  public void sendSurname() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(surnameLocator));
    WebElement surname = driver.findElement(surnameLocator);
    surname.sendKeys(getConstants("SURNAME"));
  }

  /**
   * Method that send second surname
   */
  public void sendSecondSurname() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(secondSurnameLocator));
    WebElement secondSurname = driver.findElement(secondSurnameLocator);
    secondSurname.sendKeys(getConstants("SECOND_SURNAME"));
  }

  /**
   * Method that click gender
   */
  public void clickGender() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(genderLocator));
    driver.findElement(genderLocator).click();
  }

  /**
   * Method that click female
   */
  public void clickFemale() {
    driver.findElement(femaleLocator).sendKeys("Femenino");
    driver.findElement(femaleLocator).sendKeys(Keys.ENTER);
  }

  /**
   * Method click birth date
   */
  public void clickBirthDate() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(birthDateLocator));
    driver.findElement(birthDateLocator).click();
  }

  /**
   * Method that click month
   */
  public void clickMonth() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(monthLocator));
    driver.findElement(monthLocator).click();
  }

  /**
   * Method that click year
   */
  public void clickYear() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(yearLocator));
    driver.findElement(yearLocator).click();
  }

  /**
   * Method that click day
   */
  public void clickDay() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(dayLocator));
    driver.findElement(dayLocator).click();
  }

  /**
   * Method that send cell phone
   */
  public void sendCellPhone() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(cellPhoneLocator));
    WebElement cellPhone = driver.findElement(cellPhoneLocator);
    cellPhone.sendKeys(getConstants("CELL_PHONE"));
  }

  /**
   * Method that send direction
   */
  public void sendDirection() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(directionLocator));
    WebElement direction = driver.findElement(directionLocator);
    direction.sendKeys(getConstants("DIRECTION"));
  }

  /**
   * Method that send email
   */
  public void sendEmail() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(emailLocator));
    WebElement email = driver.findElement(emailLocator);
    email.sendKeys(getConstants("EMAIL"));
    email.sendKeys(Keys.ENTER);
  }


  /**
   * Method that checkout step three
   *
   * @return boolean
   */
  public boolean checkoutStepThree() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutStepThreeLocator));
    return driver.findElement(checkoutStepThreeLocator).isDisplayed();
  }

  /**
   * Method that send  empty fields
   */
  public void sendEmptyFields() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(emailLocator));
    WebElement email = driver.findElement(emailLocator);
    email.sendKeys(Keys.ENTER);
  }


  /**
   * Method that get error id
   *
   * @return boolean
   */
  public boolean getErrorId(String error) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageIdLocator));
    return driver.findElement(errorMessageIdLocator).getText().contains(error);
  }

  /**
   * Method that get constants error id
   *
   * @return String
   */
  public String getConstantsErrorId() {
    return getConstants("ERRORID");
  }

  /**
   * Method that get error name
   *
   * @return String
   */
  public String getErrorName() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageNameLocator));
    return driver.findElement(errorMessageNameLocator).getText();
  }

  /**
   * Method that get constants error name
   *
   * @return String
   */
  public String getConstantsErrorName() {
    return getConstants("ERROR_NAME");
  }

  /**
   * Method that get error surname
   *
   * @return String
   */
  public String getErrorSurname() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageSurnameLocator));
    return driver.findElement(errorMessageSurnameLocator).getText();
  }

  /**
   * Method that get constants error surname
   *
   * @return String
   */
  public String getConstantsErrorSurname() {
    return getConstants("ERROR_SURNAME");
  }

  /**
   * Method that get error gender
   *
   * @return boolean
   */
  public boolean getErrorGender(String error) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageGenderLocator));
    return driver.findElement(errorMessageGenderLocator).getText().contains(error);
  }

  /**
   * Method that get constants error gender
   *
   * @return String
   */
  public String getConstantsErrorGender() {
    return getConstants("ERROR_GENDER");
  }

  /**
   * Method that get error birth date
   *
   * @return String
   */
  public String getErrorBirthDate() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageDateBirthLocator));
    return driver.findElement(errorMessageDateBirthLocator).getText();
  }

  /**
   * Method that get constants error birth date
   *
   * @return String
   */
  public String getConstantsErrorBirthDate() {
    return getConstants("ERROR_BIRTHDATE");
  }

  /**
   * Metho that get error cell phone
   *
   * @return boolean
   */
  public boolean getErrorCellPhone(String error) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessagePhoneLocator));
    return driver.findElement(errorMessagePhoneLocator).getText().contains(error);
  }

  /**
   * Method that get constants error cell phone
   *
   * @return String
   */
  public String getConstantsErrorCellPhone() {
    return getConstants("ERROR_CELLPHONE");
  }

  /**
   * Method that get error address
   *
   * @return boolean
   */
  public boolean getErrorAddress(String error) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageAddressLocator));
    return driver.findElement(errorMessageAddressLocator).getText().contains(error);
  }

  /**
   * Method that get constants error address
   *
   * @return String
   */
  public String getConstantsErrorAddress() {
    return getConstants("ERROR_ADDRESS");
  }

  /**
   * Method that get error email
   *
   * @return String
   */
  public String getErrorEmail() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageEmailLocator));
    return driver.findElement(errorMessageEmailLocator).getText();
  }

  /**
   * Method that get constants error email
   *
   * @return String
   */
  public String getConstantsErrorEmail() {
    return getConstants("ERROR_EMAIL");
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
   * Method that take screenshot
   *
   * @param archiveName
   */
  public void getScreenshot(String archiveName) {
    generalUtilities.takeSnapShot(driver,archiveName) ;

  }

  /**
   * Steps send data
   */
  public void stepsSendData(){
    clickButtonContinue();
    sendIdentificationNumber();
    sendNames();
    sendSurname();
    sendSecondSurname();
    clickGender();
    clickFemale();
    clickBirthDate();
    clickMonth();
    clickYear();
    clickDay();
    sendCellPhone();
    sendDirection();
    sendEmail();
  }

}
