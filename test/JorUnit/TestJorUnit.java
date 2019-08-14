package JorUnit;

import JorUnit.Test;
import JorUnit.TestResult;

class TestJorUnit {
    public static void main(String[] args) {
        TestResult result = new TestResult();
        TestSuite suite = new TestSuite();
        
        suite.add(new TestTemplateMethod());
        suite.add(new TestTestResultDirectly());
        suite.add(new TestTestResultOfTests());
        suite.add(new TestTestSuite());
        suite.add(new TestAssertRaises());
        suite.add(new TestAssertRaisesAssertionException());
        suite.add(new TestAssertIsTrue());
        suite.add(new TestAssertEqualStrings());

        suite.run(result);
        System.out.println(result.summarize());
    }
}

class TestTemplateMethod extends Test {
    void testMethod() throws AssertionException { 
        Prototype test = new Prototype();
        TestResult result = new TestResult();
        test.run(result);
        Assert.isTrue(test.log.equals("setup method teardown"));
    }
}

class TestTestResultDirectly extends Test {
    void testMethod() throws AssertionException {
        TestResult result = new TestResult();
        Assert.isTrue(result.summarize().equals("0 ran, 0 failed"));
        result.testStarted();
        Assert.isTrue(result.summarize().equals("1 ran, 0 failed"));
        result.testFailed();
        Assert.isTrue(result.summarize().equals("1 ran, 1 failed"));
    }
}

class TestTestResultOfTests extends Test {
    void testMethod() throws AssertionException {
        Test test1 = new Prototype();
        TestResult result1 = new TestResult(); 
        test1.run(result1);
        Assert.isTrue(result1.summarize().equals("1 ran, 0 failed"));
        
        Test test2 = new FailingTest();
        TestResult result2 = new TestResult(); 
        test2.run(result2);
        Assert.isTrue(result2.summarize().equals("1 ran, 1 failed"));
    }
}

class FailingTest extends Test {
    void testMethod() throws AssertionException {
        Assert.isTrue(false);
    }
}

class TestTestSuite extends Test {
    void testMethod() throws AssertionException {
        TestSuite suite = new TestSuite();
        suite.add(new Prototype());
        suite.add(new FailingTest());
        TestResult result = new TestResult();
        suite.run(result);
        Assert.isTrue(result.summarize().equals("2 ran, 1 failed"));
    }
}

class TestAssertRaises extends Test {
    void testMethod() throws AssertionException {
        ShouldRaise wrapper = new AssertWrapper();
        Assert.isTrue(Assert.raises(wrapper));
    }
    class AssertWrapper implements ShouldRaise {
        public void shouldRaise() throws Exception {
            throw new Exception();
        }
    }
}


class TestAssertRaisesAssertionException extends Test {
    void testMethod() throws AssertionException {
        ShouldRaise wrapper = new ShouldRaiseAssertionException();
        Assert.isTrue(Assert.raisesAssertionException(wrapper));
    }
    class ShouldRaiseAssertionException implements ShouldRaise {
        public void shouldRaise() throws AssertionException {
            throw new AssertionException();
        }
    }
}


class TestAssertIsTrue extends Test {
    public void testMethod() throws AssertionException {
        Assert.isTrue(true);
    }
}

class TestAssertEqualStrings extends Test {
    public void testMethod() throws AssertionException {
        Assert.areEqual("ab", "ab");
        ShouldRaise wrapper = new RaiseWrapper();
        Assert.isTrue(Assert.raisesAssertionException(wrapper));
    }

    class RaiseWrapper implements ShouldRaise {
        public void shouldRaise() throws Exception {
            Assert.areEqual("ab", "ba");
        }
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

// The concrete class implements a testMethod that logs.
class Prototype extends PrototypeTemplate { 
    void testMethod() {
        log += " method";
    }
}
