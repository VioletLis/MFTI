package ru.lisenkova.tools;
class Cycles
{
    //числа подряд
    public static String listNums(int x) {
        String res="";
        for(int i=0;i<x+1;i++)
        {
            res+= i +" ";
        }
        return res;
    }
    //числа наоборот
    public static String reverseListNums(int x) {
        String res="";
        for(int i=x;i>=0;i--)
        {
            res+= i +" ";
        }
        return res;
    }
    //четные числа
    public static String chet(int x) {
        String res="";
        for(int i=0;i<x+1;)
        {
            res+=i+" ";
            i+=2;
        }
        return res;
    }
    //степень числа
    public static int pow(int x, int y) {
        int res=1;
        for(int i=1;i<=y;i++)
        {
            res=res*x;
        }
        return  res;
    }
    //длина числа
    public static int numLen(long x) {
        int res=0;
        for(;x/10>0 || x/10 <-1;)
        {
            res+=1;
            x=x/10;
        }
        res+=1;
        return res;
    }
    //одинаковость
    public static boolean equalNum(int x) {
        boolean res=true;
        while ((x/10>0 || x/10 <-1)&&(x%10==(x/10)%10))
        {
            x=x/10;
        }
        if (x>=10) res=false;
        return res;
    }
    //квадрат
    public static void square(int x) {
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<x;j++)
            {
                System.out.print('*');
            }
            System.out.println();
        }
    }
    //левый треугольник
    public static void leftTriangle(int x) {
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<=i;j++)
            {
                System.out.print('*');
            }
            System.out.println();
        }
    }
    //правый треугольник
    public static void rightTriangle(int x) {
        for(int i=0;i<x;i++)
        {
            for (int j=0;j<x-i;j++)
            {
                System.out.print(' ');
            }
            for(int j=0;j<=i;j++)
            {
                System.out.print('*');
            }
            System.out.println();

        }
    }
    //угадайка
    public static void guessGame() {
        int randomNum = 3;
        boolean succesed=false;
        int res=0;
        while(!succesed) {
            java.util.Scanner sc = new java.util.Scanner(System.in);
            System.out.println("What number am I thinking (0 to 9)? :");
            int x = sc.nextInt();
            if (x != randomNum) {
                System.out.println("No, try again");
            } else {
                System.out.println("Yes, it`s " + randomNum);
                succesed=true;
            }
            res+=1;
        }
        System.out.println("Число попыток: " + res);
    }
}
