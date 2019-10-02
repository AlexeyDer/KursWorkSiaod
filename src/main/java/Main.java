import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        DataBase db = new DataBase();
        db.read("testBase3.dat");
        db.print();
    }
}
