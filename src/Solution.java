import java.util.ArrayList;
import java.io.*;


public class Solution {
    public static void main(String[] args)
    {
        ArrayList<String> s_from= new ArrayList<String>(), s_mid= new ArrayList<String>(), s_to = new ArrayList<String>();
        Integer t_size = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter number for the size of tower.");


        while (!(t_size>=1 && t_size<=8)) {
            try {
                System.out.println("It should be between 1 and 8 not to wait too long");
                t_size = Integer.valueOf(reader.readLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.getClass());
            }
        }

        s_from = setTower(t_size);
        s_mid.add("stick_2");
        s_to.add("stick_3");


        System.out.println(s_from.size()-1);

        moveRings(s_from, s_mid, s_to, s_from.size()-1);


    }

    public static ArrayList<String> setTower (int n){
        ArrayList<String> s_from= new ArrayList<String>();
        s_from.add("stick_1");
            for(int i=n; i>0; i--){
                //System.out.println(s_from.get(i));
                s_from.add(String.valueOf(i));
            }
            return s_from;

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