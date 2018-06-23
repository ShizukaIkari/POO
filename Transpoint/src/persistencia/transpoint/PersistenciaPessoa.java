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
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.cartao.Cartao;
import modelo.usuario.Pessoa;
import modelo.usuario.Usuario;

/**
 *
 * @author Serenna
 */
public class PersistenciaPessoa {
    
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
    
    public void criarTabelaPessoa(){     
        String sql = "CREATE TABLE pessoa"+
                "(rg INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nome VARCHAR(60) NOT NULL,"
                + "cpf INTEGER NOT NULL,"           //FOREIGN KEY
                + "dataNascimento VARCHAR(12),"
                +"telefone VARCHAR(11))";     
        this.executeSQL(sql);        
    }
    
    public void salvaPessoa(Usuario u){
        String sql = "INSERT INTO pessoa (rg,cpf,nome,dataNascimento,telefone)"
        +"values (" +
        u.getRG()+","+
        u.getCpf()+",'"+
        u.getNome()+"','"+
        u.getDataNascimento()+"','"+
        u.getTelefone()+"')";
        this.executeSQL(sql);
    }
    
    public Pessoa recuperaDadosPessoa(int cpf) throws SQLException{
        String sql = "SELECT * FROM pessoa WHERE cpf = " + cpf;
        Connection connection = null;
        Statement stament = null;
        Pessoa p = null;
        try {
         //verifica se as classe da biblioteca existem
         Class.forName("org.sqlite.JDBC");
         //abre a conexao com o  banco de dados
         connection = DriverManager.getConnection("jdbc:sqlite:transpoint.db");
         System.out.println("Banco de dados aberto");   
         stament = connection.createStatement();
         //executa a query no meu banco de dados
         ResultSet rs = stament.executeQuery(sql);         
         while(rs.next()){
             p = new Pessoa();
             p.setNome(rs.getString("nome"));
             p.setCpf(cpf);
             p.setRG(Integer.parseInt(rs.getString("rg")));
             p.setDataNascimento(rs.getString("dataNascimento"));
             p.setTelefone(rs.getString("telefone"));
             //p.setCartaoCredito(recuperaCartaoCredito(p)); Precisa de implementação 
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
        
        return p;
    }
    
}
