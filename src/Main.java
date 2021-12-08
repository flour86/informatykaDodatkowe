import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean loop1 = true;

        while (loop1) {
            System.out.println("---------Gry oparte na RNG---------");
            System.out.println();
            System.out.println("Co chcesz zrobić?");
            System.out.println("1 aby zagrac w  papier, kamien i nozyce");
            System.out.println("2 aby zagrac w kosci");
            System.out.println("3 aby uzyc randomizera okreslonych rzeczy");
            System.out.println();

            Scanner scan1 = new Scanner(System.in);
            int scan1Int = scan1.nextInt();

            switch (scan1Int) {
                case 1:
                    PapierKamienNozyce();
            }
        }
    }

    public static void PapierKamienNozyce() {
        Random rand1 = new Random();
        int playerScore = 0;
        int enemyScore = 0;
        boolean loop2 = true;

        while (loop2 ) {
            System.out.println("Witaj w grze papier, kamien nozyce!");
            System.out.println();
            System.out.println("Wynik: grasz - " + playerScore + "; a CPU - " + enemyScore);
            System.out.println("Czym chcesz zagrac?");
            System.out.println("1 - Papier");
            System.out.println("2 - Kamien");
            System.out.println("3 - Nozyce");
            System.out.println();

            Scanner scan = new Scanner(System.in);
            int scanInt = scan.nextInt();
            int enemyPick = rand1.nextInt(2);

            switch (scanInt) {
                case 1:
                    if (enemyPick == 1) {
                        System.out.println("Remis");
                    } else if (enemyPick == 2) {
                        System.out.println("Wygrywasz!");
                        playerScore += 1;
                    } else {
                        System.out.println("Przegrywasz...");
                        enemyScore += 1;
                    }
                    break;

                case 2:
                    if (enemyPick == 1) {
                        System.out.println("Przegrywasz...");
                        enemyScore += 1;
                    } else if (enemyPick == 2) {
                        System.out.println("Remis");
                    } else {
                        System.out.println("Wygrywasz!");
                        playerScore += 1;
                    }
                    break;

                case 3:
                    if (enemyPick == 1) {
                        System.out.println("Wygrywasz!");
                        playerScore += 1;
                    } else if (enemyPick == 2) {
                        System.out.println("Przegrywasz...");
                        enemyScore += 1;
                    } else {
                        System.out.println("Remis");
                    }
                    break;

                default:
                    break;
            }
            System.out.println("Czy chcesz powtorzyc gre w papier kamien i nozyce? Y/N");
            Scanner scan2 = new Scanner(System.in);
            String scan2String = scan.next();
            if ( scan2String == "Y" || scan2String == "y" ) {
                loop2 = true;
            }
            else {
                loop2 = false;
            }
        }
    }
}
