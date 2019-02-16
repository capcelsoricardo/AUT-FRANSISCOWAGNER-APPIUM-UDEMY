package appiumudemy.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import appiumudemy.config.SetUp;
import io.appium.java_client.MobileElement;

public class SplashPage {
	
	public boolean verificarTexto() { 
		List<MobileElement> elementos =  SetUp.getDriver().findElements(By.xpath("//*[@text='Splash!']"));
		return elementos.size() > 0;				
	}

	public void aguardarSplashSumir() {
		
		SetUp.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(SetUp.getDriver(), 10);		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Splash!']")));		
		
	}
}
