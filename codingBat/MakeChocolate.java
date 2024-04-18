package codingBat;

public class MakeChocolate {
    public int makeChocolate(int small, int big, int goal) {
        if(goal>big*5+small){
            return -1;
        }

        if(goal>=big*5){
            if ((goal-big*5)<=small){
                return goal-big*5;
            }
        } else if(goal<big*5){
            if(goal%5<=small){
                return (goal%5);
            }
        }
        return -1;

    }

    public static void main(String[] args){
        MakeChocolate obj=new MakeChocolate();
        System.out.println(obj.makeChocolate(6,2,7));
    }
}
