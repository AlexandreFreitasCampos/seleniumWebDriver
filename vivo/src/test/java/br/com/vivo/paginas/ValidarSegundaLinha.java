package br.com.vivo.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ValidarSegundaLinha {

	public WebDriver driver;
	
	public ValidarSegundaLinha(WebDriver driver) {
		this.driver = driver;
	}
	
	public void validarSegundaLinha() throws InterruptedException {
		
		driver.get("https://meuvivo.vivo.com.br/meuvivo/appmanager/portal/vivo?_nfpb=true&_pageLabel=vcMovCtrlMeuPlanoNovo&_nfls=false");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\"idCombo\"]/div/span[2]")).click();
		
		WebElement meuPlano =  driver.findElement(By.xpath("//*[@id=\"idCombo\"]/div/span[2]"));
		
		Actions passarMouse = new Actions(driver);
		passarMouse.moveToElement(meuPlano).perform();
	}

}
