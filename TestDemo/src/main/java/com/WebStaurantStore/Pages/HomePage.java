package com.WebStaurantStore.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.WebStaurantStore.Base.Base;

public class HomePage extends Base{
	
	//Page Factory - OR
	@FindBy(id = "searchval")
	WebElement searchInput;
	
	@FindBy(css = "button[value='Search']")
	WebElement searchButton;
	
	@FindBy(css = ".new-header a[data-testid='logo']")
	WebElement webStaurantStoreLogo;
	
	//Page Object Intialization
	public HomePage() {
	    PageFactory.initElements(driver, this);
	}
	
	//Actions
	public boolean validateLogo() {
	    return webStaurantStoreLogo.isDisplayed();
	}

	public SearchPage searchItem() {
	    searchInput.sendKeys("stainless work table");
	    searchButton.click();
	    return new SearchPage();
	}

}
