package JorUnit;

class Assert {
    public static boolean raises(ShouldRaise arg) {
        try {
            arg.shouldRaise();
            return false;
        } catch (Throwable e) {
            return true;
        }
    }
}

interface ShouldRaise {
    public void shouldRaise() throws Throwable;
}

class AssertionException extends Exception {};
