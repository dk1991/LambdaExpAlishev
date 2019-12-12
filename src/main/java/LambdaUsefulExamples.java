import java.util.*;
import java.util.stream.Collectors;

public class LambdaUsefulExamples {
    public static void main(String[] args) {
        int[] array1 = new int[10];
        List<Integer> list1 = new ArrayList<>();
        
        fillArr(array1);
        fillList(list1);

        // map method
        // map(): берет набор элементов и итерируется по нему, a - элемент набора.
        // a -> a * 2 значит, что берем элемент набора и умножаем его на 2: [1,2,3] -> [2,2,3] -> [2,4,3] -> [2,4,6]
        array1 = Arrays.stream(array1).map(a -> a * 2).toArray(); // .toArray() преобразовать поток в массив
        list1 = list1.stream().map(a -> a * 2).collect(Collectors.toList()); // .collect(Collectors.toList()) преобразовать поток в лист

        array1 = Arrays.stream(array1).map((a -> 3)).toArray();
        array1 = Arrays.stream(array1).map((a -> a + 1)).toArray();

        System.out.println(list1);
        System.out.println(Arrays.toString(array1));

        // filter method. фильтруем массив по определенному правилу. Получаем подмножество элементов
        int[] array2 = new int[10];
        List<Integer> list2 = new ArrayList<>();

        fillArr(array2);
        fillList(list2);

        array2 = Arrays.stream(array2).filter(a -> a % 2 == 0).toArray();
        list2 = list2.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());

        System.out.println(list2);
        System.out.println(Arrays.toString(array2));

        // forEach method - пройти по элементам массива и листа
        Arrays.stream(array2).forEach(System.out::println);
        list2.stream().forEach(System.out::println);

        // reduce method (уменьшение набора данных, например до 1 элемента)
        int[] array3 = new int[10];
        List<Integer> list3 = new ArrayList<>();

        fillArr(array3);
        fillList(list3);

        // значение аккумулятора по умолчанию равно первому элементу
        // [1,2,3]: на первой итерации аккумулятор равен 1 и начинаем итеацию со ВТОРОГО элемента,
        // мы к значению аккумулятора приравниваем сумму аккумулятора и второго элемента
        // на второй итерации аккумулятор равен 3, третий элемент равен 3, новое значение аккумулятора равно текущее значение + третий элемент
        int sum = Arrays.stream(array3).reduce((acc, currentElement) -> acc + currentElement)/*.ifPresent()*/.getAsInt();
        int composition = list3.stream().reduce((acc, currentElement) -> acc * currentElement).get();

        // значение аккумулятора по умолчанию равно 0, итерация начинается с ПЕРВОГО элемента
        int sum2 = Arrays.stream(array3).reduce(0, (acc, currentElement) -> acc + currentElement);

        System.out.println(sum);
        System.out.println(sum2);
        System.out.println(composition);

        int[] array4 = new int[10];

        fillArr(array4);

        // последовательность вызова методов для stream
        array4 = Arrays.stream(array4).filter(a -> a % 2 != 0).map(a -> a * 3).toArray();

        System.out.println(Arrays.toString(array4));

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(7);
        set = set.stream().map(a -> a * 5).collect(Collectors.toSet());
        System.out.println(sum);
    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
    }

    private static void fillArr(int[] arr) {
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }
    }
}
