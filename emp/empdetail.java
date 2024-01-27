package emp;

import java.util.Scanner;

public class empdetail {
    static Scanner sc=new Scanner(System.in);

    public static emp detail()
    {
        emp e=new emp();
        System.out.println("Enter name: ");
        e.setName(sc.next());
        System.out.println("Enter course name: ");
        e.setCourse(sc.next());
        System.out.println("Enter Year of passing: ");
        e.setYop(sc.nextInt());
        System.out.println("Enter your percentage: ");
        e.setPercent(sc.nextDouble());
        return e;
    }
}
