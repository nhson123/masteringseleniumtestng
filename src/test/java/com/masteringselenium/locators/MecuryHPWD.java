package com.masteringselenium.locators;

import com.masteringselenium.DriverFactory;
import com.masteringselenium.locators.factories.MecuryHPFactory;
import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/** Package: PACKAGE_NAME Generated by: Hoang.Son.Nguyen Generated at: 08.01.2019 2019 */
public class MecuryHPWD extends DriverFactory {
  private Logger LOGGER;
  MecuryHPFactory mecuryHPFactory;
  WebDriver driver;

  @BeforeMethod
  public void setUp() throws Exception {
    LOGGER = Logger.getLogger(this.getClass().getName());
    driver = DriverFactory.getDriver();
  }

  @Test
  public void MerucyHPCheck() throws Exception {
    driver.navigate().to("http://newtours.demoaut.com");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    mecuryHPFactory = new MecuryHPFactory();
    LOGGER.info(
        "Logger Name: " + LOGGER.getName() + ", WebElements: " + mecuryHPFactory.countByTagName());
    assertTrue(mecuryHPFactory.countByTagName() >= 1);
    assertTrue(mecuryHPFactory.logoDisplayed());
    assertTrue(mecuryHPFactory.mouseOutSize()<12);
    assertTrue(mecuryHPFactory.htmlVerDisplay());
    assertTrue(mecuryHPFactory.bannerDisplay());
    assertTrue(mecuryHPFactory.destinationsDisplay());
    assertTrue(mecuryHPFactory.contactDisplay());
    assertTrue(mecuryHPFactory.lasVegasDisplay());
    assertTrue(mecuryHPFactory.registerDisplay());
    assertTrue(mecuryHPFactory.linksDisplay());
    assertTrue(mecuryHPFactory.rightPaneDisplay());
    assertTrue(mecuryHPFactory.toChicagoDisplay());
    assertTrue(mecuryHPFactory.sanfransiscoDisplay());
  }
}
