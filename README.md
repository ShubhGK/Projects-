# Student_Management_project
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


import java.util.*;
class studtest
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        List<stud> stud=new ArrayList<stud>();
        
        while(true) 
        {
            System.out.println("                            STUDENT MANAGEMENT PROJECT");
            System.out.println("_________________________________________________________________________________");
            System.out.println("1.Add Students");
            System.out.println("2.Update Students");
            System.out.println("3.Display all students details");
            System.out.println("4.Delete Student");
            System.out.println("5.Exit");
            System.out.println("Please select any Operations : "); 
            
            int opt=sc.nextInt();
            switch (opt) {
                case 1:
                    stud std= studutility.add();
                    stud.add(std);
                    System.out.println("Student added successfully ");
                    
                    break;
            
                case 2:
                    studutility.update(stud);
                     break;
                case 3:
                    studutility.display(stud);
                    break;
                case 4:
                    System.out.println("Which id do u want to delete: ");
                    int id=sc.nextInt();
                    studutility.delete(stud,id);
                    break;
                case 5:
                    System.out.println("\t\t\t THANK YOU!!!!");
                    System.exit(0);
                    break;
                default:
                    System.err.println("            Invalid");

            }
        }
    }
}


import java.util.*;

class studutility
{
   static Scanner sc=new Scanner(System.in);
   public static stud add()
   {
        stud s=new stud();
        System.out.println("Enter id ");
        s.setid(sc.nextInt());
        System.out.println("Enter name ");
        s.setname(sc.next());
        System.out.println("Enter age ");
        s.setage(sc.nextInt());
        return s;
   } 

   public static void update(List<stud> students)
   {
          System.out.println("please enter update details ");
          System.out.println("which id do you want to change: ");
          int id=sc.nextInt();
          System.out.println("Which name do you want to add: ");
          String name=sc.next();
          System.out.println("which age do you u want to add: ");
          int age=sc.nextInt();

          int index=0;
          for (stud s : students) 
          {
               if (id==s.getid())
               {
                    break;     
               }
               index++;
          }
          students.get(index).setname(name);
          students.get(index).setage(age);
   }

   public static void display(List<stud> stud)
   {
          Iterator l=stud.iterator();
          while (l.hasNext()) 
          {
               System.out.println(l.next());//,toString());
               
          }
   }

   public static void delete(List<stud> stud,int id)
   {
          Iterator i=stud.iterator();
          while (i.hasNext())
          {
               stud s=(stud) i.next();
               if (id==s.getid()) 
               {
                    i.remove();    
               }
          }
          System.out.println("Deleted");

   }
}
