package com.masteringselenium.locators.factories;

import com.masteringselenium.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Package: com.masteringselenium.locators.factories Generated by: Hoang.Son.Nguyen Generated at:
 * 08.01.2019 2019
 */
public class MecuryHPFactory {
  public MecuryHPFactory() throws Exception {
    PageFactory.initElements(DriverFactory.getDriver(), this);
  }
  // Xpath by name
  @CacheLookup
  @FindBy(how = How.TAG_NAME, using = "a")
  List<WebElement> byTagName;

  public int countByTagName() {
    return byTagName.size();
  }

  // Xpath by ChromePath
  @CacheLookup
  @FindBy(how = How.XPATH, using = "//input[@name='password']")
  WebElement pwd;

  public boolean pwdSisplaed() {
    return pwd.isDisplayed();
  }

  // Xpath by CSS Sellector
  @CacheLookup
  @FindBy(
      how = How.CSS,
      using =
          "tbody:nth-child(1) tr:nth-child(1) td:nth-child(1) p:nth-child(1) > img:nth-child(1)")
  WebElement logo;

  public boolean logoDisplayed() {
    return logo.isDisplayed();
  }

  // Css by class of Element
  @CacheLookup
  @FindBy(how = How.CSS, using = ".mouseOut")
  List<WebElement> mouseOut;

  public int mouseOutSize() {
    for (WebElement e : mouseOut) {
      System.out.println(e.getAttribute("onmouseout"));
    }
    return mouseOut.size();
  }

  // CSS using any Attribute
  @CacheLookup
  @FindBy(how = How.CSS, using = "[src='/images/nav/html.gif']")
  WebElement htmlVersion;

  public boolean htmlVerDisplay() {
    return htmlVersion.isDisplayed();
  }

  // Xpath by any Attribute
  @CacheLookup
  @FindBy(how = How.XPATH, using = "//img[@src='/images/nav/html.gif']")
  WebElement banner;

  public boolean bannerDisplay() {
    return banner.isDisplayed();
  }

  // Xpath by many Attribute incl. and, or
  @CacheLookup
  @FindBy(
      how = How.XPATH,
      using = "//img[@src='/images/hdr_destinations.gif' and @alt ='Desinations']")
  WebElement destinations;

  public boolean destinationsDisplay() {
    return destinations.isDisplayed();
  }

  // Xpath by many Attribute with * an containt text
  @CacheLookup
  @FindBy(how = How.XPATH, using = "//*[contains(text(),'CONTACT')]")
  WebElement contact;

  public boolean contactDisplay() {
    return contact.isDisplayed();
  }

  // Xpath by many Attribute with containt text
  @CacheLookup
  @FindBy(how = How.XPATH, using = "//font[contains(text(),'to Las Vegas')]")
  WebElement lasVegas;

  public boolean lasVegasDisplay() {
    return lasVegas.isDisplayed();
  }

  // contains partial Attribute
  @CacheLookup
  @FindBy(how = How.XPATH, using = "//img[contains(@src,'/images/hdr_register')]")
  WebElement register;

  public boolean registerDisplay() {
    return register.isDisplayed();
  }

  // locate element through parents, tr[11] = 11. tr-element in tbody
  @CacheLookup
  @FindBy(how = How.XPATH, using = "//tbody/tr[11]/td/img[contains(@src,'links')]")
  WebElement links;

  public boolean linksDisplay() {
    return links.isDisplayed();
  }

  // locate element through childs, tr[11] = 11. tr-element in tbody
  @CacheLookup
  @FindBy(
      how = How.XPATH,
      using = "//tbody/tr[11]/td/img[contains(@src,'links')]/parent::td/parent::tr/parent::tbody")
  WebElement rightPane;

  public boolean rightPaneDisplay() {
    return rightPane.isDisplayed();
  }

  // locate element through sibling, next sibling
  @CacheLookup
  @FindBy(
          how = How.XPATH,
          using = "//td//td//td[@width='273']//tbody//tbody//tr[3]//following-sibling::tr")
  WebElement toChicago;

  public boolean toChicagoDisplay() {
    return toChicago.isDisplayed();
  }

  // locate element through sibling, preceding sibling
  @CacheLookup
  @FindBy(
          how = How.XPATH,
          using = "//td//td//td[@width='273']//tbody//tbody//tr[4]/preceding-sibling::tr")
  WebElement sanfransisco;

  public boolean sanfransiscoDisplay() {
    return sanfransisco.isDisplayed();
  }
}
