package org.ManikantaMandala;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Factorial factorial = n -> {
            if(n==1) return n;
            return n * factorial.func(n-1);
        }
        System.out.println(factorial.func(5));

    }
}
@FunctionalInterface
interface Factorial{
    int func(int n);
}