package emp;

import java.util.*;

public class emphire {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<emp> emp=new ArrayList<emp>();
        while (true) 
        {
            
            System.out.println("1.Software");
            System.out.println("2.Testing");
            System.out.println("3.Full Stack");
            System.out.println("4.Exit");
        

        int opt=sc.nextInt();
        switch (opt) {
            case 1:
                while (true)
                {
                    System.out.println("1.Java");
                    System.out.println("2.Web Tech");
                    System.out.println("3.SQL");
                    
                
                int select=sc.nextInt();
                switch (select) 
                {
                    case 1:
                        System.out.println("Enter your details: ");
                        emp e=empdetail.detail();
                        emp.add(e);

                        
                        break;
                    case 2:

                    case 3:
                
                    default:
                        break;
                }
                
                break;
            }

            case 2:
                    while (true) {
                    System.out.println("1.Manual Testing");
                    System.out.println("2.Automation Testing");
                    
                    
                

                int sel=sc.nextInt();
                switch (sel) 
                {
                    case 1:
                        System.out.println("Enter your details: ");
                        emp e=empdetail.detail();
                        emp.add(e);

                        
                        break;
                    case 2:

                
                    default:
                        break;
                }
                break;
            }
            case 3:
                    while (true) {
                    System.out.println("1.FullStack Java");
                    System.out.println("2.FullStack Python");
                    
                
                int se=sc.nextInt();
                switch (se) 
                {
                    case 1:
                        System.out.println("Enter your details: ");
                        emp e=empdetail.detail();
                        emp.add(e);

                        
                        break;
                    case 2:
                
                    default:
                        break;
                }
                break;
            }

            case 4:
                System.out.println("\t\t\t THANK YOU!!!!");
                System.exit(0);

        
            default:
                System.err.println("            Invalid");

        }
    }

    }
}
