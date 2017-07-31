package model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TCC extends Application {
    
    private static String tela = "Inicio.fxml";
    private static Stage palco = new Stage();
    
    public void iniciaStage(String stage){
        tela = stage;
        Stage stage1 = new Stage();
        try {
            start(stage1);
        } catch (Exception ex) {
            Logger.getLogger(TCC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/" + tela));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        palco = stage;
    }
    
    public void fechaTela(){
        palco.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
