/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import Utils.InputVerifier;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diego Justi
 */
public class TesteProdutos {
    
    InputVerifier iv = new InputVerifier();
    
    public TesteProdutos() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void test_isInt_estrutural1(){
        assertEquals(false, iv.isIntegerPositiveValid("-1"));
    }
    @Test
    public void test_isFloat_estrutural1(){
        assertEquals(false, iv.isFloatingPositiveValid("-0.00000001"));
    }
    @Test
    public void test_isText_estrutural1(){
        assertEquals(false, iv.isTextValid(""));
    }
    @Test
    public void test_isText_funcional1(){
        assertEquals(false, iv.isTextValid("sajhdsakjdkajdhawijdhajkshdlawhdkawhdiawodawjhdkajhaksjdhakhdaçkjshd"
                + "sakjdasjkdnlasdaskjdaskjdasjdhakjdhawjdh3iu2423e232323e232423e23e23"
                + "23423e23423e234rerawjldakajlwkejalkdnlawkjeliawej3heiu2wheqawjheo3iehjqoiwheawd"
                + "328eu38i2rhoqwdhakjndkquehlawiuhdoiweuhriwuerhoiweuhrejlnh"));
    }
    
    @Test
    public void test_all_correct(){
        assertEquals(true, iv.isIntegerPositiveValid("0"));
        assertEquals(true, iv.isFloatingPositiveValid("0.005"));
        assertEquals(true, iv.isTextValid("any"));
    }
    

}
