package appiumudemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appiumudemy.config.SetUp;
import appiumudemy.utils.Geral;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class CliquesPage {
	
	
	public void clickLongo() {
		Geral geral = new Geral();

		WebElement element =  SetUp.getDriver().findElement(By.xpath("//*[@text='Clique Longo']"));		
		geral.clikLongo(element);								
				
	}

}
