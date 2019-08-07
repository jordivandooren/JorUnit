package JorUnit;

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
