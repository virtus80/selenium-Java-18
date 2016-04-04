package sasha;

import org.testng.annotations.*;
import static org.junit.Assert.*;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchWithResults extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testSearchWithResults() throws Exception {    
	driver.get(baseUrl + "/php4dvd/");
	WebDriverWait wait = new WebDriverWait(driver, 20);
	WebElement filmBeforeSearch = driver.findElement(By.cssSelector("div.movie_box"));
    driver.findElement(By.id("q")).clear();
    String searchString = "star";
    driver.findElement(By.id("q")).sendKeys(searchString + Keys.RETURN);
    
    wait.until(ExpectedConditions.stalenessOf(filmBeforeSearch));
    try{
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.movie_box"))); 
    } catch (TimeoutException ex) {
        
    }
   

   }
}