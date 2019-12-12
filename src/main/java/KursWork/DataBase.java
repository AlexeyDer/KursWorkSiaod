package KursWork;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.*;

public class DataBase {
    private List<People> peoples;

    public DataBase() {
        peoples = new ArrayList<>();
    }

    public List<People> getPeoples() {
        return peoples;
    }

    public void read(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        while (fis.available() > 0) {
            byte[] b = fis.readNBytes(64);
            People people = new People();

            people.setFIO_vklad(new String(Arrays.copyOfRange(b, 0, 29), "CP866").trim());
            people.setDate(new String(Arrays.copyOfRange(b, 32, 41), "CP866").trim());
            people.setFioAdv(new String(Arrays.copyOfRange(b, 42, 63), "CP866").trim());

            ByteBuffer byteBuffer = ByteBuffer.allocate(2);
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.put(b[30]);
            byteBuffer.put(b[31]);
            people.setSum(byteBuffer.getShort(0) & 0xffff);

            peoples.add(people);
        }
    }

    public void printOneElement(Vertex p) {
        System.out.println("\nФИО Вкладчика: " + p.getPeople().getFioVklad());
        System.out.println("Сумма вклада: " + p.getPeople().getSum());
        System.out.println("Дата вкалада: " + p.getPeople().getDate());
        System.out.println("ФИО Адвоката: " + p.getPeople().getFioAdv());
        System.out.println("---------------------------------");

        if (p.getAgain() != null) {
            System.out.println("\nФИО Вкладчика: " + p.getAgain().getPeople().getFioVklad());
            System.out.println("Сумма вклада: " + p.getAgain().getPeople().getSum());
            System.out.println("Дата вкалада: " + p.getAgain().getPeople().getDate());
            System.out.println("ФИО Адвоката: " + p.getAgain().getPeople().getFioAdv());
            System.out.println("---------------------------------");
        }
    }

    public void printOneElement(People p) {
        System.out.println("\nФИО Вкладчика: " + p.getFioVklad());
        System.out.println("Сумма вклада: " + p.getSum());
        System.out.println("Дата вкалада: " + p.getDate());
        System.out.println("ФИО Адвоката: " + p.getFioAdv());
        System.out.println("---------------------------------");
    }

    public void printOneElement(List<People> list, int i) {
        System.out.println("\nИндекс записи: " + i + "\nФИО Вкладчика: " + list.get(i).getFioVklad());
        System.out.println("Сумма вклада: " + list.get(i).getSum());
        System.out.println("Дата вкалада: " + list.get(i).getDate());
        System.out.println("ФИО Адвоката: " + list.get(i).getFioAdv());
        System.out.println("---------------------------------");
    }

    public void print(List<People> list) throws IOException {
        int j = 1;
        boolean b = true;

        for (People i : list) {
            System.out.print(j + " ФИО Вкладчика: " + i.getFioVklad());
            System.out.print(" Сумма вклада: " + i.getSum());
            System.out.print(" Дата вкалада: " + i.getDate());
            System.out.println(" ФИО Адвоката: " + i.getFioAdv());

            Scanner sc = new Scanner(System.in);

            if (b == true && j % 20 == 0) {
                String ch = sc.next();

                if (ch == "q")
                    break;
                if (ch.equals("a"))
                    b = false;
            }
            j++;
        }
    }

    public List<People> binSearch(List<People> list, int key) {
        int l = 0;
        int r = list.size() - 1;

        List<People> result = new LinkedList<>();

        while (l <= r) {
            int mid = (l + r) / 2;
            if (list.get(mid).getSum() < key)
                l = mid + 1;
            else if (list.get(mid).getSum() > key)
                r = mid - 1;
            else {

                while (mid < list.size() - 1 && list.get(mid).getSum() == key) {
                    result.add(list.get(mid));
                    ++mid;
                }

                while (list.get(mid).getSum() == key && list.get(mid - 1).getSum() == key && mid != 0) {
                    --mid;
                }

                return result;
            }
        }

        return null;
    }


}
