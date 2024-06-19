import java.util.List;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        List<Box> list = reader.readBoxes("casosT30/caso00020.txt");
        for (Box b : list) {
            System.out.println(b);
        }
    }
}
