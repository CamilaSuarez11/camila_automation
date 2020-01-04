package com.prueba.camila_automation.home;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.BaseConfigSelenium;

public class HomeTest extends BaseConfigSelenium {

  private HomePage homePage;
  private SoftAssertions softAssertions;

  /**
   * Check success flux send license plate
   */
  @Test
  public void successFluxSoat() {
    homePage.displayedBoxSoat();
    homePage.sendLicensePlate();
    homePage.clickCheckboxAuthorization();
    softAssertions.assertThat(homePage.displayedGiftLoading()).isTrue();
    homePage.clickWantQuoteButton();
    softAssertions.assertThat(homePage.displayedGiftLoading()).isTrue();
    softAssertions.assertThat(homePage.displayedScreenAboutVehicle()).isTrue();
    homePage.getScreenshot("successFluxSoat");
    softAssertions.assertAll();
  }

  /**
   * Check error authorization
   */
  @Test
  public void errorAuthorization() {
    homePage.sendLicensePlate();
    homePage.waitInvisibilityGiftLoading();
    homePage.clickWantQuoteButton();
    softAssertions.assertThat(homePage.displayedErrorAuthorization()).isTrue();
    homePage.getScreenshot("errorAuthorization");
    softAssertions.assertAll();
  }

  @BeforeEach
  public void initialize() {
    homePage = new HomePage(driver);
    navigateTo(homePage.getBaseURL());

    softAssertions = new SoftAssertions();
  }

}
