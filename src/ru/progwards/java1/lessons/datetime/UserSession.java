package ru.progwards.java1.lessons.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Random;

public class UserSession {
    private int sessionHandle;
    private String userName;
    private LocalDateTime lastAccess;
    public int getSessionHandle() { return sessionHandle; }
    public String getUserName(){ return userName; }
    public LocalDateTime getLastAccess() { return lastAccess; }
    public void updateLastAccess() { this.lastAccess = LocalDateTime.now(); }
    public UserSession(String userName) {
        this.userName = userName;
        lastAccess = LocalDateTime.now();
        sessionHandle = new Random().nextInt();
    }
    public UserSession(UserSession a) {
        this.userName = a.userName;
        this.updateLastAccess();
        sessionHandle = a.sessionHandle;
    }
    @Override
    public String toString() {
        return "Name:" + this.userName + ",       Last access:  " + lastAccess + ",    Session handle: " + sessionHandle;
    }
}
