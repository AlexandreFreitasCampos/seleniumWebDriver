package br.com.vivo.conexao;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import br.com.vivo.paginas.LoginVivo;
import br.com.vivo.paginas.MeuPlano;
import br.com.vivo.paginas.ValidarSegundaLinha;

public class ConexaoVivo {
	// Instancia a classe WebDriver
	static WebDriver driver;
	
	static LoginVivo loginVivo ;
	static MeuPlano meuPlano;
	static ValidarSegundaLinha segundaLinha;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Informe o caminho dos drivers dos navegadores
		String caminhoChrome = "C:\\Users\\alexandre.campos\\eclipse-workspace\\chromedriver.exe";
		String caminhoFirefox = "C:\\Users\\alexandre.campos\\eclipse-workspace\\geckodriver.exe";
		String caminhoIE = "C:\\Users\\alexandre.campos\\eclipse-workspace\\IEDriverServer.exe";

		System.setProperty("webdriver.chrome.driver", caminhoChrome);
		System.setProperty("webdriver.gecko.driver", caminhoFirefox);
		System.setProperty("webdriver.ie.driver", caminhoIE);
		
		
		// Cria uma instância com os drivers dos navegadores
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		//driver = new InternetExplorerDriver();

		//Abre a URL
		driver.get("http://vivo.com.br");
		
		//Istancia a Classe após abertura da url
		loginVivo = new LoginVivo(driver);
		meuPlano = new MeuPlano(driver);
		segundaLinha = new ValidarSegundaLinha(driver);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		// Fecha o driver
		driver.quit();
	}

	@Test
	public void test() throws Exception {
		//fail("Not yet implemented");
		loginVivo.loginVivo();
		meuPlano.validarPlano();
		segundaLinha.validarSegundaLinha();
		
	}

}
