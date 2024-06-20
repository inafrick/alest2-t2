import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Reader {

    public List<Box> readBoxes(String filename) {
        List<Box> boxes = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int dim1 = Integer.parseInt(parts[0]);
                int dim2 = Integer.parseInt(parts[1]);
                int dim3 = Integer.parseInt(parts[2]);
                boxes.add(new Box(dim1, dim2, dim3));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return boxes;
    }
}