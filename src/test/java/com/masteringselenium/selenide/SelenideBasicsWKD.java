package com.masteringselenium.selenide;

import com.codeborne.selenide.*;
import com.masteringselenium.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

/**
 * Package: com.masteringselenium.selenide Generated by: Hoang.Son.Nguyen Generated at: 21.01.2019
 * 2019 https://www.seleniumeasy.com/test/
 */
public class SelenideBasicsWKD extends DriverFactory {
  @BeforeTest
  public void setUp() throws Exception {
    WebDriverRunner.setWebDriver(DriverFactory.getDriver());
    open("https://www.seleniumeasy.com/test/");
  }

  @Test
  public void testSeleniumBasics() throws InterruptedException {
    // cssSelector by ID
    WebElement slogan = $("#site-slogan").shouldBe(Condition.visible);
    // $$ response a Collection
    $$(By.xpath("//div")).shouldHave(size(63));
    $$(By.xpath("//div")).filter(Condition.visible).shouldHave(size(39));
    System.out.println("Anzahl: " + $$(By.xpath("//div")).filter(Condition.visible).size());
    // findBy full text
    $(byText("Make Yourself an Expert")).shouldBe(Condition.visible);
    // find by partial text
    $(withText("an expert will be fun"))
        .shouldHave(text("Becoming an expert will be fun and exciting."));
    // find parent
    $(By.xpath("//img[@class='cbt']"))
        .parent()
        .parent()
        .shouldHave(attribute("class", "top-banner col-md-6"));
    // find child
    $(By.xpath("//div[@class='top-banner col-md-6']"))
        .find(
            By.xpath(
                "//a[@href='https://crossbrowsertesting.com/?utm_source=seleniumeasy&utm_medium=da&utm_campaign=sedemo']"))
        .shouldBe(visible);
    SelenideElement a = $(byXpath("//i[@class='fa fa-angle-right']")).shouldBe(visible);
    SelenideElement inputForm =
        $(byXpath(
                "//body/div[@class='container-fluid']/div[@class='row']/nav[@class='navbar navbar-default']/div[@class='container']/div[@id='navbar-brand-centered']/ul[@class='nav navbar-nav']/li[1]/a[1]"))
            .doubleClick();
    $(byXpath(
            "//body/div[@class='container-fluid']/div[@class='row']/nav[@class='navbar navbar-default']/div[@class='container']/div[@id='navbar-brand-centered']/ul[@class='nav navbar-nav']/li[2]/a[1]"))
        .contextClick();
    $(byXpath("//span[@class='round-tabs one']")).hover();
    System.out.println(
        "hover/tool tip text: "
            + $(byXpath("//a[@id='home_bar']")).getAttribute("data-original-title"));
    $(byXpath("//ol[@class='carousel-indicators']//li[4]")).click();
    $(byXpath("//a[@id='btn_basic_example']")).shouldBe(visible).click();
    $(byXpath("//a[@class='list-group-item'][contains(text(),'Simple Form Demo')]"))
        .shouldBe(visible)
        .click();
    // send key
    $(byXpath("//input[@id='user-message']")).shouldBe(enabled).sendKeys("test");
    // click
    $(byXpath("//button[contains(text(),'Show Message')]")).shouldBe(enabled).click();
    assertTrue($("#display").getText().equals("test"));
    // drag and drop
    $(byXpath(
            "//body/div[@class='container-fluid']/div[@class='row']/nav[@class='navbar navbar-default']/div[@class='container']/div[@id='navbar-brand-centered']/ul[@class='nav navbar-nav navbar-right']/li[4]/a[1]"))
        .dragAndDropTo($(byXpath("//a[contains(text(),'Demo Home')]")));
    // sumary
    $(byXpath("//input[@id='sum1']")).sendKeys("4");
    $(byXpath("//input[@id='sum2']")).sendKeys("4");
    $(byXpath("//button[contains(text(),'Get Total')]")).shouldBe(enabled).click();
    assertTrue($("#displayvalue").getText().equals("8"));

    //input form
    $(byXpath("//li[@class='tree-branch']//a[@href='#'][contains(text(),'Input Forms')]")).click();
    // checkbox demo
    $(byCssSelector("#treemenu > li > ul > li:nth-child(1) > ul > li:nth-child(2) > a"))
        .shouldBe(visible)
        .click();
    $(byXpath("//div[@class='col-md-6 text-left']//div[1]//div[2]//div[1]//label[1]"))
        .shouldBe(visible);
    Thread.sleep(4000);


  }
}
