/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import ordemservico.util.Util;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Teixeira
 */
public class ValidationMethodsTest {
    
    private Util testUtil;
    
    
    public ValidationMethodsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.testUtil = new Util();
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void emailValidationTestError(){
      boolean ret;
      ret = testUtil.isValidEmailAddressRegex("email@....");
      assertFalse(ret);  
    }
    
    @Test
    public void emailValidationTestOk() {
        boolean ret;
        ret = testUtil.isValidEmailAddressRegex("email@testedeemail.com");
        assertTrue(ret);

    }
    
    @Test
    public void testRetMethodFormatDateBROK(){
        String ret = "";
        ret = testUtil.dataFormatoBR("2021/10/01");
        assertEquals("01/10/2021",ret);  
    }
    
    @Test
    public void testRetMethodFormatDateUsOk(){
        String ret = "";
        ret = testUtil.dataFormatoUS("01/10/2021");
        assertEquals("2021/10/01",ret); 
    }
    
    @Test
    public void testRetMethodDateByActualHour(){
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormatada = formatterHora.format(LocalDateTime.now());
        String dateSpected = "2021/10/01 "+horaFormatada;
        //passando uma data BR ele retorna uma DATA e HORA US
        String dateRetorned = testUtil.recuperaDtHr("01/10/2021");
        assertEquals(dateSpected, dateRetorned);
        
    }
    
    @Test
    public void testNumberCPFisValid(){
        boolean valid;
        valid = testUtil.isValid("030.861.705-30");
        assertTrue(valid);
    }
    
    @Test
    public void testNumberCPFisNotValid() {
        boolean valid;
        valid = testUtil.isValid("030.861.705-31");
        assertFalse(valid);
    }
    @Test
    public void testNumberCNPJisValid() {
        boolean valid;
        valid = testUtil.isValid("11916929000181");
        assertTrue(valid);
    }
    @Test
    public void testNumberCNPJisNotValid() {
        boolean valid;
        valid = testUtil.isValid("11916929000182");
        assertFalse(valid);
    }
    
    @Test
    public void testFormatingStringInDoubleNumber(){
        double number;
        number = testUtil.formataMoeda("1.500,00");
        assertEquals(1500.00, number, 0000.1);
    }
    
    @Test 
    public void testValidationDateBr(){
        boolean ret;
        ret = testUtil.validaDataFormatoBR("01/10/2021");
        assertTrue(ret);
    }
    
    @Test
    public void testValidationDateBrError(){
        boolean ret;
        ret = testUtil.validaDataFormatoBR("45/25/2021");
        assertFalse(ret);
    }
    
    
}
