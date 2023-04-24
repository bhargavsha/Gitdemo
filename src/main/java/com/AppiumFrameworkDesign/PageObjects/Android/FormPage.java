package com.AppiumFrameworkDesign.PageObjects.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.Activity;
import com.AppiumFrameworkDesign.Utils.AndroidGestureActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidGestureActions {
	
	AndroidDriver driver;
	
	public 	FormPage (AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Bhargav Shah");
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField; 
	
	//driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement genderFemale;
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement gendermale;
	public void setNameField(String name) {
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	public void setGender (String gender)
	{
		if (gender.contains("female")) {
			genderFemale.click();
		}
		else
			gendermale.click();
			
	}
	@AndroidFindBy(id="android:id/text1")
	private WebElement CountrySelection;
	
	
	public void setcontryselection(String CountryName) {
		CountrySelection.click();
		ScrolltoText(CountryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+CountryName+"']")).click();
		
	}
	//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopbutton;
	
	public ProductCatalogue submitForm() {
		
		shopbutton.click();
		return new ProductCatalogue(driver);
}
	public void setActivity() {
		//Screen to homepage
		Activity activity = new Activity ("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);

}}
