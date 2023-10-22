import java.util.Scanner;

public class StepTracker {

    Converter converter = new Converter();
    MonthData monthData = new MonthData();
     MonthData[] monthToData = new MonthData[12];
     Scanner scanner;

     int goalByStepsPerDay = 10000;
     StepTracker(Scanner scan) {
         scanner = scan;

         for (int i = 0; i < monthToData.length; i++) {
             monthToData[i] = new MonthData();
         }
     }

    void addNewNumberStepsPerDay() {

         System.out.println("Введите номер месяца от 1 до 12");
         int month = scanner.nextInt();
         if (month < 1 || month > 12) {
             System.out.println("Номер месяца введен некорректно");
             return;
         } else {

             System.out.println("Введите номер дня от 1 до 30");
             int day = scanner.nextInt();
             if (day < 1 || day > 30) {
                 System.out.println("Номер дня введен некорректно");
                 return;
             } else {

                 System.out.println("Введите количество шагов");
                 int steps = scanner.nextInt();
                 if (steps < 1 ) {
                     System.out.println("Количество шагов введено некорректно");
                     return;
                 } else {

                     MonthData monthData = monthToData[month - 1];
                     monthData.days[day - 1] = steps;
                 }
             }
         }
    }

    void changeStepGoal() {
        System.out.println("Введите цель шагов на день");

        int targetSteps = scanner.nextInt();
        if (targetSteps <= 0) {
            System.out.println("Планируемое количество шаго введено некорректно");
            return;
        } else {
            goalByStepsPerDay = targetSteps;
        }
    }

    void printStatistic() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Номер месяца введен некорректно");
            return;
        } else {

            monthData = monthToData[month - 1];
            int sumSteps = monthData.sumStepsFromMonth();
            monthData.printDaysAndStepsFromMonth();
            System.out.println("За этот месяц вы прошли " + sumSteps + " шагов");
            System.out.println("Максимальное количество шагов за месяц " + monthData.maxSteps());
            System.out.println("В среднем за месяц в день вы прошли " + (sumSteps / 30) + " шагов");
            System.out.println("За месяц вы прошли " + converter.convertToKm(sumSteps) + " км.");
            System.out.println("За этот месяц вы сожгли " + converter.convertStepsToKilocalories(sumSteps)
                    + " килокалорий");
            System.out.println("Лучшая серия за этот месяц " + monthData.bestSeries(goalByStepsPerDay));
            System.out.println();
        }
    }
}
