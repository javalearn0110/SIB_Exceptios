

/**
 * Пример
 * 1) Создание исключений
 * 2) Работа с checked / unchecked
 * 3) Множественный перехват
 * 4) Вызов исключение через промежуточный класс
 */
//
public class Main {


    public static void main(String[] args) {
        System.out.println("Hello world!");
        Tester tester = new Tester();
//        TesterNew tester = new TesterNew();

        try {
            tester.checked(1);
            //tester.checked(1);
        } catch (Tester.CheckedExceptionV1 e) {
            e.printStackTrace();                //Трейс и сообщение
        } catch (Tester.CheckedExceptionV2 e) {
            System.err.println(e.getMessage()); //Только сообщение
        }
        //catch (Tester.CheckedException e) {
        //catch (Tester.CheckedExceptionV1 | Tester.CheckedExceptionV2 e) {
        //tester.unchecked(0);
    }

    public static class TesterNew {
        Tester tester;

        public TesterNew() {
            tester = new Tester();
        }

        public void checked(int i) throws Tester.CheckedExceptionV2, Tester.CheckedExceptionV1 {
            tester.checked(i);
        }

        public void unchecked(int i) {
            tester.unchecked(i);
        }


    }
}