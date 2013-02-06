import java.util.Arrays;

public class ArrayValue extends Value {
    int[] arr;

    public ArrayValue(int size) {
        arr = new int[size];
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ArrayValue) {
            ArrayValue other = (ArrayValue) o;
            return Arrays.equals(this.arr, other.arr);
        }
        return false;
    }

    @Override
    public boolean isFalse(){
        // TODO(spradeep): Raise incompatible types exception. Array
        // cannot be used as a boolean.

        // Not doing any error-handling now.
        return false;
    }
}
