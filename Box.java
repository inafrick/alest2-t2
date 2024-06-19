import java.util.Arrays;

public class Box {
    int[] dimensions;

    public Box(int dim1, int dim2, int dim3) {
        dimensions = new int[] { dim1, dim2, dim3 };
        Arrays.sort(dimensions);
    }

    public boolean canNest(Box other) {
        return this.dimensions[0] < other.dimensions[0] &&
                this.dimensions[1] < other.dimensions[1] &&
                this.dimensions[2] < other.dimensions[2];
    }
}
