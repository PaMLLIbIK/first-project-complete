import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Поехали!
        System.out.println("Здравствуйте");
        System.out.println("Выберите пункт меню");

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();

            int currency = scanner.nextInt();
            if (currency == 1) {
                stepTracker.addNewNumberStepsPerDay();//реализация команды 1
            } else if (currency == 2) {
                stepTracker.changeStepGoal();   //реализация команды 2
            } else if (currency == 3) {
                stepTracker.printStatistic();   //реализация команды 3
            } else if (currency == 4) {
                System.out.println("Пока!");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды не существует");
            }

        }

    }

    static void printMenu() {
        System.out.println("Выберите пункт меню от 1 до 4");
        System.out.println("1 - ввести количество шагов за определённый день");
        System.out.println("2 - изменить цель по количеству шагов в день");
        System.out.println("3 - напечатать статистику за определённый месяц");
        System.out.println("4 - выйти из приложения");
    }
}

