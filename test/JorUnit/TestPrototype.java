package JorUnit;

import JorUnit.Test;
import JorUnit.TestResult;

class TestPrototype {
    public static void main(String[] args) {
        Test test1 = new TestTestMethod();
        test1.run();
        System.out.println(test1.summarize());
        
        Test test2 = new TestSummarize();
        test2.run();
        System.out.println(test2.summarize());

        Test test3 = new TestTestResult();
        test3.run();
        System.out.println(test3.summarize());
    }
}

class TestTestMethod extends MetaTest {
    TestTestMethod() {}

    void testMethod() { 
        assert test.log.equals("setup method teardown");
    }
}

class TestSummarize extends MetaTest {
    TestSummarize() {}

    void testMethod() {
        assert test.summarize().equals("1 ran, 0 failed");
    }
}

class TestTestResult extends Test {
    TestTestResult() {}
    
    void testMethod() {
        TestResult result = new TestResult();
        assert result.summarize().equals("0 ran, 0 failed");
        result.testStarted();
        assert result.summarize().equals("1 ran, 0 failed");
        result.testFailed();
        assert result.summarize().equals("1 ran, 0 failed");
    }

    void setUp() {}
    void tearDown() {}
}
        

abstract class MetaTest extends Test {
    Prototype test;
 
    MetaTest() {}

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
    Prototype() {}

    void testMethod() {
        log += " method";
    }
}
