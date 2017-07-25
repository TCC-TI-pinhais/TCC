package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Alertas;
import model.CriptografiaOtp;
import model.TCC;
import model.Usuario;
import model.jdbc.UsuarioDAO;

public class CadastraUsuarioController implements Initializable {

    @FXML
    private PasswordField textSenha;

    @FXML
    private TextField textLogin;

    @FXML
    private TextField textEmail;

    @FXML
    private CheckBox checkRevendedor;

    @FXML
    void cadastra(ActionEvent event) {
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        CriptografiaOtp criptografia = new CriptografiaOtp();
        usuario.setLogin(textLogin.getText());
        usuario.setEmail(textEmail.getText());
        usuario.setRevendedor(checkRevendedor.isSelected());
        String chave = criptografia.genKey(textSenha.getText().length());
        usuario.setChaveSenha(chave);
        usuario.setSenha(criptografia.criptografa(textSenha.getText(), chave));
        usuarioDAO.addUsuario(usuario);
        
        
    }

    @FXML
    void voltar(ActionEvent event) {
        TCC tcc = new TCC();
        tcc.fechaTela();
        tcc.iniciaStage("Login.fxml");
    }
    
    private boolean verificaValores(){
        Alertas alerta = new Alertas();
        for (int i = 0; i < Usuario.getUsuarios().size(); i++) {
            if (textLogin.getText().equals(Usuario.getUsuarios().get(i).getLogin())) {
                alerta.erroCadastroUsuarioLogin();
                return true;
            } else if (textLogin.getText().length() > 100) {
                alerta.erroCadastroUsuarioLogin();
                return true;
            } else if (textSenha.getText().length() > 100) {
                alerta.erroCadastroUsuarioSenha();
                return true;
            } else if (true) {
                
            }
            
            
        }
        return false;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario.setUsuarios(usuarioDAO.selectUsuario());
        
    }    
    
}
