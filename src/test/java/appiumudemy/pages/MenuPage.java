package appiumudemy.pages;

import java.util.List;

import org.openqa.selenium.By;

import appiumudemy.utils.Geral;
import io.appium.java_client.MobileElement;

public class MenuPage  {
	public Geral geral = new Geral();
	
	public void teste() {
		
		List<MobileElement> findElements =  Geral.getDriver().findElements(By.className("android.widget.TextView"));
		
		for (MobileElement mobileElement : findElements) {
			System.out.println(mobileElement.getText());			
		}
	}
	
	public void clickSeuBarrigaHibrido() {
		geral.clicarPorTexto("SeuBarriga Híbrido");
	}
	
	public void clickFormulario() {		
		geral.clicarPorTexto("Formulário");		
	}
	
	public void clickMenuSplash() {
		geral.clicarPorTexto("Splash");
	}
	
	public void clickMenuAlertas() {
		geral.clicarPorTexto("Alertas");
	}
	
	public void clickMenuAccordion() {
		geral.clicarPorTexto("Accordion");
	}
	
	public void clickMenuCliques() {
		geral.clicarPorTexto("Cliques");
	}
	
	public void clickOpcaoEscondida() {
		geral.clicarPorTexto("Opção bem escondida");
	}
		
	public void clickMenuSwipe() {
		geral.clicarPorTexto("Swipe");
	}
	
	public void clickMenuSwipeList() {
		geral.esperar(2);
		geral.scrool(0.9, 0.1);		
		geral.clicarPorTexto("Swipe List");
		
	}
	
	public void clickMenuDragAndDrop() {
		geral.esperar(2);
		geral.scrool(0.9, 0.1);		
		geral.clicarPorTexto("Drag and drop");		
	}
}
