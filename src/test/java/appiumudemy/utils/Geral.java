package appiumudemy.utils;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.taskdefs.Move;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import appiumudemy.config.SetUp;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Geral extends SetUp {

	@Rule
	public TestName testName = new TestName();
	
	public void waitElementVisible(By locator, int timeSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));		
	}
	
	public void escrever(By by, String valor) {
		getDriver().findElement(by).sendKeys(valor);
	}

	public String obterText(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public void selecionarComboMobile(By by, String valorCombo) {
		getDriver().findElement(by).click();
		clicarPorTexto(valorCombo);		
	}
	
	public  void clicarPorTexto(String valor) {
		getDriver().findElement(By.xpath("//*[@text='"+valor+"']")).click();
	}
	
	public void click(By by) {
		getDriver().findElement(by).click();
	}

	public void esperar(long time_segundos) {
		try {
			Thread.sleep(time_segundos * 1000);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
	}

	public void tap(int x, int y) {
			
		TouchAction touchAction = new TouchAction(getDriver());  
		touchAction.tap(PointOption.point(x, y)).perform();								
	}
	

	public void swipe(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		int y = size.height / 2;
		int x_start = (int) (size.width * inicio);
		int x_end = (int) (size.width * fim);
		
		TouchAction touchAction = new TouchAction(getDriver());
		touchAction.press(PointOption.point(x_start, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		.moveTo(PointOption.point(x_end, y)).release().perform();								
	}
	
	
	public void scrool(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		int x = size.width / 2;
		int y_start = (int) (size.height * inicio);
		int y_end = (int) (size.height * fim);
		
		TouchAction touchAction = new TouchAction(getDriver());
		touchAction.press(PointOption.point(x, y_start)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		.moveTo(PointOption.point(x, y_end)).release().perform();								
	}
	
	
	public boolean existElementContensText(String text) {
		
		esperar(3);
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[contains(@text, '"+ text +"')]"));	
		
		return elementos.size() > 0;
	}
	
	public void clikLongo(WebElement element) {	
		
		TouchAction touchAction = new TouchAction(getDriver());		
		touchAction.longPress(ElementOption.element(element)).perform();				
	}	
	
	public void gerarScreenShot() {
		try {
			
			File imagem = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(imagem, new File("target/screenshots/" + testName +".png"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
