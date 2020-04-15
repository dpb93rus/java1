package ru.progwards.java1.lessons.datetime;

import ru.progwards.java1.lessons.collections.ArrayIterator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

public class SessionManager {

    private ArrayList<UserSession> sessions;
    private int sessionValid;

    public SessionManager(int sessionValid) {
        this.sessionValid = sessionValid;
        sessions = new ArrayList<>();
    }

    public void add(UserSession userSession) {
        sessions.add(userSession);
    }

    public UserSession find (String userName) {
        for (UserSession temp : sessions) {
            if (temp.getUserName().equals(userName)) return temp;
        }
        return null;
    }

    public UserSession get(int sessionHandle) {
        UserSession temp2 = null;
        for (UserSession temp : sessions) {
            if (temp.getSessionHandle() == (sessionHandle)) {
                if ((!LocalDateTime.now().isAfter(temp.getLastAccess().plusSeconds((long) this.sessionValid))) &
                        !LocalDateTime.now().isBefore(temp.getLastAccess())) {
                    temp2 = temp;
                } else {return null;}
            }
        }
        int a = sessions.indexOf(temp2);
        UserSession t = new UserSession(sessions.get(a));
        sessions.set(a,t);
        return sessions.get(a);
    }

    public void delete(int sessionHandle) {
        for (UserSession temp : sessions) {
            if (temp.getSessionHandle() == sessionHandle) {
                sessions.remove(temp);
                break;
            }

        }
    }

    public void deleteExpired() {
        for (UserSession temp : sessions) {
            if (!LocalDateTime.now().isAfter(temp.getLastAccess().plusSeconds((long) this.sessionValid)) &&
                    (!LocalDateTime.now().isBefore(temp.getLastAccess()))) sessions.remove(temp);
        }
    }


    public static void main(String[] args) throws InterruptedException {
    SessionManager a = new SessionManager(4);
        System.out.println(a.find("name"));
    UserSession b = new UserSession("name");
    a.add(b);
        System.out.println(a.find("name"));
        System.out.println(a.get(b.getSessionHandle()));
        System.out.println(a.get(b.getSessionHandle()));System.out.println(a.get(b.getSessionHandle()));
        Thread.sleep(3000l);
        System.out.println(a.get(b.getSessionHandle()));
        UserSession c = new UserSession("name2");
        Thread.sleep(1000l);
        UserSession d = new UserSession("name3");
        Thread.sleep(1000l);
    }
}