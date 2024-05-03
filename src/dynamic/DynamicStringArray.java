package dynamic;

import java.sql.SQLOutput;

public class DynamicStringArray {

    private String[] words;
    private int size;
    private int arraySize;

    DynamicStringArray(){
        arraySize = 5;
        words = new String[arraySize];
        size = 0;
    }

    private void newArray(){
        arraySize*=2;
        String[] newWords = new String[arraySize];
        for(int i = 0; i < words.length; i++){
            newWords[i] = words[i];
        }
        words = newWords;
    }

    public void add(String str){
        if(size == words.length){
            newArray();
        }
        words[size++] = str;
    }

    public String get(int index){
        if(index < size && index >= 0){
            return words[index];
        } else{
            return "Error";
        }
    }

    public void remove(int index){
        if(index < size && index >= 0){
            for(int i = index + 1; i < size; i++){
                words[i - 1] = words[i];
            }
            words[size - 1] = null;
            size--;
        } else{
            System.out.println("Error");
        }
    }

    public void addToPos(int index, String str){
        if (index <= size && index >=0){
            if(size == words.length){
                newArray();
            }
            for(int i = size; i > index; i--){
                words[i] = words[i-1];
            }
            words[index] = str;
            size++;
        } else{
            System.out.println("Error");
        }
    }

    public boolean contains(String str){
        for (int i = 0; i < size; i++){
            if(words[i].equals(str)) return true;
        }
        return false;
    }

    public int indexOf(String str){
        for(int i = 0; i < size; i++){
            if(words[i].equals(str)) return i;
        }
        return  -1;
    }

    public int lastIndexOf(String str){
        for(int i = size - 1; i >= 0; i--){
            if(words[i].equals(str)) return i;
        }
        return  -1;
    }

    public void arrayDem(){
        for(String s: words){
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public int size() {
        return size;
    }


}
