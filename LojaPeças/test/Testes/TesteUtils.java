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
public class TesteUtils {
    
    InputVerifier iv = new InputVerifier();
    
    public TesteUtils() {
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
    public void test_isInt_fail1(){
        assertEquals(false, iv.isIntegerPositiveValid("-90"));
    }
    public void test_isInt_fail2(){
        assertEquals(false, iv.isIntegerPositiveValid("-0"));
    }
    public void test_isInt_fail3(){
        assertEquals(false, iv.isIntegerPositiveValid("-1"));
    }
    public void test_isFloat_fail1(){
        assertEquals(false, iv.isFloatingPositiveValid("-9.0"));
    }
    public void test_isFloat_fail2(){
        assertEquals(false, iv.isFloatingPositiveValid("-0.0"));
    }
    public void test_isFloat_fail3(){
        assertEquals(false, iv.isFloatingPositiveValid("-0.00000001"));
    }
    public void test_isText_fail1(){
        assertEquals(false, iv.isTextValid(""));
    }
    
    public void test_isInt_correct1(){
        assertEquals(true, iv.isIntegerPositiveValid("0"));
    }
    public void test_isInt_correct2(){
        assertEquals(true, iv.isIntegerPositiveValid("1"));
    }
    
    public void test_isFloat_correct1(){
        assertEquals(true, iv.isFloatingPositiveValid("0.00000001"));
    }   
    public void test_isFloat_correct2(){
        assertEquals(true, iv.isFloatingPositiveValid("9"));
    }

    public void test_isText_correct1(){
        assertEquals(true, iv.isTextValid("any"));
    }
    
}
