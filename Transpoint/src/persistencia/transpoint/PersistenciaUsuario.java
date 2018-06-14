/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.transpoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.cartao.Cartao;
import modelo.usuario.Pessoa;


/**
 *
 * @author 20161BSI0403
 */
public class PersistenciaUsuario {
      
    public void criarTabelaUsuario(){     
        String sql = "CREATE TABLE usuario"+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "cpf INTEGER NOT NULL,"
                + "senha VARCHAR(60) NOT NULL,"
                + "idcartao INTEGER NOT NULL";     
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
    
    
    
    
    
}
    