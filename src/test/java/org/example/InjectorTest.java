package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InjectorTest {

    private Injector injector;

    @BeforeEach
    public void setUp() {
        injector = new Injector();
    }

    @Test
    public void testInject() throws Exception {
        SomeBean someBean = new SomeBean();

        injector.inject(someBean);

        assertNotNull(someBean.getField1(), "field1 should be injected");
        assertNotNull(someBean.getField2(), "field2 should be injected");
    }

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