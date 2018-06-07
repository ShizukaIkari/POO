/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import persistenciaFILE.PersistenciaPedido;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lanchonete.Hamburguer;
import lanchonete.ItemPedido;
import lanchonete.Pedido;
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
public class PersistenciaPedidoTest {
    
    public PersistenciaPedidoTest() {
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
        Pedido ped1 = new Pedido(1);
        ped1.adicionarItem(item2);
        ped1.adicionarItem(item1);
        PersistenciaPedido.savePedido(ped1);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of readCSVFile method, of class PersistenciaPedido.
     */
    @Test
    public void testReadCSVFile() throws Exception {
        System.out.println("readCSVFile");
        ArrayList<Pedido> pedidos = PersistenciaPedido.readCSVFile();
        if(pedidos.isEmpty()) fail("sem pedidos");
        Pedido pedido = pedidos.get(0);
        assertEquals(17, pedido.getValor(),1);
        assertEquals(1, pedido.getIdPedido());
    }
}
