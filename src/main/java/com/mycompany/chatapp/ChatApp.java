/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class ChatApp {

    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);
        
        String userName = "";
        String password = "";
        String cellPhoneNumber = "";
        
        boolean validUserName;
        boolean validPassword;
        boolean validCellPhoneNumber;

        System.out.println("==============================");
        System.out.println("     LOGIN REGISTRATION");
        System.out.println("==============================");

        System.out.print("Please Enter Name: ");
        String name = input.nextLine();
        
        System.out.print("Please Enter Surname: ");
        String surname = input.nextLine();
        
        do
        {
        System.out.print("Please Enter username: ");
        userName = input.nextLine();
        
        Login user = new Login(userName," ", "");
        validUserName = user.checkUserName();
       
        }while(!validUserName);
                
        do
        {
        System.out.print("Please Enter password: ");
        password = input.nextLine();
        Login user = new Login(userName,password, "");
        validPassword = user.checkPassword();
        }while(!validPassword);
       
        do
        {
        System.out.print("Enter cellphone number: ");
        cellPhoneNumber = input.nextLine();
        Login user = new Login(userName,password,cellPhoneNumber);
        validCellPhoneNumber = user.checkCellPhoneNumber();
        }while(!validCellPhoneNumber);
    
    
        
       Login user = new Login(
             userName,
              password,
               cellPhoneNumber
       );

     System.out.println();
       System.out.println("========== REGISTRATION RESULTS ==========");

        
       System.out.println(user.getUserNameMessage());
        System.out.println(user.getPasswordMessage());
        System.out.println(user.getCellPhoneMessage());

       boolean loggedIn = false;
        if (user.registrationSuccessful()) {

            System.out.println();
            System.out.println("Registration successful!");

           
            Login login = new Login(
                    userName,
                    password, cellPhoneNumber
            );

            System.out.println();
            System.out.println("==============================");
            System.out.println("            LOGIN");
            System.out.println("==============================");

           
            System.out.print("Enter username to login: ");
            String loginUserName = input.nextLine();

           
            System.out.print("Enter password to login: ");
            String loginPassword = input.nextLine();

            
            boolean loginSuccessful = login.loginUser(
                    loginUserName,
                    loginPassword
            );
          loggedIn = loginSuccessful;
            
            System.out.println();
            System.out.println(login.returnLoginStatus(loginSuccessful)+" "+name+" "+surname);

        } else {

            
            System.out.println();
            System.out.println("Registration failed.");
            System.out.println("Please correct your details and try again.");
        }

               // Part 2 starts here
        if (!loggedIn) {
            System.out.println("You must log in successfully to send messages.");
            input.close();
            return;
        }

        System.out.println();
        System.out.println("Welcome to QuickChat.");

        System.out.println("How many messages would you like to enter?");
        int numberOfMessages = Integer.parseInt(input.nextLine().trim());
        int messagesEntered = 0;

        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.println("Select an option: ");
            String choice = input.nextLine().trim();

            if (choice.equals("1")) {
                if (messagesEntered >= numberOfMessages) {
                    System.out.println("You have already entered all " + numberOfMessages + " messages.");
                } else {
                    System.out.println();
                    System.out.println("Message " + (messagesEntered + 1));
                    System.out.println("=====================================");

                    String recipient;
                    message messageObject;

                    do {
                        System.out.println("Enter recipient cellphone number using +27: ");
                        recipient = input.nextLine();
                        messageObject = new message(recipient, messagesEntered, "Temporary message", "summary");
                        System.out.println(messageObject.checkRecipientCell());
                    } while (!messageObject.isRecipientValid());

                    String messageText;

                    do {
                        System.out.println("Enter your message: ");
                        messageText = input.nextLine();
                        messageObject = new message(recipient, messagesEntered, messageText, "summary");
                        System.out.println(messageObject.checkMessageLength());
                    } while (!messageObject.isMessageValid());

                    message finalMessage = new message(recipient, messagesEntered, messageText, "summary");

                    System.out.println();
                    System.out.println("Generated information");
                    System.out.println("=====================");
                    System.out.println(finalMessage.messageIDGenerated());
                    System.out.println("Message Hash: " + finalMessage.getMessageHash());

                    System.out.println();
                    System.out.println("What would you like to do now?");
                    System.out.println("1 - send message");
                    System.out.println("0 - disregard message");
                    System.out.println("2 - store message");
                    System.out.println("Select an option: ");
                    int option = Integer.parseInt(input.nextLine().trim());

                    if (option == 1) {
                        System.out.println(finalMessage.sentMessage(1));
                        System.out.println();
                        System.out.println("MESSAGE DETAILS");
                        System.out.println(finalMessage.printMessageDetails());
                    } else if (option == 0) {
                        System.out.println(finalMessage.sentMessage(0));
                    } else if (option == 2) {
                        System.out.println(finalMessage.sentMessage(2));
                    } else {
                        System.out.println("Invalid Option.");
                    }

                    messagesEntered++;
                }
            } else if (choice.equals("2")) {
                System.out.println("Coming Soon.");
            } else if (choice.equals("3")) {
                running = false;
            } else {
                System.out.println("Invalid option.");
            }
        }

        System.out.println();
        System.out.println("=====================================");
        System.out.println("=              SUMMARY              =");
        System.out.println("=====================================");

        message summary = new message(
                "000000",
                0,
                "+273456789675",
                "summary"
        );

        System.out.println("Total Messages sent: " + summary.returnTotalMessages());
        System.out.println();
        System.out.println("MESSAGES SENT");
        System.out.println(summary.printMessage());

        
        input.close();
    }
}
