package ru.lisenkova.annotations;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Objects;

class MonkeyGranny
{
    private int height;
    protected Object obj;
}
class MonkeyDad extends MonkeyGranny
{
    static String st;
    public int y;
}
@Default
public class MonkeyOrigin extends MonkeyDad {
    @Default private String str="hello";
    public String str2="bye";
}
class MonkeyReset extends MonkeyResetDad
{
    @Default
    private String str1 = "no";
    @Default
    public int height1 = 0;
    @Default
    protected Object object ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MonkeyReset that = (MonkeyReset) o;
        return height1 == that.height1 && Objects.equals(str1, that.str1) && Objects.equals(object, that.object);
    }
    public MonkeyReset(){
        super();
    };

    public MonkeyReset(int x, int height1, Integer weight, String str1, int height11, Object object) {
        super(x, height1, weight);
        this.str1 = str1;
        this.height1 = height11;
        this.object = object;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), str1, height1, object);
    }
}
class MonkeyResetDad extends MonkeyResetGranny
{
    protected int height1 = 99;
    @Default
    Integer weight = -100;

    public MonkeyResetDad(){
        super();
    }
    public MonkeyResetDad(int x, int height1, Integer weight) {
        super(x);
        this.height1 = height1;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonkeyResetDad that = (MonkeyResetDad) o;
        return (height1 == that.height1 && weight.equals(that.weight));
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(height1);
    }
}
@Default
class MonkeyResetGranny
{
    int x=1000;

    public MonkeyResetGranny() {}
    public MonkeyResetGranny(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonkeyResetGranny that = (MonkeyResetGranny) o;
        return x == that.x;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(x);
    }
}
interface MonkeyCacheable
{
    @Mutator
    void setHeight(int height);
    void setName(String name);
    @Cache
    public String getHeight();
    @Cache
    public String getName();
}

class CacheMonkey1 implements MonkeyCacheable
{

    private int height = 170;
    protected String name = "Vasya";

    int valueGetHeight = 0; //количество обычных вызовов метода getHeight
    int valueGetName =  0;  //количество обычных вызовов метода getName
    @Mutator
    @Override
    public void setHeight(int height){
        this.height = height;
        valueGetHeight = 0;  //обнуление, потому что при @Mutator кэш обнуляется
        valueGetName = 0;
    }
    @Override
    public void setName(String name){
        this.name = name;
    }
    @Cache
    public String getHeight()
    {
        valueGetHeight++;
        return valueGetHeight + " invoke getHeight: "+ this.height;
    }
    @Cache
    public String getName()
    {
        valueGetName++;
        return valueGetName + " invoke getName: " + this.name;
    }
    @Override
    public String toString()
    {
        return valueGetHeight + " invoke getHeight: "+ this.height + ", " + valueGetName + " invoke getName: " + this.name;
    }
}
@Validate(ValidateMonkeyTests1.class)
class MonkeyValidate1{
    private int height = 170;
    protected String name = "Vasya";
}

class MonkeyValidate2{
    int height = 170;
    public String name = "Vasya12";
}

@Validate(ValidateMonkeyTests1.class)
class MonkeyValidate3{
    private int height = 20;
    protected String name = "Vasya";
}
class ValidateMonkeyTests1{
    public ValidateMonkeyTests1() {
    }
    @SneakyThrows
    public void checkHeightBottom(Object obj) throws NoSuchFieldException {
        Field height = obj.getClass().getDeclaredField("height");
        height.setAccessible(true);
        int x = (int) height.get(obj);
        if((x<40)) throw new RuntimeException("Too small for a human");
    }
    @SneakyThrows
    protected void checkHeightUp(Object obj)
    {
        Field height = obj.getClass().getDeclaredField("height");
        height.setAccessible(true);
        int x = (int) height.get(obj);
        if((x>240)) throw new RuntimeException("Too tall for a human");
    }
    @SneakyThrows
    private void checkNameNumber(Object obj)
    {
        Field nameF = obj.getClass().getDeclaredField("name");
        nameF.setAccessible(true);
        String name = (String) nameF.get(obj);
        if(name.contains("[0-9]")) throw new RuntimeException("Name can't contain numbers");;
    }
    @SneakyThrows
    private void checkNameSymbol(Object obj)
    {
        Field nameF = obj.getClass().getDeclaredField("name");
        nameF.setAccessible(true);
        String name = (String) nameF.get(obj);
        if(name.matches("[a-zA-Z]")) throw new RuntimeException("Name must contains only alphabets");;
    }
}




