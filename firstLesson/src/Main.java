public class Main {
    public static void main(String[] args) {
        System.out.println("1) "+Utilities.fraction(5.25));
        System.out.println("2) "+Utilities.sumLastNums(4568));
        System.out.println("3) "+Utilities.charToNum('3'));
        System.out.println("4) "+Utilities.isPositive(-11));
        System.out.println("5) "+Utilities.is2Digits(-11));
        System.out.println("6) "+Utilities.isUpperCase('D'));
        System.out.println("7) "+Utilities.isInRange(-8,-3,-3));
        System.out.println("8) "+Utilities.isDivisor(-1,2));
        System.out.println("9) "+Utilities.isEqual(-1,-1,-1));
        int res=Utilities.lastNumSum(5,11);
        System.out.println("10) ");
        System.out.println("5+11 это " + res);
        System.out.print(res + "+123 это ");
        res=Utilities.lastNumSum(res,123);
        System.out.println(res);
        System.out.print(res + "+14 это ");
        res=Utilities.lastNumSum(res,14);
        System.out.println(res);
        System.out.print(res + "+1 это ");
        res=Utilities.lastNumSum(res,1);
        System.out.println(res);
        System.out.println("Итого "+res);
    }
}



