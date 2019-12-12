package Coding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShanonCode {
    // Массив вероятностей, упорядоченный по убыванию
    private int[] P;
    private int[] Q;
    private double[] L;
    private List<Crypto> C;

    public ShanonCode() {

    }

    public List<Crypto> fillAlphabet(List<Crypto> cryptos, String text) throws IOException {

        boolean isHas = false;
        int countChar = 0;

        int textSize = text.length();

        for (int i = 0; i < textSize; i++) {
            isHas = false;

            for (int j = 0; j < cryptos.size(); j++) {
                if (cryptos.get(j).getCharacter() == text.charAt(i)) {
                    isHas = true;
                    break;
                }
            }

            if (isHas == false) {
                for (int k = i; k < textSize; k++) {
                    if (text.charAt(k) == text.charAt(i))
                        countChar++;
                }

                double p = (double) countChar / (double) textSize;
                cryptos.add(new Crypto(text.charAt(i), p));
                countChar = 0;
            }
        }
        return cryptos;
    }

    public List<Crypto> shennon(List<Crypto> cryptos) {

        cryptos.add(0, null);

        int[][] C = new int[cryptos.size()][cryptos.size()];

        double[] L = new double[cryptos.size()];
        double[] Q = new double[cryptos.size()];

//        cryptos.set(0, new Crypto(0));
//        cryptos.get(0).setP(0);
        Q[0] = 0;

        for (int i = 1; i < cryptos.size(); i++) {
            Q[i] = Q[i - 1] + cryptos.get(i).getP();
            L[i] =  Math.ceil(Math.abs(Math.log(cryptos.get(i).getP()) / Math.log(2.0)));
        }

        for (int i = 1; i < cryptos.size(); i++) {
            for (int j = 0; j < L[i]; j++) {
                Q[i - 1] = Q[i - 1] * 2.0;
                C[i][j] = (int) Q[i - 1];
                if (Q[i - 1] > 1)
                    Q[i - 1] = Q[i - 1] - 1;
            }
        }

        for (int i = 1; i < cryptos.size(); i++) {
            for (int j = 0; j < L[i]; j++) {
                cryptos.get(i).setCodeCharacter("" + C[i][j]);
            }
        }

        double entrophy = 0;
        double sumlength = 0;

        for (int i = 1; i < cryptos.size(); i++) {
            double result = Math.abs(Math.log(cryptos.get(i).getP()) / Math.log(2.0)) * cryptos.get(i).getP();
            entrophy += result;
            sumlength += (L[i] * cryptos.get(i).getP());
        }

        System.out.println("H = " + entrophy + " L = " + sumlength);

        return cryptos;
    }

    public List<Crypto> SelectSort(List<Crypto> cryptos) {
        List<Crypto> t = new ArrayList<>(1);

        for (int i = 0; i < cryptos.size() - 1; i++) {
            int min_i = i;

            for (int j = i + 1; j < cryptos.size(); j++) {
                if (cryptos.get(j).getP() > cryptos.get(i).getP()) {
                    min_i = j;
                }
            }

            t.add(0, cryptos.get(i));
            cryptos.set(i, cryptos.get(min_i));
            cryptos.set(min_i, t.get(0));

        }


        return cryptos;
    }

    public static int log2(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        return 31 - Integer.numberOfLeadingZeros(n);
    }

    public static void main(String[] args) {

    }
}
