package JorUnit;

abstract class Test {
    public void run(TestResult result) {
        result.testStarted();
        setUp();
        try {
            testMethod();
        } catch(AssertionError ae) {
            result.testFailed();
        } catch(Exception e) {
            result.testFailed();
        }
        tearDown();
    }

    void setUp() {};
    abstract void testMethod() throws AssertionException;
    void tearDown() {};
}
