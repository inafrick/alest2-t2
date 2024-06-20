import java.util.Arrays;

public class Box implements Comparable<Box> {
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

    @Override
    public int compareTo(Box other) {
        for (int i = 0; i < 3; i++) {
            if (this.dimensions[i] != other.dimensions[i]) {
                return this.dimensions[i] - other.dimensions[i];
            }
        }
        return 0;
    }

    public String toString() {
        return dimensions[0] + " " + dimensions[1] + " " + dimensions[2];
    }
}