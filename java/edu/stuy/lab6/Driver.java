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

//            test3.addFirst(null);
//            test3.addLast(null);

            MyDeque<String> test4 = new MyDeque<String>(2);
            test4.addFirst("James");
            test4.addLast("says");
            System.out.println(test4);
            test4.addLast("bye");
            System.out.println(test4);
            test4.addFirst("Mr."); 
            System.out.println(test4);

            System.out.println();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

}
