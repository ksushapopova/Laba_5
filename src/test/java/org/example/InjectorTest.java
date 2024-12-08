package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Класс InjectorTest содержит тесты для проверки функциональности класса {@link Injector}.
 */
public class InjectorTest {

    private Injector injector;

    /**
     * Метод, который выполняется перед каждым тестом.
     * Инициализирует экземпляр {@link Injector}.
     */
    @BeforeEach
    public void setUp() {
        injector = new Injector();
    }

    /**
     * Тестирует метод {@link Injector#inject(Object)} на корректность инъекции зависимостей.
     *
     * @throws Exception если происходит ошибка во время инъекции
     */
    @Test
    public void testInject() throws Exception {
        SomeBean someBean = new SomeBean();

        injector.inject(someBean);

        assertNotNull(someBean.getField1(), "field1 should be injected");
        assertNotNull(someBean.getField2(), "field2 should be injected");
    }

    /**
     * Тестирует метод {@link SomeBean#foo()} на корректность вывода.
     * Проверяет, что вывод соответствует ожидаемым значениям.
     *
     * @throws Exception если происходит ошибка во время инъекции или выполнения метода foo
     */
    @Test
    public void testFoo() throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        SomeBean someBean = new SomeBean();

        injector.inject(someBean);


        someBean.foo();

        String output = outputStream.toString();
        assertTrue(output.equals("BC") || output.equals("CB"), "Output should be 'BC' or 'CB'");
    }
}