package ControleTeste;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import paginas.PreencheForm;

import java.util.concurrent.TimeUnit;

public class SipTrunk {

    private WebDriver navegador;

    @BeforeEach
    public void CarregaNavegador(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gsilva\\Documents\\Drivers\\chromedriver.exe");

        this.navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        navegador.get("https://teste.directcallsoft.com/teste/sip-trunk");

    }

    @Test
    @DisplayName("Preenche formulário de testes SipTrunk Directcall, com sucesso")
    public void SipTrunkDc(){

        Select mensagemApresentada = new PreencheForm(navegador)
                .informarEmpresa("SANTOS QA")
                .informarCnpj("068.163.569-00")
                .informarNome("SAO QAZEIRO")
                .informarEmail("gabrielcwb@live.com")
                .informarTelefoneFixo("4133552211")
                .informarCelular("41992185398")
                .informarEstado("PR");

        new PreencheForm(navegador)
                .informarCidade("Curitiba");

        new PreencheForm(navegador)
                .informaAdaptador("5");

        new PreencheForm(navegador)
                .informaObservacao("TESTE TESTE")
                .submterFormulario()
                .capturarMensagem();

        Assertions.assertEquals("O valor é obrigatório e não pode estar vazio", mensagemApresentada);

    }

    @Test
    @DisplayName("Erro de CPF já cadastrado")
    public void formularioSipComCpfJaUsado(){

        Select mensagemApresentada = new PreencheForm(navegador)
                .informarEmpresa("SANTOS QA CPF")
                .informarCnpj("068.163.569-00")
                .informarNome("JOAO QAZEIRO CPF")
                .informarEmail("gabrielcwb@live.com")
                .informarTelefoneFixo("4133552211")
                .informarCelular("41992185398")
                .informarEstado("PR");

        new PreencheForm(navegador)
                .informarCidade("Curitiba");

        new PreencheForm(navegador)
                .informaAdaptador("5");

        new PreencheForm(navegador)
                .informaObservacao("TESTE TESTE")
                .submterFormulario()
                .capturarMensagem();

        Assertions.assertEquals("O valor é obrigatório e não pode estar vazio", mensagemApresentada);

    }


    @AfterEach
    public void CloseBrowser(){


    }

}
