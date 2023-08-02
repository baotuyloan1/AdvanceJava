package com.study.generics;

import java.util.ArrayList;

/**
 * @author ADMIN
 * 8/2/2023
 */
class Test<T, U> {
    T obj1;
    U obj2;

    Test(T obj1, U obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void print() {
        System.out.println(obj1);
        System.out.println(obj2);
    }

    //    Type Safety:
    <P> void genericDisplay(T element) {
        System.out.println(element.getClass().getName() + " = " + element);
    }


    public static void main(String[] args) {
//        <> type safety
        Test<String, Integer> obj = new Test<>("NguyenDucBao", 15);
        Test<Integer, String> obj1 = new Test<>(15, "Duc bao");
        obj.print();
        obj.genericDisplay("Nguyen Duc Bao");
//        obj.genericDisplay(1.0);
//        obj.genericDisplay(11);

        // we cannot use primitive data types like int, char - > collection trong java chỉ lưu mỗi reference type
//        Test<int> obj = new Test<int>(20)
//        can be resolved ussing type wwrappers  to encapsulate a primative type
//        but primitive type arrays can be passed to the type parameter because arrays are refernce types
        ArrayList<int[]> a = new ArrayList<>();

//        Even though obj and obj1 are of type Test
//        obj = obj1;

        /**
         * T – Type
         * E – Element
         * K – Key
         * N – Number
         * V – Value
         */

        ArrayList al = new ArrayList();

        al.add("Sachin");
        al.add("Rahul");
        al.add(10); // Compiler allows this

        String s1 = (String) al.get(0);
        String s2 = (String) al.get(1);

        // Causes Runtime Exception
        // java.lang.Integer cannot be cast to java.lang.String
//        String s3 = (String)al.get(2);
        ArrayList<String> al1 = new ArrayList<String>();

        al1.add("Sachin");
        al1.add("Rahul");

        // Now Compiler doesn't allow this
//        al1.add(10);

        String s11 = (String) al.get(0);
        String s21 = (String) al.get(1);
//        String s31 = (String) al.get(2);

        //generics prmotes code Reusability
        Integer[] b = {100, 22, 58, 41, 6, 50};

        Character[] c = {'v', 'g', 'a', 'c', 'x', 'd', 't'};

        String[] s = {"Virat", "Rohit", "Abhinay", "Chandu", "Sam", "Bharat", "Kalam"};

        System.out.print("Sorted Integer array :  ");
        sort_generics(b);

        System.out.print("Sorted Character array :  ");
        sort_generics(c);

        System.out.print("Sorted String array :  ");
        sort_generics(s);

    }

    public static <T extends Comparable<T>> void sort_generics(T[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    swap(j, j + 1, a);
                }
            }
        }

        for (T i : a) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static <T> void swap(int i, int j, T[] a) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
