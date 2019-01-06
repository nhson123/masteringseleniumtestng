package com.masteringselenium.effectivePageObjects;

import com.masteringselenium.DriverFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

/**
 * Package: com.masteringselenium.effectivePageObjects Generated by: Hoang.Son.Nguyen Generated at:
 * 04.01.2019 2019
 */
public class FileDownloadWD extends DriverFactory {

  public static int verifyURLStatus(String URL) {
    CloseableHttpClient client = HttpClientBuilder.create().build();
    HttpGet request = new HttpGet(URL);
    int invalidLinksCount = 0;
    try {
      HttpResponse response = client.execute(request);
      // verifying response code and The HttpStatus should be 200 if not,
      // increment invalid link count
      // We can also check for 404 status code like response.getStatusLine().getStatusCode() == 404
      if (response.getStatusLine().getStatusCode() != 200) invalidLinksCount++;
      System.out.println(response.getStatusLine().getStatusCode());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return invalidLinksCount;
  }

  @Test
  public void checkDownloadLink() {
    String URL = "http://cdn.rentbyowner.com/sitemap/gz/site-map-0.xml.gz";
    assertTrue(verifyURLStatus(URL) == 0);
  }
}
