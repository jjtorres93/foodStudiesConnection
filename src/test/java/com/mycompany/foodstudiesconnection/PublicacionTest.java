package com.mycompany.foodstudiesconnection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class PublicacionTest {

    public PublicacionTest() {
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

    @org.junit.Test
    public void testSomeMethod() {
String titulo = "Comida en el S.XIX";
String autor = "Pearl Michel";
Publicacion comidaSXIX = new Publicacion(titulo,autor);

        System.out.println(comidaSXIX.titulo + " escrito por " + comidaSXIX.autor);
    }

}
