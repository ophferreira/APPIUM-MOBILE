package br.com.projects.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.projects.appium.core.BaseTest;
import br.com.projects.appium.page.AlertPage;
import br.com.projects.appium.page.MenuPage;

public class AlertTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AlertPage alert = new AlertPage();
	
	@Before
	public void setup() {
		//acessar menu Alerta
		menu.acessarAlertas();
	}
	
	@Test
	public void confirmarAlert() {		
		//clicar em alerta confirm
		alert.clicarAlertaConfirm();
		
		//verificar textos
		Assert.assertEquals("Info", alert.getTituloAlert());
		Assert.assertEquals("Confirma a operação?", alert.getMsgAlert());
		
		//confirmar alerta
		alert.confirmar();
		
		//validar nova mensagem
		Assert.assertEquals("Confirmado", alert.getMsgAlert());
		
		//sair
		alert.sair();
	}

	@Test
	public void clicarForaAlerta() throws InterruptedException {
		//clicar alerta simples
		alert.clicarAlertaSimples();
		
		//clicar fora da caixa
		Thread.sleep(1000);
		alert.clicarForaCaixa();
		
		//validar ausência da mensagem
		Assert.assertFalse(alert.existElementText("Pode clicar no OK ou fora da caixa para sair"));
	}
}