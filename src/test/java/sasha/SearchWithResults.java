package sasha;

import org.testng.annotations.*;
import static org.junit.Assert.*;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import org.openqa.selenium.*;

public class SearchWithResults extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testSearchWithResults() throws Exception {    
	driver.get(baseUrl + "/php4dvd/");
    driver.findElement(By.id("q")).clear();
    String searchString = "star";
    driver.findElement(By.id("q")).sendKeys(searchString + Keys.RETURN);
    List <WebElement> elements = driver.findElements(By.cssSelector("div.movie_box"));
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { 
    			for(WebElement film : elements) {
    				String title = film.findElement(By.cssSelector("div.title")).getText();
    				assertThat(title, containsString(searchString));	
    			}  
    		} catch (Exception e) {}
    	Thread.sleep(1000);
    }

   }
}