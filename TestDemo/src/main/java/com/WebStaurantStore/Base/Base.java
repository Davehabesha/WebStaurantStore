package com.WebStaurantStore.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static Properties prop;
	public static Properties testData;
	public static WebDriver driver;
	
	public Base() {
		try{
            prop = new Properties();
            testData = new Properties();
            FileInputStream configFile = new FileInputStream(
                System.getProperty("user.dir") + ""
            );
            FileInputStream testDataFile = new FileInputStream(
                System.getProperty("user.dir") + ""
            );
            prop.load(configFile);
            testData.load(testDataFile);
            
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void initialization() {
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get("https://www.webstaurantstore.com/");
	}
	

}
