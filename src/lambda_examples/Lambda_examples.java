/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda_examples;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author ipetrash
 */
public class Lambda_examples {
    
    static void example_1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(numbers);
        
        // Пример вывода с элементов списка
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
        }
        System.out.println();
        
        for (Integer value: numbers) {
            System.out.print(value);
        }
        System.out.println();
        
        numbers.forEach((Integer value) -> System.out.print(value));
        System.out.println();
        
        numbers.forEach(value -> System.out.print(value));
        System.out.println();
        
        numbers.forEach(System.out::print);
        System.out.println();
    }
    
    static void example_2() {
        // Вывод таблицы умножения
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                System.out.print(String.format("%s ", numbers.get(i) * numbers.get(j)));
            }
            System.out.println();
        }
        System.out.println();
        
        for (Integer i: numbers) {
            for (Integer j: numbers) {
                System.out.print(String.format("%s ", i * j));
            }
            System.out.println();
        }
        System.out.println();
        
        numbers.forEach(i -> {
            numbers.forEach(j -> {
                System.out.print(String.format("%s ", i * j));
            });
            System.out.println();
        });
        System.out.println();
    }
    
    static void example_3() {
        List<String> numbers = Arrays.asList("2", "hel", "aorl", "1", "on", "HEl");
        System.out.println(numbers);
        
        // Просто сортировка
        Collections.sort(numbers);
        System.out.println(numbers);
        
        // Сортировка без учета регистра
        Collections.sort(numbers, String::compareToIgnoreCase);
        System.out.println(numbers);
        
        // Сортировка по длине строк
        Collections.sort(numbers, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        System.out.println(numbers);
        
        // Обратная сортировка по длине строк
        Collections.sort(numbers, (o1, o2) -> Integer.compare(o2.length(), o1.length()));
        System.out.println(numbers);
    }
    
    static void example_4() {
        class MyString {
            public MyString(Object value) {
                obj = value;
            }
            
            private Object obj;
            
            @Override
            public String toString() {
                return "MyString<" + obj.toString() + ">";
            }
        };
        
        // List<Integer> -> List<String>
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(numbers);
        
       
        Stream<String> stream = numbers.stream().map(String::valueOf);
        List<String> strs = stream.collect(Collectors.toList());
        System.out.println(strs);
        
        // Подставление конструктора объекта
        Stream<MyString> stream2 = numbers.stream().map(MyString::new);
        List<MyString> strs2 = stream2.collect(Collectors.toList());
        System.out.println(strs2);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        example_1();
        System.out.println();
        
        example_2();
        System.out.println();
        
        example_3();
        System.out.println();
        
        example_4();
        System.out.println();
    }    
}
