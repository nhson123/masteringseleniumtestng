package com.masteringselenium.locatorsWebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Package: com.masteringselenium.locators Generated by: Hoang.Son.Nguyen Generated at: 15.01.2019
 * 2019
 */
public class WebTable {
  private WebElement _webTable;

  public WebTable(WebElement webTable) {
    set_webTable(webTable);
  }

  public void set_webTable(WebElement webTable) {
    this._webTable = webTable;
  }

  public WebElement get_webTable() {
    return _webTable;
  }
  // row count of the table
  public int getRowCount() {
    List<WebElement> tableRows = _webTable.findElements(By.tagName("tr"));
    return tableRows.size();
  }
  // colums of the table
  public int getColumCount() {
    List<WebElement> tableRows = _webTable.findElements(By.tagName("tr"));
    WebElement headerRow = tableRows.get(0);
    List<WebElement> tableColums = headerRow.findElements(By.tagName("td"));
    return tableColums.size();
  }

  public WebElement getCellEditor(int rowIdx, int colIdx, int editorIdx) {
    try {
      List<WebElement> tableRows = _webTable.findElements(By.tagName("tr"));
      WebElement currentRow = tableRows.get(rowIdx - 1);
      List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
      WebElement cell = tableCols.get(colIdx - 1);
      WebElement cellEditor = cell.findElements(By.tagName("input")).get(editorIdx);
      return cellEditor;
    } catch (NoSuchElementException e) {
      throw new NoSuchElementException("Failed to get cell editor");
    }
  }

    public WebElement setCellEditor(int rowIdx, int colIdx, int editorIdx, String message) {
        try {
            List<WebElement> tableRows = _webTable.findElements(By.tagName("tr"));
            WebElement currentRow = tableRows.get(rowIdx - 1);
            List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
            WebElement cell = tableCols.get(colIdx - 1);
            WebElement cellEditor = cell.findElements(By.tagName("input")).get(editorIdx);
            cellEditor.sendKeys(message);
            return cellEditor;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Failed to get cell editor");
        }
    }
}
