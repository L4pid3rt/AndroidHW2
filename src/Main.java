import java.util.Arrays;
import java.util.Random;

public class Main {

    static Random random = new Random();

    public static void main(String[] args) {

        //1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

        byte[] byteArr = {1,1,0,0,1,0,1,1,0,0};
        changeNumbers(byteArr);

        //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

        int[] intArr = new int[8];
        createArr(intArr);

        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        // пройти по нему циклом, и числа меньшие 6 умножить на 2

        int[] secondIntArr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        multiplyNumbers(secondIntArr);

        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

        int[][] squareArr = new int[5][5];
        changeDiagonal(squareArr);

        //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] thirdIntArray = new int[20];
        thirdIntArray = getRandomArr(thirdIntArray.length);
        searchElements(thirdIntArray);

        //6.Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
        // если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
        // checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят

        int[] fourthIntArr = {2, 2, 2, 1, 2, 2, 10, 1};
        if (checkBalance(fourthIntArr)){
            System.out.println("Массив сбалансирован");
        } else {
            System.out.println("Массив не сбалансирован");
        }

        //7. **** Написать метод, которому на вход подается одномерный массив и число n
        // (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива
        // на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.

        int[] fifthIntArr = new int[10];
        fifthIntArr = getRandomArr(10);
        System.out.println(Arrays.toString(rollArr(fifthIntArr, 3)));
        System.out.println(Arrays.toString(rollArr(fifthIntArr, -3)));
    }

    static void changeNumbers (byte[] a) {
        System.out.println(Arrays.toString(a));
        for (int i = 0; i <a.length ; i++) {
            if (a[i] == 1){
                a[i] = 0;
            } else {
                a[i] = 1;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    static void createArr (int[] a) {
        for (int i = 0; i <a.length; i++) {
            a[i] = i*3;
        }
        System.out.println(Arrays.toString(a));
    }

    static void multiplyNumbers (int[] a){
        for (int i = 0; i <a.length; i++) {
            if (a[i] < 6) {
                a[i] = a[i] * 2;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    static void changeDiagonal (int[][] a){
        for (int i = 0; i <a.length; i++) {
            a[i][i] = 1;
            a[i][a.length - 1 - i] = 1;
        }

        for (int i = 0; i <a.length; i++) {
            for (int j = 0; j <a[i].length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static int[] getRandomArr(int lengthArr){
        int[] arr = new int[lengthArr];
        for (int i = 0; i <lengthArr; i++) {
            arr[i] = random.nextInt(50);
        }
        return arr;
    }

    static void searchElements(int[] a){
        int max = a[0];
        int min = a[0];
        for (int i = 0; i <a.length; i++) {
            if (a[i] > max){
                max = a[i];
            }
            if (a[i] < min){
                min = a[i];
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println("Минимальное число " + min);
        System.out.println("Максимальное число " + max);
    }

    static boolean checkBalance (int[] a){
        int sum1;
        int sum2;
        for (int i = 0; i <a.length; i++) {
            sum1 = 0;
            sum2 = 0;
            for (int j = 0; j <i; j++) {
                sum1 = sum1 + a[j];
            }
            for (int j = i; j <a.length ; j++) {
                sum2 = sum2 + a[j];
            }
            if (sum1 == sum2){
                return true;
            }
        }
        return false;
    }

    static int[] rollArr(int[] arr, int n){
        if (n>0){
            for (int i = 0; i < n; i++) {
                arr = arrForwardRotation(arr);
            }
        } else if (n < 0) {
            for (int i = 0; i < -n; i++) {
                arr = arrBackRotation(arr);
            }
        }
        return arr;
    }

    static int[] arrForwardRotation(int[] a){
        int arrElement = a[0];
        for (int i = 0; i <a.length-1; i++) {
            a[i] = a[i + 1];
        }
        a[a.length - 1] = arrElement;
        return a;
    }

    static int[] arrBackRotation(int[] a){
        int arrElement = a[a.length - 1];
        for (int i = a.length - 1; i > 0; i--) {
            a[i] = a[i - 1];
        }
        a[0] = arrElement;
        return a;
    }

    }
