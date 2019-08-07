package JorUnit;

import JorUnit.Test;
import JorUnit.TestResult;

class TestPrototype {
    public static void main(String[] args) {
        Test test1 = new TestTestMethod();
        System.out.println(test1.run().summarize());
      
        Test test2 = new TestTestResult();
        System.out.println(test2.run().summarize());
    }
}

class TestTestMethod extends MetaTest {
    void testMethod() { 
        assert test.log.equals("setup method teardown");
    }
}

class TestTestResult extends Test {
    void testMethod() {
        TestResult result = new TestResult();
        assert result.summarize().equals("0 ran, 0 failed");
        result.testStarted();
        assert result.summarize().equals("1 ran, 0 failed");
        result.testFailed();
        assert result.summarize().equals("1 ran, 1 failed");
    }

    void setUp() {}
    void tearDown() {}
}
        

abstract class MetaTest extends Test {
    Prototype test;
    void setUp() {
        test = new Prototype();
        test.run();
    }

    void tearDown() {}
} 

// Log when setUp or tearDown is called.
abstract class PrototypeTemplate extends Test {
    String log;

    PrototypeTemplate() {
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

// The concrete class implements the a testMethod that logs.
class Prototype extends PrototypeTemplate { 
    void testMethod() {
        log += " method";
    }
}
