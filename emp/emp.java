package emp;

public class emp {
    
    private String name;
    private String course;
    private int yop;
    private double percent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYop() {
        return yop;
    }

    public void setYop(int yop) {
        this.yop = yop;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    emp(String name,String course,int yop,int percent)
    {
        this.name=name;
        this.course=course;
        this.yop=yop;
        this.percent=percent;

    }

    emp()
    {

    }

    public String toString()
    {
        return "Emp(name: "+ name + "course: "+course+"Passing year: "+yop+"Percent:"+percent+")";
    }
    
}
