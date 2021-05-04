package br.com.projects.appium.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.projects.appium.core.DriverFactory;
import br.com.projects.appium.page.FormsPage;
import br.com.projects.appium.page.MenuPage;

public class FormularioTest {
	
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
	
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}
}