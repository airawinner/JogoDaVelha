package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

import Logica.Jogador;
import Logica.Jogo;

public class ControladorIniciar {

    private Jogador jogador1;
    private Jogador jogador2;

    @FXML
    private ImageView comecar;

    @FXML
    private ImageView sair;

    @FXML
    private StackPane stackPane;

    @FXML
    private ImageView tabuleiro;
    
    @FXML
    private TextField fieldJogador2;

    @FXML
    private TextField fieldjogador1;
    
    private int clicked1=0;
    private int clicked2=0;

    @FXML
    void AcaoDoInicial(MouseEvent event)throws IOException  {
        if (event.getSource() == fieldjogador1) {
            System.out.println("Clicou em jogador1Img");
            clicked1=1;
            abrirCampoNome(fieldjogador1, "Jogador 1");
        } else if (event.getSource() == fieldJogador2) {
            System.out.println("Clicou em jogador2Img");
            clicked2=1;
            abrirCampoNome(fieldJogador2, "Jogador 2");
        } else if (event.getSource() == comecar) {
            System.out.println("Clicou em comecar");
            if (jogador1 != null && jogador2 != null) {
                System.out.println("Clicou em comecar");
            
                FXMLLoader loader = new FXMLLoader(getClass().getResource("tabuleiro.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) stackPane.getScene().getWindow();
                stage.setScene(scene);
                ControladorTabuleiro controller = loader.getController();
                Jogo jogo= new Jogo(jogador1,jogador2);
                controller.setJogo(jogo);
            } else {
                // Informa aos jogadores que eles precisam inserir seus nomes
                System.out.println("Por favor, insira o nome de ambos os jogadores.");
            }
        }
    }

    private void abrirCampoNome(TextField textField, String prompt) {
        textField.setPromptText(prompt);
        textField.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        textField.setPrefWidth(150);
        textField.requestFocus(); // Foca no campo de texto ao abrir

        textField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER || (clicked1==1 || clicked2==1) )
            {
            	//aqui se não apertar enter ele "come" a última char da string 
               // e inicialmente antes de dar um click no tetxfield ele entra em fonte diferente
            	//tem que  consertar no fxml e fazer o usuário clicar antes de sair digitando 
            	//bugs do java
            	
                String nome = textField.getText();
                if (!nome.isEmpty()) {
                    if (textField == fieldjogador1) {
                        jogador1 = new Jogador(nome);
                    } else if (textField == fieldJogador2) {
                        jogador2 = new Jogador(nome);
                    }
                }
            }
        });
    }
}
