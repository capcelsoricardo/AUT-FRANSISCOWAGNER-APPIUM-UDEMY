package appiumudemy.pages;

import java.util.Set;

import org.openqa.selenium.By;

import appiumudemy.config.SetUp;
import appiumudemy.utils.Geral;

public class WebViewPage {
	Geral geral = new Geral();
	
	public void entrarContextoWeb() {
		Set<String> contextHandles = SetUp.getDriver().getContextHandles();				
		
		for(String valor: contextHandles) {
			System.out.println(valor);
		}
		SetUp.getDriver().context((String) contextHandles.toArray()[1]);
		
		
	}
	
	
	public void setEmail(String valor) {
		SetUp.getDriver().findElement(By.id("email")).sendKeys(valor);
	}
}
