import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

            people.setFIO_vklad(new String (Arrays.copyOfRange(b, 0, 29), "CP866" ));
            people.setDate(new String (Arrays.copyOfRange(b, 32, 41), "CP866"));
            people.setFioAdv(new String(Arrays.copyOfRange(b, 42, 63), "CP866"));

            ByteBuffer byteBuffer = ByteBuffer.allocate(2);
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.put(b[30]);
            byteBuffer.put(b[31]);
            people.setSum(byteBuffer.getShort(0) & 0xffff);

            peoples.add(people);
        }
    }

    public void print(List<People> list) throws IOException {
         int j = 1;
         boolean b = true;

        for(People i : list) {
            System.out.println(j + "\n" + i.getFioVklad());
            System.out.println(i.getSum());
            System.out.println(i.getDate());
            System.out.println(i.getFioAdv());
            System.out.println("---------------------------------");

            if (b == true && j % 20 == 0) {
                char ch = (char)  System.in.read();

                if (ch == 'q')
                    break;
                if (ch == 'a');
                    b = false;
            }
            j++;
        }
    }




}
