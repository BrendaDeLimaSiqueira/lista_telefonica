package ifpr.pgua.eic.listatelefonica.controllers;

import ifpr.pgua.eic.listatelefonica.App;
import ifpr.pgua.eic.listatelefonica.models.Contato;
import ifpr.pgua.eic.listatelefonica.models.ListaTelefonica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class JanelaLista {

    private HBox root;
    private ListView<Contato> ltvContatos;
    //visualização de lista dos contatos
    private TextArea taDetalhes;
    //TextArea = ta

    private Button btVoltar;

    private ListaTelefonica listaTelefonica;

    public JanelaLista(ListaTelefonica listaTelefonica){
        this.listaTelefonica = listaTelefonica;
        inicializaComponentes();
        carregaDados();
    }

    private void inicializaComponentes(){
        
        ltvContatos = new ListView<>();
        ltvContatos.setOnMouseClicked(this::mostraDetalhes);
        //quando clicar no contato, mostra os detalhes
        
        taDetalhes = new TextArea();
        taDetalhes.setPrefWidth(200.0);

        btVoltar = new Button("Voltar");
        btVoltar.setOnAction(this::voltar);

        VBox box = new VBox();
        box.setSpacing(10.0);

        box.getChildren().addAll(ltvContatos,btVoltar);

        root = new HBox();
        root.setSpacing(10.0);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(ltvContatos,taDetalhes);
        root.getChildren().addAll(box,taDetalhes);
        
    }

    private void carregaDados(){
        ltvContatos.getItems().clear();
        //limpo itens da lista de contatos
        ltvContatos.getItems().addAll(listaTelefonica.getContatos());
        //lista telefonica para dar a lista de contatos para adicionar na list view
    }

    private void mostraDetalhes(MouseEvent evento){
        taDetalhes.clear();
        
        Contato contato = ltvContatos.getSelectionModel().getSelectedItem();
        //list view pega o contato e seleciona o modelo

        if(contato != null){
            taDetalhes.appendText("Nome: "+contato.getNome()+"\n");
            taDetalhes.appendText("Telefone: "+contato.getTelefone()+"\n");    
            taDetalhes.appendText("Email: "+contato.getEmail()+"\n");    
            //append acrescenta 
        }
    }

    public Parent getRoot(){
        return root;
    }

    private void voltar(ActionEvent evento) {
        App.popScreen();
    }

}
