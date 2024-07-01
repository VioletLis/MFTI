package ru.lisenkova.work;

import java.util.ArrayList;
import java.util.List;

public class Department
{
    /*private*/ String name;
    /*private*/ Employee bossName;
    /*private*/ List<Employee> employees = new ArrayList<>();
    Department(String name)
    {
        this.name=name;
    }
   /* public String getName()
    {
        return this.name;
    }*/
    public void setName(String name)
    {
        this.name=name;
    }
    /*public Employee getBoss()
    {
        //проверка назначен ли отделу начальник
        if(this.bossName == null) throw new IllegalArgumentException("The Boss has not been appointed to the position yet");

        return this.bossName;
    }*/
    public void setBoss(Employee bossName)
    {
        if (bossName!=null)
            bossName.setDepartment(this);
        this.bossName=bossName;
    }
    public void addEmployee(Employee employee)
    {
        if (employee.department == this) return;
        if (employee.department.bossName == employee) employee.department.setBoss(null);
        employee.setDepartment(this);
        this.employees.add(employee);
    }
}
