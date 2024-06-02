class Utilities{
    //дробная часть
    public static double fraction(double x)
    {
        return x%1;
    }
    //сумма двух последних цифр
    public static int sumLastNums(int x)
    {
        return x%10+x/10%10;
    }
    //символ цифры в саму цифру
    public static int charToNum(char x)
    {
        return x-48;
    }
    //положительность
    public static boolean isPositive(int x)
    {
        return x>0;
    }
    //двузначность
    public static boolean is2Digits(int x)
    {
        return x>9 && x<99 || x<-9  && x>-99;
    }
    //заглавная английская
    public static boolean isUpperCase(char x)
    {
        return x>='A' && x<='Z';
    }
    //внутри диапазона
    public static boolean isInRange(int a, int b, int num)
    {
        return (a<=num && num<=b)||(b<=num && num<=a);
    }
    //деление нацело
    public static boolean isDivisor (int a, int b)
    {
        return (a%b==0)||(b%a==0);
    }
    //три одинаковых числа
    public static boolean isEqual (int a, int b, int c)
    {
        return a==b && b==c;
    }
    //многократный вызов
    public static int lastNumSum(int a, int b)
    {
        return (a%10)+(b%10);
    }

}
