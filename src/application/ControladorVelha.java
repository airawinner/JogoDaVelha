package application;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControladorVelha {

    @FXML
    private VBox Xframes;

    @FXML
    private VBox background;

    @FXML
    private ImageView reiniciar;

    @FXML
    private ImageView sair;

    @FXML
    private StackPane stackPane;

    @FXML
    private ImageView velha;

    @FXML
    private ImageView vitoria;

    private boolean win = true;
    private String nomeVencedor;

    @FXML
    private Label vencedor;

    public Label getVencedor() {
        return vencedor;
    }

    public void setVencedor(Label vencedor) {
        this.vencedor = vencedor;
    }

    public String getNomeVencedor() {
        return nomeVencedor;
    }

    public void setNomeVencedor(String nomeVencedor) {
        this.nomeVencedor = nomeVencedor;
    }

    public boolean getWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    private void carregarTela1() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("jogadores.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) stackPane.getScene().getWindow();
        stage.setScene(scene);
     
    }

    @FXML
    void AcaoDoTabuleiro(MouseEvent event) throws IOException {
        if (event.getSource() == sair) {
            System.exit(0);
        }
        if (event.getSource() == reiniciar) {
            carregarTela1();
        }
    }

    public void customInitialize() {
        if (win) {
            velha.setVisible(false);
            vencedor.setText("O vencedor é " + nomeVencedor);
        } else {
            vitoria.setVisible(false);
            vencedor.setText("");
        }
    }

    @FXML
    void initialize() {
        
    }
}
