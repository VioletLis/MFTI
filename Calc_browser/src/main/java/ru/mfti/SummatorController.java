package ru.mfti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


//REST API
@RestController
class SummatorController {
    
    @GetMapping("/make")
    public String arithmeticExpression(String expression) {
        return fun(expression);
    }
    private static int pos=0;
	//логику писать сюда

    public static String fun(String str)
    {
        String[] partExpression;
        pos=0;
        String str1=str.replaceAll("\\+"," + ") //replaceAll(String.valueOf(" "),"")
                .replaceAll("-", " - ")
                .replaceAll(("\\*")," * ")
                .replaceAll(("\\(")," ( ")
                .replaceAll(("\\)")," ) ")
                .replaceAll("/"," / ")
                .replaceAll("\s+"," ");
        partExpression=str1.split(" ");
        str1=""+thirdCalc(partExpression);
        System.out.println(Arrays.toString(partExpression));
        return str1;
    }
    public static int thirdCalc(String[] partExpression)
    {
        int x = secondCalc(partExpression); //Integer.parseInt(partExpression[pos++]);
        String operator;
        while(pos<partExpression.length)
        {
            operator = partExpression[pos];
            if (!operator.equals("+") && !(operator.equals("-")))
                break;
            else {
                pos++;
            }
            int y = secondCalc(partExpression);             //Integer.parseInt(partExpression[pos++]);
            if (operator.equals("+"))
                x += y;
            else x -= y;
        }
        System.out.println(x);
        return x;

    }

    public static int secondCalc(String[] partExpression)
    {
        int x = firstCalc(partExpression);         //Integer.parseInt(partExpression[pos++]);
        String operator;
        while(pos<partExpression.length)
        {
            operator = partExpression[pos];
            if (!operator.equals("*") && !(operator.equals("/")))
                break;
            else {
                pos++;
            }
            int y = firstCalc(partExpression);             //Integer.parseInt(partExpression[pos++]);
            if (operator.equals("*"))
                x *= y;
            else x /= y;
        }
        System.out.println(x);
        return x;
    }
    public static int firstCalc(String[] partExpression)
    {
        int res=0;
        String endPart;
        String startPart=partExpression[pos];
        if (startPart.equals("("))
        {
            pos++;
            res=thirdCalc(partExpression);

            if (pos<partExpression.length)
            {
                endPart=partExpression[pos];
            }
            else
                throw new IndexOutOfBoundsException("Unexpected end of expression");
            if (endPart.equals(")"))
            {
                pos++;
                System.out.println(res);
                return res;
            }
            throw new IllegalArgumentException(") is expected");
        }
        pos++;
        System.out.println(startPart);
        return Integer.parseInt(startPart);
    }
}
