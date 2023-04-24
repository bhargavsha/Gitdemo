package com.AppiumFrameworkDesign.PageObjects.Android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.AppiumFrameworkDesign.Utils.AndroidGestureActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class cartpage extends AndroidGestureActions {

		AndroidDriver driver;
		
		public 	cartpage (AndroidDriver driver) {
			super(driver);
			this.driver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		}
		//List<WebElement> Productprices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
		private List<WebElement> productpricelist;
		
		//String PurchaseAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
		private WebElement totalAmount;
		
		//WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
		private WebElement termsbtn;
		
		//driver.findElement(By.id("android:id/button1")).click();
		@AndroidFindBy(id="android:id/button1")
		private WebElement acceptbtn;
		
		//driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		@AndroidFindBy(className="android.widget.CheckBox")
		private WebElement checkbox;

		//driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
		private WebElement proceedbtn;
		
		public List<WebElement> getProductList()
		{
			return productpricelist;
		}
		public double getproductSum() {
			int size = productpricelist.size();
			Double totalSum = 0.0;
			for (int i = 0; i<size; i++)
			{
				String amountString = productpricelist.get(i).getText();
				Double price = getFormatedAmount(amountString);
				totalSum = totalSum + price;
			}
			return totalSum;
		}
		public Double gettotalAmountdisplayed() {
			
			return getFormatedAmount(totalAmount.getText());
			}
		public void acceptterms() {
		
			LongPressAction(termsbtn);
			acceptbtn.click();
		}
		public void Submitorder() {
			
			checkbox.click();
			proceedbtn.click();
		}
}
