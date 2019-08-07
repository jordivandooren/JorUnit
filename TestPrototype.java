package JorUnit;

class TestPrototype {
    public static void main(String[] args) {
        Test test1 = new TestTestMethod();
        test1.run();
        System.out.println(test1.summarize());
        
        Test test2 = new TestSummarize();
        test2.run();
        System.out.println(test2.summarize());
    }
}

class TestTestMethod extends MetaTest {
    TestTestMethod() { 
        super();
    }

    void testMethod() { 
        assert test.log.equals("setup method teardown");
    }
}

class TestSummarize extends MetaTest {
    TestSummarize() { 
        super();
    }

    void testMethod() {
        assert test.summarize().equals("1 ran, 0 failed");
    }
}

abstract class MetaTest extends Test {
    Prototype test;
 
    MetaTest() {
        super();
    }

    void setUp() {
        test = new Prototype();
        test.run();
    }

    void tearDown() {}
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
        }
        tearDown();
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
