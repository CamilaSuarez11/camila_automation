package com.prueba.camila_automation.soat;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utilities.BaseConfigSelenium;

public class SoatTest extends BaseConfigSelenium {

  private SoatPage soatPage;
  private SoftAssertions softAssertions;

  /**
   * Check validate features vehicle
   */
  @Test
  public void validateFeaturesVehicle() {

    softAssertions.assertThat(soatPage.getAmountSoat()).isEqualTo(soatPage.getConstantsAmountSoat());
    softAssertions.assertThat(soatPage.getLicensePlate()).isEqualTo(soatPage.getConstantsLicensePlate());
    softAssertions.assertThat(soatPage.getYearOfModel()).isEqualTo(soatPage.getConstantsYearOfModel());
    softAssertions.assertThat(soatPage.getBrandVehicle()).isEqualTo(soatPage.getConstantsBrandVehicle());
    softAssertions.assertThat(soatPage.getCylindricalVehicle()).isEqualTo(soatPage.getConstantsCylindricalVehicle());

    soatPage.clickButtonContinue();

    softAssertions.assertThat(soatPage.soatCheckout()).isTrue();

    soatPage.getScreenshot("validateFeatureVehicle");

    softAssertions.assertAll();
  }

  /**
   * Check validate data
   */
  @Test
  public void validateData() {

    soatPage.stepsSendData();

    softAssertions.assertThat(soatPage.checkoutStepThree()).isTrue();

    soatPage.getScreenshot("validateData");

    softAssertions.assertAll();
  }

  /**
   * Check validate empty errors
   */
  @Test
  public void validateEmptyErrors() {

    soatPage.clickButtonContinue();
    soatPage.sendEmptyFields();

    softAssertions.assertThat(soatPage.getErrorId(soatPage.getConstantsErrorId())).isTrue();
    softAssertions.assertThat(soatPage.getErrorName()).isEqualTo(soatPage.getConstantsErrorName());
    softAssertions.assertThat(soatPage.getErrorSurname()).isEqualTo(soatPage.getConstantsErrorSurname());
    softAssertions.assertThat(soatPage.getErrorGender(soatPage.getConstantsErrorGender())).isTrue();
    softAssertions.assertThat(soatPage.getErrorBirthDate()).isEqualTo(soatPage.getConstantsErrorBirthDate());
    softAssertions.assertThat(soatPage.getErrorCellPhone(soatPage.getConstantsErrorCellPhone())).isTrue();
    softAssertions.assertThat(soatPage.getErrorAddress(soatPage.getConstantsErrorAddress())).isTrue();
    softAssertions.assertThat(soatPage.getErrorEmail()).isEqualTo(soatPage.getConstantsErrorEmail());

    soatPage.getScreenshot("validateEmptyErrors");

    softAssertions.assertAll();
  }

  @BeforeEach
  public void initialize() {
    soatPage = new SoatPage(driver);
    navigateTo(soatPage.getBaseURL());
    soatPage.stepsGoToScreen();

    softAssertions = new SoftAssertions();
  }

}
