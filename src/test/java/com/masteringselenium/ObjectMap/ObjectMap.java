package com.masteringselenium.ObjectMap;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Package: com.masteringselenium.ObjectMap Generated by: Hoang.Son.Nguyen Generated at: 18.01.2019
 * 2019
 */
public class ObjectMap {
  Properties properties;
  private Logger LOOGER = Logger.getLogger(this.getClass().getName());

  public ObjectMap(String mapFile) {
    properties = new Properties();
    try {
      FileInputStream in = new FileInputStream(mapFile);
      properties.load(in);
    } catch (IOException e) {
      LOOGER.warning(e.getMessage());
    }
  }

  public By getLocator(String logicalElementName) throws Exception {
    // read value using logical name al Key
    String locator = properties.getProperty(logicalElementName);

    // split the value wich contains locator type and value
    String locatorType = locator.split(">")[0];
    String locatorValue = locator.split(">")[1];

    // return instance of By class based type of locator
    if (locatorType.toLowerCase().equals("id")) {
        System.out.println(By.id(locatorValue).toString());
      return By.id(locatorValue);
    } else if (locatorType.toLowerCase().equals("name")) return By.name(locatorValue);
    else if ((locatorType.toLowerCase().equals("classname"))
        || (locatorType.toLowerCase().equals("class"))) return By.className(locatorValue);
    else if ((locatorType.toLowerCase().equals("tagname"))
        || (locatorType.toLowerCase().equals("tag"))) return By.className(locatorValue);
    else if ((locatorType.toLowerCase().equals("linktext"))
        || (locatorType.toLowerCase().equals("link"))) return By.linkText(locatorValue);
    else if ((locatorType.toLowerCase().equals("cssselector"))
        || (locatorType.toLowerCase().equals("css"))) return By.cssSelector(locatorValue);
    else if (locatorType.toLowerCase().equals("xpath")) return By.xpath(locatorValue);
    else throw new Exception("Locator type '" + locatorType + "' not defined!!");
  }
}
