package packZad8;

import java.util.Scanner;

public class ScannerWork {
    Scanner scanner = new Scanner(System.in);

    public char getChar(){
        boolean flag = false;
        char znak = 'a';
        do {
            System.out.println();
            System.out.println("Wybierz: a/b/w ?");
            znak = scanner.next().charAt(0);
            if (znak == 'a' || znak == 'b' || znak == 'w') {
                flag = true;
            }
        } while (!flag);
        return znak;
    }

    public int getInt(int min, int max) {
        System.out.println();
        System.out.println("Podaj userId (zakres od 1 do 100):");
        boolean flag = false;
        int number = 0;
        do {
            System.out.println();
            System.out.println("Podaj liczbę (1 - 100):");
            String numberString = scanner.next();
            try {
                number = Integer.valueOf(numberString);
            } catch (NumberFormatException e) {
                System.err.println("Podaj liczbę!");
            }
            if (number >= 1 && number <= 100) {
                flag = true;
            }
        } while (!flag);
        return number;
    }
}
