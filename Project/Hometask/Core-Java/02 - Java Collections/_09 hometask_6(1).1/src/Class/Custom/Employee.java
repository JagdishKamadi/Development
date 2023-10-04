package Class.Custom;

// custom class Employee
public class Employee {
    private Integer id;
    private String name;
    private Double salary;
    private String bloodGroup;

    public Employee(Integer id,String name,Double salary,String bloodGroup)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.bloodGroup = bloodGroup;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String  getBloodGroup()
    {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup)
    {
        this.bloodGroup = bloodGroup;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", Salary='" + salary+ '\'' +
                ", BloodGroup='" + bloodGroup+ '\'' +
                '}'+"\n";
    }
}
