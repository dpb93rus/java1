package ru.progwards.java1.lessons.sets;

import java.sql.Array;
import java.util.*;
public class ProductAnalytics {
    private List<Shop> shops;
    private List<Product> products;

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.products = products;
        this.shops = shops;
    }
public String toString() {
        return (this.products.toString() + "\n" + this.shops.toString());
}
    public static HashSet<Product> union(HashSet<Product> set1, HashSet<Product> set2){
        HashSet <Product> res = new HashSet(set1);
        res.addAll(set2);
        return res;

    }
    public static HashSet<Product> difference(HashSet<Product>set1, HashSet<Product> set2) {
        HashSet<Product> res = new HashSet(set1);
        res.removeAll(set2);
        return res;
    }

    public static HashSet<Product> intersection(HashSet<Product> set1, HashSet<Product> set2){
        HashSet <Product> res = new HashSet(set1);
        res.retainAll(set2);
        return res;

    }
    public static HashSet<Product> symDifference(HashSet<Product> set1, HashSet<Product> set2) {
        return difference(union(set1,set2),intersection(set1,set2));
    }

    public Set<Product> existInAll() {
        HashSet <Product> pr = new HashSet(this.products);
        for (Shop temp : this.shops) {
        pr.retainAll(new HashSet<Product>(temp.getProducts()));
        }
       return pr;
    }
    public Set<Product> existAtListInOne() {
        HashSet result = new HashSet();
        for (Shop temp: shops) {
            HashSet pr = new HashSet(this.products);
            pr.retainAll(temp.getProducts());
            result.addAll(pr);
        }
        return result;
    }

    public Set<Product> notExistInShops() {
        HashSet<Product> pr = new HashSet(this.products);
        for (Shop temp: shops) {
            pr.removeAll(temp.getProducts());
        }
        return pr;
    }

    public Set<Product> existOnlyInOne() {
        HashSet pr = new HashSet();
        int c = 0;
        for (Product temp: products) {
            for (Shop temp1:shops) {
                for (Product temp2:temp1.getProducts()) {
                    if (temp.equals(temp2)) c++;
                    }
                }
                if (c == 1) pr.add(temp);
                    c = 0;

            }

//        {HashSet res = new HashSet();
//        HashSet sumdouble = new HashSet();
//        for (Shop temp: shops) {
//            if (sumdouble.isEmpty()) sumdouble = new HashSet(temp.getProducts());
//            HashSet res1 = new HashSet(temp.getProducts());
//            res=symDifference(res,res1);
//            sumdouble.add(intersection(res1,res));
//
//        }
//        res.removeAll(sumdouble);
//        pr.retainAll(res);}
        return pr;
    }

    public static void main(String[] args) {
        ArrayList <Product> prod = new ArrayList () ;
        Product g1 = new Product("art1"); Product g2 = new Product("art2"); Product g3 = new Product("art3"); Product g4 = new Product("art4"); Product g5 = new Product("art5");
        Product g6 = new Product("art6"); Product g7 = new Product("art7"); Product g8 = new Product("art8"); Product g9 = new Product("art9"); Product g10 = new Product("art10");
        prod.add (g1);prod.add (g2);prod.add (g3);prod.add (g4);prod.add (g5);prod.add (g6);prod.add (g7);prod.add (g8);prod.add (g9);prod.add (g10);
        Shop A = new Shop(new ArrayList(Set.of(g2,g3,g4,g7,g8))); Shop B = new Shop(new ArrayList(Set.of(g2,g3,g5,g6,g10))); Shop C = new Shop(new ArrayList(Set.of(g2,g3,g5,g6)));
//        {
//            prod.add(new Product("art1"));
//            prod.add(new Product("art2"));
//            prod.add(new Product("art3"));
//            prod.add(new Product("art4"));
//            prod.add(new Product("art5"));
//            prod.add(new Product("art6"));
//            prod.add(new Product("art7"));
//            prod.add(new Product("art8"));
//            prod.add(new Product("art9"));
//            prod.add(new Product("art10"));
//            Shop A = new Shop(new ArrayList(Set.of(new Product("art3"), new Product("art2"), new Product("art7"),
//                    new Product("art8"), new Product("art4"))));
//            Shop B = new Shop(new ArrayList(Set.of(new Product("art3"), new Product("art2"), new Product("art5"), new Product("art6"),
//                    new Product("art10"))));
//            Shop C = new Shop(new ArrayList(Set.of(new Product("art3"), new Product("art2"), new Product("art6"),
//                    new Product("art5"))));
//        }
        ArrayList <Shop> ls = new ArrayList(Set.of(A,B,C));
        ProductAnalytics S = new ProductAnalytics(prod,ls);
        System.out.println(S+"\n");        System.out.println(S.existInAll()); System.out.println(S.existAtListInOne()); System.out.println(S.existOnlyInOne());System.out.println(S.notExistInShops());

    }
}
