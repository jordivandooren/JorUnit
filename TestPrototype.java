package JorUnit;

import JorUnit.Checker;

class TestPrototype {
    public static void main(String[] args) {
        testPrototypeTestMethod();
    }

    static void testPrototypeTestMethod() {
        Prototype test = new Prototype();
        Checker check = new Checker();
        check.areEqual(0, test.wasRun);
        test.testMethod();
        check.areEqual(1, test.wasRun);
    }
}


class Prototype { 
    int wasRun;

    Prototype() {
        wasRun = 0;
    }

    public void testMethod() {
        wasRun = 1;
    }
}
        
