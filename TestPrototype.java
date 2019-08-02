package JorUnit;

import JorUnit.Checker;

class TestPrototype {
    public static void main(String[] args) {
        testPrototypeTestMethod();
        testSetUp();
    }

    static void testPrototypeTestMethod() {
        Prototype test = new Prototype();
        Checker check = new Checker();
        check.areEqual(0, test.wasRun);
        test.testMethod();
        check.areEqual(1, test.wasRun);
    }

    static void testSetUp() {
        Prototype test = new Prototype();
        Checker check = new Checker();
        check.areEqual(0, test.wasSetUp);
        test.testMethod();
        check.areEqual(1, test.wasSetUp);
    }
}


class Prototype { 
    int wasRun;
    int wasSetUp;

    Prototype() {
        wasSetUp = 0;
        wasRun = 0;
    }

    public void testMethod() {
        setUp();
        wasRun = 1;
    }

    void setUp() {
        wasSetUp = 1;
    }
}
        
