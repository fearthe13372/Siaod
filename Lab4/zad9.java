package com.company.Lab4;

import java.util.Stack;

public class zad9 {
    public static Stack<String> slov= new Stack<>();
    public static String first="NULL";
    public static String second="NULL";
    public static String top="NULL";
    public static String logZnach="NULL";
    public static String tokenNot="NULL";
    public static void zapoln(String [] s) {

        for (int i = 0; i < s.length; i++) {
            slov.push(s[i]);
        }
    }

    public static void sd() {

        //для одного знач
        if(logZnach.equals("N")&&(first.equals("NULL")&&!top.equals("NULL")&&tokenNot.equals("NULL"))){
            if(top.equals("T")){
                top="F";

                logZnach="NULL";
                tokenNot="YES";
                //System.out.println("SDDDD N firs= "+first +" top="+top+" logznach="+logZnach+"Token="+tokenNot);

            }
            if(top.equals("F")){
                top="T";
                logZnach="NULL";
                tokenNot="YES";
                //System.out.println("SDDDD N firs= "+first +" top="+top+" logznach="+logZnach+"Token="+tokenNot);

            }


        }
        if(logZnach.equals("A")&&(!top.equals("NULL")&&!first.equals("NULL"))){
            if((first.equals("T")&&top.equals("F"))||(first.equals("F")&&top.equals("T"))){
                top="F";
                first="NULL";
                logZnach="NULL";
               // System.out.println("od A firs= "+first +"top="+top+" logznach="+logZnach);


            }else{ if(first.equals("T")&&top.equals("T")){
                top="T";
                first="NULL";

                logZnach="NULL";
               // System.out.println("od A firs= "+first +"top="+top+" logznach="+logZnach);


            }else{
                top="F";
                first="NULL";
                logZnach="NULL";
               // System.out.println("od A firs= "+first +"top="+top+" logznach="+logZnach);


            }
            }
            //System.out.println("firs="+first+"top="+top+"M");



        }
        if(logZnach.equals("X")&&(!top.equals("NULL")&&!first.equals("NULL"))){
            if((first.equals("T")&&top.equals("T"))||(first.equals("F")&&top.equals("F"))){
                top="F";
                first="NULL";
                logZnach="NULL";
                //System.out.println("od X firs= "+first +"top="+top+" logznach="+logZnach);

            }
            else{
                top="T";
                first="NULL";
                logZnach="NULL";
                //System.out.println("od X firs= "+first +"top="+top+" logznach="+logZnach);
            }

        }
        if(logZnach.equals("O")&&(!top.equals("NULL")&&!first.equals("NULL"))){
            if(first.equals("F")&&top.equals("F")){
                top="F";
                first="NULL";
                logZnach="NULL";
              //  System.out.println("od O firs= "+first +"top="+top+" logznach="+logZnach);
            }
            else{
                top="T";
                first="NULL";
                logZnach="NULL";
                //System.out.println("od O firs= "+first +"top="+top+" logznach="+logZnach);
            }

        }

    }
    public static void start() {
        String d;
        int l=slov.size();
        for (int i = 0; i <l; i++) {
            d=slov.pop();
            if(first.equals("NULL")&&(d.equals("T")||d.equals("F"))){
                first=d;
              //  System.out.println(" zapolneneie firs= "+first);
                continue;
            }
            if(logZnach.equals("NULL")&&(d.equals("N")||d.equals("A")||d.equals("X")||d.equals("O"))){
                logZnach=d;
                tokenNot="NULL";
               // System.out.println(" zapolneneie logZnach "+logZnach);
                continue;
            }
            if(second.equals("NULL")&&(d.equals("T")||d.equals("F"))){
                second=d;

               // System.out.println(" zapolneneie second= "+second);
                continue;
            }
            if(logZnach.equals("N")&&(!first.equals("NULL")&&tokenNot.equals("NULL"))){
                if(first.equals("T")){
                    top="F";
                    first="NULL";
                    logZnach="NULL";
                    tokenNot="YES";
                //    System.out.println(" N firs= "+first +" top="+top+" logznach="+logZnach+"Token="+tokenNot);continue;

                }
                if(first.equals("F")){
                    top="T";
                    first="NULL";
                    logZnach="NULL";
                    tokenNot="YES";
                  //  System.out.println(" N firs= "+first +" top="+top+" logznach="+logZnach+"Token="+tokenNot);continue;

                }


            }
            if(logZnach.equals("A")&&(!first.equals("NULL")&&!second.equals("NULL"))){
                if((first.equals("T")&&second.equals("F"))||(first.equals("F")&&second.equals("T"))){
                    top="F";
                    first="NULL";
                    second="NULL";
                    logZnach="NULL";
                   // System.out.println(" A firs= "+first +"second="+second+ " top="+top+" logznach="+logZnach);

                }else{ if(first.equals("T")&&second.equals("T")){
                    top="T";
                    first="NULL";
                    second="NULL";
                    logZnach="NULL";
                 //   System.out.println(" A firs= "+first +"second="+second+ " top="+top+" logznach="+logZnach);

                }else{
                    top="F";
                    first="NULL";
                    second="NULL";
                    logZnach="NULL";
                 //   System.out.println(" A firs= "+first +"second="+second+ " top="+top+" logznach="+logZnach);

                }
                }
                //System.out.println("firs="+first+"top="+top+"M");


                continue;
            }
            if(logZnach.equals("X")&&(!first.equals("NULL")&&!second.equals("NULL"))){
                if((first.equals("T")&&second.equals("T"))||(first.equals("F")&&second.equals("F"))){
                    top="F";
                    first="NULL";
                    second="NULL";
                    logZnach="NULL";
                    //System.out.println(" X firs= "+first +"second="+second+ " top="+top+" logznach="+logZnach);

                }
                else{
                    top="T";
                    first="NULL";
                    second="NULL";
                    logZnach="NULL";
                   // System.out.println(" X firs= "+first +"second="+second+ " top="+top+" logznach="+logZnach);
                }
                continue;
            }
            if(logZnach.equals("O")&&(!first.equals("NULL")&&!second.equals("NULL"))){
                if(first.equals("F")&&second.equals("F")){
                    top="F";
                    first="NULL";
                    second="NULL";
                    logZnach="NULL";
                  //  System.out.println(" O firs= "+first +"second="+second+ " top="+top+" logznach="+logZnach);

                }
                else{
                    top="T";
                    first="NULL";
                    second="NULL";
                    logZnach="NULL";
                  //  System.out.println(" O firs= "+first +"second="+second+ " top="+top+" logznach="+logZnach);
                }
                continue;
            }
            ///OD
            if(logZnach.equals("N")&&(first.equals("NULL")&&!top.equals("NULL")&&tokenNot.equals("NULL"))){
                if(top.equals("T")){
                    top="F";

                    logZnach="NULL";
                    tokenNot="YES";
              //      System.out.println(" N firs= "+first +" top="+top+" logznach="+logZnach+"Token="+tokenNot);
                    continue;
                }
                if(top.equals("F")){
                    top="T";
                    logZnach="NULL";
                    tokenNot="YES";
                //    System.out.println(" N firs= "+first +" top="+top+" logznach="+logZnach+"Token="+tokenNot);
                    continue;
                }


            }
            if(logZnach.equals("A")&&(!top.equals("NULL")&&!first.equals("NULL"))){
                if((first.equals("T")&&top.equals("F"))||(first.equals("F")&&top.equals("T"))){
                    top="F";
                    first="NULL";
                    logZnach="NULL";
                  //  System.out.println("od A firs= "+first +"top="+top+" logznach="+logZnach);


                }else{ if(first.equals("T")&&top.equals("T")){
                    top="T";
                    first="NULL";

                    logZnach="NULL";
                  //  System.out.println("od A firs= "+first +"top="+top+" logznach="+logZnach);


                }else{
                    top="F";
                    first="NULL";
                    logZnach="NULL";
                  //  System.out.println("od A firs= "+first +"top="+top+" logznach="+logZnach);


                }
                }
                //System.out.println("firs="+first+"top="+top+"M");



            }
            if(logZnach.equals("X")&&(!top.equals("NULL")&&!first.equals("NULL"))){
                if((first.equals("T")&&top.equals("T"))||(first.equals("F")&&top.equals("F"))){
                    top="F";
                    first="NULL";
                    logZnach="NULL";
                //    System.out.println("od X firs= "+first +"top="+top+" logznach="+logZnach);

                }
                else{
                    top="T";
                    first="NULL";
                    logZnach="NULL";
                //    System.out.println("od X firs= "+first +"top="+top+" logznach="+logZnach);
                }

            }
            if(logZnach.equals("O")&&(!top.equals("NULL")&&!first.equals("NULL"))){
                if(first.equals("F")&&top.equals("F")){
                    top="F";
                    first="NULL";
                    logZnach="NULL";
                //    System.out.println("od O firs= "+first +"top="+top+" logznach="+logZnach);
                }
                else{
                    top="T";
                    first="NULL";
                    logZnach="NULL";
                //    System.out.println("od O firs= "+first +"top="+top+" logznach="+logZnach);
                }

            }
        }
        sd();
    }
    //Проверь при помощи sout
    public static void main(String[] args) {
        zapoln(new String[]{"T","X", "(", "T", "A", "(","N", "(", "F", "O", "T", ")", ")",")"});
        start();
        System.out.println(top);


    }
}
/*
struct List
{
    char data;
    List* next;
};

List* push_back(char, List*);
List* push_front(char, List*);
List* pop_front(List*);
void viewspis(List*);
void clearspis(List*)





///////////////////////////////////////////////
#include<iostream>
#include"modulSpis.h"
using namespace std;

List* push_back(char ch, List* head)
{
    List* newList = new List;
    newList->data = ch;
    newList->next = NULL;

    if(!head)
    {
        head = newList;
    }
    else
    {
        List* tec = head;
        while(tec->next)
        {
            tec = tec->next;
        }
        tec->next = newList;
    }

    return head;
}

List* push_front(char ch, List* head)
{
    List* newList = new List;
    newList->data = ch;
    newList->next = head;
    head = newList;
    return head;
}

void viewspis(List* first)
{
    while(first)
    {
        cout << first->data;
        first = first->next;
    }
}

void clearspis(List* first)
{
    List* temp = NULL;
    while(first)
    {
        temp = first;
        first = first->next;
        delete temp;
    }
}

List* pop_front(List* first)
{
    List* temp1 = first;
    first = first->next;
    delete temp1;
    return first;
}



///////////
using namespace std;

int main()
{
    setlocale(LC_ALL,"Russian");
    List* first = NULL;
    List* second = NULL;
    string formula;
    cout << "Введите формулу: " << endl;
    cin >> formula;
    int size = formula.size();
    for(int i = 0; i < size;)
    {
        if(formula[i] != ')')
        {
            if(formula[i] != '(')
            {
                first = push_front(formula[i],first);
            }
            i++;
        }

        else if(first->next)
        {
            char var = first->next->data;
            switch(var)
            {
            case 'N':
                {
                    if(first->data == 'T')
                    {

                        i++;
                        for(int t = 0; t < 2; t++)
                        {
                            first = pop_front(first);
                        }
                        first = push_front('F',first);
                    }
                    else
                    {
                        i++;
                        for(int t = 0; t < 2; t++)
                        {
                            first = pop_front(first);
                        }
                        first = push_front('T',first);
                    }
                }
            case 'A':
                {
                    if(first->data == 'T' && first->next->next->data == 'T')
                    {
                        i++;
                        for(int t = 0; t < 3; t++)
                        {
                            first = pop_front(first);
                        }
                        first = push_front('T',first);
                        break;
                    }
                    else
                    {
                        i++;
                        for(int t = 0; t < 3; t++)
                        {
                            first = pop_front(first);
                        }
                        first = push_front('F',first);
                        break;
                    }
                }
            case 'X':
                {
                    if(first->data == first->next->next->data)
                    {
                        i++;
                        for(int t = 0; t < 3; t++)
                        {
                            first = pop_front(first);
                        }
                        first = push_front('F',first);
                        break;
                    }
                    else
                    {
                        i++;
                        for(int t = 0; t < 3; t++)
                        {
                            first = pop_front(first);
                        }
                        first = push_front('T',first);
                        break;
                    }
                }
            case 'O':
                {
                    if(first->data == 'F' && first->next->next->data == 'F')
                    {
                        i++;
                        for(int t = 0; t < 3; t++)
                        {
                            first = pop_front(first);
                        }
                        first = push_front('F',first);
                        break;
                    }
                    else
                    {
                        i++;
                        for(int t = 0; t < 3; t++)
                        {
                            first = pop_front(first);
                        }
                        first = push_front('T',first);
                        break;
                    }
                }
            }
        }
    }


    viewspis(first);
    cout<<"\n";
    //viewspis(second);


    return 0;
}
 */