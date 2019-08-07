package JorUnit;

class TestResult {
    int runCount = 0;
    int failCount = 0;

    TestResult() {}
    public void testStarted() {
        runCount += 1;
    }

    public void testFailed() {
        failCount += 1;
    }

    public String summarize() {
        return String.format("%d ran, %d failed", runCount, failCount);
    }
}

