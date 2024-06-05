package application;
import Logica.Tabuleiro;
import Logica.Jogo;
import Logica.Jogador;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class ControladorTabuleiro {
	@FXML
	private ImageView reiniciar;

	@FXML
	private ImageView sair;

    @FXML
    private StackPane stackPane;

    @FXML
    private ImageView tabuleiro;

    @FXML
    private ImageView Xframe;

    @FXML
    private ImageView Oframe;
    
    private ImageView[][] ImageViews;
    
    @FXML
    private ImageView winColuna;

    @FXML
    private ImageView winDiagonalPrin;

    @FXML
    private ImageView winDiagonalSec;

    @FXML
    private ImageView winLine;
    
    private Jogo jogo;
    
    
    public void setJogo(Jogo jogo) {
       this.jogo=jogo; 
       System.out.println("nome jog2:"+jogo.getJogadorO().getNome());
       System.out.println("nome jog1:"+jogo.getJogadorX().getNome());
    }

    @FXML
    void AcaoDoTabuleiro(MouseEvent event) {
    	
    	
       
    }
    @FXML
    void initialize() {
    	Oframe.setVisible(false);
    	Xframe.setVisible(false);
        // Define a largura e altura das células da matriz
        double larguraX = 130;
        double alturaX = 130;
        double incrementar=0;

        // Posiciona as imagens X e O dentro do StackPane
        for (int linha = 0; linha< 3; linha++) {
            incrementar-=150;
            for (int coluna = 0; coluna < 3; coluna++) {
                ImageView xzinho = new ImageView();
                ImageView bolinha = new ImageView(); //bolinha

                xzinho.setFitWidth(larguraX);
                xzinho.setFitHeight(alturaX);
                bolinha.setFitWidth(larguraX);
                bolinha.setFitHeight(alturaX);

                // Calcula as coordenadas X e Y para posicionar a célula na grade
                double cellX = 2 * linha * larguraX;
                double cellY = 2 * coluna * alturaX;

                // Define a posição da célula no StackPane
                StackPane.setMargin(xzinho, new Insets(cellY - 70, 0, 0, cellX - 300));
                StackPane.setMargin(bolinha, new Insets(cellY - 70, 0, 0, cellX - 300));

                // Define as imagens X e O
                xzinho.setImage(Xframe.getImage());
                bolinha.setImage(Oframe.getImage());

                // Adiciona o EventHandler para cada ImageView
                xzinho.setOnMouseClicked(event -> {
                    xzinho.setVisible(false); // Torna a ImageView X invisível quando clicada
                });
                bolinha.setOnMouseClicked(event -> {
                    bolinha.setVisible(false); // Torna a ImageView O invisível quando clicada
                });

                stackPane.getChildren().add(xzinho);
                stackPane.getChildren().add(bolinha);
            }
        }
    }

}
