package JorUnit;

public class Checker {

    Checker() { }

    public void isTrue(boolean arg) {
        int evaluation = arg ? 1 : 0;
        System.out.println(evaluation);
    }

    public void isFalse(boolean arg) {
        int evaluation = arg ? 0 : 1;
        System.out.println(evaluation);
    }

    public void areEqual(Object arg1, Object arg2) {
        int evaluation = arg1 == arg2 ? 1 : 0;
        System.out.println(evaluation);
    }
}
