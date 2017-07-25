package model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alertas {
    
    public void erroCadastroUsuarioLogin(){
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Erro");
        alerta.setHeaderText("Informações Inválidas");
        alerta.setContentText("Insira informações válidas no Login, seu login deve ter menos de 100 caracteres");
        alerta.show();
    }
    
    public void erroCadastroUsuarioSenha(){
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Erro");
        alerta.setHeaderText("Informações Inválidas");
        alerta.setContentText("Insira informações válidas na Senha, sua senha deve ter menos de 100 caracteres");
        alerta.show();
    }
    
    
    
}
