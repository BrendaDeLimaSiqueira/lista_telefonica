package ifpr.pgua.eic.listatelefonica.controllers;

import ifpr.pgua.eic.listatelefonica.App;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class JanelaPrincipal {

    private HBox root;
    private Button btCadastro;
    private Button btListar;

    public JanelaPrincipal(){
        inicializaComponentes();
    }

    private void inicializaComponentes(){
        btCadastro = new Button("Cadastro");
        btCadastro.setOnAction(this::carregaTelaCadastro);

        btListar = new Button("Listar");
        btListar.setOnAction(this::carregaTelaLista);

        root = new HBox();
        root.setSpacing(10.0);
        root.setAlignment(Pos.CENTER);
        root.setPrefSize(400, 600);

        root.getChildren().addAll(btCadastro,btListar);
    }

    private void carregaTelaCadastro(ActionEvent evento){
        App.pushScreen("CADASTRO");
        //troca conteudo da janela
    }

    private void carregaTelaLista(ActionEvent evento){
        App.pushScreen("LISTA");
        // (*) esta registrado na classe app
    }

    public Parent getRoot(){
        return root;
    }

    
}
