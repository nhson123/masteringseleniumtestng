package com.masteringselenium.junitTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class dataDrivenJUnitTest {

  private String geschlecht;
  private int gewicht;
  private int groeße;
  private String bmi;

  private static WebDriver driver;

  public dataDrivenJUnitTest(String geschlecht, int gewicht, int groeße, String bmi) {

    this.geschlecht = geschlecht;
    this.gewicht = gewicht;
    this.groeße = groeße;
    this.bmi = bmi;
  }

  @Parameters
  public static Collection testData() {
    return Arrays.asList(
        new Object[][] {
          {"man", 100, 200, "Übergewicht"},
          {"frau", 50, 155, "Normalgewicht"}
        });
  }

  @Before
  public void setUp() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.online-rechner.at/bmi");
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void testFacebookRegistration() throws Exception {

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
