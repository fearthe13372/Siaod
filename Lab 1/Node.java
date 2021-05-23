package sample;

public class Node {
    public int iData; //Данные(ключ)
    public int idd;
    public Node leftChild; // Левый потомок узла
    public Node rightChild; // Правый потомок узла
    public Node(int key){
        iData=key;
    }
    public Node(int key, int id){
        iData=key;
        idd=id;
    }
    public Node (){}

    public int getKey() {
        return iData;
    }
}
