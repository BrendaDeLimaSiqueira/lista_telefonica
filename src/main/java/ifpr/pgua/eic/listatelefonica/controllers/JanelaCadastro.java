package ifpr.pgua.eic.listatelefonica.controllers;

import ifpr.pgua.eic.listatelefonica.App;
import ifpr.pgua.eic.listatelefonica.models.ListaTelefonica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class JanelaCadastro {
    
    private VBox root;
    
    private Label lbNome;
    //label identifica outro componente, rotula o textfield

    private TextField tfNome;
    //textfield para o usario digitar
    private Label lbTelefone;
    private TextField tfTelefone;

    private Label lbEmail;
    private TextField tfEmail;


    private Button btCadastrar;
    private Button btVoltar;

    private ListaTelefonica listaTelefonica;

    public JanelaCadastro(ListaTelefonica listaTelefonica){
        this.listaTelefonica = listaTelefonica;
        inicializaComponentes();
        //para colocar dentro da raiz
    }

    private void inicializaComponentes(){
        lbNome = new Label("Nome:");
        tfNome = new TextField();

        lbTelefone = new Label("Telefone:");
        tfTelefone = new TextField();

        lbEmail = new Label("E-mail");
        tfEmail = new TextField();

        btCadastrar = new Button("Cadastrar");
        btCadastrar.setOnAction(this::cadastrar);
        //quando clicar no botao Cadastrar, para cadastrar

        btVoltar = new Button("Voltar");
        btVoltar.setOnAction(this::voltar);


        //colocar os componentes um do lado do outro com o hbox
        HBox botoes = new HBox();
        botoes.getChildren().addAll(btVoltar,btCadastrar);


        root = new VBox();
        root.setSpacing(5.0);
        //spacing espaço entre os componentes

        root.setPadding(new Insets(20));
        //padding uma borda invisivel para dar um espaço ao redor da tela

        root.getChildren().addAll(lbNome,tfNome);
        root.getChildren().addAll(lbTelefone,tfTelefone);
        root.getChildren().addAll(lbEmail,tfEmail);
        root.getChildren().add(botoes);

    }
    

    public Parent getRoot(){
        return root;
    }


    private void cadastrar(ActionEvent evento){
        String nome = tfNome.getText();
        String telefone = tfTelefone.getText();
        //get para pegar o que o usuario digitou, retorna String
        String email = tfEmail.getText();


        String msg = "Cadstro realizado!"; 
        if(!listaTelefonica.adicionarContato(nome, telefone, email)){
            msg = "Cadastro não realizado!";
        }else{
            limpar();
        }

        Alert alert = new Alert(AlertType.INFORMATION,msg);
        alert.showAndWait();
        //mostrar caixa para o usuario de cadastro realizado

    }

    private void limpar(){
        tfNome.clear();
        tfTelefone.clear();
        tfEmail.clear();
    }

    private void voltar(ActionEvent evento){
        App.popScreen();
    }


}
