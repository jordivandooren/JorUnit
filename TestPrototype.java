package JorUnit;

class TestPrototype {
    public static void main(String[] args) {
        testTestMethod();
    }

    static void testTestMethod() {
        Prototype test = new Prototype();
        test.testMethod();
        assert test.log.equals("setup method teardown");
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
        
