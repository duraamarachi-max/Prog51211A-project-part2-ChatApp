/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.chatapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class ChatAppTest {
    
    public ChatAppTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class ChatApp.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ChatApp.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
   public void testUserNameCorrect(){
      Login user = new Login ("Amra_","Amara_052str","+27677159103");
       assertEquals("Username Succesfully Captured",user.getUserNameMessage());
       
   }
   @Test
   public void testUserNameInCorrect(){
      Login user = new Login ("Amara_duraaa","Amara_052str3433223","+27677159103");
       assertEquals("Username is not correctly formatted, "
                + "please ensure that your username contains "
                + "an underscore and is no more than five characters in length.",user.getUserNameMessage());
       
   }
   
    @Test
   public void testPasswordCorrectMessage(){
      Login user = new Login ("Amra_","Amara_052str","+27677159103");
       assertEquals("Password Succesfully Captured",user.getPasswordMessage());
    
}      
   
  @Test
   public void testPasswordInCorrectMessage(){
      Login user = new Login ("Amra_","Amara_052str","+27677159103");
       assertEquals("Password Succesfully CapturedPassword is not correctly formatted, "
                + "please ensure that the password contains at least "
                + "eight characters, a capital letter, a number/digit, "
                + "and a special character.",user.getPasswordMessage());
       
   }
   
   @Test
   public void testNumberCorrectMessage(){
      Login user = new Login ("Amra_","Amara_052str","+27677159103");
       assertEquals("Cell phone number successfully added.",user.getCellPhoneMessage());
}
   
   @Test
   public void testNumberInCorrectMessage(){
      Login user = new Login ("Amra_","Amara_052str","+27677159103");
       assertEquals("Cell phone number incorrectly formatted "
                + "or does not contain international code.",user.getCellPhoneMessage());
   
   }
   
   @Test
   public void testUserNameReturnsTrueValue(){
      Login user = new Login ("Amra_","Amara_052str","+27677159103");
       assertTrue(user.checkUserName());
     
   }
   
   @Test
   public void testUserNameReturnsFalseValue(){
      Login user = new Login ("Amra_","Amara_052str","+27677159103");
       assertFalse(user.checkUserName());
   
   }
   
   @Test
   public void testPasswordReturnsTrueValue(){
      Login user = new Login ("Amra_","Amara_052str","+27677159103");
       assertTrue(user.checkPassword());
}
   
   @Test
   public void testPasswordReturnsFalseValue(){
      Login user = new Login ("Amra_","Amara_052str","+27677159103");
       assertFalse(user.checkPassword());
}
   
   @Test
   public void testNumberReturnsTrueValue(){
      Login user = new Login ("Amra_","Amara_052str","+27677159103");
       assertTrue(user.checkCellPhoneNumber());
   
}
   @Test
   public void testNumberReturnsFalseValue(){
      Login user = new Login ("Amra_","Amara_052str","+27677159103");
       assertFalse(user.checkCellPhoneNumber());

}
}
