package com.AppiumFrameworkDesign.BaseTestUtils;
	
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.AppiumFrameworkDesign.PageObjects.Android.FormPage;
import com.AppiumFrameworkDesign.Utils.AppiumUtils;
import java.util.Properties;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import java.io.FileInputStream;

public class BaseTest extends AppiumUtils {
	

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPage formpage;
	@BeforeClass(alwaysRun=true)
	public void ConfigureAppium() throws Exception {
		
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\AppiumFrameworkDesign\\resources\\data.properties");
			prop.load(fis);
			String ipAddress = System.getProperty("ipAddress")!= null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
			//String ipAddress = prop.getProperty("ipAddress");
			String port = prop.getProperty("port");
			service = startAppiumServer(ipAddress, Integer.parseInt(port));
			
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName(prop.getProperty("AndroidDeviceName"));
			//options.setDeviceName("Android Device");
			options.setChromedriverExecutable("C:\\Users\\bhargavs\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
			//options.setApp("C:\\Users\\bhargavs\\eclipse-workspace\\apium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
			options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\com\\AppiumFrameworkDesign\\resource\\General-Store.apk");
			
			driver = new AndroidDriver(service.getUrl(), options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			formpage = new FormPage(driver);
	}
	/*public void LongPressAction(WebElement elem) {
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
	}*/
	public void khaliemnem() {
		System.out.println("ela ey jenaa");
		System.out.println("chal ey pritesh");
	}
	@AfterClass(alwaysRun=true)
	public void teardown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
		service.stop();
	}
	
}
