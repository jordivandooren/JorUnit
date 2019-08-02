package JorUnit;

import JorUnit.Checker;

class TestPrototype {
    public static void main(String[] args) {
        testTestMethod();
        testSetUp();
    }

    static void testTestMethod() {
        Prototype test = new Prototype();
        Checker check = new Checker();
        check.isFalse(test.wasRun);
        test.testMethod();
        check.isTrue(test.wasRun);
    }

    static void testSetUp() {
        Prototype test = new Prototype();
        Checker check = new Checker();
        check.isFalse(test.wasSetUp);
        test.testMethod();
        check.isTrue(test.wasSetUp);
    }
}


class Prototype { 
    boolean wasRun;
    boolean wasSetUp;

    Prototype() {
        wasSetUp = false;
        wasRun = false;
    }

    public void testMethod() {
        setUp();
        wasRun = true;
    }

    void setUp() {
        wasSetUp = true;
    }
}
        
