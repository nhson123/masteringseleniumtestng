package com.masteringselenium.dataDrivenTest;

import com.masteringselenium.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Package: com.masteringselenium.dataDrivenTest Generated by: Hoang.Son.Nguyen Generated at:
 * 15.01.2019 2019
 */
public class dataDrivenTestNGWD extends DriverFactory {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();

  @DataProvider
  public Object[][] testData() {
    return new Object[][] {
      new Object[] {"man", 100, 200, "Übergewicht"},
      new Object[] {"frau", 50, 155, "Normalgewicht"},
    };
  }

  @Test(dataProvider = "testData")
  public void testBMI(String geschlecht, int gewicht, int groeße, String bmi) throws Exception {
    driver = DriverFactory.getDriver();
    driver.manage().window().maximize();
    driver.get("https://www.online-rechner.at/bmi");
    WebElement berechnen = null;
    WebDriverWait wait = new WebDriverWait(driver, 20);
    try {
      berechnen =
          wait.until(
              ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Berechnen']")));
    } catch (TimeoutException ex) {
      Assert.fail("Not loaded");
    }
    // set sex
    if (geschlecht.equalsIgnoreCase("man")) {
      WebElement geschlechtField = driver.findElement(By.id("g_mann"));
      if (!geschlechtField.isSelected()) {
        geschlechtField.click();
      }
    }

    // set first name
    WebElement gewichtField = driver.findElement(By.id("gewicht"));
    gewichtField.clear();
    gewichtField.sendKeys(gewicht + "");

    // set größe
    WebElement groeßeField = driver.findElement(By.id("groesse"));
    groeßeField.clear();
    groeßeField.sendKeys(groeße + "");

    // berechnen
    if (berechnen != null) {
      berechnen.click();
      System.out.println("BMI berechung");
    }

    try {
      WebElement bmiField =
          wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='bmi_frm']")));
      Assert.assertTrue(bmiField.getText().contains(bmi));
    } catch (TimeoutException ex) {
      Assert.fail("Not found");
    }
  }
}
