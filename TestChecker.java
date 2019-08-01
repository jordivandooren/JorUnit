class TestChecker {

    public static void main(String[] args) {
        testCheckTrue();
    }
    
    public static void testCheckTrue() {
        Checker check = new Checker();
        check.isTrue(true);
        check.isTrue(false);
    }
}    


class Checker {

    Checker() { }

    public void isTrue(boolean arg) {
        int evaluation = arg ? 1 : 0;
        System.out.println(evaluation);
    }
}
