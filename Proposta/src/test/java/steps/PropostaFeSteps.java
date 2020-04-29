package steps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PropostaFeSteps {
	
	public WebDriver driver;
	

	@Quando("^Fazer uma pesquisa de \"([^\"]*)\"$")
	public void fazerUmaPesquisaDe(String arg1) throws Throwable {
	    driver.findElement(By.id("search_query_top")).sendKeys(arg1);
	    
	}

	@Entao("^Conclua a pesquisa com sucesso$")
	public void concluaAPesquisaComSucesso() throws Throwable {
		driver.findElement(By.name("submit_search")).click();
		String texto = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[2]")).getText();
		Assert.assertEquals("1 result has been found.", texto);
		
	}
	
	@Quando("^Selecionar o produto$")
	public void selecionarOProduto() throws Throwable {
		driver.findElement(By.id("search_query_top")).sendKeys("blouses");
		driver.findElement(By.name("submit_search")).click();
		driver.findElement(By.xpath("//img[@title='Blouse']")).click();
		driver.findElement(By.id("add_to_cart")).click();
		driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=order']")).click();
	}

	@Entao("^Concluir a compra$")
	public void concluirACompra() throws Throwable {
		driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=order']")).click();
		driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=order&step=1']")).click();
		driver.findElement(By.id("email")).sendKeys("rafakiyama@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("rafa123");
		driver.findElement(By.id("SubmitLogin")).click();
		driver.findElement(By.name("processAddress")).click();
		driver.findElement(By.name("cgv")).click();
		driver.findElement(By.name("processCarrier")).click();
		driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment\']")).click();
		driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium']")).click();
		String texto = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong")).getText();
		Assert.assertEquals("Your order on My Store is complete.", texto);
	}
	
	@Quando("^entrar na minha conta$")
	public void entrarNaMinhaConta() throws Throwable {
		driver.findElement(By.id("search_query_top")).click();
		driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=my-account']")).click();
		
		
	}
	
	@Entao("^acesso minha conta$")
	public void acessoMinhaConta() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("rafakiyama@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("rafa123");
		driver.findElement(By.id("SubmitLogin")).click();
		String texto = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();
		Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", texto);
	}
	
	@Entao("^apresenta erro de login invalido$")
	public void apresentaErroDeLoginInvalido() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("rafaakiyama@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("rafa123");
		driver.findElement(By.id("SubmitLogin")).click();
		String texto = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
		Assert.assertEquals("Authentication failed.", texto);
	}
	
	@Before
	public void abreBrowser( ) {
	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
	driver = new ChromeDriver();
    driver.get("http://automationpractice.com/index.php");
	}
	
	@After
	public void fecharBrowser() {
		driver.quit();

	}
}
