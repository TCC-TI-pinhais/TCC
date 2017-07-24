package control;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import model.TCC;

public class LoginController implements Initializable {

    @FXML
    void login(ActionEvent event) {
        TCC tcc = new TCC();
        Stage stage = new Stage();
        tcc.iniciaStage("Home.fxml");
        
    }
    
    @FXML
    void fechar(ActionEvent event) {
        TCC tcc = new TCC();
        tcc.fechaTela();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
