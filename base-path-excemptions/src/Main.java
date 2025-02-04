/**
 * Пример
 * 1) заворачинания checked в Unchecked
 * 2) блок Finally
 */
public class Main {
    static Tester tester = new Tester();

    public static void main(String[] args) {

        try {
            callChecked();
        } catch (RuntimeException e) {
            System.out.println("--Вывод основного исключения");
            System.out.println(e.toString());

            System.out.println("--Вывод вложенного исключения");
            Throwable cause = e.getCause();
            if (cause instanceof Tester.CheckedExceptionV1) {
                System.out.println("Caught CheckedExceptionV1");
                System.out.println("Caught" +  cause.toString());
            } else if (cause instanceof Tester.CheckedExceptionV2) {
                System.out.println("Caught CheckedExceptionV2");
                System.out.println("Caught" +  cause.toString());
            }
        } finally {
            System.out.println("Finally");
        }
    }
    public static void callChecked() {
        try {
            tester.checked(1);
        } catch (Tester.CheckedExceptionV1 | Tester.CheckedExceptionV2 e) {
            throw new RuntimeException("Переопределение ", e);
        }
    }

}