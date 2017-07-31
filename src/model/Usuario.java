package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.jdbc.UsuarioDAO;

public class Usuario {
    
    private int id_usuario;
    private String login;
    private String senha;
    private String chaveSenha;
    private String email;
    private boolean revendedor;
    private boolean adm;
    private static ObservableList<Usuario> usuarios = FXCollections.observableArrayList();

    public static ObservableList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(ObservableList<Usuario> usuarios) {
        Usuario.usuarios = usuarios;
    }

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }
    
    public static void atualizaUsuarios(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario.setUsuarios(usuarioDAO.selectUsuario());
    }
    
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getChaveSenha() {
        return chaveSenha;
    }

    public void setChaveSenha(String chaveSenha) {
        this.chaveSenha = chaveSenha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isRevendedor() {
        return revendedor;
    }

    public void setRevendedor(boolean revendedor) {
        this.revendedor = revendedor;
    }
    
    
    
}
