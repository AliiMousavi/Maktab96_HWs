package main.java.q1;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;
import java.util.function.*;

public class LambdaUtil {
    public static Supplier<String> helloSupplier() {
        return () -> "Hello";
    }

    public static Predicate<String> isEmptyPredicate() {
        return String::isEmpty;
    }

    public static BiFunction<String, Integer, String> stringMultiplier() {
        return String::repeat;
    }

    public static Function<BigDecimal, String> toDollarStringFunction() {
        return BigDecimal -> "$" + BigDecimal.toString();
    }

    public static Predicate<String> lengthInRangePredicate(int min, int max) {
        return string -> string.length() >= min && string.length() <= max;
    }

    public static IntSupplier randomIntSupplier() {
        return () -> new Random().nextInt();
    }

    public static IntUnaryOperator boundedRandomIntSupplier() {
        return bound -> new Random().nextInt(bound);
    }

    public static IntUnaryOperator intSquareOperation() {
        return x -> x * x;
    }

    public static LongBinaryOperator longSumOperation() {
        return Long::sum;
    }
    public static ToIntFunction<String> stringToIntConverter() {
        return Integer::parseInt;
    }
    public static Supplier<IntUnaryOperator> nMultiplyFunctionSupplier(int n) {
        return () -> x -> n * x;
    }
    public static Supplier<Supplier<Supplier<String>>> trickyWellDoneSupplier() {
        return () -> () -> () -> "WELL DONE";
    }
    public static UnaryOperator<Function<String, String>> composeWithTrimFunction() {
        return f -> f.compose(String::trim);
    }

    /**
     * Returns a {@link BiFunction} that has two parameters. First is {@link IntUnaryOperator} which is some integer function.
     * Second is {@link IntPredicate} which is some integer condition. And the third is {@link IntUnaryOperator} which is
     * a new composed function that uses provided predicate (second parameter of binary function) to verify its input
     * parameter. If predicate returns {@code true} it applies a provided integer function
     * (first parameter of binary function) and returns a result value, otherwise it returns an element itself.
     *
     * @return a binary function that receiver predicate and function and compose them to create a new function
     */
    public static BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator> functionToConditionalFunction() {
        //todo :: extra points
        return null;
    }

    /**
     * Returns a {@link BiFunction} which first parameter is a {@link Map} where key is a function name, and value is some
     * {@link IntUnaryOperator}, and second parameter is a {@link String} which is a function name. If the map contains a
     * function by a given name then it is returned by high order function otherwise an identity() is returned.
     *
     * @return a high-order function that fetches a function from a function map by a given name or returns identity()
     */
    public static BiFunction<Map<String, IntUnaryOperator>, String, IntUnaryOperator> functionLoader() {
        //todo :: extra points
        return null;
    }
}
