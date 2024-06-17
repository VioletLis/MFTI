public class Main {
    public static void main(String[] args) {
        Fraction A1= new Fraction(1,2);
        Fraction A2 = new Fraction(3,2);
        Fraction A3 = new Fraction(-5,2);
        System.out.println((A1.sum(A2).div(A3).minus(3)).getF());
        System.out.println("-------------------------------------------------------");
        Point P1 = new Point(1,1);
        Point P2 = new Point(10,15);
        Point P3 = new Point(0,0);
        Line L1 = new Line(P1,P2);
        Line L2 = new Line(P3,P2);
        L1.setStart(P2);
        L1.setEnd(P1);
        System.out.println("Длина L1: "+L1.length());
        System.out.println("L1: "+L1.toString());
        System.out.println("Начало L1: "+L1.getStart().toString());
        System.out.println("Конец L1: "+L1.getEnd().toString());

        System.out.println("L2: "+L2.toString());
        System.out.println("P2: "+P2.toString());
        P2.setX(2);
        System.out.println("L1: "+L1.toString());

        System.out.println("L2: "+L2.toString());
        System.out.println("P2: "+P2.toString());
        System.out.println("P2_X: " +P2.getX()+" P2_Y: "+P2.getY());
        Line L3 = new Line(0,0,3,4);
        System.out.println("L3: "+L3.toString());
        L3.setStart(1,0);
        System.out.println("L3 new start: "+L3.toString());
        System.out.println("Длина L3: "+L3.length());
        System.out.println("-------------------------------------------------------");

        Student student0 = new Student("Вася", 3, 4, 5, 4);
        Student student1 = new Student("Петя", 5, 5, 5, 5);
        System.out.println(student0.toString()+", "+student0.isExcellent() +" , Average = "+student0.averageMark());
        System.out.println(student1.toString()+", "+student1.isExcellent() +" , Average = "+student1.averageMark());
        Student student2 = new Student("Андрей",student0.copyMarks());
        System.out.println(student2.toString());
        student2.changeMarks(2,2);
        System.out.println(student2.toString()+", "+student2.isExcellent() +" , Average = "+student2.averageMark());
        Student student3 = new Student("Максим");
        System.out.println(student3.toString()+", Average = " + student3.averageMark() + ", " + student3.isExcellent());
        System.out.println("-------------------------------------------------------");
        Department department1 = new Department("IT");
        Department department2 = new Department("HR");
        Employee petrov = new Employee("Petrov",department1);
        Employee kozlov = new Employee("Kozlov",department1);
        Employee sidorov = new Employee("Sidorov",department1);
        Employee ivanov = new Employee("Ivanov",department2);
        department1.setBoss(kozlov);
        department2.setBoss(ivanov);
        System.out.println(petrov.toString());
        System.out.println(kozlov.toString());
        System.out.println(sidorov.toString());
        System.out.println(ivanov.toString());
        kozlov.setName("titov");
        System.out.println(petrov.toString());
        System.out.println(kozlov.toString());
        System.out.println(sidorov.toString());
        System.out.println(ivanov.toString());

    }
}