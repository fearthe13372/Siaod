package com.company.Lab4;

import java.util.Stack;

public class Labbb {
    public static Stack<String> slov= new Stack<>();
    public static int first=-1;
    public static int second=-1;
    public static int top=-1;
    public static void zapoln(String [] s) {

        for (int i = 0; i < s.length; i++) {
            slov.push(s[i]);
        }
    }

    public static void start() {
        String d;
        int l=slov.size();
        for (int i = 0; i <l; i++) {
            d=slov.pop();
            if(first==-1&&(d.equals("0")||d.equals("1")||d.equals("2")||d.equals("3")||d.equals("4")||d.equals("5")||d.equals("6")||d.equals("7")||d.equals("8")||d.equals("9")))
            {
                first=Integer.parseInt(d);
             //   System.out.println("firs="+first);
                continue;
            }
            if(second==-1&&(d.equals("0")||d.equals("1")||d.equals("2")||d.equals("3")||d.equals("4")||d.equals("5")||d.equals("6")||d.equals("7")||d.equals("8")||d.equals("9")))
            {
                second=Integer.parseInt(d);

               // System.out.println("second="+second);
                continue;
            }
            if(d.equals("m")&&first!=-1&&second!=-1){
                top=Math.min(first,second);

              //  System.out.println("firs="+first+"second="+second +"top="+top+"m");
                first=-1;
                second=-1;
                continue;
            }
            if(d.equals("m")&&first!=-1){
                top=Math.min(first,top);
                //System.out.println("firs="+first+"top="+top+"M");
                first=-1;

                continue;
            }

            if(d.equals("M")&&first!=-1&&second!=-1){
                top=Math.max(first,second);
               // System.out.println("firs="+first+"second="+second +"top="+top+"M");
                first=-1;
                second=-1;
                continue;
            }
            if(d.equals("M")&&first!=-1){
                top=Math.max(first,top);
                first=-1;
                //System.out.println("firs="+first +"top="+top+"M");


            }
        }
    }
    public static void main(String[] args) {
        zapoln(new String[]{"M", "(", "5", ",", "m", "(", "6", ",", "8", ")", ")"});
        start();
        System.out.println(top);


    }
}
