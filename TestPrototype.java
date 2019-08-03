package JorUnit;

class TestPrototype {
    public static void main(String[] args) {
        testTestMethod();
    }

    static void testTestMethod() {
        Prototype test = new Prototype();
        test.run();
        assert test.log.equals("setup method teardown");
    }
}

abstract class PrototypeTemplate {
    String log;

    PrototypeTemplate() {
        log = "";
    }

    public void run() {
        setUp();
        testMethod();
        tearDown();
    }

    void setUp() {
        log += "setup";
    }
    
    abstract void testMethod(); 
    
    void tearDown() {
        log += " teardown";
    }
}

class Prototype extends PrototypeTemplate { 

    Prototype() {
        super();
    }

    void testMethod() {
        log += " method";
    }
}

