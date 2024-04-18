package codingBat;

public class ConstructorExample {

        int id;
        String name;

        ConstructorExample(String n, Integer i){
            id=i;
            name=n;
        }

    public static void main(String[] args) {
        ConstructorExample student1=new ConstructorExample("Ram",1);
        ConstructorExample student2=new ConstructorExample("Ram",1);

        System.out.println(student1.equals(student2));
    }
}
