package ru.lisenkova.main;

import ru.lisenkova.math.Fraction;
import ru.lisenkova.math.Fractionable;
import ru.lisenkova.math.NewFraction;
import ru.lisenkova.tools.Work;

import java.util.*;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[]{5, 3, 1};
        int[] arr2 = new int[]{1, 2, 3, 4};
        int[] arr3 = new int[]{1, 1, 1, 1};
        int[] arr4 = new int[]{-1, -11};
        int[] arr5 = new int[]{-13, -1, -1};

        List<Integer> list0 = Work.map(List.of("qwerty", "asdfg", "zx"), s -> s.length()); //5.3.1
        List<Integer> list01 = Work.map(List.of(1, -3, 7), i -> Math.abs(i));
        List<Integer> list02 = Work.map(List.of(arr1, arr2, arr3, arr4, arr5), Main::max);
        out.println(list0);
        out.println(list01);
        out.println(list02);

        List<String> list03 = Work.filter(List.of("qwerty", "asdfg", "zx"), s -> s.length() < 3);//5.3.2
        List<Integer> list04 = Work.filter(List.of(1, -3, 7), i -> i > 0);
        List<int[]> list05 = Work.filter(List.of(arr1, arr4, arr5), Main::lessZero);
        out.println(list03);
        out.println(list04);
        list05.forEach(array -> out.print(Arrays.toString(array)));
        out.println();

        String list06 = Work.reduction(List.of("qwerty", "asdfg", "zx"), (x, y) -> (x + y).toString()).get(""); //5.3.3
        Integer list07 = Work.reduction(List.of(1, -3, 7), (x, y) -> x += y).get(99);
        List<Integer> list08 = Work.map(List.of(arr1, arr2, arr3, arr4), arr -> arr.length);
        Integer list09 = Work.reduction(list08, (x, y) -> x += y).get(0);
        out.println(list06);
        out.println(list07);
        out.println(list09);

        List<List<Integer>> list10 = Work.collect(List.of(1, -3, 7, 10, -10), () -> {    //5.3.4
                    List<List<Integer>> list = new ArrayList<>();
                    list.add(new ArrayList<>());
                    list.add(new ArrayList<>());
                    return list;
                }, (list, num) -> {
                    if (num > 0) {
                        list.get(0).add(num);
                    } else if (num < 0) {
                        list.get(1).add(num);
                    }
                }
        );
        out.println(list10);

        List<UniqueLength> list11 = Work.collect(List.of("qwerty", "asdfg", "zx","zx"),
                () -> new ArrayList<UniqueLength>(),
                (list,str) -> {
                    List<UniqueLength> lengths = Work.filter(list,x-> x.lengthL==str.length());
                    UniqueLength uniqueLength;
                    if(lengths.size() == 1) {
                        uniqueLength = lengths.get(0);
                    } else {
                        uniqueLength = new UniqueLength(str.length());
                        list.add(uniqueLength);
                    }
                    uniqueLength.lst.add(str);
                }
        );
        list11.forEach(list -> out.print(list.getLengthList()));
        out.println();

    Set<String> list12 = Work.collect(List.of("qwerty", "asdfg", "zx","zx"), () ->
            {
                Set<String> set = new HashSet<String>();
                return set;
            }, Set::add

    );
        out.println(list12);

        //Fraction doubleValue
        Fraction fraction = new Fraction(1,3);
        NewFraction fraction1 = new NewFraction(fraction);
        test(fraction1);

}
public static void test(Fractionable fractionable)
{
    out.println(fractionable.doubleValue());
    out.println(fractionable.doubleValue());
    out.println(fractionable.doubleValue());
    fractionable.setDenum(2);
    out.println(fractionable.doubleValue());
    out.println(fractionable.doubleValue());
}
    public static int max(int[] arr)
    {
        int res=arr[0];
        for(int i=1;i <arr.length; i++)
        {
            if(arr[i] > res) res=arr[i];
        }
        return res;
    }
    public static boolean lessZero(int[] arr)
    {
        for(int i=0;i <arr.length; i++)
        {
            if(arr[i] > 0) return false;
        }
        return true;
    }
}
class UniqueLength
{
    int lengthL;
    List<String> lst = new ArrayList<>();
    public UniqueLength(int strSize)
    {
        this.lengthL = strSize;
    }

    public List<String> getLengthList() {
        return lst;
    }
}

