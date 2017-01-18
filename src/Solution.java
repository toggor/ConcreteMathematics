import java.util.ArrayList;

public class Solution {
    public static void main(String[] args)
    {
        ArrayList<String> s_from= new ArrayList<String>(), s_mid= new ArrayList<String>(), s_to = new ArrayList<String>();
        s_from.add("stick_1");
        s_mid.add("stick_2");
        s_to.add("stick_3");


        s_from.add("4");
        s_from.add("3");
        s_from.add("2");
        s_from.add("1");

        for(int i=s_from.size()-1; i>0; i--){
            System.out.println(s_from.get(i));
        }


        System.out.println(s_from.size()-1);

        moveRings(s_from, s_mid, s_to, s_from.size()-1);


    }


    public static void moveRings (ArrayList<String> s_from, ArrayList<String> s_mid, ArrayList<String> s_to, Integer number){
        if (number <= 0){
            System.out.println("N is invalid");
        }if (number>1){
            int i = number-1;
            moveRings(s_from,s_to,s_mid,i);

            System.out.println(s_from.get(s_from.size()-1)+": "+ s_from.get(0)+" -> "+s_to.get(0));
            s_to.add(s_from.get(s_from.size()-1));
            s_from.remove(s_from.size()-1);

            moveRings(s_mid,s_from,s_to,i);
        }
        else {
            if (number == 1){
                System.out.println(s_from.get(s_from.size()-1)+": "+ s_from.get(0)+" -> "+s_to.get(0));
                s_to.add(s_from.get(s_from.size()-1));
                s_from.remove(s_from.size()-1);
            }
        }
    }
}