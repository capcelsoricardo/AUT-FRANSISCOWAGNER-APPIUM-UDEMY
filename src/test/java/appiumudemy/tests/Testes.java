package appiumudemy.tests;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;

import appiumudemy.config.SetUp;
import appiumudemy.pages.AccordionPage;
import appiumudemy.pages.AlertasPage;
import appiumudemy.pages.CliquesPage;
import appiumudemy.pages.DragAndDropPage;
import appiumudemy.pages.FormularioPage;
import appiumudemy.pages.MenuPage;
import appiumudemy.pages.SplashPage;
import appiumudemy.pages.WebViewPage;
import appiumudemy.utils.Geral;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Testes {
	
	private static AndroidDriver<MobileElement> driver;		
	MenuPage menuPage = new MenuPage();
	Geral geral = new Geral();	
	
	@Before
	public void createDriver() throws MalformedURLException {
		driver = SetUp.createDriver();
	}
	
	@Test
	@Ignore
	public void comprarProduto() {
		MenuPage inicialPage = new MenuPage();
		
		inicialPage.clickFormulario();		
		FormularioPage formularioPage = new FormularioPage();
		formularioPage.preencherCampo();
		formularioPage.selecionarCombo("Nintendo Switch");
		formularioPage.trabalhandoComSwitchECheckBox();
	}
	
	@Test
	public void DesafioCadastro() throws InterruptedException {
		
		MenuPage inicialPage = new MenuPage();
		inicialPage.clickFormulario();
		
		FormularioPage formularioPage = new FormularioPage();
		
		formularioPage.preencherCamposFormulario("Celso Ricardo","PS4", true, true);
		
		formularioPage.clickButtonSalvar();
		
		assertTrue(formularioPage.checkPreenchimentoFormulario("Celso Ricardo", "Marcado", "Off"));		
		
		Geral geral = new Geral();
		geral.gerarScreenShot();
	}
		
	@Test
	public void CadastroDemorado() throws InterruptedException {
		
		Geral geral = new Geral();
		MenuPage inicialPage = new MenuPage();
		inicialPage.clickFormulario();
		
		FormularioPage formularioPage = new FormularioPage();
		
		formularioPage.preencherCamposFormulario("Celso Ricardo","PS4", true, true);		
		formularioPage.clickButtonSalvarDemorado();
		
		geral.esperar(9000);
		assertTrue(formularioPage.checkPreenchimentoFormulario("Celso Ricardo", "Marcado", "Off"));		
		
		
		geral.gerarScreenShot();		
	}
	
	@Ignore
	@Test
	public void testSplash() {
		
		MenuPage menuPage = new MenuPage();		
		Geral geral = new Geral();
		SplashPage splashPage = new SplashPage();
		
		menuPage.clickMenuSplash();						
		System.out.println("Encontrou a tela Splash: " + splashPage.verificarTexto());
		
		splashPage.aguardarSplashSumir();				
		
		String texto = geral.obterText(By.xpath("//*[@text='Formulário']"));		
		Assert.assertEquals(texto, "Formulário");
					
	}
	
	
	@Test
	
	public void testAlertas() { 
		MenuPage menuPage = new MenuPage();
		AlertasPage alertasPage = new AlertasPage();
		
		menuPage.clickMenuAlertas();		
		alertasPage.clickAlertaConfirm();
		
		Assert.assertEquals(alertasPage.obterTituloAlerta(), "Info");
		Assert.assertEquals(alertasPage.obterMensagemAlerta(), "Confirma a operação?");
		
		alertasPage.confirmar();
				
		Assert.assertEquals(alertasPage.obterMensagemAlerta(), "Confirmado");
		
		alertasPage.sair();
		
	}
		
	@Test
	@Ignore
	public void testAccordion() {
		MenuPage menuPage = new MenuPage();
		Geral geral = new Geral();
		AccordionPage accordionPage = new AccordionPage();
				
		menuPage.clickMenuAccordion();
		accordionPage.selecionarOpcaoUm();
		geral.esperar(2);
		Assert.assertEquals("Esta é a descrição da opção 1", accordionPage.obterTextOpcaoUm());				
	}
	
	@Test
	@Ignore
	public void testClickCoordenada() {
		MenuPage menuPage = new MenuPage();
		Geral geral = new Geral();
		AlertasPage alertasPage = new AlertasPage();
				
		menuPage.clickMenuAlertas();
		
		alertasPage.clickAlertaSimples();
		
		geral.esperar(3);
		
		alertasPage.clickForaDaCaixa();
		
		geral.esperar(3);
		
		geral.gerarScreenShot();
		
	}
	
	@Test
	@Ignore
	public void testseekBar() {
		MenuPage menuPage = new MenuPage();
		Geral geral = new Geral();
		menuPage.clickFormulario();
		FormularioPage formularioPage = new FormularioPage(); 
		formularioPage.clickSeekBar(0.02);
		formularioPage.clickButtonSalvar();
		
	}
	
	@Test
	@Ignore
	public void testScrool() {
		
		MenuPage menuPage = new MenuPage();
		Geral geral = new Geral();
		geral.esperar(2);
		geral.scrool(0.9, 0.1);
		
		menuPage.clickOpcaoEscondida();
		
	}
	
	@Test
	@Ignore
	public void swipeTest() {
		
		MenuPage menuPage = new MenuPage();
		Geral geral = new Geral();
		
		menuPage.clickMenuSwipe();
		
		Assert.assertTrue(geral.existElementContensText("esquerda"));
	
		geral.swipe(0.9, 0.1);
		
		
	}
	
	@Ignore
	@Test
	public void desafioSwipeList() {
		MenuPage menuPage = new MenuPage();
		menuPage.clickMenuSwipeList();
		System.out.println("teste");
		
	}
	
	@Test
	@Ignore
	public void seBarrigaHibrido() {
		MenuPage menuPage = new MenuPage();
		menuPage.clickSeuBarrigaHibrido();
		geral.esperar(6);
		
		WebViewPage webViewPage = new WebViewPage();		
		webViewPage.entrarContextoWeb();
		
		webViewPage.setEmail("celso.ricardo@gmail.com");
	}
	
	@Test
	@Ignore
	public void dragAndDropTest() {
		menuPage.clickMenuDragAndDrop();

		String[] firstArray = new String[] {"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado." };
		String[] segundoArray = new String[] {"é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer local desejado." };
				
		DragAndDropPage dragAndDropPage = new DragAndDropPage();
		geral.esperar(2);
		Assert.assertArrayEquals(firstArray, dragAndDropPage.obterList());
		
		dragAndDropPage.arrastar("Esta", "e arraste para");
		
		Assert.assertArrayEquals(segundoArray, dragAndDropPage.obterList());
		
	}
	
	@Test	
	@Ignore
	public void testCliqueLongo() {
		MenuPage menuPage = new MenuPage();
		Geral geral = new Geral();
		menuPage.clickMenuCliques();		
		CliquesPage cliquesPage = new CliquesPage();
		geral.esperar(3);				
		cliquesPage.clickLongo();
		geral.esperar(3);								
	}
	
	@After
	public void tearDown() {		
		SetUp.getDriver().resetApp();  
	}
	
	@AfterClass
	public static void finalizaClass() {
		SetUp.killDriver();
	}
}
