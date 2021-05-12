package br.com.projects.appium.page;

import org.openqa.selenium.By;

import br.com.projects.appium.core.BasePage;

public class AccordionPage extends BasePage {
	
	public void selecionarOp1() {
		clickText("Opção 1");
	}
	
	public String getValor0p1() {
		return getText(By.xpath("//*[@text='Esta é a descrição da opção 1']/../..//following-sibling::android.view.ViewGroup//android.widget.TextView"));
	}
}