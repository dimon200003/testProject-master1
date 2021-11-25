package org.example.spring.springStyle;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("common-bean.xml");
        Calculator calculator = (Calculator) context.getBean("calculatorBean");

        // Calculator calculator = new Calculator();

        int result = calculator.add(20, 10);
        System.out.println(result);


        Calculator calculator2 = (Calculator) context.getBean("calculatorBean");

        int result2 = calculator2.add(4, 3);
        System.out.println(result2);


        JokerProker jokerProker  = (JokerProker) context.getBean("joker");
        System.out.println(jokerProker.sayHello());

    }

}
