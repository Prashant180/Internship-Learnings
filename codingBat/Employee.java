package codingBat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    int id,age,salary;
    String name,address,email,mobile,designation,experience;

    public Employee(int id,int age,int salary,String name,String address,String email,String mobile,String designation,String experience){
        this.id=id;
        this.age=age;
        this.address=address;
        this.name=name;
        this.salary=salary;
        this.email=email;
        this.mobile=mobile;
        this.designation=designation;
        this.experience=experience;
    }

    public String toString(){
        return id+" "+name+" "+designation+" "+age+" "+address+" "+salary+" "+email+" "+mobile+" "+experience;
    }

}

class MinimalDto{
    int id;
    String name,address,email;

    public MinimalDto(){

    }
    public MinimalDto(int id,String name, String address, String email){
        this.id=id;
        this.name=name;
        this.address=address;
        this.email=email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return id+" "+name+" "+address+" "+email;
    }
}

class EmployeeLIst{
    public static void main(String[] args) {
        List<Employee> employees=new ArrayList<>();
        employees.add(new Employee(1,25,20000,"Jack","London","aiush@gmail.com","9834802396","Developer","2 years"));
        employees.add(new Employee(2,28,25000,"Tom","CN","aiush@gmail.com","983482396","CTO","2 years"));
        employees.add(new Employee(3,24,22000,"Jerry","CN","aiush@gmail.com","9834812396","Video editor","2 years"));
        employees.add(new Employee(4,26,30000,"Ben","CN","aiush@gmail.com","983482396","Developer","2 years"));
        employees.add(new Employee(5,22,12000,"Arya","Winterfell","aiush@gmail.com","983482396","DCTO","2 years"));
        employees.add(new Employee(6,21,10000,"Sansa","Winterfell","aiush@gmail.com","983482396","Developer","2 years"));
        employees.add(new Employee(7,24,30000,"Ragnor","Norway","aiush@gmail.com","983482396","Manager","2 years"));
        employees.add(new Employee(8,23,21000,"Hound","Kings Landing","aiush@gmail.com","983482396","Developer","2 years"));
        employees.add(new Employee(9,29,30000,"Kevin","CN","aiush@gmail.com","983482396","CTO","2 years"));
        employees.add(new Employee(10,22,32000,"Peter","New York","aiush@gmail.com","983482396","Developer","2 years"));
        employees.add(new Employee(11,30,35000,"Tony","Stark Tower","aiush@gmail.com","983482396","Developer","2 years"));
        employees.add(new Employee(12,33,20000,"Thor","Asgard","aiush@gmail.com","983482396","Graphic Designer","2 years"));
        employees.add(new Employee(13,21,25000,"Loki","Asgard","aiush@gmail.com","983482396","Developer","2 years"));
        employees.add(new Employee(14,24,18000,"Hulk","New York","aiush@gmail.com","983482396","Developer","2 years"));
        employees.add(new Employee(15,35,16000,"Jack","Caribbean","aiush@gmail.com","983482396","Developer","2 years"));

        employees.stream().filter(f->f.designation.contains("Video")).forEach(n-> System.out.println(n));
        System.out.println();
        employees.stream().filter(f->f.mobile.length()!=10).forEach(n-> System.out.println(n));
        System.out.println();
        for (Employee e: employees) {
            System.out.println(e);
        }
        System.out.println();

        List<MinimalDto> minimalDtos=employees.stream().filter(f->f.salary>20000 && f.designation=="CTO" || f.designation=="DCTO")
                .map(employee-> new MinimalDto(employee.id,employee.name,employee.address,employee.email))
                .collect(Collectors.toList());
        minimalDtos.stream().forEach(n-> System.out.println(n));

    }
}
