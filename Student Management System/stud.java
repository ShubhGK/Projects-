// Student Management System Project
import java.util.*;

class stud
{
    private int id;
    private String name;
    private int age;

    public int getid()
    {
        return id;
    }
    public int getage()
    {
        return age;
    }
    public String getname()
    {
        return name;
    }
    public void setid(int id)
    {
        this.id=id;
    }
     public void setage(int age)
    {
        this.age=age;
    }
     public void setname(String name)
    {
        this.name=name;
    }

    public stud(int id,String name,int age)
    {
        super();
        this.id=id;
        this.name=name;
        this.age=age;
    }

    public stud()
    {
        super();
    }

    public String toString()
    {
        return "Stud(id: "+id+",Name: "+name+",Age: "+age+")";
    }

}
