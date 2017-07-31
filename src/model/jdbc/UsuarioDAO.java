package model.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Usuario;

public class UsuarioDAO {
    
    public void addUsuario(Usuario usuario){
        String sql = "insert into usuario (usuario_login, usuario_senha, chave_senha, email, revendedor, adm, url_imagem) values (?, ?, ?, ?, ?, ?, ?)";
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getChaveSenha());
            stmt.setString(4, usuario.getEmail());
            stmt.setBoolean(5, usuario.isRevendedor());
            stmt.setBoolean(6, usuario.isAdm());
            stmt.setString(7, usuario.getUrl_imagem());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Errou");
        }
    }
    
    public void deletaUsuario(int id_usuario){
        String sql = "delete from usuario where id_usuario = ?";
        String sql2 = "delete from lixo where id_usuario = ?";
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql2);
            stmt.setInt(1, id_usuario);
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Errou");
        }
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setInt(1, id_usuario);
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Errou");
        }
        
    }
    
    public ObservableList<Usuario> selectUsuario(){
        ObservableList<Usuario> usuarios = FXCollections.observableArrayList();
        // Escrever o SQL
        String sql = "select * from usuario order by id_usuario";
        ConnectionFactory con = new ConnectionFactory();
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setLogin(rs.getString("usuario_login"));
                usuario.setSenha(rs.getString("usuario_senha"));
                usuario.setChaveSenha(rs.getString("chave_senha"));
                usuario.setEmail(rs.getString("email"));
                usuario.setRevendedor(rs.getBoolean("revendedor"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }
    
    public void atualiza(Usuario usuario){
        String sql = "update usuario set login_usuario = ?, senha_usuario = ?, email = ?, chave = ?, url_imagem = ? where id_usuario = ?";
        ConnectionFactory con = new ConnectionFactory();
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            /*stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getChave());
            stmt.setString(5, usuario.getImagem());
            stmt.setInt(6, usuario.getId_usuario());*/
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
