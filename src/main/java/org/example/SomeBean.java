package org.example;

public class SomeBean {
    @AutoInjectable
    private SomeInterface field1;

    @AutoInjectable
    private SomeOtherInterface field2;

    /**
     * Метод foo, который вызывает методы зависимостей.
     */
    public void foo() {
        field1.doSomething();
        field2.doSomeOther();
    }

    /**
     * Возвращает значение поля field1.
     *
     * @return поле field1
     */
    public SomeInterface getField1() {
        return field1;
    }

    /**
     * Возвращает значение поля field2.
     *
     * @return поле field2
     */
    public SomeOtherInterface getField2() {
        return field2;
    }
}
