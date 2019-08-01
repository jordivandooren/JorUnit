class TestPrototype {
    public static void main(String[] args) {
        testPrototypeTestMethod();
    }

    static void testPrototypeTestMethod() {
        Prototype test = new Prototype();
        System.out.println(test.wasRun);
        test.testMethod();
        System.out.println(test.wasRun);
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
        
