package ru.lisenkova.tools;

public class Massives
{
    //поиск первогозначения
    public static int findFirst(int[] arr, int x)
    {
        int res=0;
        while( (res<arr.length) && (arr[res]!=x) )
        {
            res+=1;
        }
        if (res >= arr.length) return -1;
        return res;
    }
    //поиск последнего значения
    public static int findLast(int[] arr, int x)
    {
        int res=arr.length-1;
        while( (res>=0) && (arr[res]!=x) )
        {
            res--;
        }
        if (res <0 ) return -1;
        return res;
    }
    //поиск максимального
    public static int maxAbs(int[] arr)
    {
        int res=arr[0];
        for (int i=1;i<arr.length;i++)
        {
            if ( Conditions.abs(arr[i]) > Conditions.abs(res) ) res=arr[i];
        }
        return res;
    }
    //подсчет позитива
    public static int countPositive(int[] arr)
    {
        int res=0;
        for(int i=0;i<arr.length;i++)
        {
           if (arr[i]>0) res++;
        }
        return res;
    }
    //палиндром
    public static boolean palindrom(int[] arr)
    {
        if(arr.length%2==0)
            for (int i=0; i<=arr.length/2;i++)
            {
                if (arr[i]!=arr[arr.length-i-1]) return false;
            }
        for (int i=0; i<=(arr.length-1)/2;i++)
        {
            if (arr[i]!=arr[arr.length-i-1]) return false;
        }
        return true;
    }
    //реверс
    public static void reverse(int[] arr)
    {
        int temp=arr[0];
        if(arr.length%2==0)
        {
            for (int i=0; i<=arr.length/2-1;i++)
            {
                temp=arr[i];
                arr[i]=arr[arr.length-i-1];
                arr[arr.length-i-1]=temp;
            }
        }
        else
        {
            for (int i=0; i<=(arr.length-1)/2;i++)
            {
                temp=arr[i];
                arr[i]=arr[arr.length-i-1];
                arr[arr.length-i-1]=temp;
            }
        }

    }
    //обратный реверс
    public static int[] reverseBack(int[] arr)
    {
        int[] reverseArr = new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            reverseArr[i]=arr[arr.length-i-1];
        }
        return reverseArr;
    }
    //объединение
    public static int[] concat(int[] arr1, int[] arr2)
    {
        int[] newArr=new int[arr1.length+arr2.length];
        for (int i=0;i<arr1.length;i++)
        {
            newArr[i]=arr1[i];
        }
        for(int i=0;i<arr2.length;i++)
        {
            newArr[arr1.length+i]=arr2[i];
        }
        return newArr;
    }
    //все вхождения
    public static int[] findAll(int[] arr, int x)
    {
        int res=0;
        for(int i=0;i<arr.length;i++)
        {
            if (arr[i]==x) res++;
        }
        int[] arrNew=new int[res];
        int j=0;
        for (int i=0;i< arr.length && j<res; i++)
        {
            if (arr[i]==x)
            {
                arrNew[j]=i;
                j++;
            }
        }
        return arrNew;
    }
    //удалить негатив
    public static int[] deleteNegative(int[] arr)
    {
        int res=0;
        for (int i=0;i<arr.length;i++)
        {
            if (arr[i]>=0) res++;
        }
        int[] arrNew=new int[res];
        int j=0;
        for (int i=0;i<arr.length && j<res;i++)
        {
            if (arr[i]>0)
            {
                arrNew[j]=arr[i];
                j++;
            }
        }
        return arrNew;

    }
    //добавление в массив
    public static int[] add(int[] arr, int x, int pos)
    {
        int[] arrNew=new int[arr.length+1];
        for(int i=0;i<pos;i++)
        {
            arrNew[i]=arr[i];
        }
        arrNew[pos]=x;
        for(int i=pos+1;i<arr.length+1;i++)
        {
            arrNew[i]=arr[i-1];
        }
        return arrNew;
    }
    //добавление массива в массив
    public static int[] add(int[] arr, int[] ins, int pos)
    {
        int[] arrNew=new int[arr.length+ins.length];
        for (int i=0,j=0;j<arr.length+ins.length;i++,j++)
        {
            arrNew[j]=arr[i];
            if ((j>=pos)&&(j<=pos+ins.length-1))
            {
                arrNew[j]=ins[j-pos];
                i--;
            }
        }
        return arrNew;
    }

    //строка с элементами массива без Arrays.toString
    public static String outMass(int[] arr)
    {
        String res="["+arr[0]+", ";
        for(int i=1;i<arr.length-1;i++)
        {
            res=res+arr[i]+", ";
        }
        res=res+arr[arr.length-1]+"]";
        return res;
    }



}
