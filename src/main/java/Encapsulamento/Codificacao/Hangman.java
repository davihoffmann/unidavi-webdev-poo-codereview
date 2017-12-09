package Encapsulamento.Codificacao;

public class Hangman {

    private String pass;

    private char[] placeholder;

    private boolean canPlay;

    private int wrongs;

    private int limit;

    private boolean gotcha;

    public Hangman(String pass) {
        this.pass = pass;
        this.placeholder = new char[pass.length()];
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public char[] getPlaceholder() {
        return placeholder;
    }

    private Hangman placeholder(char[] placeholder) {
        for (int i = 0; i < pass.length(); i++) {
            this.placeholder[i] = '*';
        }
        return this;
    }

    public boolean isCanPlay() {
        return canPlay;
    }

    public boolean canPlay() {
        return wrongs < limit && !gotcha;
    }

    public int getWrongs() {
        return wrongs;
    }

    public void setWrongs(int wrongs) {
        this.wrongs = wrongs;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public boolean isGotcha() {
        return gotcha;
    }

    public void setGotcha(boolean gotcha) {
        this.gotcha = gotcha;
    }

    public String play(String attempt) {
        System.out.printf("Your attempt: %d/%d", wrongs, limit);

        boolean hit = false;
        this.gotcha = true;
        String placeholderAsString = "";

        for (int i = 0; i < this.pass.length(); i++) {
            hit = verificaAcerto(attempt);
            this.gotcha = this.gotcha & (this.pass.charAt(i) == this.placeholder[i]);
            placeholderAsString += this.placeholder[i];
        }
        if (!hit) {
            this.wrongs++;
        }

        System.out.println(placeholderAsString);
        return placeholderAsString;
    }

    private boolean verificaAcerto(String attempt) {
        for (int i = 0; i < this.pass.length(); i++) {
            if (this.pass.charAt(i) == attempt.charAt(0)) {
                this.placeholder[i] = attempt.charAt(0);
                return true;
            }
        }
        return false;
    }

}