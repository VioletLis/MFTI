import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 6, 6, 1};
        System.out.println(Conditions.maxRec(arr, 0));
        System.out.println("3.1) "+Conditions.abs(312134)); // 3.1
        System.out.println("3.2) "+Conditions.safeDiv(32, 11)); // 3.2
        System.out.println("3.3) "+Conditions.max(-32, -11)); // 3.3
        System.out.println("3.4) "+Conditions.makeDecision(32, -32)); // 3.4
        System.out.println("3.5) "+Conditions.max3(32, 11, 11)); // 3.5
        System.out.println("3.6) "+Conditions.sum3(32, 3, 36)); // 3.6
        System.out.println("3.7) "+Conditions.sum2(12, 3)); // 3.7
        System.out.println("3.8) "+Conditions.is35(27)); // 3.8
        System.out.println("3.9) "+Conditions.magic6(28, 3)); // 3.9
        System.out.println("3.10) "+Conditions.age(43)); // 3.10
        System.out.println("3.11) "+Conditions.day(3)); // 3.11
        System.out.println("3.12) "+Conditions.printDays("среда")); // 3.12

        System.out.println("4.1) " +Cycles.listNums(9));
        System.out.println("4.2) " +Cycles.reverseListNums(5));
        System.out.println("4.3) " +Cycles.chet(9));
        System.out.println("4.4) " +Cycles.pow(3,2));
        System.out.println("4.5) " +Cycles.numLen(31322));
        System.out.println("4.6) " +Cycles.equalNum(344444444));
        System.out.println("4.7) "); Cycles.square(5);
        System.out.println("4.8) "); Cycles.leftTriangle(3);
        System.out.println("4.9) "); Cycles.rightTriangle(5);
        System.out.println("4.10) "); Cycles.guessGame();

        int[] arr1 = {-11, -2, 3, 4, 6, 66, -1, 0};
        System.out.println("5.1) "+Massives.findFirst(arr1,6));
        System.out.println("5.2) "+Massives.findLast(arr1,6));
        System.out.println("5.3) "+Massives.maxAbs(arr1));
        System.out.println("5.4) "+Massives.countPositive(arr1));

        int[] arr2 = {-1, -2, 3, 4,  -4, 3, -2, -1};
        System.out.println("5.5) "+Massives.palindrom(arr2));
        Massives.reverse(arr1); System.out.println("5.6) " + Massives.outMass(arr2));

        int[] arr3 = {-1, -2, 3, 3,  9};
        System.out.println("5.7) "+ Massives.outMass(Massives.reverseBack(arr3)));
        System.out.println("5.8) "+ Massives.outMass(Massives.concat(arr1,arr3)));
        System.out.println("5.9) "+ Massives.outMass((Massives.findAll(arr3,-2))));
        System.out.println("5.10) "+ Massives.outMass((Massives.deleteNegative(arr3))));
        System.out.println("5.11) "+ Massives.outMass((Massives.add(arr3,4,3))));
        System.out.println("5.12) "+ Massives.outMass((Massives.add(arr3,arr2,2))));
    }

}

