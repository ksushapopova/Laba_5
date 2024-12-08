package org.example;

/**
 * Главный класс приложения, который демонстрирует использование инъектора.
 */

public class Main {
    public static void main(String[] args) {
        SomeBean sb = (new Injector()).inject(new SomeBean());
        sb.foo();
    }
}
