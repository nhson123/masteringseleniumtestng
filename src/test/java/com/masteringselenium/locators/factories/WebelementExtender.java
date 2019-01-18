package com.masteringselenium.locators.factories;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;

/**
 * Package: com.masteringselenium.locators.factories Generated by: Hoang.Son.Nguyen Generated at:
 * 18.01.2019 2019
 */
public class WebelementExtender {
  public static void highlightElement(WebElement element, WebDriver driver) throws InterruptedException {
    for (int i = 0; i < 5; i++) {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript(
          "arguments[0].setAttribute('style',arguments[1]);",
          element,
          "color: black; border: 2px solid yellow;");
      js.executeScript(
          "arguments[0].setAttribute('style',arguments[1]);", element, "");
    }
  }
}
