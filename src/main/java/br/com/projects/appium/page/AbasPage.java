package br.com.projects.appium.page;

import br.com.projects.appium.core.BasePage;

public class AbasPage extends BasePage {

	public boolean isAba1() {
		return existElementText("Este é o conteúdo da Aba 1");
	}
	
	public boolean isAba2() {
		return existElementText("Este é o conteúdo da Aba 2");
	}
	
	public void clicarAba2() {
		clickText("ABA 2");
	}
}