package com.study.generics;

/**
 * @author ADMIN
 * 8/2/2023
 */
// we use <> to specify Parameter  type
public class GenericsClass<T> {
    // An object of type T is declare
    T obj;
    GenericsClass(T obj){
        this.obj = obj;
    }

    public T getObj(){
        return this.obj;
    }

    public static void main(String[] args) {
        GenericsClass<Integer> iObj = new GenericsClass<>(15);
        System.out.println(iObj.getObj());

        // instance of string type
        GenericsClass<String> sObj = new GenericsClass<>("NguyenDucBao");
        System.out.println(sObj.getObj());
    }
}
