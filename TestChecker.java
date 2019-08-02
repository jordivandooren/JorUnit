package JorUnit;

import JorUnit.Checker;

class TestChecker {

    public static void main(String[] args) {
        testTruth();
        testEquality();
    }
    
    public static void testTruth() {
        Checker check = new Checker();
        check.isTrue(true);
        check.isTrue(false);
    }

    public static void testFalse() {
        Checker check = new Checker();
        check.isFalse(false);
        check.isFalse(true);
    }

    public static void testEquality() {
        Checker check = new Checker();
        check.areEqual(1, 1);
        check.areEqual(1, 0);
    }
}    
