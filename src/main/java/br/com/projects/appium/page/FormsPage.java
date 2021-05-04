package br.com.projects.appium.page;

import org.openqa.selenium.By;

import br.com.projects.appium.core.DSL;
import io.appium.java_client.MobileBy;

public class FormsPage {
	
	private DSL dsl = new DSL();

	public void escreverNome(String nome) {
		dsl.write(MobileBy.AccessibilityId("nome"), nome);
	}
	
	public String getNome() {
		return dsl.getText(MobileBy.AccessibilityId("nome"));
	}
	
	public void selecionarCombo(String value) {
		dsl.selectCombo(MobileBy.AccessibilityId("console"), value);
	}
	
	public String getValorCombo() {
		return dsl.getText(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
	
	public void clicarCbxBox(){
		 dsl.click(By.className("android.widget.CheckBox"));
	}
	
	public void clicarSwitch() {
		dsl.click(MobileBy.AccessibilityId("switch"));
	}
	
	public boolean isCbxMarcado() {
		return dsl.isChecked(By.className("android.widget.CheckBox"));
	}
	
	public boolean isSwitchMarcado() {
		return dsl.isChecked(MobileBy.AccessibilityId("switch"));
	}
	
	public void btnSalvar() {
		dsl.clickText("SALVAR");
	}
	
	public String getNomeCadastrado() {
		return dsl.getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
	}
	
	public String getConsoleCadastrado() {
		return dsl.getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	}
	
	public String getCbxCadastrado() {
		return dsl.getText((By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")));
	}
	
	public String getSwitchCadastrado() {
		return dsl.getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	}    
}
