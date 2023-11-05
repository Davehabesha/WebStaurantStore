package com.WebStaurantStore.Pages;

import java.util.List;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.WebStaurantStore.Base.Base;

public class SearchPage extends Base{
	
	//Page Factory - OR
    @FindAll({@FindBy(css = "span[data-testid='itemDescription']")})
    List<WebElement> searchResultItemNames;

    @FindBy(xpath = "//div[@id='product_listing']/descendant::input[@name='addToCartButton'][last()]")
    WebElement lastAddToCartButton;

    @FindBy(css = "a[data-testid='cart-button']")
    WebElement cartButton;

    @FindBy(xpath = "//h2[@class='notification__heading'][contains(text(), 'added to your cart')]")
	public WebElement itemAddedToCartNotification;

    @FindBy(css = "p.msg button.close")
    WebElement closeNotificationButton;

    //Page Object Intialization
    public SearchPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions
	public boolean checkSearchItem() {
	   boolean isKeyWordInSearchItemName = true;
	   for(int i=0; i<searchResultItemNames.size(); i++) {
		   new Actions(driver).scrollToElement(searchResultItemNames.get(i)).perform();
		   if(! searchResultItemNames.get(i).getText().contains("Table")) {
			   isKeyWordInSearchItemName = false;
			   break;
		   }
	   }
	   return isKeyWordInSearchItemName;
	}
	
	public void addLastItemToCart() {
		new Actions(driver).scrollToElement(lastAddToCartButton).perform();
		lastAddToCartButton.click();
	}
	
	public void closeNotification() {
			closeNotificationButton.click();
	}
	
	public CartPage clickCartButton() {
		 new Actions(driver).scrollToElement(cartButton).perform();
		 cartButton.click();
		 return new CartPage();
	}
}
