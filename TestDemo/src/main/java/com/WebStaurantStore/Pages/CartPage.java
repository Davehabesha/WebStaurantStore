package com.WebStaurantStore.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.WebStaurantStore.Base.Base;

public class CartPage extends Base{
	
	//Page Factory - OR
    @FindBy(css = "span.itemDescription")
    public WebElement cartItemName;

    @FindBy(css = "button.emptyCartButton")
    WebElement emptyCartButton;
    
    @FindBy(css="div.ReactModalPortal #empty-cart-title")
    public WebElement emptyCartConfirmationModal;
    
    @FindBy(xpath = "//div[@class='ReactModalPortal']/descendant::button[contains(text(), 'Empty')]")
    WebElement emptyCartConfirmationButton;
    
    @FindBy(xpath = "//p[contains(text(), 'Your cart is empty.')]")
    public WebElement cartIsEmptyHeading;

    //Page Object Intialization
    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions
	public void clickEmptyCart() {
		//new Actions(driver).scrollToElement(lastAddToCartButton).perform();
		 emptyCartButton.click();
	}
	
	public void clickEmptyCartConfirmation() {
		//new Actions(driver).scrollToElement(lastAddToCartButton).perform();
		 emptyCartConfirmationButton.click();
	}
}
