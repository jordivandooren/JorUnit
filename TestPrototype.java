package JorUnit;

class TestPrototype {
    public static void main(String[] args) {
        testTestMethod();
    }

    static void testTestMethod() {
        Prototype test = new Prototype();
        test.testMethod();
        boolean result = test.log.equals("setup method teardown");
        System.out.println(result);
    }
}


class Prototype { 
    String log;

    Prototype() {
        log = "";
    }

    public void testMethod() {
        setUp();
        log += " method";
        tearDown();
    }

    void setUp() {
        log += "setup";
    }
    
    void tearDown() {
        log += " teardown";
    }
}
        
