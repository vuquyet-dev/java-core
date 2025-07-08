package Test;


import java.util.Scanner;

public class Demo{
    public static void main(String[] args) {
        int a = 80;
        boolean check = false;
        System.out.println(2);
        System.out.println(3);
        for(int i = 4; i <= 80; i++)
        {
            for(int j = 2; j <= i; j++){
                if(i % j == 0 ) check = false;
            }
            check = true;
        }
    }
}