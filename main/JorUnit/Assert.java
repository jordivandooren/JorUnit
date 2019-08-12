package JorUnit;

class Assert {
    public static void isTrue(boolean arg) throws AssertionException { 
        if (!arg) {
            throw new AssertionException();
        }
    }

    public static boolean raises(ShouldRaise arg) {
        try {
            arg.shouldRaise();
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean raisesAssertionException(ShouldRaise arg) {
        try {
            arg.shouldRaise();
            return false;
        } catch (AssertionException e) {
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

interface ShouldRaise {
    public void shouldRaise() throws Exception;
}

class AssertionException extends Exception {};
