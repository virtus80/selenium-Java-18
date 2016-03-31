package sasha;

import org.testng.annotations.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class CreateDescriptionPositive extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testCreateDescriprionPositive() throws Exception {    driver.get(baseUrl + "/php4dvd/");
    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("imdbsearchform"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Star Wars");
    driver.findElement(By.name("aka")).clear();
    driver.findElement(By.name("aka")).sendKeys("Star Wars: Episode IV The New Hope");
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys("1977");
    driver.findElement(By.name("duration")).clear();
    driver.findElement(By.name("duration")).sendKeys("121");
    driver.findElement(By.name("rating")).clear();
    driver.findElement(By.name("rating")).sendKeys("8.1");
    driver.findElement(By.id("text_languages_0")).clear();
    driver.findElement(By.id("text_languages_0")).sendKeys("English");
    driver.findElement(By.name("genres")).clear();
    driver.findElement(By.name("genres")).sendKeys("Fantastic");
    driver.findElement(By.name("director")).clear();
    driver.findElement(By.name("director")).sendKeys("George Lucas");
    driver.findElement(By.id("submit")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Star Wars (1977)".equals(driver.findElement(By.cssSelector("h2")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
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