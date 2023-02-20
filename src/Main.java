import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //task 1
        Stream<Integer> integerStream = Stream.of(12, 36, 8900, -20);
        Comparator<Integer> integerComparator = Comparator.comparing(Integer::intValue);
        BiConsumer<Integer, Integer> biConsumer = (min, max) -> System.out.println("Min " + min + " Max " + max);

        findMinMax(integerStream, integerComparator, biConsumer);

        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        findEvenNumbers(integerList);
    }

    public static <T> void findMinMax(
           Stream<? extends T> stream,
           Comparator<? super T> order,
           BiConsumer<? super T, ? super T> сonsumer) {
        List<T> list = stream.sorted(order).collect(Collectors.toList());
        сonsumer.accept(list.size() == 0 ? null : list.get(0), list.size() == 0 ? null : list.get(list.size() - 1));
    }
    //task 2
    public static void findEvenNumbers(List<Integer> list) {
        long count = list.stream().filter(val -> val % 2 == 0).count();
        System.out.println("Amount of even numbers " + count);
}
}