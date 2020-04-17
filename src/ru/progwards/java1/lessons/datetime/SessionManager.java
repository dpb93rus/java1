package ru.progwards.java1.lessons.datetime;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SessionManager {
    private HashMap<Integer, UserSession> sessions;
    private int sessionValid;

    public SessionManager(int sessionValid) {
        this.sessionValid = sessionValid;
        sessions = new HashMap<>();
    }

    public void add(UserSession userSession) {
    if (sessions.containsKey(userSession.getSessionHandle())) sessions.remove(userSession.getSessionHandle());
    sessions.put(userSession.getSessionHandle(),userSession);
    }

    public UserSession find (String userName) {
        for (Map.Entry<Integer, UserSession> temp: sessions.entrySet()) {
            if (temp.getValue().getUserName().equals(userName)) return temp.getValue();
        }
        return null;
    }

    public UserSession get(int sessionHandle) {
            if (!sessions.containsKey(sessionHandle)) return null;
            if ((!LocalDateTime.now().isAfter(sessions.get(sessionHandle).getLastAccess().plusSeconds((long)this.sessionValid))) &
                    !LocalDateTime.now().isBefore(sessions.get(sessionHandle).getLastAccess())) {
                sessions.get(sessionHandle).updateLastAccess();
                return sessions.get(sessionHandle);
            } else {
                return  null;
            }
    }

    public void delete(int sessionHandle) {
        sessions.remove(sessionHandle);
    }

    public void deleteExpired() {
        ArrayList<Integer> arrDel = new ArrayList<>();
        for (Map.Entry<Integer, UserSession> temp: sessions.entrySet()) {
            if (LocalDateTime.now().isAfter(temp.getValue().getLastAccess().plusSeconds((long)this.sessionValid))||
                    (LocalDateTime.now().isBefore(temp.getValue().getLastAccess()))) {
                arrDel.add(temp.getValue().getSessionHandle());
            }
        }
        for (int n = 0; n < arrDel.size(); n++) {
            sessions.remove(arrDel.get(n));
        }
    }


    public static void main(String[] args) throws InterruptedException {
//        SessionManager a = new SessionManager(1);
//        UserSession b = new UserSession("name");
//        a.add(b);
//        Thread.sleep(500);
//        System.out.println(a.get(b.getSessionHandle()));
//        Thread.sleep(500);
//        System.out.println(a.get(b.getSessionHandle()));

        SessionManager a = new SessionManager(6);
        System.out.println(a.find("A"));
        UserSession A = new UserSession("A");
        a.add(A);
        System.out.println(a.get(A.getSessionHandle()));
        System.out.println(a.get(A.getSessionHandle()));
        System.out.println(a.get(A.getSessionHandle()));
        System.out.println("2. Вызвали Гет 3 раза");
        Thread.sleep(7000l);
        System.out.println("3. Подождали овертайм");
        System.out.println(a.get(A.getSessionHandle()));
        System.out.println("4.  Уже проверили что сессии нет через метод get");
        UserSession B = new UserSession("B");
        a.add(B);
        Thread.sleep(3000l);
        System.out.println("5-6.  Создали еще одну сессию и подождали половину времени валидности сессии");
        UserSession C = new UserSession("C");
        a.add(C);
        Thread.sleep(3000l);
        System.out.println("7-8.  Создали еще одну сессию и подождали еще раз половину времени валидности сессии");
        a.deleteExpired();
        System.out.println(a.find("B") + "     10.1   Эта должна быть удалена");
        System.out.println(a.find("C") + "     10.2   Эта еще должна существовать");
        a.delete(C.getSessionHandle());
        System.out.println(a.find("C") + "     12.   Эта должна быть удалена");




//        UserSession us1 = new UserSession("User1");
//                int sh1 = us1.getSessionHandle();
//                SessionManager sm = new SessionManager(1);
//                UserSession uus = sm.find(us1.getUserName());
//        //        Assert.assertTrue("Был создан новый SessionManager, в который не добавлялось сессий, однако метод find(\"User1\") не возвратил значение, равное null.", uus == null);
//                sm.add(us1);
//
//                uus = sm.get(sh1);
//        //        Assert.assertTrue("Был создан новый SessionManager(1), в который была добавлена сессия для пользователя \"User1\" (sessionHandle = " + sh1 + "), однако сразу после этого метод get возвратил значение, равное null.", uus != null);
//
//                try { Thread.sleep(1001); } catch (InterruptedException e) {}
//                uus = sm.get(sh1);
//                System.out.println(uus);
//                //  Assert.assertTrue("Был создан новый SessionManager(1), в который была добавлена сессия для пользователя \"User1\" (sessionHandle = " + sh1 + "), затем была выждана пауза более 1 сек, однако после этого метод get не возвратил значение, равное n
//
//





    }
}