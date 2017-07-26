package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.CriptografiaOtp;
import model.TCC;
import model.Usuario;

public class LoginController implements Initializable {

    @FXML
    private PasswordField textSenha;

    @FXML
    private TextField textLogin;
    
    @FXML
    void login(ActionEvent event) {
        CriptografiaOtp criptografia = new CriptografiaOtp();
        TCC tcc = new TCC();
        String senha;
        for (int i = 0; i < Usuario.getUsuarios().size(); i++) {
            
            senha = criptografia.decriptografa(Usuario.getUsuarios().get(i).getSenha(), Usuario.getUsuarios().get(i).getChaveSenha());
            if (senha.equals(textSenha.getText()) && textLogin.getText().equals(Usuario.getUsuarios().get(i).getLogin())) {
                
                if (Usuario.getUsuarios().get(i).isRevendedor()) {
                    tcc.fechaTela();
                    tcc.iniciaStage("HomeRevendedor.fxml");
                    
                } else {
                    tcc.fechaTela();
                    tcc.iniciaStage("HomeUsuario.fxml");
                }
                
            }
            
        }
        
        
        
    }
    
    @FXML
    void fechar(ActionEvent event) {
        TCC tcc = new TCC();
        tcc.fechaTela();
    }
    
    @FXML
    void cadastrar(ActionEvent event) {
        TCC tcc = new TCC();
        tcc.fechaTela();
        tcc.iniciaStage("CadastraUsuario.fxml");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Usuario.atualizaUsuarios();
    }    
    
}
