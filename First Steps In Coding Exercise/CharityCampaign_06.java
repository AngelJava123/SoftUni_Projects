package com.company;

import java.util.Scanner;

public class CharityCampaign_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Торта - 45 лв.
        // Гофрета - 5.80 лв.
        // Палачинка - 3.20 лв

        int days = Integer.parseInt(scanner.nextLine());
        int chefs = Integer.parseInt(scanner.nextLine());
        int cakes = Integer.parseInt(scanner.nextLine());
        int waffles = Integer.parseInt(scanner.nextLine());
        int pancakes = Integer.parseInt(scanner.nextLine());

        //Изчисляваме сумата, която се изкарва на ден за всеки един от продуктите, направени от 1 сладкар:

        int cakesNum = cakes * 45;

        double wafflesNum = waffles * 5.80;

        double pancakesNum = pancakes * 3.20;

        //Обща сума за един ден от всички сладкари

        double AllSum = (cakesNum + wafflesNum + pancakesNum) * chefs;

        //Сума събрана от цялата кампания

        double CampaignSum = AllSum * days;

        //Сума след покриване на разходите

        double sumAfter = CampaignSum - CampaignSum/8;

        System.out.printf("%.2f",sumAfter);


    }
}
