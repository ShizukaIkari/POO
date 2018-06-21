/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.transpoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.cartao.Cartao;
import modelo.usuario.Usuario;
import persistencia.transpoint.PersistenciaCartao;


/**
 *
 * @author 20161BSI0403
 */
public class PersistenciaUsuario {
      
    public void criarTabelaUsuario(){     
        String sql = "CREATE TABLE usuario"+
                "(cpf INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "senha VARCHAR(20) NOT NULL)";     
        this.executeSQL(sql);        
    }

    private void executeSQL(String sql) {
       Connection connection = null;
        Statement stament = null;
        try {
            //verifica se as classe da biblioteca existem
         Class.forName("org.sqlite.JDBC");
         //abre a conexao com o  banco de dados chamado lanchonete.
         //esse banco de dado é em arquivo
         connection  =DriverManager.getConnection("jdbc:sqlite:transpoint.db");
         System.out.println("Banco de dados aberto");   
         stament = connection.createStatement();
         //exeucta o sql no meu banco de dados
         stament.executeUpdate(sql);
         stament.close();
         //fecha a conexao com o banco de dados
         connection.close();
         
            
        } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
        } catch (SQLException ex) {
                ex.printStackTrace();
        }
    }
    //Salva usuário no banco
    public void salvaUsuario(Usuario u){
        PersistenciaPessoa p = new PersistenciaPessoa();
        String sql = "INSERT INTO usuario (cpf,senha)"
        +"values (" +
        u.getCpf()+","+
        u.getSenha()+"')";
        p.salvaPessoa(u);
        this.executeSQL(sql);
    }
    
    public Usuario recuperaUsuario(int cpfUser) throws SQLException{
        String sql = "SELECT * FROM usuario WHERE cpf = "+cpfUser;
        Connection connection = null;
        Statement stament = null;
        PersistenciaCartao persCard = new PersistenciaCartao();
        
        try{
            Class.forName("org.sqlite.JDBC");
            connection  =DriverManager.getConnection("jdbc:sqlite:transpoint.db");
            stament = connection.createStatement();
            ResultSet rs = stament.executeQuery(sql);
            Usuario user =null;
            while(rs.next()){
                user=new Usuario();
                ArrayList<Cartao> cartoes;
                user.setSenha(rs.getString("senha"));
                user.setCpf(cpfUser);
                cartoes = persCard.recuperaCartoesUsuario(user);
                user.setCartoesTranscol(cartoes);
            }               
            
            stament.close();
            connection.close();
            return user;
        } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
        } catch (SQLException ex) {
                ex.printStackTrace();
                throw ex;
        } catch (Exception ex) {
            Logger.getLogger(PersistenciaCartao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
        
    }
    
    public Usuario validaUsuario(int cpfUser, String senha) throws SQLException{
        String sql = "SELECT * FROM usuario WHERE cpf = "+cpfUser;
        boolean inside=false;
        Connection connection = null;
        Statement stament = null;
        Usuario user =null;
        try{
            Class.forName("org.sqlite.JDBC");
            connection  =DriverManager.getConnection("jdbc:sqlite:transpoint.db");
            stament = connection.createStatement();
            ResultSet rs = stament.executeQuery(sql);
            
            while(rs.next()){               
                inside=true;
                if(senha.equals(rs.getString("senha"))){
                    user=new Usuario();
                    user=recuperaUsuario(cpfUser);
                }
                else{
                    throw new Exception ("Senha inválida!");
                }
               
            } 
            if(!inside){
                throw new Exception ("Usuário não existe!");
            }
            
            stament.close();
            connection.close();
            return user;
            
        } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
        } catch (SQLException ex) {
                ex.printStackTrace();
                throw ex;
        } catch (Exception ex) {
            Logger.getLogger(PersistenciaCartao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
        
        
    }
    
}
    