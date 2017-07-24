package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.TCC;

public class LoginController implements Initializable {

    @FXML
    private PasswordField textSenha;

    @FXML
    private TextField textLogin;
    
    @FXML
    void login(ActionEvent event) {
        TCC tcc = new TCC();
        tcc.iniciaStage("Home.fxml");
        
    }
    
    @FXML
    void fechar(ActionEvent event) {
        TCC tcc = new TCC();
        tcc.fechaTela();
    }
    
    @FXML
    void cadastrar(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
