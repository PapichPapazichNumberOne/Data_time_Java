package org.example;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BankTransaction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Получить регион от пользователя
        System.out.print("Enter your region (UTC, EST, CST, MST, PST, GMT, CET, IST, JST, AEDT): ");
        String region = scanner.nextLine();

        // Имяо пользователя
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        //Сумма перевода
        System.out.print("Enter the transfer amount: ");
        double amount = scanner.nextDouble();

        // Текущее время в выбранном регионе
        LocalDateTime now;
        switch (region.toUpperCase()) {
            case "UTC":
                now = LocalDateTime.now(ZoneId.of("UTC"));
                break;
            case "EST":
                now = LocalDateTime.now(ZoneId.of("America/New_York"));
                break;
            case "CST":
                now = LocalDateTime.now(ZoneId.of("America/Chicago"));
                break;
            case "MST":
                now = LocalDateTime.now(ZoneId.of("America/Denver"));
                break;
            case "PST":
                now = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
                break;
            case "GMT":
                now = LocalDateTime.now(ZoneId.of("GMT"));
                break;
            case "CET":
                now = LocalDateTime.now(ZoneId.of("Europe/Paris"));
                break;
            case "IST":
                now = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
                break;
            case "JST":
                now = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
                break;
            case "AEDT":
                now = LocalDateTime.now(ZoneId.of("Australia/Sydney"));
                break;
            default:
                System.out.println("Invalid region selected.");
                return;
        }

        // Создает строку квитанции
        String initials = firstName.charAt(0) + "." + lastName.charAt(0) + ".";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String receipt = String.format("Transaction time: %s%nAmount: $%.2f%nSender: %s",
                now.format(formatter), amount, initials);

        // Выводит квитанцию в консоль
        System.out.println(receipt);
    }

}
