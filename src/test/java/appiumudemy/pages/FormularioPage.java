package appiumudemy.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import appiumudemy.config.SetUp;
import appiumudemy.utils.Geral;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioPage  {
	
	public Geral geral = new Geral();
		
	public void preencherCampo() {		
		geral.escrever(MobileBy.AccessibilityId("nome"), "teste");			
	}
	
	public void selecionarCombo(String valorCombo) { 				
		geral.selecionarComboMobile(By.xpath("//android.widget.Spinner[@content-desc='console']"), valorCombo);														
	}
	
	public void trabalhandoComSwitchECheckBox() { 
		MobileElement elementCheckBox = SetUp.getDriver().findElement(By.className("android.widget.CheckBox"));
		MobileElement elementSwitch = SetUp.getDriver().findElement(By.xpath("//android.widget.Switch[@content-desc='switch']"));
		
		System.out.println("Atributo do CheckBox: " + elementCheckBox.getAttribute("checked"));
		
		Assert.assertTrue(elementCheckBox.getAttribute("checked").equals("false"));
		
		System.out.println("Atributo do Switch: " + elementSwitch.getAttribute("checked"));
		
		elementCheckBox.click();
		elementSwitch.click();		
	}
	
	public void preencherCamposFormulario(String nome, String combo, boolean selectCheckBox, boolean selectSwitch) {
		
		geral.escrever(MobileBy.AccessibilityId("nome"), nome);				
		geral.click(MobileBy.className("android.widget.Spinner"));						
		geral.clicarPorTexto("PS4");		
		
		if (selectCheckBox)
			geral.click(MobileBy.AccessibilityId("check"));
		
		if(selectSwitch)
			geral.click(MobileBy.AccessibilityId("switch"));				
	}

	public void clickButtonSalvar() { 
		geral.clicarPorTexto("SALVAR");
	}
	
	
	public void clickSeekBar(double position) {
		MobileElement seekBar = SetUp.getDriver().findElement(MobileBy.AccessibilityId("slid"))	;
		int y = seekBar.getLocation().y + (seekBar.getSize().height / 2); 
		System.out.println(y);
		int x = (int) (seekBar.getLocation().x + (seekBar.getSize().width * position));
		System.out.println(x);
		geral.tap(x, y);
	}
	
	
	public  void clickButtonSalvarDemorado() {		
		geral.clicarPorTexto("SALVAR DEMORADO");
		
		WebDriverWait wait = new WebDriverWait(SetUp.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Celso Ricardo']")));
		
	}
	
	public boolean checkPreenchimentoFormulario(String nome, String selectCheckBox, String selectSwitch) throws InterruptedException {
							
		MobileElement elementNome =  SetUp.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Nome: Celso Ricardo']"));
		String vNome = elementNome.getText();

		String vConsole = SetUp.getDriver().findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]")).getText();  					
		String vSwitch = SetUp.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'Switch:')]")).getText();
			
		String vCheckBox = SetUp.getDriver().findElement(MobileBy.xpath("//android.widget.TextView[starts-with(@text,'Checkbox:')]")).getText();																					
			
		System.out.println(vNome);			
		System.out.println(vConsole);
		System.out.println(vSwitch);
		System.out.println(vCheckBox);
		
		return true;										
	}		
}
