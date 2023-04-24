package com.AppiumFrameworkDesign.PageObjects.Android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.AppiumFrameworkDesign.Utils.AndroidGestureActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogue extends AndroidGestureActions {
		
		AndroidDriver driver;
		
		@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
		private List<WebElement> addtocart;
		//driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		//driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		
		@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
		private WebElement cartbutton;
		//driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		public 	ProductCatalogue (AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
				
	}
		
		public void addItemToCartByIndex(int index) 
		{
			addtocart.get(index).click();
		}
		public cartpage gotoCartPage() throws InterruptedException
		{
			cartbutton.click();
			Thread.sleep(2000);
			return new cartpage(driver);
		}
}
