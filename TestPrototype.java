package JorUnit;

class TestPrototype {
    public static void main(String[] args) {
        testTestMethod();
        testSummarize();
    }

    static void testTestMethod() {
        Prototype test = new Prototype();
        test.run();
        assert test.log.equals("setup method teardown");
    }

    static void testSummarize() {
        Prototype test = new Prototype();
        test.run();
        assert test.summarize().equals("1 ran, 0 failed");
    }
}

abstract class Test {
    int runCount;
    int failCount;
    
    Test() {
        runCount = 0;
        failCount = 0;
    }
    
    public void run() {
        runCount += 1;
        setUp();
        try {
            testMethod();
        } catch(Exception e) {
            failCount += 1;
        } finally {
            tearDown();
        }
    }

    abstract void setUp();
    abstract void testMethod();
    abstract void tearDown();
    
    public String summarize() {
        return String.format("%d ran, %d failed", runCount, failCount);
    }
}

abstract class PrototypeTemplate extends Test {
    String log;

    PrototypeTemplate() {
        super();
        log = "";
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

