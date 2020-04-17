package ru.progwards.java1.lessons.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Random;

public class UserSession {

    private static int count;
    private int id;
    private int sessionHandle;
    private String userName;
    private LocalDateTime lastAccess;


    public int getSessionHandle() {
        return sessionHandle;
    }
    public String getUserName() {
        return userName;
    }
    public LocalDateTime getLastAccess() {
        return lastAccess;
    }
    public void updateLastAccess() {
        this.lastAccess = LocalDateTime.now();
    }
    public UserSession(String userName) {
        this.userName = userName;
        this.lastAccess = LocalDateTime.now();
        this.sessionHandle = new Random().nextInt();
        this.id = count;
        count++;
    }
    public UserSession(UserSession a) {
        this.userName = a.userName;
        this.lastAccess = LocalDateTime.now();
        this.sessionHandle = a.sessionHandle;
        this.id = count;
        count++;
    }
    @Override
    public String toString() {
        return "Name:" + this.userName + ",       Last access:  " + lastAccess + ",    Session handle: " + sessionHandle;
    }
}
