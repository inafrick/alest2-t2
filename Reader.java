import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Reader {

    public List<Box> lerCaixas(String nomeArquivo) {
        List<Box> caixas = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(" ");
                int dim1 = Integer.parseInt(partes[0]);
                int dim2 = Integer.parseInt(partes[1]);
                int dim3 = Integer.parseInt(partes[2]);
                caixas.add(new Box(dim1, dim2, dim3));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return caixas;
    }
}