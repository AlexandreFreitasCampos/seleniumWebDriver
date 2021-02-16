package br.com.vivo.paginas;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MeuPlano {
	static WebDriver driver;
	
	public MeuPlano(WebDriver driver) {
		MeuPlano.driver = driver;
	}
	
	public void validarPlano() throws InterruptedException {
		//Acessa a página do plano
		driver.get(
				"https://meuvivo.vivo.com.br/meuvivo/appmanager/portal/vivo?_nfpb=true&_nfls=false&_pageLabel=vcMeuVivoMovContLogBook&pFlutua=true");
		//Aguarda 10 segundos o carregamento
		Thread.sleep(5000);
		
		//Atualiza a página
		driver.navigate().refresh();
		
		Thread.sleep(5000);
				
		// Instancia a classe WebDriverwait
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// Aguardo o elemento presente na tela
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#btnFecharDiv > #btnFechar")));

		// Clica no botão fechar
		driver.findElement(By.cssSelector("#btnFecharDiv > #btnFechar")).click();

		Thread.sleep(5000);
		
		//Procura pelo elemento meu plano
		WebElement meuPlano = driver.findElement(By.linkText("Meu plano"));
		
		//Executa a ação de passar o mouse sobre o elemento
		Actions passarMouse = new Actions(driver);
		passarMouse.moveToElement(meuPlano).perform();

		// 4 | click | linkText=Detalhe do plano | |
		driver.findElement(By.linkText("Detalhe do plano")).click();
		
		// 5 | assertText | css=.valor_total:nth-child(5) span:nth-child(1) | R$44 |
		assertEquals(driver.findElement(By.cssSelector(".valor_total:nth-child(5) span:nth-child(1)")).getText(),
				"R$44");
		// 6 | pause | 3000 | |
		
	}
}
