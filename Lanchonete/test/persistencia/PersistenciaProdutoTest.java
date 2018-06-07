/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import persistenciaFILE.PersistenciaProduto;
import java.util.ArrayList;
import lanchonete.Hamburguer;
import lanchonete.Produto;
import lanchonete.Refrigerante;
import lanchonete.Suco;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Serenna
 */
public class PersistenciaProdutoTest {
    
    public PersistenciaProdutoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Hamburguer aburg = new Hamburguer ("Frango",21,"XFrango Duplo",2);
        Hamburguer vburg = new Hamburguer ("Vegetariano",15,"XVegeta",6);
        Hamburguer cburg = new Hamburguer ("Boi",19,"XCow",3);
        Suco juice = new Suco("Laranja", 'M', 6, "Suco de laranja", 12);
        Refrigerante bb = new Refrigerante("Coca Cola", 'G', 4, "Refrigerante Coca Cola", 13);
        
        PersistenciaProduto.saveProduto(aburg);
        PersistenciaProduto.saveProduto(cburg);
        PersistenciaProduto.saveProduto(vburg);
        PersistenciaProduto.saveProduto(bb);
        PersistenciaProduto.saveProduto(juice);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of readCSVFile method, of class ManipulaCSVProduto.
     */
    @Test
    public void testReadCSVFile() {
        System.out.println("readCSVFile");
        ArrayList<Produto> produtos = PersistenciaProduto.readCSVFile();       
        Produto produto = produtos.get(0);
        assertEquals(2,produto.getCodigo());      
        for (int i  = 0; i< produtos.size() ; i++){            
            if (produtos.get(i) == null){
                fail ("Produto não salvo");
            } 
        }
    }
}
