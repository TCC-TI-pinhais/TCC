package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.TCC;

public class InicioController implements Initializable {

    @FXML
    private ImageView imagem;
    
    @FXML
    private ImageView imagem2;

    @FXML
    void inicio(ActionEvent event) {
        TCC tcc = new TCC();
        tcc.fechaTela();
        tcc.iniciaStage("Login.fxml");
    }
    
    public void iniciaImagem(){
        imagem.setImage(new Image("file:///" + System.getProperty("user.dir") + "\\src\\imagens\\EssenciAll.png"));
        imagem2.setImage(new Image("file:///" + System.getProperty("user.dir") + "\\src\\imagens\\pefumelogo.jpg"));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciaImagem();
    }    
    
}
