package ru.progwards.java1.lessons.datetime;

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
        UserSession temp3 = null;
        for (UserSession temp : sessions) {
            if (temp.getSessionHandle() == (sessionHandle)) {
                if ((!LocalDateTime.now().isAfter(temp.getLastAccess().plusSeconds((long) this.sessionValid))) &
                        !LocalDateTime.now().isBefore(temp.getLastAccess())) {
                    temp2 = temp;
                } else {temp3 = temp; return null;}
            } else {return null;}
        }
        int a = sessions.indexOf(temp2);
        UserSession t = new UserSession(sessions.get(a));
        t.updateLastAccess();
        if (temp3 != null) sessions.remove(temp3);
        sessions.set(a,t);
        return sessions.get(a);
    }

    public void delete(int sessionHandle) {
        UserSession temp2 = null;
        for (UserSession temp : sessions) {
            if (temp.getSessionHandle() == sessionHandle) {
                temp2 = temp;
                break;
            }
        }
        if (temp2 != null) sessions.remove(temp2);
    }

    public void deleteExpired() {
        UserSession temp2 = null;
        for (UserSession temp : sessions) {
            if (LocalDateTime.now().isAfter(temp.getLastAccess().plusSeconds((long) this.sessionValid)) &&
                    (LocalDateTime.now().isBefore(temp.getLastAccess()))) {
                temp2 = temp;
                break;
            }
        }
        if (temp2 != null) sessions.remove(temp2);
    }


    public static void main(String[] args) throws InterruptedException {
//        SessionManager a = new SessionManager(1);
//        UserSession b = new UserSession("name");
//        a.add(b);
//        Thread.sleep(500);
//        System.out.println(a.get(b.getSessionHandle()));
//        Thread.sleep(500);
//        System.out.println(a.get(b.getSessionHandle()));

//        SessionManager a = new SessionManager(6);
//        System.out.println(a.find("A"));
//        UserSession A = new UserSession("A");
//        a.add(A);
//        System.out.println(a.get(A.getSessionHandle()));
//        System.out.println(a.get(A.getSessionHandle()));
//        System.out.println(a.get(A.getSessionHandle()));
//        System.out.println("2. Вызвали Гет 3 раза");
//        Thread.sleep(7000l);
//        System.out.println("3. Подождали овертайм");
//        System.out.println(a.get(A.getSessionHandle()));
//        System.out.println("4.  Уже проверили что сессии нет через метод get");
//        UserSession B = new UserSession("B");
//        a.add(B);
//        Thread.sleep(3000l);
//        System.out.println("5-6.  Создали еще одну сессию и подождали половину времени валидности сессии");
//        UserSession C = new UserSession("C");
//        a.add(C);
//        Thread.sleep(3000l);
//        System.out.println("7-8.  Создали еще одну сессию и подождали еще раз половину времени валидности сессии");
//        a.deleteExpired();
//        System.out.println(a.find("B") + "     10.1   Эта должна быть удалена");
//        System.out.println(a.find("C") + "     10.2   Эта еще должна существовать");
//        a.delete(C.getSessionHandle());
//        System.out.println(a.find("C") + "     12   Эта должна быть удалена");




        UserSession us1 = new UserSession("User1");
                int sh1 = us1.getSessionHandle();
                SessionManager sm = new SessionManager(1);
                UserSession uus = sm.find(us1.getUserName());
        //        Assert.assertTrue("Был создан новый SessionManager, в который не добавлялось сессий, однако метод find(\"User1\") не возвратил значение, равное null.", uus == null);
                sm.add(us1);

                uus = sm.get(sh1);
        //        Assert.assertTrue("Был создан новый SessionManager(1), в который была добавлена сессия для пользователя \"User1\" (sessionHandle = " + sh1 + "), однако сразу после этого метод get возвратил значение, равное null.", uus != null);

                try { Thread.sleep(1001); } catch (InterruptedException e) {}
                uus = sm.get(sh1);
                System.out.println(uus);
                //  Assert.assertTrue("Был создан новый SessionManager(1), в который была добавлена сессия для пользователя \"User1\" (sessionHandle = " + sh1 + "), затем была выждана пауза более 1 сек, однако после этого метод get не возвратил значение, равное n







    }
}