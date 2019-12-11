package KursWork;

public class People {
    private String fioVklad;
    private int sum;
    private String date;
    private String fioAdv;

    public void setFIO_vklad(String FIO_vklad) {
        this.fioVklad = FIO_vklad;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setFioAdv(String fioAdv) {
        this.fioAdv = fioAdv;
    }

    public String getFioVklad() {
        return fioVklad;
    }

    public int getSum() {
        return sum;
    }

    public String getDate() {
        return date;
    }

    public String getFioAdv() {
        return fioAdv;
    }
}
