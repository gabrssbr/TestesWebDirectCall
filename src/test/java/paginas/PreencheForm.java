package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PreencheForm {

    private WebDriver navegador;
    public PreencheForm(WebDriver navegador){
        this.navegador = navegador;
    }

    public PreencheForm informarEmpresa(String empresa){
        navegador.findElement(By.name("empresa")).sendKeys(empresa);
        return this;
    }

    public PreencheForm informarCnpj(String cnpj){
        navegador.findElement(By.name("cnpj")).sendKeys(cnpj);
        return this;
    }

    public PreencheForm informarNome(String nome){
        navegador.findElement(By.name("nome")).sendKeys(nome);
        return this;
    }

    public PreencheForm informarEmail(String email){
        navegador.findElement(By.name("email")).sendKeys(email);
        return this;
    }

    public PreencheForm informarTelefoneFixo(String fixo){
        navegador.findElement(By.cssSelector("input[name='fixo']")).sendKeys(fixo);
        return this;
    }

    public PreencheForm informarCelular(String celular){
        navegador.findElement(By.cssSelector("input[name='celular']")).sendKeys(celular);
        return this;
    }

    public Select informarEstado(String estado){
        WebElement selectElement = navegador.findElement(By.id("estado"));
        Select selectObject = new Select(selectElement);
        selectObject.selectByVisibleText(estado);

        return selectObject;
    }

    public Select informarCidade(String cidade){
        WebElement comboboxElement = navegador.findElement(By.id("cidade"));
        Select combobox = new Select(comboboxElement);
        combobox.selectByVisibleText(cidade);

        return combobox;
    }

    public Select informaAdaptador(String campo){
        WebElement adaptadorBox = navegador.findElement(By.name("sip_tipo_teste"));
        Select adaptador = new Select(adaptadorBox);
        adaptador.selectByValue(campo);

        return adaptador;
    }

    public PreencheForm informaObservacao (String observacao){
        navegador.findElement(By.name("observacoes")).sendKeys("TESTE1, TESTE2, TESTE3...");
        return this;
    }

    public PreencheForm submterFormulario(){
        navegador.findElement(By.cssSelector("button[type='submit']")).click();
        return this;
    }

    public PreencheForm capturarMensagem(){
        navegador.findElement(By.name("O valor é obrigatório e não pode estar vazio"));
        return this;
    }

}
