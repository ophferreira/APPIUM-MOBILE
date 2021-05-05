package br.com.projects.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.projects.appium.core.BaseTest;
import br.com.projects.appium.page.MenuPage;
import br.com.projects.appium.page.SplashPage;

public class SplashTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SplashPage splash = new SplashPage();
	
	@Test
	public void aguardarSplashSumir() {
		//acessar Splash
		menu.acessarSplash();
		
		//verificar Splash visivel
		splash.isTelaSplashVisible();
		
		//aguardar Splash finalizar
		splash.aguardarSplashSumir();
		
		//verificar tela formulário
		Assert.assertTrue(splash.existElementText("Formulário"));
	}
}
