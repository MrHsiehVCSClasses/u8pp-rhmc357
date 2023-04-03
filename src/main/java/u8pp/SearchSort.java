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
    

    public static ArrayList<Student> selectionSort(ArrayList<Student> wordInput) {
        // int nextStudent;
        // for (int i = 0; i < wordInput.size(); i++){
        //     nextStudent = i;
        //     for (int j = 0; j < wordInput.size(); j++){
        //         if (wordInput.get(j).getYear() > wordInput.get(nextStudent).getYear() ){
        //             nextStudent = j;
        //         }
        //         // else if (wordInput.get(j).getYear() == wordInput.get(nextStudent).getYear() ) {
        //         //     if (wordInput.get(j).getLastName().compareTo( wordInput.get(nextStudent).getLastName()) < 0 ){
        //         //         nextStudent = j;
        //         //     }
        //         //     else if (wordInput.get(j).getLastName().compareTo( wordInput.get(nextStudent).getLastName()) == 0){
        //         //         if (wordInput.get(j).getFirstName().compareTo( wordInput.get(nextStudent).getFirstName()) < 0){
        //         //             nextStudent = j;
        //         //         }
        //         //     }
        //         // }
        //     }
        //     if (nextStudent != i){
        //         Student temp = wordInput.get(nextStudent);
        //         wordInput.set(nextStudent, wordInput.get(i));
        //         wordInput.set(i, temp);
        //     }
        // }
        int Index;
        ArrayList<Student> words = new ArrayList<>();
        for (int i = 0; i < wordInput.size(); i++){
            Index = i;
            for (int j = i; j < wordInput.size(); j++){
                // if (wordInput.get(Index).getYear() < wordInput.get(j).getYear()){
                //     Index = j;
                // }
                if (wordInput.get(Index).getYear() == wordInput.get(j).getYear()){
                    if (wordInput.get(Index).getLastName().compareTo( wordInput.get(Index).getLastName()) > 0){
                        Index = j;
                    }
                    else if (wordInput.get(Index).getLastName().compareTo( wordInput.get(Index).getLastName()) == 0){
                        if (wordInput.get(Index).getFirstName().compareTo( wordInput.get(Index).getFirstName()) > 0){
                            Index = j;
                        }
                    }
                }
                else if (wordInput.get(Index).getYear() < wordInput.get(j).getYear()){
                    Index = j;
                }
                // if (numInput[j] < numInput[smallestIndex]){
                //     smallestIndex = j;
                // }
            }
            words.add(wordInput.get(Index));
            // wordInput.remove(Index);
        }
        return words;
    }

    //only inserts the given value in the correct spot
    //everythign else moves around it
    public static void insertionSort(int[] input) {
        for (int i = 1; i < input.length; i++) {
            for (int j = i; j > 0; j--) {
                if (input[j - 1] > input[j]) {
                    int temp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = temp;
                }
            }
        }
    }

    //helper method
    //swaps to things in a list
    private static void swap (int[] list, int start, int end){
        int temp = list[start];
        list[start] = list[end];
        list[end] = temp;
    }

    public static ArrayList<Student> insertionSort(ArrayList<Student> wordInput) {
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

    //Helper method
    //does the reverse merging 
    public static void merge(int[] input, int[] left, int[] right, int mid, int halfMid) {
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

    public static ArrayList<Student> mergeSort(ArrayList<Student>  wordInput) {
        return wordInput;
    }
}
