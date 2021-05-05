package br.com.projects.appium.core;

import static br.com.projects.appium.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;

public class BasePage {

	public void write(By by, String text) {
		getDriver().findElement(by).sendKeys(text);
	}
	
	public String getText(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public void click(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clickText(String text) {
		click(By.xpath("//*[@text='"+ text +"']"));
	}
	
	public void selectCombo(By by, String value) {
	    //clicar no combo
	    getDriver().findElement(by).click();
	    
	    //selecionar opção desejada
	    getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='"+value+"']")).click();
	}
	
	public boolean isChecked(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}
	
	public boolean existElementText(String text) {
		List<MobileElement> elements = getDriver().findElements(By.xpath("//*[@text='"+text+"']"));
		
		return elements.size() > 0;
	}
}