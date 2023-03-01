import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        Scanner scanner = new Scanner(System.in);
        long diffMonth;
        long diffWeek;
        long diffDay;
        double humidity;

        System.out.println("Ввод даты последнего полива");
        System.out.println("Введите год: ");
        int yearLastHumidity = scanner.nextInt();

        System.out.println("Введите месяц: ");
        int monthLastHumidity = scanner.nextInt();

        System.out.println("Введите дату: ");
        int dateLastHumidity = scanner.nextInt();

        LocalDate today = LocalDate.now(); //Считываем текущую дату
//        today = LocalDate.of(2022, 12, 15); //Проверка для зимы
//        today = LocalDate.of(2022, 03, 15); //Проверка для весны
//        today = LocalDate.of(2022, 06, 15); //Проверка для лета
//        today = LocalDate.of(2022, 09, 15); //Проверка для осени

        LocalDate dateOfLastWatering = LocalDate.of(yearLastHumidity, monthLastHumidity, dateLastHumidity);

        switch (today.getMonthValue()) {
            case 12, 1, 2 ->{
                diffMonth = ChronoUnit.MONTHS.between(dateOfLastWatering, today);
                if (diffMonth > 1) {
                    System.out.println("Текущая дата : " + today + ", зима. Дата последнего полива : " +
                            dateOfLastWatering + ", прошло " + diffMonth + " месяцев. Вам пора полить кактус!");
                } else {
                    if (diffMonth >= 0) {
                        System.out.println("Текущая дата : " + today + ", зима. Дата последнего полива : " +
                                dateOfLastWatering + ", прошло меньше месяца. Полейте кактус " +
                                dateOfLastWatering.plusMonths(1) + "!");
                    }
                }
            }
            case 3, 4, 5 ->{
                diffWeek = ChronoUnit.WEEKS.between(dateOfLastWatering, today);
                if (diffWeek > 1) {
                    System.out.println("Текущая дата : " + today + ", весна. Дата последнего полива : " +
                            dateOfLastWatering + ", прошло " + diffWeek + " недель. Вам пора полить кактус!");
                } else {
                    System.out.println("Текущая дата : " + today + ", весна. Дата последнего полива : " +
                            dateOfLastWatering + ", прошло меньше недели. Полейте кактус " +
                            dateOfLastWatering.plusWeeks(1)  + "!");
                }
            }
            case 9, 10, 11 ->{
                diffWeek = ChronoUnit.WEEKS.between(dateOfLastWatering, today);
                if (diffWeek > 1) {
                    System.out.println("Текущая дата : " + today + ", осень. Дата последнего полива : " +
                            dateOfLastWatering + ", прошло " + diffWeek + " недель. Вам пора полить кактус!");
                } else {
                    System.out.println("Текущая дата : " + today + ", осень. Дата последнего полива : " +
                            dateOfLastWatering + ", прошло меньше недели. Полейте кактус " +
                            dateOfLastWatering.plusWeeks(1) + "!");
                }
            }
            case 6, 7, 8 ->{
                diffDay = ChronoUnit.DAYS.between(dateOfLastWatering, today);
                if (diffDay >= 2) {
                    System.out.println("Текущая дата : " + today + ", лето. Дата последнего полива : " +
                            dateOfLastWatering + ", прошло " + diffDay + " дней. Вам пора полить кактус!");
                } else {
                    HumiditySensor humiditySensor = new HumiditySensor();
                    humidity = humiditySensor.getHumidity();
                    if (humidity >= 30) {
                        System.out.println("Текущая дата : " + today + ", лето. Дата последнего полива : " +
                                dateOfLastWatering + ", прошло меньше 2-х дней и влажность = " +
                                String.format("%.2f",humidity) + ", это больше 30%. Полейте кактус " +
                                dateOfLastWatering.plusDays(2) + "!");
                    } else {
                        System.out.println("Текущая дата : " + today + ", лето. Дата последнего полива : " +
                                dateOfLastWatering + ", прошло меньше 2-х дней, но влажность = " +
                                String.format("%.2f",humidity) + ", это меньше 30%. Полейте кактус!");

                    }
                }
            }
        }

    }
}
