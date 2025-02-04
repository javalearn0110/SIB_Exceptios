import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        TestExceptions test = new TestExceptions();

        Class classDescriptor = test.getClass();
        for (Method method : classDescriptor.getDeclaredMethods()) {

            System.out.println("--Method: " + method.getName());
            try {
                method.invoke(test);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static class TestExceptions {
        /**
         * Возвращает сообщение об ошибке, которое было передано в конструктор исключения.
         * Это полезно для получения описания ошибки.
         */
        public void getMessage() {
            try {
                int result = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println("Ошибка: " + e.getMessage()); // Выведет: / by zero
            }
        }

        /**
         * Возвращает причину исключения (другое исключение, которое вызвало текущее).
         * Это полезно, если исключение является оберткой для другого исключения.
         */
        public void getCause() {
            try {
                throw new RuntimeException("Ошибка", new IOException("Причина"));
            } catch (RuntimeException e) {
                System.out.println("Причина: " + e.getCause());                     // Выведет: java.io.IOException: Причина
            }
        }

        /**
         * Выводит трассировку стека (stack trace) в стандартный поток ошибок (System.err).
         * Это помогает понять, где именно произошла ошибка.
         */
        public void printStackTrace() {
            try {
                int result = 10 / 0;
            } catch (ArithmeticException e) {
                e.printStackTrace(System.out);
            }
        }

        /**
         * Возвращает массив элементов StackTraceElement, которые представляют собой трассировку стека.
         * Это полезно для программного анализа стека вызовов.
         */
        public void getStackTrace() {
            try {
                int result = 10 / 0;
            } catch (ArithmeticException e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    System.out.println(element);
                }
            }
        }

        /**
         * Возвращает строковое представление исключения, включая имя класса и сообщение об ошибке.
         */
        public void toStringMeth() {
            try {
                int result = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println(e.toString()); // Выведет: java.lang.ArithmeticException: / by zero
            }
        }

        /**
         * Устанавливает причину исключения.
         * Это полезно, если вы создаете собственное исключение и хотите указать, что его вызвало.
         */
        public void initCause() {
            try {
                IOException ioException = new IOException("Ошибка ввода-вывода");
                RuntimeException runtimeException = new RuntimeException();
                runtimeException.initCause(ioException);
                throw runtimeException;
            } catch (RuntimeException e) {
                System.out.println(e.getCause());
            }
        }
    }
}