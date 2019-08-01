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
        if (arg == true) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
