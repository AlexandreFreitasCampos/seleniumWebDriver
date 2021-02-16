package br.com.vivo.paginas;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.sql.Time;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginVivo {

	public WebDriver driver;

	public LoginVivo(WebDriver driver) throws Exception {
		this.driver = driver;
	}

	public boolean validaPagina() {
		// Recomendação do Selenium
	    Boolean existe = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[3]/div/div[2]/ul/li[2]/a/span")).size() > 0;
	   		return existe;
		} 

	public void loginVivo() throws Exception {
		
		if(validaPagina()) {
			//Se entrar na página para selecionar o estado, clica em Rio de Janeiro
			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div[2]/ul/li[2]/a/span")).click();
		}
		//Segue se não entrar na página para selecionar o estado
		Thread.sleep(5000);

		// Valida o estado
		String texto = driver
				.findElement(By.xpath(
						"/html/body/div[2]/div[2]/header/div/div/div/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[2]/a"))
				.getText();
		assertEquals("Rio de Janeiro, RJ", texto);

		// Clica no botão login
		driver.findElement(By.xpath("//*[@id=\"main-menu\"]/div[1]/nav/div/a[2]")).click();

		// Aguarda a página carregar
		Thread.sleep(3000);

		// Insere o usuário do login
		driver.findElement(By.name("vivo_login_username")).sendKeys("02447060777");

		// Insere a senha
		driver.findElement(By.name("vivo_login_password")).sendKeys("@Gg190504");

		// Clica no botão para logar
		driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/header/div/div/div/div[1]/div[1]/div[2]/div/div/div[2]/form/button"))
				.click();

		//fim da página de login

	}

}
