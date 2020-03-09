package ru.progwards.java1.lessons.sets;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductAnalytics {
    private List<Shop> shops;
    private List<Product> products;

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.products = products;
        this.shops = shops;
    }

    public Set<Product> existInAll() {
        HashSet pr = new HashSet(this.products);
        for (Shop temp: shops) {
            pr.retainAll(temp.getProducts());
        }
        return pr;

    }
    public static HashSet<Integer> union(HashSet<Integer> set1, HashSet<Integer> set2){
        HashSet <Integer>res = new HashSet<>(set1);
        res.addAll(set2);
        return res;

    }
    public static HashSet<Integer> difference(HashSet<Integer> set1, HashSet<Integer> set2) {
        HashSet res = new HashSet(set1);
        res.removeAll(set2);
        return res;
    }

    public static HashSet<Integer> intersection(HashSet<Integer> set1, HashSet<Integer> set2){
        HashSet res = new HashSet(set1);
        res.retainAll(set2);
        return res;

    }
    public static HashSet<Integer> symDifference(HashSet<Integer> set1, HashSet<Integer> set2) {
        return difference(union(set1,set2),intersection(set1,set2));
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
        HashSet pr = new HashSet(this.products);
        for (Shop temp: shops) {
            pr.removeAll(temp.getProducts());
        }
        return pr;
    }

    public Set<Product> existOnlyInOne() {
        HashSet pr = new HashSet(this.products);
        HashSet res = new HashSet();
        HashSet sumduble = new HashSet();
        for (Shop temp: shops) {
            if (sumduble.isEmpty()) sumduble = new HashSet(temp.getProducts());
            HashSet res1 = new HashSet(temp.getProducts());
            res=symDifference(res,res1);
            sumduble.add(intersection(res1,res));

        }
        res.removeAll(sumduble);
        pr.retainAll(res);
        return pr;
    }


}
