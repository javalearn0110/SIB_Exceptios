
public class Main {
    static Tester tester = new Tester();

    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            callChecked();
        } catch (RuntimeException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Tester.CheckedExceptionV1) {
                System.out.println("Caught CheckedExceptionV1");
            } else if (cause instanceof Tester.CheckedExceptionV2) {
                System.out.println("Caught CheckedExceptionV2");
            }
        } finally {
            System.out.println("Finally");
        }
    }
    public static void callChecked() {
        try {
            tester.checked(1);
        } catch (Tester.CheckedExceptionV1 | Tester.CheckedExceptionV2 e) {
            throw new RuntimeException(e);
        }
    }

}