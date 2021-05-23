package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	int [] array = StartGenerate();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
        System.out.println("/////");
        StartTreeFind(array);
        System.out.println("/////");
        binarySearch(array,0,array.length,  array[3]);
        System.out.println("/////");
        System.out.println("На позиции = " +fibFind(array,array[3]));
        System.out.println("/////");
        System.out.println("На позиции = " +(InterpolSearch(array,array[3])+1));

	    ReHash.StartReHashProst();
        ReHash.StartReHashPsevd();

        Ferzi.startFerzi();

    }
    public static int rnd(int min, int max){
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
    public static int [] StartGenerate(){
        int [] mas = new int[14];
        for (int i = 0; i <mas.length; i++) {
            mas[i]= rnd(0,130);
        }
        Arrays.sort(mas);
        return mas;
    }
    public static int [] insertElement(int[] array, int key, int posytion){
        int [] arrayNew = new int[array.length+1];
        int i=0;
        posytion--;
        while(i!=posytion){
            arrayNew[i]=array[i];
            i++;
        }
        arrayNew[posytion]=key;
        i++;
        while(i!=arrayNew.length-1){
            arrayNew[i+1]=array[i];
            i++;
        }
        return arrayNew;
    }
    public static void deleteElement(int[] array, int posytion ){
        for (int i = posytion-1; i <array.length-1; i++) {
            array[i]=array[i+1];
        }
    }
    public static void StartTreeFind(int [] array){
        Tree tree = new Tree();
        // вставляем узлы в дерево:
        for (int i = 0; i < array.length; i++) {
            tree.insertNode(array[i]);
        }


        // находим узел по значению и выводим его в консоли
        Node foundNode = tree.findNodeByValue(array[3]);
        foundNode.printNode();
    }
    public static void binarySearch(int[] array, int first, int last, int item) {
        int position;
        int comparisonCount = 1;    // для подсчета количества сравнений

        // для начала найдем индекс среднего элемента массива
        position = (first + last) / 2;

        while ((array[position] != item) && (first <= last)) {
            comparisonCount++;
            if (array[position] > item) {  // если число заданного для поиска
                last = position - 1; // уменьшаем позицию на 1.
            } else {
                first = position + 1;    // иначе увеличиваем на 1
            }
            position = (first + last) / 2;
        }
        if (first <= last) {
            System.out.println(item + " является " + ++position + " элементом в массиве");
            System.out.println("Метод бинарного поиска нашел число после " + comparisonCount +
                    " сравнений");
        } else {
            System.out.println("Элемент не найден в массиве. Метод бинарного поиска закончил работу после "
                    + comparisonCount + " сравнений");
        }
    }
    public static int fibFind(int [] array,int key){
        int f=1,s=1,i=f+s;
        if(array[0]==key)
            return 0;
        if(array[1]==key)
            return 1;
        while (key>array[i]){
            f=s;
            s=i;
            i=s+f;
            if(i>=array.length){
                break;
            }
        }
        if(array[i]==key)
            return i+1;
        else {
            int f1=0,s1=1,i1=f1+s1;
            while (array[s+i1]<key){
                f1=s;
                s1=i;
                i1=s+f;
                if(s+i1> array.length){
                    i=-1;
                    break;
                }
            }

        }
        return i;
    }
    public static int InterpolSearch(int A[], int key){
        int mid, left=0, right=A.length-1;
        while (A[left]<=key && A[right]>=key)
        {
            mid=left+((key-A[left])*(right-left))/(A[right]-A[left]);
            if (A[mid]<key) left=mid+1;
            else if (A[mid]>key) right=mid-1;
            else return mid;
        }
        if (A[left]==key) return left;
        else return -1;
    }
 }
