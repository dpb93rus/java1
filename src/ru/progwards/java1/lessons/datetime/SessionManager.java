package ru.progwards.java1.lessons.datetime;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SessionManager {

    private ArrayList <UserSession> sessions;
    private int sessionValid;

    public SessionManager(int sessionValid) {
    this.sessionValid = sessionValid;
    }

    public void add(UserSession userSession) {
    sessions.add(userSession);
    }

    public UserSession find(String userName) {
    for (UserSession temp: sessions) {
        if (temp.getUserName().equals(userName)) return temp;
    }
        return null;
    }

    public UserSession get(int sessionHandle) {
        for (UserSession temp: sessions) {
            if ((temp.getSessionHandle()==(sessionHandle))&&
                    (!LocalDateTime.now().isAfter(temp.getLastAccess().plusSeconds((long)temp.getSessionHandle()))))
                    return temp;
        }
        return null;
    }

    public void delete(int sessionHandle) {
        for (UserSession temp: sessions) {
            if (temp.getSessionHandle()==sessionHandle) {
                sessions.remove(temp);
                break;
            }

        }
    }

    public void deleteExpired() {
        for (UserSession temp: sessions) {
            if (!LocalDateTime.now().isAfter(temp.getLastAccess().plusSeconds((long)temp.getSessionHandle()))&&
                    (!LocalDateTime.now().isBefore(temp.getLastAccess())))  sessions.remove(temp);
        }
    }
}


