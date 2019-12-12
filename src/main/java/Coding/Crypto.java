package Coding;

public class Crypto {
    char character;
    double p;
    String codeCharacter;

    public Crypto(char ch, double p, String codeCharacter) {
        this.character = ch;
        this.p = p;
        this.codeCharacter = codeCharacter;
    }

    public Crypto(char ch, double p) {
        this.character = ch;
        this.p = p;
    }

    public Crypto(double p) {
        this.p = p;
    }

    public char getCharacter() {
        return character;
    }

    public double getP() {
        return p;
    }

    public String getCodeCharacter() {
        return codeCharacter;
    }


    public void setCharacter(char character) {
        this.character = character;
    }

    public void setP(double p) {
        this.p = p;
    }

    public void setCodeCharacter(String codeCharacter) {
        this.codeCharacter = codeCharacter;
    }
}
