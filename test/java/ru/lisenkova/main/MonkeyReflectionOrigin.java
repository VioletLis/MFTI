package ru.lisenkova.main;

import ru.lisenkova.annotations.Default;

import java.util.Objects;

class MonkeyReflectionGranny
{
    private int height;
    protected Object obj;
}
class MonkeyReflectionDad extends MonkeyReflectionGranny
{
    static String st;
    public int y;
}
@Default
public class MonkeyReflectionOrigin extends MonkeyReflectionDad{
    @Default private String str="hello";
    public String str2="bye";
}
class MonkeyReflectionReset extends MonkeyReflectionResetDad
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
        MonkeyReflectionReset that = (MonkeyReflectionReset) o;
        return height1 == that.height1 && Objects.equals(str1, that.str1) && Objects.equals(object, that.object);
    }
    public MonkeyReflectionReset(){
        super();
    };

    public MonkeyReflectionReset(int x,int height1, Integer weight, String str1, int height11, Object object) {
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
class MonkeyReflectionResetDad extends MonkeyReflectionResetGranny
{
    protected int height1 = 99;
    @Default
    Integer weight = -100;

    public MonkeyReflectionResetDad(){
        super();
    }
    public MonkeyReflectionResetDad(int x, int height1, Integer weight) {
        super(x);
        this.height1 = height1;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonkeyReflectionResetDad that = (MonkeyReflectionResetDad) o;
        return (height1 == that.height1 && weight.equals(that.weight));
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(height1);
    }
}
@Default
class MonkeyReflectionResetGranny
{
    int x=1000;

    public MonkeyReflectionResetGranny() {}
    public MonkeyReflectionResetGranny(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonkeyReflectionResetGranny that = (MonkeyReflectionResetGranny) o;
        return x == that.x;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(x);
    }
}



