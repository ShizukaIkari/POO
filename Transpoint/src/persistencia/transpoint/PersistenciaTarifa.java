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
import modelo.pagamento.Tarifa;
import modelo.usuario.Usuario;

/**
 *
 * @author Serenna
 */
public class PersistenciaTarifa {
        public void criarTabelaTarifa(){     
            String sql = "CREATE TABLE tarifa"+
                "(cod INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "linha INT NOT NULL,"
                + "data VARCHAR(60),"
                + "valor FLOAT,"
                +"codCartao INT)";     
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
         System.out.println("Banco de tarifas aberto por: executeSQL");   
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
    
    public void salvaTarifa(Tarifa t){
        String sql = "INSERT INTO tarifa (codCartao,linha,data,valor)" 
        +"values (" +
        t.getCodCartUtilizado()+","+
        t.getLinha()+",'"+
        t.getData()+"',"+
        t.getValor()+")";
        this.executeSQL(sql);
    }
    
    private ArrayList<Integer> codigosCartoes (Usuario u){
        String sql ="SELECT codigo FROM cartao WHERE cpfUser = " + u.getCpf();
        Connection connection = null;
        Statement stament = null;
        ArrayList codCardsUser = new ArrayList();
        
        try {
            //verifica se as classe da biblioteca existem
            Class.forName("org.sqlite.JDBC");
            //abre a conexao com o  banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:transpoint.db");
            System.out.println("Banco de tarifa aberto por: codigosCartoes");   
            stament = connection.createStatement();
            //executa a query no meu banco de dados
            ResultSet rs = stament.executeQuery(sql);         
            while(rs.next()){
                codCardsUser.add(Integer.parseInt(rs.getString("codigo")));
            }
            stament.close();
            //fecha a conexao com o banco de dados
            connection.close();           
        } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
        } catch (SQLException ex) {
                ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(PersistenciaCartao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codCardsUser;
    }
    
    
    public ArrayList<Tarifa> geraHistoricoTarifasUsuario (Usuario u){
        ArrayList<Integer> codigos = this.codigosCartoes(u);
        ArrayList<Tarifa> historico = new ArrayList<>();
        
        for(int codigo : codigos){
            String sql ="SELECT * FROM tarifa WHERE codCartao = " + codigo;
            Connection connection = null;
            Statement stament = null;
            try {
                //verifica se as classe da biblioteca existem
                Class.forName("org.sqlite.JDBC");
                //abre a conexao com o  banco de dados
                connection = DriverManager.getConnection("jdbc:sqlite:transpoint.db");
                System.out.println("Banco de tarifa aberto por: geraHistoricoTarifasUsuario");   
                stament = connection.createStatement();
                //executa a query no meu banco de dados
                ResultSet rs = stament.executeQuery(sql);         
                while(rs.next()){
                    Tarifa t = new Tarifa();
                    t.setCodCartUtilizado(Integer.parseInt(rs.getString("codCartao")));
                    t.setValor(Double.parseDouble(rs.getString("valor")));
                    t.setLinha(Integer.parseInt(rs.getString("linha")));
                    t.setData(rs.getString("data"));
                    historico.add(t);
                }
                stament.close();
                //fecha a conexao com o banco de dados
                connection.close();           
            } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
            } catch (SQLException ex) {
                    ex.printStackTrace();
            } catch (Exception ex) {
                Logger.getLogger(PersistenciaCartao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return historico;
    }
    
    public ArrayList<Tarifa> historicoUsuarioLinha(Usuario u,int linha){
        ArrayList<Integer> codigos = this.codigosCartoes(u);
        ArrayList<Tarifa> historico = new ArrayList<>();
        for(int codigo : codigos){
            String sql ="SELECT * FROM tarifa WHERE codCartao = " + codigo+" AND linha ="+linha;
            Connection connection = null;
            Statement stament = null;
            try {
                //verifica se as classe da biblioteca existem
                Class.forName("org.sqlite.JDBC");
                //abre a conexao com o  banco de dados
                connection = DriverManager.getConnection("jdbc:sqlite:transpoint.db");
                System.out.println("Banco de tarifa aberto por: historicoUsuarioLinha");   
                stament = connection.createStatement();
                //executa a query no meu banco de dados
                ResultSet rs = stament.executeQuery(sql);         
                while(rs.next()){
                    Tarifa t = new Tarifa();
                    t.setCodCartUtilizado(Integer.parseInt(rs.getString("codCartao")));
                    t.setValor(Double.parseDouble(rs.getString("valor")));
                    t.setLinha(Integer.parseInt(rs.getString("linha")));
                    t.setData(rs.getString("data"));
                    historico.add(t);
                }
                stament.close();
                //fecha a conexao com o banco de dados
                connection.close();           
            } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
            } catch (SQLException ex) {
                    ex.printStackTrace();
            } catch (Exception ex) {
                Logger.getLogger(PersistenciaCartao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        return historico;
    }
    public ArrayList<Tarifa> historicoUsuarioCartao(int codigo){
        ArrayList<Tarifa> historico = new ArrayList<>();
        String sql ="SELECT * FROM tarifa WHERE codCartao = " + codigo;
            Connection connection = null;
            Statement stament = null;
            try {
                //verifica se as classe da biblioteca existem
                Class.forName("org.sqlite.JDBC");
                //abre a conexao com o  banco de dados
                connection = DriverManager.getConnection("jdbc:sqlite:transpoint.db");
                System.out.println("Banco de tarifa aberto por: historicoUsuarioLinha");   
                stament = connection.createStatement();
                //executa a query no meu banco de dados
                ResultSet rs = stament.executeQuery(sql);         
                while(rs.next()){
                    Tarifa t = new Tarifa();
                    t.setCodCartUtilizado(Integer.parseInt(rs.getString("codCartao")));
                    t.setValor(Double.parseDouble(rs.getString("valor")));
                    t.setLinha(Integer.parseInt(rs.getString("linha")));
                    t.setData(rs.getString("data"));
                    historico.add(t);
                }
                stament.close();
                //fecha a conexao com o banco de dados
                connection.close();           
            } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
            } catch (SQLException ex) {
                    ex.printStackTrace();
            } catch (Exception ex) {
                Logger.getLogger(PersistenciaCartao.class.getName()).log(Level.SEVERE, null, ex);
            }
        return historico;
    }
}
