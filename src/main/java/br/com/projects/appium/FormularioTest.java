package br.com.projects.appium;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.projects.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FormularioTest {
	private AndroidDriver<MobileElement> driver;
	
	@Before
	public void startAppium() throws MalformedURLException {
	    driver = DriverFactory.getDriver();
		
	    //selecionar opção formulário
	    driver.findElement(By.xpath("//*[@text='Formulário']")).click();
	}
	
	@Test
	public void preencherCampoText() throws MalformedURLException {
//	    //selecionar opção formulário
//	    List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
//	    
//	    for(MobileElement elemento: elementosEncontrados) {
//	    	System.out.println(elemento.getText());
//	    }
//	    
//	    elementosEncontrados.get(1).click();
	    
	    //escrever nome
	    MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
	    campoNome.sendKeys("Pedro Guima");
	    
	    //validar nome escrito
	    String nome = campoNome.getText();
	    Assert.assertEquals("Pedro Guima", nome);
	}
	
	@Test
	public void interagirCombo() throws MalformedURLException {
	    //clicar no combo
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	    
	    //selecionar opção desejada
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
	    
	    //verificar opção selecionada
	    String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
	    Assert.assertEquals("Nintendo Switch", text);
	}
	
	@Test
	public void interagirSwitchCheckBox() throws MalformedURLException {
	   //verificar status dos elementos
	    MobileElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
	    MobileElement swit = driver.findElement(MobileBy.AccessibilityId("switch"));
	    
	    Assert.assertTrue(checkbox.getAttribute("checked").equals("false"));
	    Assert.assertTrue(swit.getAttribute("checked").equals("true"));
	    
	   //clicar nos elementos
	    checkbox.click();
	    swit.click();
	    
	   //verificar estados alterados
	    Assert.assertFalse(checkbox.getAttribute("checked").equals("false"));
	    Assert.assertFalse(swit.getAttribute("checked").equals("true"));
	}
	
	@Test
	public void preencherFormulario() throws MalformedURLException {
	    //preencher campo nome
	    driver.findElement(By.className("android.widget.EditText")).sendKeys("Pedro");
	    
	    //combo, checkbox & switch
	    driver.findElement(By.className("android.widget.CheckBox")).click();
	    driver.findElement(MobileBy.AccessibilityId("switch")).click();
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
	    
	    //clicar salvar
	    driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']")).click();
	    
	    //validar formulário
	    MobileElement nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Pedro']"));
	    Assert.assertEquals("Nome: Pedro", nome.getText());
	    
	    MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	    Assert.assertEquals("Console: switch", combo.getText());
	    
	    MobileElement swit = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	    Assert.assertTrue(swit.getText().endsWith("Off"));
	    
	    MobileElement cbx = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
	    Assert.assertTrue(cbx.getText().endsWith("Marcado"));
	}
	
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}
}