/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

/**
 *
 * @author Student
 */
public class Login {
      private String userName;
    private String password;
   private String cellPhoneNumber;
    
    public Login(String userName, String password, String cellPhoneNumber) {
        this.userName = userName;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }
 
    public boolean checkUserName() {
        return userName.contains("_") && userName.length() <= 5;
    }

    public boolean checkPassword() {

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;

        
        if (password.length() < 8) {
            return false;
        }

        
        for (int i = 0; i < password.length(); i++) {

            char currentCharacter = password.charAt(i);

            if (Character.isUpperCase(currentCharacter)) {
                hasCapital = true;
            }

            if (Character.isDigit(currentCharacter)) {
                hasNumber = true;
            }

            if (!Character.isLetterOrDigit(currentCharacter)) {
                hasSpecialCharacter = true;
            }
        }

        
        return hasCapital && hasNumber && hasSpecialCharacter;
    }

   
    public boolean checkCellPhoneNumber() {

        String cellPhoneRegex = "^\\+27\\d{9}$";
       return cellPhoneNumber.matches(cellPhoneRegex);
    }

   
    public String getUserNameMessage() {

        if (checkUserName()) {
            return "Username successfully captured.";
        }

        return "Username is not correctly formatted, "
                + "please ensure that your username contains "
                + "an underscore and is no more than five characters in length.";
    }

    
    public String getPasswordMessage() {

        if (checkPassword()) {
            return "Password successfully captured.";
        }

        return "Password is not correctly formatted, "
                + "please ensure that the password contains at least "
                + "eight characters, a capital letter, a number/digit, "
                + "and a special character.";
    }

    
    public String getCellPhoneMessage() {

        if (checkCellPhoneNumber()) {
            return "Cell phone number successfully added.";
        }

        return "Cell phone number incorrectly formatted "
                + "or does not contain international code.";
    }

    
    public boolean registrationSuccessful() {

        return checkUserName()
                && checkPassword()
                && checkCellPhoneNumber();
    }
   
    public boolean loginUser(String enteredUserName, String enteredPassword) {

        return enteredUserName.equals(userName)
                && enteredPassword.equals(password);
    }

    
    public String returnLoginStatus(boolean loginSuccessful) {

        if (loginSuccessful) {
            return "Login successful. Welcome back!";
        }

        return "Username or password incorrect, please try again.";
    }
}
