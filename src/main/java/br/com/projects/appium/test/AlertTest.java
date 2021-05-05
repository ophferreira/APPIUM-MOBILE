package br.com.projects.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.projects.appium.core.BaseTest;
import br.com.projects.appium.page.AlertPage;
import br.com.projects.appium.page.MenuPage;

public class AlertTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AlertPage alert = new AlertPage();
	
	@Test
	public void confirmarAlert() {
		//acessar menu Alerta
		menu.acessarAlertas();
		
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

}