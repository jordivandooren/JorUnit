class TestPrototype {
    public static void main(String[] args) {
        WasRun test = new WasRun();
        System.out.println(test.wasRun);
        test.testMethod();
        System.out.println(test.wasRun);
    }
}

class WasRun { 
    int wasRun;
    WasRun() {
        wasRun = 0;
    }

    public void testMethod() {
        wasRun = 1;
    }

}
        
