package dev.joenio.automation.pratice.selenium;          // Define o pacote do projeto


import org.junit.jupiter.api.AfterEach;                  // Importa anotações para métodos pós-teste
import org.junit.jupiter.api.Assertions;                 // Importa classe para asserções de teste
import org.junit.jupiter.api.BeforeEach;                 // Importa anotações para métodos pré-teste
import org.junit.jupiter.api.Test;                        // Importa anotação para método de teste
import org.openqa.selenium.By;                           // Importa seletor de elementos do Selenium
import org.openqa.selenium.WebDriver;                    // Importa interface principal do Selenium
import org.openqa.selenium.WebElement;                   // Importa interface para elementos HTML
import org.openqa.selenium.chrome.ChromeDriver;          // Importa driver do Chrome
import org.openqa.selenium.chrome.ChromeOptions;         // Importa opções para o ChromeDriver


class LoginTeste {                                        // Declaração da classe de teste
    private WebDriver driver;                             // Declara variável global do driver


    @BeforeEach                                           // Método executado antes de cada teste
    void setUp() {                                        // Método para inicializar ambiente de teste
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");          // Define o caminho do ChromeDriver
        ChromeOptions options = new ChromeOptions();      // Cria opções para o Chrome
        options.addArguments("--incognito");              // Abre navegador em modo anônimo
        driver = new ChromeDriver(options);               // Inicializa o driver com as opções definidas
        driver.manage().window().maximize();              // Maximiza a janela do navegador
        driver.get("https://www.saucedemo.com/");         // Abre a URL da aplicação para teste
    }


    @AfterEach                                           // Método executado após cada teste
    void tearDown() {                                     // Método para limpar ambiente de teste
        driver.quit();                                    // Fecha o navegador após o teste
    }


    @Test                                               						// Indica o método como um caso de teste
    void test() throws InterruptedException {         							  // Método de teste principal
        WebElement loginEmail = driver.findElement(By.id("user-name"));          // Localiza campo do usuário pelo id
        loginEmail.sendKeys("standard_user");                                   // Digita o usuário "standard_user"
        Thread.sleep(3000);                                                     // Pausa de 3 segundos (evitar se possível)

        WebElement passwordElement = driver.findElement(By.name("password"));   // Localiza campo senha pelo nome
        passwordElement.sendKeys("secret_sauce");                              // Digita a senha "secret_sauce"
        Thread.sleep(3000);                                                     // Pausa de 3 segundos (evitar se possível)

        WebElement loginButton = driver.findElement(By.id("login-button"));     // Localiza botão de login pelo id
        loginButton.click();                                                    // Clica no botão de login
        Thread.sleep(3000);                                                     // Pausa de 3 segundos (evitar se possível)
        
      
        WebElement title = driver.findElement(By.tagName("title"));          // Tenta localizar elemento pelo nome da tag "title" (inválido)
        String texTagTitle = title.getText();                                // Pega o texto do elemento encontrado
        Assertions.assertTrue(texTagTitle.equals("Products"));               // Verifica se o texto é igual a "Products"
    }
}
