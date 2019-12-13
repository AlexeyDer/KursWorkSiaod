package Coding;

public class Coder {
    char character;
    double p;
    String codeChar;

    public Coder(char ch, double p, String codeCharacter) {
        this.character = ch;
        this.p = p;
        this.codeChar = codeCharacter;
    }

    public Coder(char ch, double p) {
        this.character = ch;
        this.p = p;
    }

    public Coder(double p) {
        this.p = p;
    }

    public char getCharacter() {
        return character;
    }

    public double getP() {
        return p;
    }

    public String getCodeChar() {
        return codeChar;
    }


    public void setCharacter(char character) {
        this.character = character;
    }

    public void setP(double p) {
        this.p = p;
    }

    public void setCodeChar(String codeChar) {
        this.codeChar = codeChar;
    }
}
