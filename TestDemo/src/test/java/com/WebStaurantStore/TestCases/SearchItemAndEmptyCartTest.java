package com.WebStaurantStore.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.WebStaurantStore.Base.Base;
import com.WebStaurantStore.Pages.CartPage;
import com.WebStaurantStore.Pages.HomePage;
import com.WebStaurantStore.Pages.SearchPage;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchItemAndEmptyCartTest extends Base{
	HomePage homePage;
	SearchPage searchPage;
	CartPage cartPage;
	
	public SearchItemAndEmptyCartTest() {
		super();
	}
	
	@BeforeClass
    public void setup() {
        initialization();
        homePage = new HomePage();
    }

    @Test(priority = 1)
    public void HomePageTitleTest() {
        boolean isLogoPresent = homePage.validateLogo();
        Assert.assertTrue(isLogoPresent);
    }

    @Test(priority = 2)
    public void searchItemTest() {
        searchPage = homePage.searchItem();
    }
    
    @Test(priority = 3, dependsOnMethods = "searchItemTest")
    public void itemContainsKeyWordTest() {
        Assert.assertTrue(searchPage.checkSearchItem());
    }
    
    @Test(priority=4, dependsOnMethods = "itemContainsKeyWordTest")
    public void addItemToCart() {
    	searchPage.addLastItemToCart();
    	searchPage.closeNotification();
    	cartPage = searchPage.clickCartButton();
    }
    
    @Test(priority=5, dependsOnMethods = "addItemToCart")
    public void emptyCart() throws InterruptedException {
    	Assert.assertTrue(cartPage.cartItemName.isDisplayed());
    	cartPage.clickEmptyCart();
    	Assert.assertTrue(cartPage.emptyCartConfirmationModal.isDisplayed());
    	cartPage.clickEmptyCartConfirmation();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	//wait.until(ExpectedConditions.visibilityOfElementLocated((By) cartPage.cartIsEmptyHeading));
    	Thread.sleep(5000);
    	Assert.assertTrue(cartPage.cartIsEmptyHeading.isDisplayed());
    }
    
    
    
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
