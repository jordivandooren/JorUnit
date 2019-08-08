package JorUnit;

import JorUnit.Test;
import JorUnit.TestResult;

import java.util.ArrayList;
import java.util.Iterator;

class TestSuite {
    ArrayList<Test> tests = new ArrayList<Test>();

    void add(Test test) {
        tests.add(test);
    }
        
    public void run(TestResult result) {
        Iterator<Test> iterator = tests.iterator();
        while (iterator.hasNext()) {
            Test test = iterator.next();
            test.run(result);
        }
    }
}
