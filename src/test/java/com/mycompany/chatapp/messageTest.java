/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.chatapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
/**
 *
 * @author Student
 */
public class messageTest {

    private final String RECIPIENT_1 = "+27718693002";
    private final String MESSAGE_1 = "Hi Mike, can you join us for dinner tonight?";
    private final String RECIPIENT_2 = "08575975889";
    private final String MESSAGE_2 = "Hi Keegan, did you receive the payment?";

    @BeforeEach
    public void setUp() {
        message.resetMessageData();
    }

    // 1 and 2: Message length
    @Test
    public void testCheckMessageLength_Success() {
        message msg = new message(RECIPIENT_1, 0, MESSAGE_1, "");
        assertEquals("Message ready to send.", msg.checkMessageLength());
    }

    @Test
    public void testCheckMessageLength_Failure() {
        message msg = new message(RECIPIENT_1, 0, "a".repeat(260), "");
        assertEquals("Message exceeds 250 characters by 10; please reduce the size.",
                msg.checkMessageLength());
    }

    // 3 and 4: Recipient number
    @Test
    public void testCheckRecipientCell_Success() {
        message msg = new message(RECIPIENT_1, 0, MESSAGE_1, "");
        assertEquals("Cell phone number successfully captured.", msg.checkRecipientCell());
    }

    @Test
    public void testCheckRecipientCell_Failure() {
        message msg = new message(RECIPIENT_2, 1, MESSAGE_2, "");
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
                msg.checkRecipientCell());
    }

    // 5 and 6: Message hash
    @Test
    public void testCreateMesageHash_Success() {
        message msg = new message(RECIPIENT_1, 0, MESSAGE_1, "");
        String expected = msg.getMessageID().substring(0, 2) + ":0:HITONIGHT";
        assertEquals(expected, msg.getMessageHash());
    }

    @Test
    public void testCreateMesageHash_Failure() {
        message msg = new message(RECIPIENT_2, 1, MESSAGE_2, "");
        String wrong = msg.getMessageID().substring(0, 2) + ":0:HITONIGHT";
        assertNotEquals(wrong, msg.getMessageHash());
    }

    // 7 and 8: Message ID
    @Test
public void testCheckMessageID_Success() {
    message msg = new message(RECIPIENT_1, 0, MESSAGE_1, "");
    assertEquals("Message ID generated: " + msg.getMessageID(), msg.messageIDGenerated());
    assertTrue(msg.checkMessageID());
}

    @Test
    public void testCheckMessageID_Failure() {
        message msg = new message(RECIPIENT_1, 0, MESSAGE_1, "");
        assertFalse(msg.checkMessageID("12345678901")); // 11 characters, too long
    }

    // 9 and 10: MessageSent
    @Test
    public void testSentMessage_Success() {
        message msg = new message(RECIPIENT_1, 0, MESSAGE_1, "");
        assertEquals("Message successfully sent.", msg.sentMessage(1)); // Send
    }

    @Test
    public void testSentMessage_Failure() {
        message msg = new message(RECIPIENT_2, 1, MESSAGE_2, "");
        assertEquals("Press 0 to delete the message.", msg.sentMessage(0)); // Discard
    }
}