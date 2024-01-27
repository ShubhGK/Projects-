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