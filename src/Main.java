import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean loop = true;

        while (loop) {
            System.out.println("---------Gry oparte na RNG---------");
            System.out.println();
            System.out.println("Co chcesz zrobić?");
            System.out.println("1 aby zagrac w  papier, kamien i nozyce");
            System.out.println("2 aby zagrac w kosci");
            System.out.println("3 aby zagrac w gre z kulkami ze \"Squid Game\"");
            System.out.println();
            System.out.println("0 aby wyjsc");

            Scanner scan1 = new Scanner(System.in);
            int scan1Int = scan1.nextInt();

            if (scan1Int == 0) {
                loop = false;
            }

            switch (scan1Int) {
                case 1 -> PapierKamienNozyce();
                case 2 -> Kosci();
                case 3 -> squidGameKulki();
                case 0 -> loop = false;
            }
        }
    }

    public static void PapierKamienNozyce() {
        Random rand = new Random();
        int playerScore = 0;
        int enemyScore = 0;
        boolean loop = true;

        while (loop) {
            System.out.println();
            System.out.println("Witaj w grze papier, kamien nozyce!");
            System.out.println();
            System.out.println("Wynik: gracz - " + playerScore + "; a CPU - " + enemyScore);
            System.out.println("Czym chcesz zagrac?");
            System.out.println("1 - Papier");
            System.out.println("2 - Kamien");
            System.out.println("3 - Nozyce");
            System.out.println();
            System.out.println("0 - Wyjscie");

            Scanner scan = new Scanner(System.in);
            int scanInt = scan.nextInt();
            int enemyPick = rand.nextInt(3);

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

                case 0:
                    loop = false;
                    break;
            }
        }
    }

    public static void Kosci() {
        Random rand = new Random();
        int playerScore = 0;
        int enemyScore = 0;
        boolean loop = true;

        while (loop) {
            System.out.println();
            System.out.println("Witaj w grze w Kosci!");
            System.out.println();
            System.out.println("Wynik: gracz - " + playerScore + "; a CPU - " + enemyScore);
            System.out.println("Na ile kostek chcesz grac? (mozna podac duza liczbe, ale tego nie radze)");
            System.out.println();
            System.out.println("0 - wyjscie");

            Scanner scan = new Scanner(System.in);
            int scanInt = scan.nextInt();
            int diceNum = scanInt;

            if(scanInt != 0) {
                int dicePossibleOutcome = 6 * diceNum;

                int playerDice = rand.nextInt(dicePossibleOutcome);
                int enemyDice = rand.nextInt(dicePossibleOutcome);

                System.out.println("Kosci gracza: " + playerDice);
                System.out.println("Kosci CPU: " + enemyDice);

                if (playerDice > enemyDice) {
                    System.out.println("Wygrywasz!");
                    playerScore++;
                } else if (enemyDice > playerDice) {
                    System.out.println("Przegrywasz...");
                    enemyScore++;
                } else {
                    System.out.println("Remis");
                }
            }
            else {
                loop = false;
            }
        }
    }

    public static void squidGameKulki() {
        Random rand = new Random();
        int playerScore = 0;
        int enemyScore = 0;
        boolean loop = true;
        int playerMarbles;
        int enemyMarbles;

        while (loop) {
            System.out.println();
            System.out.println("Witaj w slabej wersji gry z kulkami ze \"Squid Game\"");
            System.out.println();
            System.out.println("Jaki budzet kulek chcesz miec?");
            System.out.println();
            System.out.println("0 - wyjscie");

            Scanner scan = new Scanner(System.in);
            int marbleBudget = scan.nextInt();
            playerMarbles = marbleBudget;
            enemyMarbles = marbleBudget;

            if (marbleBudget != 0) {
                while ((playerMarbles < marbleBudget * 2) && (enemyMarbles < marbleBudget * 2)) {
                    System.out.println("Masz " + playerMarbles + " kulek");
                    System.out.println("Ile kulek obstawiasz?");
                    Scanner bid = new Scanner(System.in);
                    int playerBid = bid.nextInt();
                    int enemyBid;
                    if (enemyMarbles > 1) {
                        enemyBid = ThreadLocalRandom.current().nextInt(1, enemyMarbles);
                    } else {
                        enemyBid = 1;
                    }

                    int enemyBidEven;
                    if (enemyBid % 2 == 1) {
                        enemyBidEven = 0;
                    } else {
                        enemyBidEven = 1;
                    }

                    System.out.println("Obstawiasz parzystste (1), czy nieparzyste (0)?");
                    Scanner guess = new Scanner(System.in);
                    int playerGuess = guess.nextInt(); //chcialem to zrobic na booleanach, ale wtedy nie wiem czemu nie dzialalo, mimo, ze zmienilem wejscie i sprawdzenie na boolean

                    if (playerBid > playerMarbles || playerBid < 1) {
                        System.out.println("ERROR");
                    } else {
                        if (playerGuess == enemyBidEven) {
                            playerMarbles = playerMarbles + enemyBid;
                            enemyMarbles = enemyMarbles - enemyBid;
                            System.out.println("Trafiles - zyskujesz kulki przeciwnika");
                        } else {
                            enemyMarbles = enemyMarbles + playerBid;
                            playerMarbles = playerMarbles - playerBid;
                            System.out.println("Przegrywasz - tracisz obstawione kulki...");
                        }
                    }
                }
            } else {
                loop = false;
            }
        }
    }
}