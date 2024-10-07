package ru.lisenkova.tools;
class Conditions
{
    public static int maxRec(int[] arr, int indx) {
        if (arr.length - 1 == indx) return arr[indx];
        int res = maxRec(arr, indx +1);
        if (res > arr[indx]) {
            return res;
        }
        return arr[indx];
    }
    //модуль числа (3.1)
    public static int abs(int x) {
        if (x<0) return -x;
        return x;
    }
    //безопасное деление (3.2)
    public static int safeDiv(int x, int y) {
        if (y==0) return 0;
        return x/y;
    }
    //максимум (3.3)
    public static int max(int x, int y) {
        if (x>y) return x;
        return y;
    }
    //строка сравнения
    public static String makeDecision(int x, int y) {
        if (x>y) return Integer.toString(x) +">" +Integer.toString(y);
        if (x<y) return Integer.toString(x) +"<" +Integer.toString(y);
        return Integer.toString(x) +"==" +Integer.toString(y);
    }
    //тройной максимум
    public static int max3(int x, int y, int z) {
        if ((x>=y)&&(x>=z)) return x;
        if((y>=x)&&(y>=z)) return y;
        return z;
    }
    //тройная сумма
    public static boolean sum3(int x, int y, int z) {
        return (x + y == z) || (x + z == y) || (y + z == x);
    }
    //двойная сумма
    public static int sum2(int x, int y) {
        if ((x+y>=10)&&(x+y<=19)) return 20;
        return x+y;
    }
    //тридцать пять
    public static boolean is35(int x) {
        if ((x % 5 == 0) && (x % 3 == 0)) return false;
        if (x % 5 == 0) return true;
        return x % 3 == 0;
    }
    //волшебная шестерка
    public static boolean magic6(int x, int y) {
        return (x == 6) || (y == 6) || x - y == 6 || y - x == 6 || x + y == 6;

    }
    //Возраст
    public static String age(int x) {
        if ((x % 10 == 1) && (x != 11)) return Integer.toString(x) + " год";
        if ( (x % 10 < 5) && ( x != 11) && ( x != 12)
                && ( x != 13)&& ( x != 14))
        {
            return Integer.toString(x) + " года";
        }
        return Integer.toString(x) + " лет";

    }
    //день недели
    public static String day(int x) {
        String res;
        switch (x) {

            case 1: res="понедельник"; break;
            case 2: res="вторник"; break;
            case 3: res="среда"; break;
            case 4: res="четверг"; break;
            case 5: res="пятница"; break;
            case 6: res="суббота"; break;
            case 7: res="воскресенье"; break;
            default: res="это не день недели";break;
        }
        return res;
    }
    //Вывод дней недели
    public static String printDays(String x) {
        String res = "";
        switch (x) {
            case "понедельник": res+=" понедельник";
            case "вторник": res+=" вторник";
            case "среда": res+=" среда";
            case "четверг": res+=" четверг";
            case "пятница": res+=" пятница";
            case "суббота": res+=" суббота";
            case "воскресенье": res+=" воскресенье"; break;
            default: res="это не день недели"; break;
        }
        return res;
    }
}
