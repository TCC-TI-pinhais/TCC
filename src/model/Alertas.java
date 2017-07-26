package model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alertas {
    
    public void erroCadastroUsuarioLogin(){
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Erro");
        alerta.setHeaderText("Login");
        alerta.setContentText("Insira informações válidas no Login, seu login deve ter menos de 100 caracteres");
        alerta.show();
    }
    
    public void erroCadastroUsuarioSenha(){
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Erro");
        alerta.setHeaderText("Senha");
        alerta.setContentText("Insira informações válidas na Senha, sua senha deve ter menos de 100 caracteres");
        alerta.show();
    }
    
    public void erroCadastroUsuarioEmail(){
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Erro");
        alerta.setHeaderText("Email");
        alerta.setContentText("O email inserido não é válido, insira um email válido");
        alerta.show();
    }
    
    public void erroCadastroUsuarioLoginExistente(){
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Erro");
        alerta.setHeaderText("Login");
        alerta.setContentText("O login inserido já existe!");
        alerta.show();
    }
    
    public void erroCadastroUsuarioSenhaDiferente(){
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Erro");
        alerta.setHeaderText("Senha");
        alerta.setContentText("Confirme a senha correta!");
        alerta.show();
    }
    
    public void usuarioCadastrado(){
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Cadastro");
        alerta.setHeaderText("Usuario");
        alerta.setContentText("Usuario cadastrado com sucesso!");
        alerta.show();
    }
    
    public void erroCadastroUsuarioEmailExistente(){
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Erro");
        alerta.setHeaderText("Email");
        alerta.setContentText("O email inserido já está cadastrado!");
        alerta.show();
    }
    
}
