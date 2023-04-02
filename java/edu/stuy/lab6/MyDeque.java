package edu.stuy.lab6;

import java.util.NoSuchElementException;
public class MyDeque<E>{

    // Instance variables
    private E[] data;
    private int size;
    private int start, end;

    private final int DEFAULT_CAPACITY = 10;
    // Constructors
    @SuppressWarnings("unchecked")
    public MyDeque(){
        data = (E[])new Object[DEFAULT_CAPACITY];
        size = 0;
        start = 0;
        end = 0;
    }
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
        data = (E[])new Object[initialCapacity];
        size = 0;
        start = 0;
        end = 0;
    }

    // Add a new value on the indicated side
    public void addFirst(E element) throws NullPointerException{
        nullElement(element);

        if(size == data.length){
            resize();
        }
        if(start == 0){
            start = data.length - 1;
        }else{
            start--;
        }

        if(size == 0){
            end = start;
        }

        data[start] = element;
        size++;
    }
    public void addLast(E element) throws NullPointerException{
        nullElement(element);
        if(size == data.length){
            resize();
        }
        if(end == data.length - 1){
            end = 0;
        }

        if (end != 0 || data[end] != null) {
            end++;
        }

        data[end] = element;
        size++;
    }

    // // Remove and return the element
    public E removeFirst() throws NoSuchElementException{
        emptyArray();
        E element = data[start];
        data[start] = null;
        start++;
        size--;
        return element;
    }
    public E removeLast() throws NoSuchElementException{
        emptyArray();
        E element = data[end];
        data[end] = null;
        end--;
        size--;
        return element;
    }

    // Return the element. Do not deleter elements.
    public E getFirst() throws NoSuchElementException{
        emptyArray();
        return data[start];
    }
    public E getLast() throws NoSuchElementException{
        emptyArray();
        return data[end];
    }

    // Return deque size
    public int size(){
        return size;
    }

    // // Getters

    // // Return data
    public E[] getData() throws NoSuchElementException{
        emptyArray();
        return data;
    }
    // // Return start
    public int getStart() throws NoSuchElementException{
        emptyArray();
        return start;
    }
    // // Return end
    public int getEnd() throws NoSuchElementException{
        return end;
    }

    // Resize the array. Double its length (data.length * 2)
    @SuppressWarnings("unchecked")
    private void resize() {
        E[] replacementArray = (E[])new Object[data.length*2];
        int startIndex = start;
        for(int i = 0; i < size; i++){
            replacementArray[i] = data[startIndex];
            if(startIndex == data.length-1){
                startIndex = 0;
            }
            else{
                startIndex++;
            }
        }
        data = replacementArray;
        start = 0;
        end = size - 1;

    }

    // Return the deque as string. Ex.:  "[hello, my, dear, friends!]"
    public String toString(){
        int startIndex = start;
        String representation = "[";
        for(int i = 0; i < size; i++){
            representation += data[startIndex] + (i != size -1 ? ", ": "");
            if(startIndex == data.length-1){
                startIndex = 0;
            }
            else{
                startIndex++;
            }
        }
        return representation + "]";
    }

    public void nullElement(E element) throws NullPointerException{
        if(element == null){
            throw new NullPointerException("Cannot insert a null element.");
        }
    }

    public void emptyArray() throws NoSuchElementException{
        if(size == 0){
            throw new NoSuchElementException("The dequeue is empty so the method cannot be executed.");
        }
    }
}