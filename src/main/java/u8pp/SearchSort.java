package u8pp;

import java.util.ArrayList;

public class SearchSort {
    public SearchSort(){
    }
    //seaches only the unsorted part and swaps to find the order of sorted from least to greatest
    public static void selectionSort(int[] numInput ) {
        int smallestIndex;
        for (int i = 0; i < numInput.length; i++){
            smallestIndex = i;
            for (int j = i; j < numInput.length; j++){
                if (numInput[j] < numInput[smallestIndex]){
                    smallestIndex = j;
                }
            }
            if (smallestIndex != i){
                swap(numInput, smallestIndex, i);
            }
        }
    }
    

    public static ArrayList<Student> selectionSort(ArrayList<Student> word) {
        int Index;
        ArrayList<Student> wordInput = new ArrayList<>();
        makeNew(wordInput, word);
        ArrayList<Student> words = new ArrayList<>();
        for (int i = 0; i < wordInput.size(); i++){
            Index = i;
            for (int j   = i; j < wordInput.size(); j++){
                if (Student.compare(wordInput.get(Index), wordInput.get(j))> 0){
                    Index = j;
                }
            }
            words.add(wordInput.get(Index));
            if (Index != i){
                swap(wordInput, Index, i);
            }
        }
        return words;
    }

    //only inserts the given value in the correct spot
    //everythign else moves around it
    public static void insertionSort(int[] input) {
        for (int i = 1; i < input.length; i++) {
            for (int j = i; j > 0; j--) {
                if (input[j - 1] > input[j]) {
                    swap (input, j, j-1);
                }
            }
        }
    }

    public static ArrayList<Student> insertionSort(ArrayList<Student> word) {
        ArrayList<Student> wordInput = new ArrayList<>();
        makeNew(wordInput, word);
        for (int i = 1; i < wordInput.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (Student.compare(wordInput.get(j-1), wordInput.get(j))> 0) {
                    swap(wordInput, j, j-1);
                }
            }
        }
        return wordInput;
    }

    //factorial run 
    //keeps splitting inot smaller parts until it can compare just 2
    //recurisivly rebuids in a sorted way
    public static void mergeSort(int[] input) {
        int end = input.length;
        if (end < 2) {
        return;
        }
        int mid = end / 2;
        int[] left = new int[mid];
        int[] right = new int[end - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = input[i];
        }
        for (int i = mid; i < end; i++) {
            right[i - mid] = input[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(input, left, right, mid, end - mid);
    }

    public static ArrayList<Student> mergeSort(ArrayList<Student>  wordInput) {
        ArrayList<Student> input = new ArrayList<>();
        makeNew(input, wordInput);
        ArrayList<Student> last = new ArrayList<>();
        // if (input.size() <= 1){
            return input;
        // }
        // else{
        //     ArrayList<Student> left = new ArrayList<>();
        //     ArrayList<Student> right = new ArrayList<>();
        //     for (int i = 0; i < input.size()/2; i++){
        //         left.add(input.get(i));
        //     }
        //     for (int i = input.size()/2; i < input.size(); i++){
        //         left.add(input.get(i));
        //     }
        //     mergeSort(left);
        //     mergeSort(right);
        //     merge(last, left, right);
        // }
        // return last;
    }

    //helper method
    //swaps to things in a list
    private static void swap (int[] list, int start, int end){
        int temp = list[start];
        list[start] = list[end];
        list[end] = temp;
    }
    private static void swap(ArrayList<Student> list, int start, int end){
        Student temp =  list.get(start);
        list.set(start, list.get(end));
        list.set(end, temp);
    }

    //Helper method
    //does the reverse merging 
    private static void merge(int[] input, int[] left, int[] right, int mid, int halfMid) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < mid && j < halfMid) {
            if (left[i] <= right[j]) {
                input[k++] = left[i++];
            }
            else {
                input[k++] = right[j++];
            }
        }
        while (i < mid) {
            input[k++] = left[i++];
        }
        while (j < halfMid) {
            input[k++] = right[j++];
        }
    }

    private static void merge(ArrayList<Student> last, ArrayList<Student> left, ArrayList<Student> right) {
        for (int i= 0 ; i<left.size(); i++){
            for (int j = 0; j<right.size(); j++){
                if (Student.compare(left.get(i), right.get(j))> 0) {
                    last.add(left.get(i));
                    left.remove(i);
                    last.add(right.get(j));
                    right.remove(j);
                }
                else{
                    last.add(right.get(j));
                    right.remove(j);
                    last.add(left.get(i));
                    left.remove(i);
                }
            }
        }
    }

    //helper method 
    //makes a new list so that it doesnt modify the og
    private static void makeNew(ArrayList<Student> neww, ArrayList<Student> og){
        for (int i = 0; i < og.size(); i++){
            neww.add(og.get(i));
        }
    }
}
