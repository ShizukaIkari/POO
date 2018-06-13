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
public class PersistenciaCartao {
      
    public void criarTabelaCartao(){     
        String sql = "CREATE TABLE cartao"+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "codigo INTEGER NOT NULL,"
                + ","
                + "categoria CHAR(60) NOT NULL,"
                + "saldo NUMERIC NOT NULL,"
                + "disponivel BOOLEAN)";     
        this.executeSQL(sql);        
    }
    
    public void executeSQL(String sql) {
        
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
    
    //Retorna uma lista com todos os cartões disponíveis associados ao usuário
    public ArrayList recuperaCartoesPessoa(Pessoa p){
        ArrayList<Cartao> allCards = new ArrayList<>();
        String sql ="SELECT * FROM cartao WHERE ";
        Connection connection = null;
        Statement stament = null;
        
        return allCards;
    }
    
    
}
