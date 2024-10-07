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
    public String getName()
    {
        return this.name;
    }

    public Employee getBoss()
    {
        //проверка назначен ли отделу начальник
        if(this.bossName == null) throw new IllegalArgumentException("The Boss has not been appointed to the position yet");

        return this.bossName;
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setBoss(Employee bossName)
    {
        if(bossName!=null)
            bossName.setDepartment(this);
        if(this.bossName!=null && bossName==null)
            this.bossName.setDepartment(null);
        this.bossName=bossName;
    }
    public void addEmployee(Employee employee)
    {
        if (employee.department == null) return;
        employee.setDepartment(this);
    }
}
