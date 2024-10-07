package ru.lisenkova.work;
public class Employee
{
     /*private*/ String name;
     /*private*/ Department department;


     Employee(String name, Department department)
     {
        this(name);
        setDepartment(department);
     }
    Employee(String name)
    {
        this.name = name;
    }
     public void setName(String employeeName)
    {
        this.name=employeeName;
    }
     public Department getDepartment()
     {
         return department;
     }

     void setDepartment(Department department)
     {
         if(department==this.department) return;
         if(this.department!=null && this == this.department.bossName)
             this.department.bossName=null;
         if(department!=null)
             this.department.employees.remove(this);
         this.department = department;
         if (department!=null)
            department.employees.add(this);
     }

     public String getName()
     {
         return this.name;
     }



    @Override
     public String toString()
     {
         if (this.department.bossName.equals(this.name))
             return this.name + " начальник отдела " + this.department.name;
          return this.name + " работает в отделе " + this.department.name + " начальник которого " + this.department.bossName;
     }

}
