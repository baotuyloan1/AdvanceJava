package com.study.serialization_and_deserialization;

import java.io.Serializable;

/**
 * @author ADMIN
 * 8/3/2023
 */
public class Emp implements Serializable {

    transient int a;
    static int b;
    String name;
    int age;

    public Emp(int a, String name, int age, int b) {
        this.a = a;
        this.name = name;
        this.age = age;
        this.b = b;
    }

    public static void printData(Emp data){
        System.out.println();
    }

    public static void main(String[] args) {

    }
}
