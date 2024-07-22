package ru.lisenkova.main;

import ru.lisenkova.tools.Work;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args)
    {
        int[] arr1 = new int[]{5,3,1};
        int[] arr2 = new int[]{1,2,3,4};
        int[] arr3 = new int[]{1,1,1,1};
        int[] arr4 = new int[]{-1,-11};
        int[] arr5 = new int[]{-13,-1,-1};

        List<Integer> list0 = Work.map(List.of("qwerty","asdfg","zx"), s -> s.length()); //5.3.1
        List<Integer> list01 = Work.map(List.of(1,-3,7), i -> Math.abs(i));
        Operation<int[],Integer> op = list -> {
            int res=list[0];
            for (Integer integer: list)
            {
                if (res<integer) res=integer;
            }
            return res;
        };
        List<Integer> list02 = Work.map(List.of(arr1,arr2,arr3,arr4,arr5), op);
        out.println(list0);
        out.println(list01);
        out.println(list02);

        List<String> list03 = Work.filter(List.of("qwerty","asdfg","zx"), s -> s.length()<3);//5.3.2
        List<Integer> list04 = Work.filter(List.of(1,-3,7), i -> i > 0 );
        Filter<int[]> filter = list -> {
            for (Integer integer : list) {
                if (integer > 0) return false;
            }
            return true;
        };
        List<int[]> list05 = Work.filter(List.of(arr1, arr4, arr5), filter);
        out.println(list03);
        out.println(list04);
        list05.forEach(array->out.print(Arrays.toString(array)));
        out.println();

        String list06 = Work.reduction(List.of("qwerty", "asdfg", "zx"), (x, y) -> (x + y).toString()).get(""); //5.3.3
        Integer list07 = Work.reduction(List.of(1, -3, 7), (x, y) -> x += y).get(99);
        List<Integer> list08 = Work.map(List.of(arr1, arr2, arr3, arr4), arr -> arr.length);
        Integer list09 = Work.reduction(list08, (x, y) -> x += y).get(0);
        out.println(list06);
        out.println(list07);
        out.println(list09);
        }

}
