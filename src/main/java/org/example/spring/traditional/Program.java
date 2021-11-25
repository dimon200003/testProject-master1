package org.example.spring.traditional;

public class Program {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int i;
        i = calculator.add(4, 3);
        System.out.println(i);

        int result = calculator.add(4, 3);
        System.out.println(result);


        System.out.println(calculator.add(4, 3));

    }

}
