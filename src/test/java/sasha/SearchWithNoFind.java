package sasha;

import org.testng.annotations.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class SearchWithNoFind extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testSearchWithNoFind() throws Exception {    driver.get(baseUrl + "/php4dvd/");
    driver.findElement(By.id("q")).clear();
    driver.findElement(By.id("q")).sendKeys("fff" + Keys.RETURN);
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { 
    		if ("No movies where found.".equals(driver.findElement(By.cssSelector("div.content")).getText())) break; 
    		} catch (Exception e) {}
    	Thread.sleep(1000);
    }

   }
}