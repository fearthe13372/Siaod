package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class ReHash {
    static int MaxN = 10; //Размерность таблицы
    static String[] mas = new String[MaxN];
    static int [] bufMas = new int[MaxN];
    static boolean[] masFlag = new boolean[MaxN];
    static String sstr;
    static int j,c,n;

    public static void initArray(){

        //Процедура инициализации массива (хеш-таблицы).
        //Массив типа string, '' - пустая ячейка.

    int j;

    for ( j = 0; j <MaxN ; j++)
    {
    mas[j]= "";
    masFlag[j]= true;
    } }
    public static void printMas(){
        for (int i = 0; i <MaxN; i++) {
            System.out.println("i = "+i+" mas = "+mas[i] +" bufMas ="+bufMas[i] );
        }
    }
    public static int hash(String str) {
        int hash;
        hash = Integer.parseInt(str)%MaxN;
        return hash;
    }
    public static int rhash(int ii, int c, String str) {
        //Разрешение коллизий. Подбирает новый адрес для элемента,
        //если место, которое ему определила хеш-функция, занято.
        //ii - ii-й элемент последовательности проб;
        //c - фиксированный шаг;
        //str - текущий элемент.
        //Прим. Для того, чтобы все ячейки оказались просмотренными по одному разу,
        //необходимо, чтобы "с" было взаимно-простым с размером хеш-таблицы (maxn).
        //например, такой метод - линейное пробирование
        int srhash = (hash(str) + c * ii) % MaxN;
        return srhash;
    }

    public static int rhashPsevd(int ii, String str) {

        int srhash = (hash(str) + Main.rnd(1,9) * ii) % MaxN;
        return srhash;
    }
    public static void AddHash(int j, int c, int n) {
        String str;
        //Процедура добавления элемента в таблицу. Здесь с - шаг,
        // j - cчетчик элементов, str - вводимая строка n - сколько свобод ячеек

        int f=0;
        int i, ii;
        //В случае, если потребуется подбирать свободное
        //        место для элемента в таблице, начинать всегда
        //        нужно с начала. Поэтому i=0


        Scanner scanner = new Scanner(System.in);

        i = 0;  //переменная для rhash

        if (n == 0)
            System.out.println("Таблица заполнена");
        else {

           // j++; // счетчик для элементов
            System.out.println("Элемент " + j);
            str = scanner.nextLine();
            bufMas[j]=Integer.parseInt(str);
            ii = hash(str);  //получения адреса для хранения элемента в хеш-таблице
            while (true) {

                //ячейка по определенному хеш-функцией адресу пуста
                if (ii <= MaxN) {

                    if (mas[ii].equals("") ) {

                        mas[ii] = str;
                        //добавляем элемент в ячейку
                        masFlag[ii] = false;
                        //помечаем как занятую
                        n--;
                        break;
                        //выходим для дальшейших операций
                    }
                    //по указанному адресу лежит элемент-клон
                    if (((!mas[ii].equals("")) && (mas[ii].equals(str))) ) {

                        mas[ii] = str;  //заменяем его (они ведь одинаковы)
                        masFlag[ii] = false; // помечаем ячейку как занятую
                        j--;  //элемент заменился, значит счетчик не увеличиваем
                        break;  //выходим для дальшейших операций
                    }
                    //по указанному адресу уже есть элемент, отдичный от текущего
                    if ((!mas[ii].equals("") && (!mas[ii].equals(str))) )

                        ii = rhash(i, c, str);  //меняем адрес элементу во избежание коллизии

                    //проверяем таблицу на наличие свободного места
                } else {
                    ii = rhash(i, c, str);

                     // в случае, если адрес, выданный rhash, тоже занят, продолжаем поиск

                }
                i++;
            }


        }

    printMas();
    }
    public static void DeleteHash(int j, int n,int c){
        //Процедура удаления элемента по адресу в таблице.
        //Здесь j - номер вводимого элемента, c -шаг

    String str;
    int i,ii ;
    i =1;
    //переменная для rhash
        System.out.println("Введите элемент для удаления:");
        Scanner scanner = new Scanner(System.in);
    str=scanner.nextLine();
    //вводим элемент
    ii = hash(str);
    //вычисляем его адрес



  while (true) {

    if (ii <=MaxN) {
        //ищем в таблице
        if (mas[ii].equals("") || ( mas[ii].equals(str) && masFlag[ii]))
        {

            System.out.println("Элемент не найден");
            break;
        }
         //находим

        if (mas[ii].equals( str)  && !masFlag[ii]) {
            //Помечаем ячейку как свободную.Элемент при этом не удаляем.
            //Добавляемый в нее элемент просто перезапишет пред.значение


            masFlag[ii]=true;
            bufMas[Arrays.binarySearch(bufMas,Integer.parseInt(str))]=Integer.MIN_VALUE;//делаю метку, какой удален
            System.out.println("Элемент удален");
            n++;
            j--;
            //элемент удален, уменьшаем счетчик
            break;
        }
    }
    //Поиск другого адреса.Это значит, что элемент был
      //        добавлен в таблицу с применением функции rhash, т.е.выдачей
      //        ему нового адреса из -за конфликта с другим элементом.

    ii = rhash(i, c, str);

    i++;
    //переменная для rhash
    }
  printMas();
}
    public static void SearchHash(int c)    {
        //Процедура для поиска элемента в таблице по хеш-адресу.
        //Здесь c - шаг
        String  str;
    int i, ii;

    i = 1;  //переменная для rhash
        System.out.println("Введите элемент для поиска: ");
        Scanner scanner = new Scanner(System.in);
    str=scanner.nextLine();//вводим элемент для поиска
    ii = hash(str);  //вычисляем его адрес в таблице
  while (true) {

    if (ii <= MaxN) {

     //ищем
      if (mas[ii].equals("") ) {
          System.out.println("Элемент не найден");
        break;
      }

    //нашли
      if (mas[ii].equals( str)){
          System.out.println("Адрес: "+ ii+" сравнений: "+ i);
        break;  //прекращаем поиск
      }
    }
        //Поиск другого адреса. Это значит, что элемент был
      //        добавлен в таблицу с применением функции rhash, т.е. выдачей
      //        ему нового адреса из-за конфликта с другим элементом.

    ii = rhash(i, c, str);
        //rhash присвоил недопустимый адрес
      //        для ячейки или ячейка со стандартным адресом пуста
    i++;
    //переменная для rhash

  }
  printMas();
    }
    public static void SearchHashPsevd(int c)    {
        //Процедура для поиска элемента в таблице по хеш-адресу.
        //Здесь c - шаг
        String  str;
        int i, ii;

        i = 1;  //переменная для rhash
        System.out.println("Введите элемент для поиска: ");
        Scanner scanner = new Scanner(System.in);
        str=scanner.nextLine();//вводим элемент для поиска
        ii = hash(str);  //вычисляем его адрес в таблице
        while (true) {

            if (ii <= MaxN) {

                //ищем
                if (mas[ii].equals("") ) {
                    System.out.println("Элемент не найден");
                    break;
                }

                //нашли
                if (mas[ii].equals( str)){
                    System.out.println("Адрес: "+ ii+" сравнений: "+ i);
                    break;  //прекращаем поиск
                }
            }
            //Поиск другого адреса. Это значит, что элемент был
            //        добавлен в таблицу с применением функции rhash, т.е. выдачей
            //        ему нового адреса из-за конфликта с другим элементом.

            ii = rhashPsevd(i, str);
            //rhash присвоил недопустимый адрес
            //        для ячейки или ячейка со стандартным адресом пуста
            i++;
            //переменная для rhash

        }
        printMas();
    }
    public static void StartReHashProst(){
    initArray();
        System.out.println("init");
        for (int i = 0; i <10; i++) {
            AddHash(i,1,10);
        }
    SearchHash(1);

    }
    public static void StartReHashPsevd(){
        initArray();
        System.out.println("init");
        for (int i = 0; i <10; i++) {
            AddHash(i,1,10);
        }
        SearchHashPsevd(1);

    }

}


