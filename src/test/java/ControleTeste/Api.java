package ControleTeste;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import paginas.PreencheForm;

import java.util.concurrent.TimeUnit;

@DisplayName("Teste Web para formulário de APIs")
public class Api {

    private WebDriver navegador;


    @BeforeEach
    public void CarregaNavegador(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gsilva\\Documents\\Drivers\\chromedriver.exe");

        this.navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        navegador.get("https://teste.directcallsoft.com/teste/api");

    }

    @Test
    @DisplayName("Teste preenchendo formulário")
    public void preencheFormsApi(){

        Select mensagemApresentada = new PreencheForm(navegador)
                .informarEmpresa("SANTOS QA")
                .informarCnpj("068.163.569-00")
                .informarNome("SAO QAZEIRO")
                .informarEmail("qa@qa.com.br")
                .informarTelefoneFixo("4133552211")
                .informarCelular("41992185398")
                .informarEstado("PR");


        new PreencheForm(navegador)
                .informarCidade("Curitiba");


        new PreencheForm(navegador)
                .informaObservacao("TESTE TESTE")
                .submterFormulario()
                .capturarMensagem();

        Assertions.assertEquals("O valor é obrigatório e não pode estar vazio", mensagemApresentada);

    }



    @AfterEach
    public void afterEach(){
        //navegador.close();
    }
}
