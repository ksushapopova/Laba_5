package org.example;

public class OtherImpl implements SomeInterface {
    public OtherImpl() {
    }

    @Override
    public void doSomething() {
        System.out.print("B");
    }
}
