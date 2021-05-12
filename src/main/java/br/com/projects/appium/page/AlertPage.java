package br.com.projects.appium.page;

import org.openqa.selenium.By;

import br.com.projects.appium.core.BasePage;

public class AlertPage extends BasePage {

	public void clicarAlertaConfirm() {
		clickText("ALERTA CONFIRM");
	}
	
	public void clicarAlertaSimples() {
		clickText("ALERTA SIMPLES");
	}
	
	public String getTituloAlert() {
		return getText(By.id("android:id/alertTitle"));
	}
	
	public String getMsgAlert() {
		return getText(By.id("android:id/message"));
	}
	
	public void confirmar() {
		clickText("CONFIRMAR");
	}
	
	public void sair() {
		clickText("SAIR");
	}
	
	public void clicarForaCaixa() {
		tap(100, 150);
	}
}