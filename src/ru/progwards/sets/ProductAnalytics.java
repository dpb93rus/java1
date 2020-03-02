package ru.progwards.sets;

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
HashSet sh = new HashSet(this.shops);
        for (HashSet<shop> temp:sh) {

        }

    }

    public Set<Product> existAtListInOne() {

    }

    public Set<Product> notExistInShops() {

    }

    public Set<Product> existOnlyInOne() {

    }


}
