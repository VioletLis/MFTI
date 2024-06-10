import java.rmi.UnexpectedException;
import java.util.Arrays;

public class Main {
    public static String[] partExpression;
    public static int pos=0;
    public static void main(String[] args)
    {
        String expr="100+2*(10+8*(11-3*2))+11*2-24*((19-15*3)-2)";

        System.out.println((100+2*(10+8*(11-3*2))+11*2-24*((19-15*3)-2))+"=" + fun(expr));
    }
    public static String fun(String str)
    {

        str=str.replaceAll("\\+"," + ") //replaceAll(String.valueOf(" "),"")
                .replaceAll("-", " - ")
                .replaceAll(("\\*")," * ")
                .replaceAll(("\\(")," ( ")
                .replaceAll(("\\)")," ) ")
                .replaceAll("/"," / ")
                .replaceAll("\s+"," ");
        partExpression=str.split(" ");
        int pos=0;
        return str=""+thirdCalc();
    }
    public static double thirdCalc()
    {
        double x = secondCalc(); //Double.parseDouble(partExpression[pos++]);
        String operator;
        while(pos<partExpression.length)
        {
            operator = partExpression[pos];
            if (!operator.equals("+") && !(operator.equals("-")))
                break;
            else {
                pos++;
            }
            double y = secondCalc();             //Double.parseDouble(partExpression[pos++]);
            if (operator.equals("+"))
                x += y;
            else x -= y;
        }
        return x;

    }

    public static double secondCalc()
    {
        double x = firstCalc();         //Double.parseDouble(partExpression[pos++]);
        String operator;
        while(pos<partExpression.length)
        {
            operator = partExpression[pos];
            if (!operator.equals("*") && !(operator.equals("/")))
                break;
            else {
                pos++;
            }
            double y = firstCalc();             //Double.parseDouble(partExpression[pos++]);
            if (operator.equals("*"))
                x *= y;
            else x /= y;
        }
        return x;
    }
    public static double firstCalc()
    {
        double res=0;
        String endPart;
        String startPart=partExpression[pos];
        if (startPart.equals("("))
        {
            pos++;
            res=thirdCalc();

            if (pos<partExpression.length)
            {
                endPart=partExpression[pos];
            }
            else
                throw new IndexOutOfBoundsException("Unexpected end of expression");
            if (endPart.equals(")"))
            {
                pos++;
                return res;
            }
            throw new IllegalArgumentException(") is expected");
        }
        pos++;
        return Double.parseDouble(startPart);
    }




}