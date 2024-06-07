package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import Logica.*;

public class ControladorTabuleiro {

	@FXML
	private ImageView Oframe;

	@FXML
	private Label VezJogador;

	@FXML
	private ImageView Xframe;

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
	private ImageView tabuleiro;

	private Jogo jogo;
	
    private double larguraX = 130;
    private double alturaX = 130;


	public void setTextoPlayerInicial(Jogador jogador1) {
		VezJogador.setText("O jogador Inicial é " + jogador1.getNome());
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
		//System.out.println("nome jog2: " + jogo.getJogadorO().getNome()+" symbol "+ jogo.getJogadorO().getSimbolo());
		//System.out.println("nome jog1:" + jogo.getJogadorX().getNome()+" symbol "+ jogo.getJogadorX().getSimbolo());
	}

	private Quadrante procurarQuadrante(double xImageView, double yImageView) {
	    Quadrante quadrante = new Quadrante();
	    double aux=1;
	    double auxy=0;
	  

	    for (double x = 0; x <= 600; x += 200) {
	    	auxy=0;	
	    	
	        for (double y = 180; y <= 600; y += 140) {
	            if (xImageView >= x && xImageView <= x + 200 && yImageView >= y && yImageView <= y + 140) {
	            	double cellX =2.5* aux * larguraX;  // larguraX = 130
	                double cellY =2.2*  auxy * alturaX;    // alturaX = 130

	                //System.out.println("Clicou no quadrante coluna "+aux +"linha " +auxy);
	              //  System.out.println("Clicou no quadrante  "+cellY +" " + cellX);
	                quadrante.setX(cellX);//você é a coluna
	                quadrante.setY(cellY);//vocÊ é a largura
	                quadrante.setLinha((int)(aux-1));
	                quadrante.setColuna((int)auxy);
	               // System.out.println("x "+ quadrante.getLinha() +"y"+quadrante.getColuna() );
	                return quadrante;
	            }
	            auxy++;
	       
	        }
	        aux++;
	    }

	    return quadrante;
	}
	private ImageView criarXouO(ImageView frame) {
	    ImageView novaImageView = new ImageView();
	    novaImageView.setImage(frame.getImage());
	    novaImageView.setFitWidth(130);
	    novaImageView.setFitHeight(130);
	    return novaImageView;
	}
	private void resetar(boolean bool, String nome) throws IOException {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("vitoria.fxml"));
	    Parent root = loader.load();
	    Scene scene = new Scene(root);

	    // Check if the stackPane is attached to a scene and the scene is attached to a window
	    if (stackPane.getScene() != null && stackPane.getScene().getWindow() != null) {
	        Stage stage = (Stage) stackPane.getScene().getWindow();
	        stage.setScene(scene);
	        ControladorVelha controller = loader.getController();
	        controller.setWin(bool);
	        controller.setNomeVencedor(nome);
	        controller.customInitialize(); // Call custom initialization method
	    } else {
	        //System.err.println("Error: Scene or window is null.");
	    	//algum erro chato de runtime
	    }
	}


    private void retornar() throws IOException {
   	 FXMLLoader loader = new FXMLLoader(getClass().getResource("jogadores.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) stackPane.getScene().getWindow();
        stage.setScene(scene);
     
        
        
   }
 
	@FXML
	void AcaoDoTabuleiro(MouseEvent event) throws IOException {
	
	    
	    if (event.getSource() == tabuleiro) {
	        double xMouse = event.getSceneX();
	        double yMouse = event.getSceneY();

	        // Convertendo as coordenadas do mouse para as coordenadas do ImageView
	        Point2D localCoords = tabuleiro.sceneToLocal(xMouse, yMouse);
	        double xImageView = localCoords.getX();
	        double yImageView = localCoords.getY();

	      //  System.out.println("Clique dentro do ImageView: x = " + xImageView + ", y = " + yImageView);
	        
	        // Procura o quadrante correspondente ao clique do mouse
	        Quadrante quadrante = procurarQuadrante(xImageView, yImageView);

	       //x ou o 
	       ImageView novaImageView=new ImageView();
	        if (jogo.getJogadorAtual().getSimbolo() =='X') {
	        	novaImageView=criarXouO(Xframe);
            } else {
            	novaImageView=criarXouO(Oframe);
            }
             if(jogo.fazerJogada(quadrante.getLinha(),quadrante.getColuna())==false) {
            	 VezJogador.setText("jogada inválida!" );
            }else {
            	 StackPane.setMargin(novaImageView, new Insets(quadrante.getY()-100, 0, 0, quadrante.getX()-700));
                 stackPane.getChildren().add(novaImageView);
                 jogo.alternarJogador();
            }
	        
	       
            VezJogador.setText("é a vez do jogador "+ jogo.getJogadorAtual().getNome() );
          
         
           
            if( jogo.verificarVencedor()!=' ') {
            	if(jogo.getJogadorAtual().getNome().equals(jogo.getJogadorO().getNome())){
            		
            		 resetar(true,jogo.getJogadorX().getNome());
            	}else {
            	    resetar(true,jogo.getJogadorO().getNome());
            		} 
            	
            	}
            }
	       if(jogo.Empate()){
    		resetar(false,":(");	
                   
          
	    }

	    if (event.getSource() == sair) {
	        System.exit(0);
	    }

	    if (event.getSource() == reiniciar) {
	    	retornar();
               
	    }
	}

	 @FXML
	 void initialize() {
		 Xframe.setVisible(false);
		 Oframe.setVisible(false);
	 }
}
