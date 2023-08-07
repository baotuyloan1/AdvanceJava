package com.study.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ADMIN
 * 8/4/2023
 */
public class StreamProduct {


    int id;
    String name;
    float price;

    public StreamProduct(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "StreamProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {
        List<StreamProduct> products = new ArrayList<>();
        //Adding Products
        products.add(new StreamProduct(1, "HP Laptop", 25000f));
        products.add(new StreamProduct(2, "Dell Laptop", 30000f));
        products.add(new StreamProduct(3, "Lenevo Laptop", 28000f));
        products.add(new StreamProduct(4, "Sony Laptop", 28000f));


        products.stream().filter(p -> p.price > 25000).forEach(System.out::println);
        List<StreamProduct> products1 = products.stream().filter(p -> p.price > 28000).toList();
        List<Float> prices = products.stream().filter(p -> p.price > 25000f).limit(1).map(p -> p.price).toList();
        System.out.println(prices);
        System.out.println(products1);
        Stream.iterate(
                1, element -> element + 1).filter(element -> element % 5 == 0).limit(5).forEach(System.out::println);


        // reduce (accumulate): collect a large number of things over a long period of time
        Float totalPrice = products.stream().map(p -> p.price).reduce(-111000f, (chicken, price) -> chicken+price);
        System.out.println(totalPrice);

        float totalPrice2= products.stream().map(map -> map.price).reduce(0.0f, Float::sum);
        System.out.println(totalPrice2);

        // sum using collector
        double totalPrice3 = products.stream().collect(Collectors.summingDouble(product -> product.price));
        System.out.println(totalPrice3);

        List<String> names = Arrays.asList("Reflection", "Collection", "Stream");
        List<String> result = names.stream().filter(name -> name.startsWith("S")).toList();
        System.out.println(result);

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        List<String> sortedResult = names.stream().sorted(comparator).toList();
        System.out.println(sortedResult);
    }
}



