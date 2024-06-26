import java.util.Arrays;

public class Box implements Comparable<Box> {
    int[] dimensoes;

    public Box(int dim1, int dim2, int dim3) {
        dimensoes = new int[] { dim1, dim2, dim3 };
        Arrays.sort(dimensoes);
    }

    public boolean podeAninhar(Box outraCaixa) {
        return this.dimensoes[0] < outraCaixa.dimensoes[0] &&
                this.dimensoes[1] < outraCaixa.dimensoes[1] &&
                this.dimensoes[2] < outraCaixa.dimensoes[2];
    }

    @Override
    public int compareTo(Box outraCaixa) {
        for (int i = 0; i < 3; i++) {
            if (this.dimensoes[i] != outraCaixa.dimensoes[i]) {
                return this.dimensoes[i] - outraCaixa.dimensoes[i];
            }
        }
        return 0;
    }

    public String toString() {
        return dimensoes[0] + " " + dimensoes[1] + " " + dimensoes[2];
    }
}