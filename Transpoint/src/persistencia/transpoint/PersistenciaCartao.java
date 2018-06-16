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
import modelo.cartao.Categoria;
import modelo.usuario.Pessoa;
import modelo.usuario.Usuario;

/**
 *
 * @author 20161BSI0403
 */
public class PersistenciaCartao {
      
    public void criarTabelaCartao(){     
        String sql = "CREATE TABLE cartao"+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "codigo INTEGER NOT NULL,"
                + "idUser INTEGER NOT NULL,"
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
    public ArrayList recuperaCartoesUsuario(Usuario u) throws SQLException{
        ArrayList<Cartao> allCards = new ArrayList<>();
        String sql ="SELECT * FROM cartao WHERE idUser = " + u.getIdUser();
        Connection connection = null;
        Statement stament = null;
        
        try {
            //verifica se as classe da biblioteca existem
         Class.forName("org.sqlite.JDBC");
         //abre a conexao com o  banco de dados
         connection  =DriverManager.getConnection("jdbc:sqlite:transpoint.db");
         System.out.println("Banco de dados aberto");   
         stament = connection.createStatement();
         //executa a query no meu banco de dados
         ResultSet rs = stament.executeQuery(sql);         
         while(rs.next()){
             String cat = rs.getString("categoria");
             
             Cartao card = new Cartao(cat);
             card.setCodigo(Integer.parseInt(rs.getString("codigo")));
             card.setSaldo(Double.parseDouble(rs.getString("saldo")));
             card.setDisponivel(Boolean.parseBoolean("isDisponivel"));
             allCards.add(card);
         }             
         stament.close();
         //fecha a conexao com o banco de dados
         connection.close();
         
         
            
        } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
        } catch (SQLException ex) {
                ex.printStackTrace();
                throw ex;
        } catch (Exception ex) {
            Logger.getLogger(PersistenciaCartao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return allCards;
    }
    
    public void salvaCartao(Cartao card){
        String sql = "INSERT INTO cartao (codigo,idUser,categoria,saldo,disponivel)"
        +"values ('" +
        card.getCodigo()+","+
        card.getIdUser()+","+
        card.getTipoCategoria()+","+
        card.getSaldo()+","+
        card.isDisponivel()+")";
        this.executeSQL(sql);
    }
    
}
