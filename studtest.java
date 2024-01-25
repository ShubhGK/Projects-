
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
