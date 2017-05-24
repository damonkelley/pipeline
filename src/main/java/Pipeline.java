import java.util.function.Function;

public class Pipeline<T> {
    private T value;

    public Pipeline(T value) {
        this.value = value;
    }

    public static <T> Pipeline<T> with(T i) {
        return new Pipeline<T>(i);
    }

    public <U> Pipeline<U> into(Function<T, U> mapper) {
        return new Pipeline<U>(mapper.apply(value));
    }

    public T get() {
        return value;
    }
}
