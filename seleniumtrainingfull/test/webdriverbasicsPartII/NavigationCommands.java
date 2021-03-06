/*We can navigate browser using Selenium WebDriver commands.
 * We can use back(). forward(), refresh(), navigte.to(URL), etc.. commands to navigate browser. 
 * */
package webdriverbasicsPartII;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class NavigationCommands {
	WebDriver driver;
	
  @Test
  public void f() {
	  
	  /*Load the URL using get(URL) method */
	  driver.get("https://in.yahoo.com");
	  driver.manage().window().maximize(); /*Maximize the browser window*/
	  
	  /* We get page tile using getTitle() method*/
	  String pageTitle = driver.getTitle();
	  System.out.println("PageTitle is: "+pageTitle);
	  
	  /*Using findElement() method we are locating web element on the web page 
	   * using ID as a locating technique
	   * We are inserting "Selenium" as a keyword into the search field 
	   * using sendKeys() method..
	   * */
	  WebElement searchField = driver.findElement(By.id("uh-search-box"));
	  searchField.sendKeys("Selenium");
	  
	  /*Clicking on search button to go on search result page.*/
	  WebElement searchButton = driver.findElement(By.id("uh-search-button"));
	  searchButton.click();
	  
	  /*
			 * It is discouraged to use Thread.sleep in our tests. 
			 * We will eventually cover how to do away with them. 
			 * Thread.sleep below is used so that you can 
			 * observe that it has actually logout and then browser closes.
			 */
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  
	  /* We get the URL of current page using getCurrentUrl() method. 
	   * It returns the the URL in the form of string.
	   */
	  System.out.println("Current URL is:"+driver.getCurrentUrl());
	  
	  /*
		 * It is discouraged to use Thread.sleep in our tests. 
		 * We will eventually cover how to do away with them. 
		 * Thread.sleep below is used so that you can 
		 * observe that it has actually logout and then browser closes.
		 */
	  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  /*Using navigate().to(URL) method, we can navigate to any URL 
	   * in the same opened browser. 
	   */
	  driver.navigate().to("http://timesofindia.indiatimes.com/");
	  
	  /*Using navigate().back() method, we can navigate to previous URL page.  */
	  driver.navigate().back();
	  
	  /*Storing all the WebElements in the LIst of type WebElement 
	   * having tag name as "a" 
	   * using findElements() function
	  */
	  List<WebElement> searchResultURLs = driver.findElements(By.tagName("a"));
	  
	  /*size() method retrieves the no. of element present in the List in the form of Integer*/
	  int noOfSearchResults = searchResultURLs.size();
	  System.out.println("No. of Search Result URLs: "+noOfSearchResults);
	  
	  /*Using navigate().forward() method, we can navigate to next visited page URL 
	   * in the same opened browser. 
	   */
	  driver.navigate().forward();
	  
	  /*Using navigate().forward() method, we can refresh the current page*/
	  driver.navigate().refresh();
	  
	  File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  try {
		FileUtils.copyFile(src, new File("C:/Users/SAI/workspace/SeleniumAssignments/Assignments/esources/screenShots/"+ System.currentTimeMillis() + ".png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }
  
  @BeforeTest
  public void beforeTest() {
	// Firefox Browser
				System.setProperty("webdriver.gecko.driver", "Assignments\\resources\\geckodriver.exe");
				driver = new FirefoxDriver();

				// Chrome Browser
				/*
				 * System.setProperty("webdriver.chrome.driver",
				 * "Assignments\\resources\\chromedriver.exe"); driver = new
				 * ChromeDriver();
				 */

				// IE Browser
				  /* System.setProperty("webdriver.ie.driver",
					* "Assignments\\resources\\IEDriverServer1.exe");
					* driver = new InternetExplorerDriver();
					*/
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
