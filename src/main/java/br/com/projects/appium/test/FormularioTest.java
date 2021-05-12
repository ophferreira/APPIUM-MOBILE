package br.com.projects.appium.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.projects.appium.core.BaseTest;
import br.com.projects.appium.page.FormsPage;
import br.com.projects.appium.page.MenuPage;
import io.appium.java_client.MobileBy;

public class FormularioTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private FormsPage forms = new FormsPage();
	
	@Before
	public void startAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}
	
	@Test
	public void preencherCampoText() throws MalformedURLException {
		forms.escreverNome("Pedro");

	    assertEquals("Pedro", forms.getNome());
	}
	
	@Test
	public void interagirCombo() throws MalformedURLException {
		forms.selecionarCombo("Nintendo Switch");
	    Assert.assertEquals("Nintendo Switch", forms.getValorCombo());
	}
	
	@Test
	public void interagirSwitchCheckBox() throws MalformedURLException {
	    Assert.assertFalse(forms.isCbxMarcado());
	    Assert.assertTrue(forms.isSwitchMarcado());
	    
	    forms.clicarCbxBox();
	    forms.clicarSwitch();

	    Assert.assertTrue(forms.isCbxMarcado());
	    Assert.assertFalse(forms.isSwitchMarcado());
	}
	
	@Test
	public void realizarCadastro() throws MalformedURLException {
		forms.escreverNome("Pedro");
		forms.clicarCbxBox();
		forms.clicarSwitch();
		forms.selecionarCombo("Nintendo Switch");

	    forms.btnSalvar();

	    Assert.assertEquals("Nome: Pedro", forms.getNomeCadastrado());
	    Assert.assertEquals("Console: switch", forms.getConsoleCadastrado());
	    Assert.assertTrue(forms.getCbxCadastrado().endsWith("Marcado"));
	    Assert.assertTrue(forms.getSwitchCadastrado().endsWith("Off"));
	}
	
	@Test
	public void alterarData() {
		forms.clickText("01/01/2000");
		forms.clickText("20");
		forms.clickText("OK");
		Assert.assertTrue(forms.existElementText("20/2/2000"));
	}
	
	@Test
	public void alterarHora() {
		forms.clickText("06:00");
		forms.click(MobileBy.AccessibilityId("10"));
		forms.click(MobileBy.AccessibilityId("40"));
		forms.clickText("OK");
		Assert.assertTrue(forms.existElementText("10:40"));
	}
}