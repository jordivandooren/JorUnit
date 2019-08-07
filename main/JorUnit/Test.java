package JorUnit;

abstract class Test {
    public TestResult run() {
        TestResult result = new TestResult();
        result.testStarted();
        setUp();
        try {
            testMethod();
        } catch(Exception e) {
            result.testFailed();
        }
        tearDown();
        return result;
    }

    void setUp() {};
    abstract void testMethod();
    void tearDown() {};
}
