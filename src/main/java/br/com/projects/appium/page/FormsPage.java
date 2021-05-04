package br.com.projects.appium.page;

import org.openqa.selenium.By;

import br.com.projects.appium.core.BasePage;
import io.appium.java_client.MobileBy;

public class FormsPage extends BasePage {

	public void escreverNome(String nome) {
		write(MobileBy.AccessibilityId("nome"), nome);
	}
	
	public String getNome() {
		return getText(MobileBy.AccessibilityId("nome"));
	}
	
	public void selecionarCombo(String value) {
		selectCombo(MobileBy.AccessibilityId("console"), value);
	}
	
	public String getValorCombo() {
		return getText(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
	
	public void clicarCbxBox(){
		 click(By.className("android.widget.CheckBox"));
	}
	
	public void clicarSwitch() {
		click(MobileBy.AccessibilityId("switch"));
	}
	
	public boolean isCbxMarcado() {
		return isChecked(By.className("android.widget.CheckBox"));
	}
	
	public boolean isSwitchMarcado() {
		return isChecked(MobileBy.AccessibilityId("switch"));
	}
	
	public void btnSalvar() {
		clickText("SALVAR");
	}
	
	public String getNomeCadastrado() {
		return getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
	}
	
	public String getConsoleCadastrado() {
		return getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	}
	
	public String getCbxCadastrado() {
		return getText((By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")));
	}
	
	public String getSwitchCadastrado() {
		return getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	}    
}