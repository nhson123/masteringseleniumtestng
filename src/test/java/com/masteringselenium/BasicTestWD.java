package com.masteringselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/** Package: PACKAGE_NAME Generated by: Hoang.Son.Nguyen Generated at: 31.12.2018 2018 */
public class BasicTestWD extends DriverFactory {

  private ExpectedCondition<Boolean> pageTitleStartsWith(final String searchString) {
    return driver -> driver.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
  }

  private void googleExampleThatSearchesFor(final String searchString) throws Exception {

    WebDriver driver = DriverFactory.getDriver();
    // If your page does not load within 15 seconds, a WebDriverException  will be thrown.
    driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    // Selenium  will wait for up to 15 seconds for an element to appear in  the DOM when trying to
    // find it.
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    driver.get("http://www.google.com");

    // Explicit wait until max 20 seconds with recheck every 500 miliseconds
    WebDriverWait exWait = new WebDriverWait(driver, 20, 500);
    WebElement searchField =
        exWait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
    // no explicit wait  WebElement searchField = driver.findElement(By.name("q"));

    searchField.clear();
    searchField.sendKeys(searchString);

    System.out.println("this Page title is: " + driver.getTitle());

    searchField.submit();

    WebDriverWait wait = new WebDriverWait(driver, 10, 100);
    wait.until(pageTitleStartsWith(searchString));

    System.out.println("the Page title is: " + driver.getTitle());

      /* Fluent wait
      List<Class<? extends Throwable>> exceptionsToIgnore =
              new ArrayList<Class<? extends Throwable>>() {
                  {
                      add(NoSuchElementException.class);
                      add(StaleElementReferenceException.class);
                  }
              };
      Wait<WebDriver> fluentWait =
              new FluentWait<WebDriver>(driver)
                      .withTimeout(10, TimeUnit.SECONDS)
                      .pollingEvery(500, TimeUnit.MILLISECONDS)
                      .ignoreAll(exceptionsToIgnore)
                      .withMessage("The message you will see in if a TimeoutException is thrown");
      WebElement logo = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@id='hplogo']")));
*/

  }

  @Test
  public void googleCheeseExample() throws Exception {
    googleExampleThatSearchesFor("Cheese!");
  }

  @Test
  public void googleMilkExample() throws Exception {
    googleExampleThatSearchesFor("Milk!");
  }

}
