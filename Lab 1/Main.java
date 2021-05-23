package sample;



public class Main  {
    private static int MAXINT=32767;
    public static void main(String[] args) {

        hello_World();
        int[][] firstArray = new int[50][50];
        generationMatrix(firstArray);
        System.out.println("default matrix");
        printMatrix(peredelVodnomer(firstArray));
        System.out.println("///////");
        int[][] obmenSortArray = firstArray;
        int[][] selectSortArray = firstArray;
        int[][] insertSortArray = firstArray;
        int[][] shelSortArray = firstArray;
        int[][] quickSortArray = firstArray;
        int[][] pyramidSortArray = firstArray;
        int[][] tourSortArray = firstArray;

        System.out.println("SelectSort:");
        selectionSort(selectSortArray);
        System.out.println();

        System.out.println("insertSort:");
        insertSort(insertSortArray);
        System.out.println();

        System.out.println("ObmenSort:");
        obmenSort(obmenSortArray);
        System.out.println();

        System.out.println("ShellSort:");
        shellSort(shelSortArray);
        System.out.println();

        System.out.println("QuickSort:");
         quickStart(quickSortArray);



        System.out.println();
        System.out.println("Pyramid");
        pyramidStart(pyramidSortArray);

        System.out.println();
        System.out.println("Tournament:");
        quickTourn(tourSortArray);


    }





    public static int getRandom (int min, int max){
        max -= min;//делаем число на min меньше чтобы сделать в дальнейшем диапазон от min до max-min, а потом сделать +1 - чтобы включить конечную границу и сделать +min
        return (int) (Math.random() * (++max)) + min;
    }
    public static void generationMatrix(int[][] matrix) {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                matrix[i][j] = getRandom(-250, 1014);
            }
        }
    }
    public static int[] peredelVodnomer(int[][] matrix) {
        int[] mass = new int[2500];
        for (int i = 0; i < 50; i++)
            for (int j = 0; j < 50; j++)//циклы прохода двумерного массива, опираясь на которые мы выражаем одномерный
            {
                mass[i * 50 + j] = matrix[i][j];
            }
        return mass;
    }
    public static void printMatrix(int[] mas) {

        int j = 0;
        for (int i = 0; i < 2500; i++) {
            if (j == 50) {
                System.out.println();
                j = 0;
            }
            System.out.print(mas[i] + " ");
            j++;
        }
    }
    public static void obmenSort(int[][] matrix) {
        int[] mass = peredelVodnomer(matrix);
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < mass.length; i++) {
                if (mass[i] < mass[i - 1]) {
                    swap(mass, i, i - 1);
                    needIteration = true;
                }
            }
        }
        printMatrix(mass);
    }
    public static void selectionSort(int[][] matrix) {
        int[] mas = peredelVodnomer(matrix);
        for (int left = 0; left < mas.length; left++) {
            int minInd = left;
            for (int i = left; i < mas.length; i++) {
                if (mas[i] < mas[minInd]) {
                    minInd = i;
                }
            }
            swap(mas, left, minInd);
        }
        printMatrix(mas);
    }
    public static void insertSort(int[][] matrix) {
        int[] mas = peredelVodnomer(matrix);
        for (int left = 0; left < mas.length; left++) {
            // Вытаскиваем значение элемента
            int value = mas[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < mas[i]) {
                    mas[i + 1] = mas[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            mas[i + 1] = value;

        }
        printMatrix(mas);
    }
    public static void shellSort(int [] [] matrix){
        int [] mas = peredelVodnomer(matrix);
        // Высчитываем промежуток между проверяемыми элементами
        int gap = mas.length / 2;
        // Пока разница между элементами есть
        while (gap >= 1) {
            for (int right = 0; right < mas.length; right++) {
                // Смещаем правый указатель, пока не сможем найти такой, что
                // между ним и элементом до него не будет нужного промежутка
                for (int c = right - gap; c >= 0; c -= gap) {
                    if (mas[c] > mas[c + gap]) {
                        swap(mas, c, c + gap);
                    }
                }
            }
            // Пересчитываем разрыв
            gap = gap / 2;
        }
        printMatrix(mas);
    }
    public static void quickStart(int [] [] matrix){
        int [] mas =peredelVodnomer(matrix);
        quickSort(mas,0,2499);
        printMatrix(mas);
    }
    public static void pyramidStart(int [] [] matrix){
        int [] mas =peredelVodnomer(matrix);
        HeapSort d= new HeapSort();
        d.sort(mas);
        printMatrix(mas);
    }
    public static void quickSort(int[]  source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];//определяется опорный элемент
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (source[leftMarker] < pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (source[rightMarker] > pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    swap(source,leftMarker,rightMarker);
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }
    public static void swap ( int[] array, int ind1, int ind2){
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
    public static void hello_World (){
        System.out.printf("Hello,World!\n");
    }
    public static void quickTourn(int [] [] matrix){
        int [] mas =peredelVodnomer(matrix);
        TournamentSort s = new TournamentSort();
        s.Sort(mas);
        printMatrix(mas);
    }
}


