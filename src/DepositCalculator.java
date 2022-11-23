import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int period ) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
        return round(amount+amount * yearRate * period, 2);
    }

    double round(double value,int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void calculatePay() {
        int period ;
        int action ;
        Scanner input = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = input.nextInt();

        System.out.println("Введите срок вклада в годах:") ;
        period = input.nextInt( );
        System.out.println   (   "Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = input.nextInt();
        double pay = 0;

        if (action == 1) {
            pay = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2){
            pay = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + pay);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculatePay();
    }

}