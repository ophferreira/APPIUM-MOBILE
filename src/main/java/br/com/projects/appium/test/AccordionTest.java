package br.com.projects.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.projects.appium.core.BaseTest;
import br.com.projects.appium.page.AccordionPage;
import br.com.projects.appium.page.MenuPage;

public class AccordionTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AccordionPage accordion = new AccordionPage();

	@Test
	public void interagirComAccordion() throws InterruptedException {
		//acessar menu
		menu.acessarAccordion();
		
		//clicar op 1
		accordion.selecionarOp1();
		
		//validar texto da op 1
		Thread.sleep(1000);
		Assert.assertEquals("Esta é a descrição da opção 1", accordion.getValor0p1());		
	}
}