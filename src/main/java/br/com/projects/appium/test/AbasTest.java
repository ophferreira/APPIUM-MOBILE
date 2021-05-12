package br.com.projects.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.projects.appium.core.BaseTest;
import br.com.projects.appium.page.AbasPage;
import br.com.projects.appium.page.MenuPage;

public class AbasTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AbasPage abas = new AbasPage();
	
	@Test
	public void interagirComAbas() {
		//acessar menu Abas
		menu.acessarAbas();
		
		//validar que está na aba 1
		Assert.assertTrue(abas.isAba1());;
		
		//acessar aba 2
		abas.clicarAba2();
		
		//validar que está na aba 2
		Assert.assertTrue(abas.isAba2());
		
	}
}