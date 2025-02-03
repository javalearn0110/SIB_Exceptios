
public class Tester {
    public void checked(int n) throws CheckedExceptionV1, CheckedExceptionV2
    {
        if (n == 0)
            throw new CheckedExceptionV1("n равно нулю!");
        if (n == 1)
            throw new CheckedExceptionV2("n равно единице");
    }
    public void unchecked(int n) {
        if (n == 0)
            throw new RuntimeException("n равно нулю!");
        if (n == 1)
            throw new RuntimeException("n равно единице");
    }


    public static class CheckedException extends Exception {
        public CheckedException(String message) {
            super(message);
        }
    }
    public static class CheckedExceptionV1 extends CheckedException {
        public CheckedExceptionV1(String message) {
            super("Exception-1 " + message);
        }
    }
    public static class CheckedExceptionV2 extends CheckedException {
        public CheckedExceptionV2(String message) {
            super("Exception-2 " + message);
        }
    }


    public static class UnCheckedException extends RuntimeException {
        public UnCheckedException(String message) {
            super(message);
        }
    }
    public static class UnCheckedExceptionV1 extends UnCheckedException {
        public UnCheckedExceptionV1(String message) {
            super("Exception-1 " + message);
        }
    }
    public static class UnCheckedExceptionV2 extends UnCheckedException {
        public UnCheckedExceptionV2(String message) {
            super("Exception-2 " + message);
        }
    }

}



