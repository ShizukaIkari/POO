/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.transpoint;

import modelo.usuario.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 20161bsi0403
 */
public class PersistenciaUsuarioTest {
    
    public PersistenciaUsuarioTest() {
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

    /**
     * Test of criarTabelaUsuario method, of class PersistenciaUsuario.
     */
    @Test
    public void testCriarTabelaUsuario() {
        System.out.println("criarTabelaUsuario");
        PersistenciaUsuario instance = new PersistenciaUsuario();
        instance.criarTabelaUsuario();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvaUsuario method, of class PersistenciaUsuario.
     */
    @Test
    public void testSalvaUsuario() {
        System.out.println("salvaUsuario");
        Usuario u = null;
        PersistenciaUsuario instance = new PersistenciaUsuario();
        instance.salvaUsuario(u);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recuperaUsuario method, of class PersistenciaUsuario.
     */
    @Test
    public void testRecuperaUsuario() throws Exception {
        System.out.println("recuperaUsuario");
        int cpfUser = 0;
        PersistenciaUsuario instance = new PersistenciaUsuario();
        Usuario expResult = null;
        Usuario result = instance.recuperaUsuario(cpfUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaUsuario method, of class PersistenciaUsuario.
     */
    @Test
    public void testValidaUsuario() throws Exception {
        System.out.println("validaUsuario");
        int cpfUser = 0;
        String senha = "";
        PersistenciaUsuario instance = new PersistenciaUsuario();
        Usuario expResult = null;
        Usuario result = instance.validaUsuario(cpfUser, senha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
