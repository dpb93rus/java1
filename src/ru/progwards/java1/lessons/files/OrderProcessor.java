package ru.progwards.java1.lessons.files;
        import javax.management.ObjectName;
        import java.time.*;
        import java.io.File;
        import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Path;
        import java.time.LocalDate;
        import java.time.LocalDateTime;
        import java.util.*;

public class OrderProcessor {
    static Path workDir; static ArrayList<File> files = new ArrayList<>();
    static TreeSet<Order> loadedOrders = new TreeSet<>(new Comparator <Order> () {
        @Override
        public int compare(Order o1, Order o2) {
            if (o1.datetime.isAfter((o2.datetime))) return 1;
            if (o2.datetime.isBefore((o2.datetime))) return -1;
            return 0;
        }});
    public OrderProcessor(String startPath){
        listOfFilesFromFolderTree(Path.of(startPath).toFile());
    }
    public static void listOfFilesFromFolderTree(File folder) {
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                listOfFilesFromFolderTree(entry);
                continue;
            }
            files.add(entry);
        }
    }
    public static Order checkAndReturn(File f) {
        try {
            String name = f.getName();
            String[] n = name.split("-");
            String data = Files.readString(f.toPath());
            String[] lines = data.split("\\n");
            if ((name.length() < 19) || n.length!=3) return null;
            if (!".csv".equals(n[2].substring(n[2].length() - 4).toLowerCase()) ||
                    ((n[0].length() != 3)) || ((n[1].length() != 6)) || ((n[2].length() != 8))) return null;
            else {
                Order o = new Order();
                o.sum = 0; o.items = new ArrayList<>();
                o.datetime = LocalDateTime.ofInstant(Files.getLastModifiedTime(f.toPath()).toInstant(), ZoneId.systemDefault());
                o.customerId = n[2].substring(n[2].length() - 8, n[2].length() - 4);
                o.orderId = n[1]; o.shopId = n[0];

                for (int c = 0; c < lines.length; c++) {
                    String[] d = lines[c].split(","); if (d.length!=3) continue;
                    OrderItem i = new OrderItem(d[0], Integer.parseInt(d[1].trim()), Double.parseDouble(d[2].trim()));
                    o.sum += i.price;
                    o.items.add(i);
                }
                Collections.sort(o.items, new Comparator <OrderItem>() {
                    public int compare(OrderItem o1, OrderItem o2) {
                        return o1.googsName.compareTo(o2.googsName);
                    }
                });
                return o;
            }
        }
        catch (IOException e) { e.printStackTrace(); }
        return null;
    }
    public int loadOrders(LocalDate start, LocalDate finish, String shopId) {
        int count = 0;
        for (File temp : files) {
            Order t = checkAndReturn(temp);
            if (t != null) {
                if (start == null & finish == null) {
                    if (shopId == null) loadedOrders.add(t);
                    if (shopId != null && t.shopId.equals(shopId)) loadedOrders.add(t);
                }
                if (start != null & finish == null) {
                    if (shopId == null && t.datetime.toLocalDate().isAfter(start)) loadedOrders.add(t);
                    if (shopId != null && t.shopId.equals(shopId) && t.datetime.toLocalDate().isAfter(start))
                        loadedOrders.add(t);
                }
                if (start == null & finish != null) {
                    if (shopId == null && t.datetime.toLocalDate().isBefore(finish)) loadedOrders.add(t);
                    if (shopId != null && t.shopId.equals(shopId) && t.datetime.toLocalDate().isBefore(finish))
                        loadedOrders.add(t);
                }
                if (start != null & finish != null) {
                    if (shopId == null && t.datetime.toLocalDate().isBefore(finish) &&
                            t.datetime.toLocalDate().isAfter(start)) loadedOrders.add(t);
                    if (shopId != null && t.shopId.equals(shopId) && t.datetime.toLocalDate().isBefore(finish) &&
                            t.datetime.toLocalDate().isAfter(start)) loadedOrders.add(t);
                }
            } else count++;
        }
        return count;
    }
    public List<Order> process(String shopId) {
        List <Order> l = new ArrayList<>();
        if (shopId == null) l.addAll(loadedOrders);
        else for (Order o: loadedOrders) if (o.shopId.equals(shopId)) l.add(o);
        return l;
    }
    public Map<String, Double> statisticsByShop() {
        Map<String, Double> r = new TreeMap<>();
        Double s = 0.0;
        for (Order o : loadedOrders) {
            if (r.containsKey(o.shopId)) r.put(o.shopId, r.get(o.shopId) + o.sum);
            else r.put(o.shopId, o.sum);
        }
        return r;
    }
    public Map<String, Double> statisticsByGoods() {
        Map<String, Double> r = new TreeMap<>();
        Double s = 0.0;
        for (Order o : loadedOrders) {
            for (OrderItem i : o.items) {
                if (r.containsKey(i.googsName)) r.put(i.googsName, r.get(i.googsName) + i.price);
                else r.put(i.googsName, i.price);
            }
        }
        return r;
    }
    public Map<LocalDate, Double> statisticsByDay() {
        Map<LocalDate, Double> r = new TreeMap<>();
        Double s = 0.0;
        for (Order o : loadedOrders) {
            if (r.containsKey(o.datetime.toLocalDate())) r.put(o.datetime.toLocalDate(), r.get(o.datetime.toLocalDate()) + o.sum);
            else r.put(o.datetime.toLocalDate(), o.sum);
        }
        return r;
    }

    public static void main(String[] args) {
    OrderProcessor A = new OrderProcessor("C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\files\\Folder2");

        System.out.println(A.loadOrders(LocalDate.of(1991,12,12), LocalDate.of(2012,12,12), "S02"));
        System.out.println(A.process("S02"));
        System.out.println(A.statisticsByShop());
        System.out.println(A.statisticsByGoods());
        System.out.println(A.statisticsByDay());
    }
}
