/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import persistencia.transpoint.PersistenciaCartao;

/**
 *
 * @author 20161BSI0403
 */
public class TesteBD {
    
    public TesteBD() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    //@Test  TÁ COMENTADO MAS SE PRECISAR RODAR SÓ TIRAR
    public void testCriaTabelaCartao(){
        System.out.println("criarTabelaCartao");
        PersistenciaCartao instance = new PersistenciaCartao();
        instance.criarTabelaCartao();
    }
    
    @Test
    public void testUpdateTable(){
        PersistenciaCartao instance = new PersistenciaCartao();
        String sql = "ALTER TABLE cartao ADD idUser INTEGER NOT NULL;";
        instance.executeSQL(sql);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
