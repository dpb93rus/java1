package ru.progwards.sets;

import java.util.List;

public class Shop {

    private List<Product> products;

public Shop(List<Product> products){
    this.products = products;
}

public List<Product> getProducts(){
    return this.products;
}
}
