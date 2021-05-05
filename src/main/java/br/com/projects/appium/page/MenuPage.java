package br.com.projects.appium.page;

import br.com.projects.appium.core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarFormulario() {
		clickText("Formulário");
	}
	
	public void acessarSplash() {
		clickText("Splash");
	}
	
	public void acessarAlertas() {
		clickText("Alertas");
	}
}