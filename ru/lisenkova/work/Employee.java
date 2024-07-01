package ru.lisenkova.work;
public class Employee
{
     /*private*/ String name;
     /*private*/ Department department;


     Employee(String name, Department department)
     {
        this.name = name;
        this.department = department;
     }

     public Department getDepartment()
     {
         return department;
     }
     void setDepartment(Department department)
     {
         if(department==this.department) return;
         if(department!=null && this == department.bossName)
             this.department.setBoss(null);
         this.department = department;
     }

     /*public String getName()
     {
         return this.name;
     }*/

     public void setName(String employeeName)
    {
        this.name=employeeName;
    }

    @Override
     public String toString()
     {
         if (this.department.bossName.equals(this.name))
             return this.name + " начальник отдела " + this.department.name;
          return this.name + " работает в отделе " + this.department.name + " начальник которого " + this.department.bossName;
     }

}
