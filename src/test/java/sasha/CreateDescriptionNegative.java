package sasha;

import org.testng.annotations.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class CreateDescriptionNegative extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testCreateDescriprionNegative() throws Exception {    driver.get(baseUrl + "/php4dvd/");
    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("imdbsearchform"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Груз 200");
    driver.findElement(By.name("duration")).clear();
    driver.findElement(By.name("duration")).sendKeys("90");
    driver.findElement(By.id("text_languages_0")).clear();
    driver.findElement(By.id("text_languages_0")).sendKeys("русский");
    driver.findElement(By.name("director")).clear();
    driver.findElement(By.name("director")).sendKeys("Алексей Балабанов");
    driver.findElement(By.id("submit")).click();
    try {
      assertEquals(driver.findElement(By.xpath("//form[@id='updateform']/table//tr[4]//label[@class='error']")).getText(), "This field is required");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
   }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
