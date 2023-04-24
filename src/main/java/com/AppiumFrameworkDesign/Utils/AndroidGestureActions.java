package com.AppiumFrameworkDesign.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidGestureActions {
	AndroidDriver driver;
	public AndroidGestureActions (AndroidDriver driver) {
		
		this.driver = driver;
	}
	
	public void LongPressAction(WebElement elem) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement)elem).getId(),
						"duration",2000));
	}
	public void ScrolltoEndAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
			}while (canScrollMore);
	}
	public void ScrolltoText(String text) {
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
	}
	public void swipeAction(WebElement firstImage, String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId" ,((RemoteWebElement)firstImage).getId(), 
				"direction", direction,
			    "percent", 0.75
			));
	}
	public void DragDropGesture(WebElement drag) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) drag).getId(),
			    "endX", 649,
			    "endY", 653
			));
	}
	public Double getFormatedAmount(String amount) {
		Double price = Double.parseDouble((amount).substring(1));
		return price;
	}
}
