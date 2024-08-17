package com.testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Cases {
	
	WebDriver driver;

    @BeforeClass
    public void setup() {
   
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
     
    }
    @Test
    public void testSearchFunctionality() throws InterruptedException {
    	
        // ------------------Locating the search bar ----------------------
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        // ------------------Here storing the search text in String in variable and send to the search box --------
     
        String searchText = "Selenium";
        searchBox.sendKeys(searchText);

        Thread.sleep(2000);
        // -----------------Here locating the the search button and store in variable and perform the click operation
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

        Thread.sleep(3000);
        //------------------Here Locating the search result and store in result variable
        WebElement results = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        Thread.sleep(3000);
       
        //------------------Here storing the searchTest in the expectedText String variable------------------  
        String expectedText = "Results for '" + searchText + "'";
         
        //-----------------Gets the actual text from the located element------------------
	    String actualText = results.getText();
	        
	    //-----------------Compares the expected and actual texts-----------------------------
	    Assert.assertEquals(actualText, expectedText, "The search results are as expected!");
    }
    @AfterClass
    public void tearDown() {
    
        if (driver != null) {
            driver.quit();
        }

}

}
