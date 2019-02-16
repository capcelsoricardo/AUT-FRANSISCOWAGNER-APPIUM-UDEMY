package appiumudemy.pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static appiumudemy.config.SetUp.getDriver;
import appiumudemy.utils.Geral;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import net.bytebuddy.jar.asm.commons.TryCatchBlockSorter;

public class DragAndDropPage {

	public Geral geral = new Geral();
	private String[] estadoInicial = new String[] {};

	public void arrastar(String origem, String destino) {

		MobileElement inicio = getDriver().findElement(By.xpath("//*[@text='"+origem+"']"));
		MobileElement fim = getDriver().findElement(By.xpath("//*[@text='"+destino+"']"));
		
		int x_inicio = inicio.getLocation().getX();
		int y_inicio = inicio.getLocation().getY();
		
		int x_fim = fim.getLocation().getX();
		int y_fim = fim.getLocation().getY();
		
		TouchAction touchAction = new TouchAction(getDriver());
		touchAction.longPress(PointOption.point(x_inicio, y_inicio)).moveTo(PointOption.point(x_fim, y_fim)).release().perform();	
		
		System.out.println("Informacoes de Inicio:" + x_inicio + " " + y_inicio);
		System.out.println("Informacoes de Fim:" + x_fim + " " + y_fim);
								
	}

	public String[] obterList() {
		List<MobileElement> elements = getDriver().findElements(By.className("android.widget.TextView"));

		String[] retorno = new String[elements.size()];

		for (int i = 0; i < elements.size(); i++) {
			retorno[i] = elements.get(i).getText();
			System.out.println("\"" + retorno[i] + "\", ");

		}
		return retorno;
	}
}
