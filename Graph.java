import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private List<Box> vertices;
    private Map<Box, List<Box>> adjacentes;

    public Graph(List<Box> caixas) {
        vertices = new ArrayList<>(caixas);
        adjacentes = new HashMap<>();
        for (Box caixa : caixas) {
            adjacentes.put(caixa, new ArrayList<>());
        }
        construirGrafo();
    }

    private void construirGrafo() {
        Collections.sort(vertices);
        for (int i = 0; i < vertices.size(); i++) {
            Box caixaAtual = vertices.get(i);
            for (int j = i + 1; j < vertices.size(); j++) {
                Box proximaCaixa = vertices.get(j);
                if (caixaAtual.podeAninhar(proximaCaixa)) {
                    adjacentes.get(caixaAtual).add(proximaCaixa);
                }
            }
        }
    }

    public List<Box> encontrarCaminhoMaisLongo() {
        Map<Box, List<Box>> mapa = new HashMap<>();
        List<Box> maiorCaminho = new ArrayList<>();

        for (Box caixa : vertices) {
            List<Box> caminhoAtual = encontrarCaminhoMaisLongoDaCaixa(caixa, mapa);
            if (caminhoAtual.size() > maiorCaminho.size()) {
                maiorCaminho = caminhoAtual;
            }
        }
        return maiorCaminho;
    }

    private List<Box> encontrarCaminhoMaisLongoDaCaixa(Box caixa, Map<Box, List<Box>> mapa) {
        if (mapa.containsKey(caixa)) {
            return mapa.get(caixa);
        }

        List<Box> maiorCaminho = new ArrayList<>();
        for (Box vizinho : adjacentes.get(caixa)) {
            List<Box> caminhoAtual = encontrarCaminhoMaisLongoDaCaixa(vizinho, mapa);
            if (caminhoAtual.size() > maiorCaminho.size()) {
                maiorCaminho = caminhoAtual;
            }
        }

        List<Box> resultado = new ArrayList<>();
        resultado.add(caixa);
        resultado.addAll(maiorCaminho);
        mapa.put(caixa, resultado);

        return resultado;
    }
}