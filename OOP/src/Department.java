public class Department
{
    private String name;
    private Employee bossName;
    Department(String name)
    {
        this.name=name;
    }
    Department(String name, Employee bossName)
    {
        this.name=name;
        checkBoss(bossName);
        this.bossName=bossName;
    }
    void setBoss(Employee bossName)
    {
        checkBoss(bossName);
        this.bossName=bossName;
    }
    void setName(String name)
    {
        this.name=name;
    }
    void checkBoss(Employee bossName) //Проверка работает ли потенциальный босс в этом отделе
    {
        if (!this.name.equals(bossName.getDepartment().getName()))
            throw new IllegalArgumentException("The Boss must be from this department");
    }
    public String getName()
    {
        return this.name;
    }

    public String getBossName()
    {
        //проверка назначен ли отделу начальник
        if(this.bossName == null) throw new IllegalArgumentException("The Boss has not been appointed to the position yet");

        return this.bossName.getName();
    }
}
