package appiumudemy.pages;

import org.openqa.selenium.By;

import appiumudemy.utils.Geral;

public class AccordionPage {
	Geral geral = new Geral();
	
	public void selecionarOpcaoUm() {
		geral.clicarPorTexto("Opção 1");
	}
	
	
	public String obterTextOpcaoUm() {
		return geral.obterText(By.xpath("//*[@text='Opção 1']/../..//following-sibling::android.view.ViewGroup[1]//android.widget.TextView"));						
	}
}
