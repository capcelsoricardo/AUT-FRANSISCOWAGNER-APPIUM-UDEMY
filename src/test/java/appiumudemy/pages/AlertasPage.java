package appiumudemy.pages;

import org.openqa.selenium.By;

import appiumudemy.utils.Geral;

public class AlertasPage {
	Geral geral = new Geral();
	
	public void clickAlertaConfirm() {			
		geral.clicarPorTexto("ALERTA CONFIRM");
				
	}
	
	public void clickForaDaCaixa() { 
		geral.tap(100, 150);
	}
	
	
	public void clickAlertaSimples() {
		geral.clicarPorTexto("ALERTA SIMPLES");
	}
	
	public String obterTituloAlerta() {
		return geral.obterText(By.id("android:id/alertTitle"));
	}

	public String obterMensagemAlerta() {
		return geral.obterText(By.id("android:id/message"));
	}
	
	public void confirmar() { 
		geral.clicarPorTexto("CONFIRMAR");
	}

	public void sair() {
		geral.clicarPorTexto("SAIR");
		
	}
}
