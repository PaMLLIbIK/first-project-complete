public class Converter {

    static int distance = 75;  //1 шаг = 75см = 0,0075км
    static int calories = 50;


    int convertToKm(int sumSteps) {
        int sum = (sumSteps / distance) / 100000;
        return sum;
    }

   int convertStepsToKilocalories(int sumSteps) {
        int kKal = sumSteps * calories / 1000;
        return kKal;
    }
}
