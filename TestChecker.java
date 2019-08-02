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

    public static void testEquality() {
        Checker check = new Checker();
        check.areEqual(1, 1);
        check.areEqual(1, 0);
    }
}    


class Checker {

    Checker() { }

    public void isTrue(boolean arg) {
        int evaluation = arg ? 1 : 0;
        System.out.println(evaluation);
    }

    public void areEqual(Object arg1, Object arg2) {
        int evaluation = arg1 == arg2 ? 1 : 0;
        System.out.println(evaluation);
    }
}
