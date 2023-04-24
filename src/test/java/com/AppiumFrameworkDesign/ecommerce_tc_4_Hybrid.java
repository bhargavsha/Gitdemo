package com.AppiumFrameworkDesign;

import java.util.List;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.AppiumFrameworkDesign.BaseTestUtils.BaseTest;
import com.AppiumFrameworkDesign.PageObjects.Android.ProductCatalogue;
import com.AppiumFrameworkDesign.PageObjects.Android.cartpage;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ecommerce_tc_4_Hybrid extends BaseTest {

	@Test(dataProvider="getdata", groups = {"smoke"})
	public void CheckouttoHybrid(HashMap<String, String> input) throws Exception
	{
		
		formpage.setNameField(input.get("name"));
		formpage.setGender(input.get("gender"));
		formpage.setcontryselection(input.get("country"));
		ProductCatalogue productcatalogue = formpage.submitForm();
		//String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		//Assert.assertEquals(toastMessage, "Please enters your name");
		//ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		productcatalogue.addItemToCartByIndex(0);
		productcatalogue.addItemToCartByIndex(0);
		//String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		//Assert.assertEquals(toastMessage, "Please enter your name");
		cartpage Cartpage = productcatalogue.gotoCartPage();
		
		Thread.sleep(3000);
		
		//driver.findElement(By.xpath("//android.widget.TextView[@text='ADD TO CART'][0]")).click();
		/*WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));*/
		Double totalSum = Cartpage.getproductSum();
		Double totalPurchaseAmount = Cartpage.gettotalAmountdisplayed();
		Assert.assertEquals(totalPurchaseAmount, totalSum);
		Cartpage.acceptterms();
		Cartpage.Submitorder();
		Thread.sleep(10000);
		
		Set<String> contexts = driver.getContextHandles();
		for (String contextName : contexts) {
			System.out.println(contextName);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Bhargav n shah");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		
		}
		@DataProvider
		public Object[][] getdata() throws IOException
		{
			List<HashMap<String, String>> data = getJSONData(System.getProperty("user.dir")+"\\src\\test\\java\\com\\AppiumFrameworkDesign\\testdata\\eCommerce.json");
			//return new Object [] [] {{"Bhargav Shah", "female", "Argentina" }, {"Stuti Shah", "male", "India" }};
			return new Object [] [] {{ data.get(0)}, {data.get(1) }};
		}
		
		//@BeforeMethod(alwaysRun=true)
		public void preSetup()
		{
			formpage.setActivity();
			
		}
	}