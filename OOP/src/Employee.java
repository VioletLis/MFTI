public class Employee
{
     private String name;
     private Department department;

     Employee(String name, Department department) //у сотрудника всегда есть имя и он должен быть распределен в отдел
     {
        this.name = name;
        this.department = department;
     }

     public Department getDepartment()
     {
         return department;
     }

     public String getName()
     {
         return this.name;
     }
    public void setName(String employeeName)
    {
        this.name=employeeName;
    }

    @Override
     public String toString()
     {
         if (this.department.getBossName().equals(this.name))
             return this.name + " начальник отдела " + this.department.getName();
          return this.name + " работает в отделе " + this.department.getName() + " начальник которого " + this.department.getBossName();
     }

}
