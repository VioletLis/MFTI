import java.util.ArrayList;
import java.util.List;

public class Student
{
    private String name;
    private List<Integer> marks=new ArrayList<>();

    Student(String name, int ... marks)
    {
        this.name=name;
        setMarks(marks);

    }
    public void checkMarks(int ... arrMarks)
    {
        for (int i=0;i<arrMarks.length;i++)
        {
            if ((arrMarks[i]<2)||(arrMarks[i]>5))
                throw new IllegalArgumentException("Недопустимая оценка");
        }
    }
    public void setMarks(int ... marks)
    {
        checkMarks(marks);
        for (int i=0;i<marks.length;i++)
        {
            this.marks.add(i,marks[i]);
        }
    }
    public int[] getMarks() //поправить тут
    {
        int[] res= new int[this.marks.size()];
        for (int i=0;i<this.marks.size();i++)
        {
            res[i]=this.marks.get(i);
        }
        return res;
        //return this.marks;
    }
    public int[] copyMarks()     //копируем оценки студента
    {
        int[] res=new int[marks.size()];
        for (int i=0;i< res.length;i++)
        {
            res[i] = marks.get(i);
        }
        return res;
    }
    public void changeMarks(int index, int mark) // замена оценки по  index на значение mark
    {
        checkMarks(mark);
        this.marks.set(index,mark);
    }
    public double averageMark()                 //подсчет средней оценки
    {
       int average=0;
        if (this.marks.isEmpty()) return 0;
        for (int i : marks)
        {
            average+=i;
        }
        average/=marks.size();
            return average;

    }
    public String isExcellent()
    {
        if (this.marks.isEmpty())
            return "Недостаточно оценок для вывода";
        if (averageMark()==5)
            return "Отличник";
        else
            return "Не отличник";
    }

    @Override
    public String toString()
    {
        return this.name + ": " + marks;
    }
}
