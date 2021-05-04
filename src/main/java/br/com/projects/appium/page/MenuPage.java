package br.com.projects.appium.page;

import br.com.projects.appium.core.DSL;

public class MenuPage {
	
	private DSL dsl = new DSL();
	
	public void acessarFormulario() {
		dsl.clickText("Formulário");
	}
}
