package control;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    private PasswordField textSenha2;

    @FXML
    void cadastra(ActionEvent event) {
        
        if (verificaValores()) {
            
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = new Usuario();
            CriptografiaOtp criptografia = new CriptografiaOtp();
            Alertas alerta = new Alertas();
            usuario.setLogin(textLogin.getText());
            usuario.setEmail(textEmail.getText());
            usuario.setRevendedor(checkRevendedor.isSelected());
            String chave = criptografia.genKey(textSenha.getText().length());
            usuario.setChaveSenha(chave);
            usuario.setSenha(criptografia.criptografa(textSenha.getText(), chave));
            usuarioDAO.addUsuario(usuario);
            alerta.usuarioCadastrado();
            Usuario.atualizaUsuarios();
            
        } else {
            System.out.println("Não cadastrou!");
        }
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
            System.out.println(Usuario.getUsuarios().get(i).getLogin());
            if (textLogin.getText().equals(Usuario.getUsuarios().get(i).getLogin())) {
                alerta.erroCadastroUsuarioLoginExistente();
                return false;
            } else if (textEmail.getText().equals(Usuario.getUsuarios().get(i).getEmail())) {
                alerta.erroCadastroUsuarioEmailExistente();
                return false;
            }
        }
        if (textLogin.getText().length() > 100 || textLogin.getText().equals("")) {
            alerta.erroCadastroUsuarioLogin();
            return false;
        } else if (textSenha.getText().length() > 100 || textSenha.getText().equals("")) {
            alerta.erroCadastroUsuarioSenha();
            return false;
        } else if (validaEmail()) {
            alerta.erroCadastroUsuarioEmail();
            return false;
        } else if (!textSenha2.getText().equals(textSenha.getText())) {
            alerta.erroCadastroUsuarioSenhaDiferente();
            return false;
        }
        
        return true;
    }
    
    private boolean validaEmail(){
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(textEmail.getText());
        if (m.find() && m.group().equals(textEmail.getText())) {
            return false;
        } else {
            return true;
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Usuario.atualizaUsuarios();
        
    }    
    
}
