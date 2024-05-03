package my_list;

import java.util.Comparator;
import java.util.SplittableRandom;

public class MyArrayList<T> extends MyAbstractList<T>{

    private Object[] values;
    private int size;
    private int arraySize;

    MyArrayList(){
        arraySize = 5;
        values = new Object[arraySize];
        size = 0;
    }

    private void newArray(){
        arraySize*=2;
        Object[] newValues = new Object[arraySize];
        for(int i = 0; i < values.length; i++){
            newValues[i] = values[i];
        }
        values = newValues;
    }

    public void add(T value){
        if(size == values.length){
            newArray();
        }
        values[size++] = value;
    }



    public T get(int index){
        if(index < size && index >= 0){
            return (T)values[index];
        } else{
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void set(int position, T value) {
        if(position >= 0 && position <= size - 1){
            values[position] = value;
        }else System.out.println("Неверный индекс.");
    }

    public void remove(int index){
        if(index < size && index >= 0){
            for(int i = index + 1; i < size; i++){
                values[i - 1] = values[i];
            }
            values[size - 1] = null;
            size--;
        } else{
            System.out.println("Error");
        }
    }

    public void add(int position, T value){
        if (position <= size && position >=0){
            if(size == values.length){
                newArray();
            }
            for(int i = size; i > position; i--){
                values[i] = values[i-1];
            }
            values[position] = value;
            size++;
        } else{
            System.out.println("Error");
        }
    }

    public boolean contains(T value){
        for (int i = 0; i < size; i++){
            if(values[i].equals(value)) return true;
        }
        return false;
    }

    public int indexOf(T value){
        for(int i = 0; i < size; i++){
            if(values[i].equals(value)) return i;
        }
        return  -1;
    }

    public int lastIndexOf(T value){
        for(int i = size - 1; i >= 0; i--){
            if(values[i].equals(value)) return i;
        }
        return  -1;
    }

    @Override
    public void sort(Comparator<T> comparator) {
        for(int i = 0; i < size-1; i++){
            for(int j = size - 1; j > i; j--){
                if(comparator.compare((T)values[j], (T)values[j - 1]) < 0){
                    Object temp = values[j];
                    values[j] = values[j-1];
                    values[j-1] = temp;
                }
            }
        }
    }

    public String toString(){
        String str = "[";
        for(int i = 0; i < size; i++){
            if(i < size - 1){
                str += values[i] + ", ";
            } else {
                str += values[i];
            }
        }
        str += "]";
        return str;
    }

    @Override
    public T[] toArray() {
        Object[] values = new Object[size];
        for (int i = 0; i < size; i++) {
            values[i] = this.values[i];
        }
        return (T[])values;
    }

    public int size() {
        return size;
    }


}
