/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

/**
 *
 * @author Student
 */

import java.io. *;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Paths;
import java.util.*;

public class message {
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;
    private String messageHash;

    private static int totalMessageSent = 0;
    private static String sentMessages = "";

    public message(String recipient, int messageNumber, String message, String summary){
        
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();

    }

    public String messageIDGenerated() {
    return "Message ID generated: " + messageID;
}

    public String generateMessageID() {
        Random random = new Random();
        String id = "";

        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10);
            id += digit;
        }

        return id;

    }

   public boolean checkMessageID() {
    return checkMessageID(messageID);
}

// New overload so the failure case can be tested
public boolean checkMessageID(String id) {
    return id != null && id.length() <= 10;
}

   public String checkRecipientCell() {
    if (recipient.matches("^\\+27\\d{9}$")) {
        return "Cell phone number successfully captured.";
    } else {
        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }
}

    public boolean isRecipientValid() {
        return recipient.matches("^\\+27\\d{9}$");
    }

    public String checkMessageLength() {
    if (message.length() <= 250) {
        return "Message ready to send.";
    } else {
        int extra = message.length() - 250;
        return "Message exceeds 250 characters by " + extra + "; please reduce the size.";
    }
}

    public boolean isMessageValid() {
        return message.length() <= 250;
    }

    public String createMessageHash() {
    String[] words = message.trim().split("\\s+");   // was "\\\\s+", which never split on spaces
    String firstWord = words[0].replaceAll("[^a-zA-Z0-9]", "");
    String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z0-9]", "");
    String hash = messageID.substring(0, 2) + ":" + messageNumber + ":" + firstWord + lastWord;
    return hash.toUpperCase();
}
    
public String sentMessage(int option) {
    if (option == 1) {
        totalMessageSent++;
        sentMessages += printMessageDetails()
                + System.lineSeparator()
                + "====================="
                + System.lineSeparator();
        return "Message successfully sent.";
    } else if (option == 0) {
        return "Press 0 to delete the message.";
    } else if (option == 2) {
        return StoreMessage();
    } else {
        return "Invalid option";
    }
}

public String printMessage(){
    if (sentMessages.isEmpty()){
        return "No messages sent";
    }   
    return sentMessages;
}  
public int returnTotalMessages(){
    return totalMessageSent;
}  

  public String printMessageDetails() {
    return "Message ID: " + messageID
            + System.lineSeparator()
            + "Message hash: " + messageHash
            + System.lineSeparator()
            + "Recipient: " + recipient
            + System.lineSeparator()
            + "Message: " + message;
}
  
  public String StoreMessage() {
    Path filePath = Paths.get("messages.json");

    String jsonObject =
            "  {\n"
            + "    \"messageID\": \"" + escapeJson(messageID) + "\",\n"
            + "    \"messageNumber\": " + messageNumber + ",\n"
            + "    \"messageHash\": \"" + escapeJson(messageHash) + "\",\n"
            + "    \"recipient\": \"" + escapeJson(recipient) + "\",\n"
            + "    \"message\": \"" + escapeJson(message) + "\"\n"   // no comma on the last field
            + "  }";

    try {
        if (!Files.exists(filePath) || Files.readString(filePath).trim().isEmpty()) {
            Files.writeString(filePath, "[\n" + jsonObject + "\n]");
        } else {
            String currentJson = Files.readString(filePath).trim();
            int closingBracket = currentJson.lastIndexOf("]");

            if (closingBracket >= 0) {
                String beforeClosing = currentJson.substring(0, closingBracket).trim();

                if (beforeClosing.endsWith("[")) {
                    currentJson = beforeClosing + "\n" + jsonObject + "\n]";
                } else {
                    currentJson = beforeClosing + ",\n" + jsonObject + "\n]";
                }
                Files.writeString(filePath, currentJson);
            }
        }
        return "Message successfully stored.";
    } catch (IOException e) {
        return "Message could not be stored.";
    }
}

private String escapeJson(String value) {
    return value
            .replace("\\", "\\\\")
            .replace("\"", "\\\"")
            .replace("\n", "\\n")
            .replace("\r", "\\r");
}
      
      public String getMessageID()
      {
          return messageID;
      }
      public String getMessageHash()
      {
          return messageHash;
      }
      public static void resetMessageData()
      {
          totalMessageSent = 0;
          sentMessages = " ";
      }
  }  
  
  



