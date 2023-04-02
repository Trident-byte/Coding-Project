package edu.stuy.lab6;

public class Driver{
    public static void main(String[] args){
        try{
            MyDeque<String> test3 = new MyDeque<String>(10);

//            test3.removeFirst();
//            test3.removeLast();

            test3.addFirst("Hello");
            test3.addLast("James");
            test3.addFirst("Well");
            test3.addLast("Wane");
            System.out.println(test3);
            test3.removeFirst();
            test3.removeLast();
            System.out.println(test3);
            System.out.println(test3.getEnd());
            System.out.println(test3.getStart());

            Object[] array= test3.getData();
            String arrayString = "";
            for(int i = 0; i < array.length; i++){
                arrayString += array[i] + ", ";
            }
            System.out.println(arrayString);
            System.out.println();


            MyDeque<String> test4 = new MyDeque<String>(2);
            test4.addFirst("James");
            test4.addLast("says");
            System.out.println(test4);
            test4.addLast("bye");
            System.out.println(test4);
            test4.addFirst("Mr.");
            System.out.println(test4);

            System.out.println();

            MyDeque<String> q = new MyDeque<>();
            q.addFirst("Hello");
            q.addLast("James");
            q.addFirst("Well");
            q.addLast("Wane");

            System.out.println(q.getFirst());
            System.out.println(q.getLast());
            System.out.println(q.size());
            System.out.println(q.toString());
            System.out.println(q.removeFirst());
            System.out.println(q.removeLast());

            MyDeque<String> test5 = new MyDeque<>();
            test5.addFirst("Hello");
            test5.addLast("James");
            test5.addFirst("Well");
            test5.addLast("Wane");
            test5.addLast("what");
            test5.addLast("is");
            test5.addLast("your");
            test5.addLast("problem");
            test5.addLast("AI");
            test5.addLast("will");
            test5.addLast("be");
            test5.addLast("the");
            test5.addLast("future");
            test5.addLast("of");
            test5.addLast("computing");
            test5.addFirst("Hola");
            System.out.println(test5.size());
            System.out.println(test5.toString());

            Object[] array2= test5.getData();
            String arrayString2 = "";
            for(int i = 0; i < array2.length; i++){
                arrayString2 += array2[i] + ", ";
            }
            System.out.println(arrayString2);
            System.out.println();


        } catch(Exception e){
            e.printStackTrace();
        }

        try{
            MyDeque<String> test3 = new MyDeque<String>(10);
            test3.removeFirst();
        }catch(Exception e){
            System.out.println("Error: The dequeue is empty so the method cannot be executed.");
        }

        try{
            MyDeque<String> test3 = new MyDeque<String>(10);
            test3.removeLast();
        }catch(Exception e){
            System.out.println("Error: The dequeue is empty so the method cannot be executed.");
        }

        try{
            MyDeque<String> test3 = new MyDeque<String>(10);
            test3.addFirst(null);
        }catch(Exception e){
            System.out.println("Error: Cannot insert a null element");
        }

        try{
            MyDeque<String> test3 = new MyDeque<String>(10);
            test3.addLast(null);
        }catch(Exception e){
            System.out.println("Error: Cannot insert a null element");
        }

        try{
            MyDeque<String> test3 = new MyDeque<String>(10);
            test3.getData();
        }catch(Exception e){
            System.out.println("Error: The dequeue is empty so the method cannot be executed.");
        }

        try{
            MyDeque<String> test3 = new MyDeque<String>(10);
            test3.getEnd();
        }catch(Exception e){
            System.out.println("Error: The dequeue is empty so the method cannot be executed.");
        }

        try{
            MyDeque<String> test3 = new MyDeque<String>(10);
            test3.getFirst();
        }catch(Exception e){
            System.out.println("Error: The dequeue is empty so the method cannot be executed.");
        }

        try{
            MyDeque<String> test3 = new MyDeque<String>(10);
            test3.getLast();
        }catch(Exception e){
            System.out.println("Error: The dequeue is empty so the method cannot be executed.");
        }

        try{
            MyDeque<String> test3 = new MyDeque<String>(10);
            test3.getStart();
        }catch(Exception e){
            System.out.println("Error: The dequeue is empty so the method cannot be executed.");
        }
    }


}
