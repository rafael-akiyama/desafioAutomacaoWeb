package steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class PropostaFeSteps {
	
	public WebDriver driver;
	
	@Dado("^que estou acessando uma aplicação$")
	public void queEstouAcessandoUmaAplicação() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
	    driver.get("http://automationpractice.com/index.php");
	}

	@Quando("^Fazer uma pesquisa de \"([^\"]*)\"$")
	public void fazerUmaPesquisaDe(String arg1) throws Throwable {
	    driver.findElement(By.id("search_query_top")).sendKeys(arg1);
	    
	}

	@Então("^Conclua a pesquisa com sucesso$")
	public void concluaAPesquisaComSucesso() throws Throwable {
		driver.findElement(By.name("submit_search")).click();
		driver.quit();
	}
	
	@Quando("^Selecionar o produto$")
	public void selecionarOProduto() throws Throwable {
		driver.findElement(By.id("search_query_top")).sendKeys("blouses");
		driver.findElement(By.name("submit_search")).click();
		driver.findElement(By.xpath("//img[@title='Blouse']")).click();
		driver.findElement(By.id("add_to_cart")).click();
		driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=order']")).click();
	}

	@Então("^Concluir a compra$")
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
		driver.quit();
	}
	
	@Quando("^entrar na minha conta$")
	public void entrarNaMinhaConta() throws Throwable {
		driver.findElement(By.id("search_query_top")).click();
		driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=my-account']")).click();
		
		
	}
	
	@Então("^acesso minha conta$")
	public void acessoMinhaConta() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("rafakiyama@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("rafa123");
		driver.findElement(By.id("SubmitLogin")).click();
	}
	
	@Então("^apresenta erro de login inválido$")
	public void apresentaErroDeLoginInválido() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("rafaakiyama@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("rafa123");
		driver.findElement(By.id("SubmitLogin")).click();
	}

}
