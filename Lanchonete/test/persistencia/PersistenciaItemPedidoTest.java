/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import persistenciaFILE.PersistenciaItemPedido;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lanchonete.Hamburguer;
import lanchonete.ItemPedido;
import lanchonete.Produto;
import lanchonete.Refrigerante;
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
public class PersistenciaItemPedidoTest {
    
    public PersistenciaItemPedidoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
        Hamburguer vburg = new Hamburguer ("Vegetariano",15,"XVegeta",6);
        Refrigerante refri = new Refrigerante("Coca Cola", 'P', 4, "Refrigerante de Cola",13);
        ItemPedido item1 = new ItemPedido(1, vburg.getValor()-2,vburg, "Sem milho, preco promocional");
        ItemPedido item2 = new ItemPedido(1, refri.getValor(),refri, "Normal");
        PersistenciaItemPedido.saveItemPedido(item1);
        PersistenciaItemPedido.saveItemPedido(item2);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of saveItemPedido method, of class PersistenciaItemPedido.
     */
    /*@Test
    public void testSaveItemPedido() throws Exception {
        System.out.println("saveItemPedido");
        ItemPedido item = null;
        PersistenciaItemPedido.saveItemPedido(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of readCSVFile method, of class PersistenciaItemPedido.
     */
    @Test
    public void testReadCSVFile() throws Exception {
        System.out.println("readCSVFile");
        List<ItemPedido> itens = PersistenciaItemPedido.readCSVFile();
        
        if (itens.isEmpty()) fail("sem itens");
        
        ItemPedido item = itens.get(0);
        assertEquals("Sem milho, preco promocional", item.getAnotacao());
        assertEquals(1, item.getQuantidade());
        assertEquals(6, item.getProduto().getCodigo());
        assertEquals(13, item.getPreco(),1);
        
    }
    
}
