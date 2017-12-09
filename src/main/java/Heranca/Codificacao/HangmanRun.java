package Heranca.Codificacao;

import java.util.Scanner;

public class HangmanRun {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hangman hangman = new Hangman("Teste");
        String attempt = scanner.nextLine();
        do {
            hangman.play(attempt);
        } while (hangman.canPlay());
        scanner.close();
        System.out.println("You ".concat(hangman.isGotcha() ? " win" : " lose"));
    }

}