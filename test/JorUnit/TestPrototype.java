package JorUnit;

import JorUnit.Test;
import JorUnit.TestResult;

class TestPrototype {
    public static void main(String[] args) {
        TestResult result = new TestResult();
        TestSuite suite = new TestSuite();
        
        suite.add(new TestTemplateMethod());
        suite.add(new TestTestResultDirectly());
        suite.add(new TestTestResultOfTests());
        suite.add(new TestTestSuite());
        suite.add(new TestAssertRaises());
        suite.add(new TestAssertRaisesAssertionException());

        suite.run(result);
        System.out.println(result.summarize());
    }
}

class TestTemplateMethod extends Test {
    void testMethod() { 
        Prototype test = new Prototype();
        TestResult result = new TestResult();
        test.run(result);
        assert test.log.equals("setup method teardown");
    }
}

class TestTestResultDirectly extends Test {
    void testMethod() {
        TestResult result = new TestResult();
        assert result.summarize().equals("0 ran, 0 failed");
        result.testStarted();
        assert result.summarize().equals("1 ran, 0 failed");
        result.testFailed();
        assert result.summarize().equals("1 ran, 1 failed");
    }
}

class TestTestResultOfTests extends Test {
    void testMethod() {
        Test test1 = new Prototype();
        TestResult result1 = new TestResult(); 
        test1.run(result1);
        assert result1.summarize().equals("1 ran, 0 failed");
        
        Test test2 = new FailingTest();
        TestResult result2 = new TestResult(); 
        test2.run(result2);
        assert result2.summarize().equals("1 ran, 1 failed");
    }
}

class FailingTest extends Test {
    void testMethod() {
        assert false;
    }
}

class TestTestSuite extends Test {
    void testMethod() {
        TestSuite suite = new TestSuite();
        suite.add(new Prototype());
        suite.add(new FailingTest());
        TestResult result = new TestResult();
        suite.run(result);
        assert result.summarize().equals("2 ran, 1 failed");
    }
}

class TestAssertRaises extends Test {
    void testMethod() {
        ShouldRaise wrapper = new AssertWrapper();
        assert Assert.raises(wrapper);
    }
}

class AssertWrapper implements ShouldRaise {
    public void shouldRaise() throws Exception {
        throw new Exception();
    }
}

class TestAssertRaisesAssertionException extends Test {
    void testMethod() {
        ShouldRaise wrapper = new ShouldRaiseAssertionException();
        assert Assert.raisesAssertionException(wrapper);
    }
}

class ShouldRaiseAssertionException implements ShouldRaise {
    public void shouldRaise() throws AssertionException {
        throw new AssertionException();
    }
}


// Log when setUp or tearDown is called.
abstract class PrototypeTemplate extends Test {
    public String log = "";
    
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
