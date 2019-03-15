/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Thong Nguyen
 */
public class Message implements Serializable {
    String sender;
    String subject;
    String content;
    boolean isViewed;
    public Message(String _sender, String _subject, String _content) {
        sender = _sender;
        subject = _subject;
        content = _content;
        isViewed = false;
        
    }
    public void view() {
        isViewed = true;
        System.out.println(subject + ":");
        System.out.println(content);
    }
    
    public boolean isViewed() {
        return isViewed;
    }
    
    public void info() {
        if (isViewed) System.out.print("Read - ");
        else System.out.print("Unread - ");
        System.out.println("From: " + sender + " - " + subject);
    }
}
