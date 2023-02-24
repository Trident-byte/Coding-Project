class Driver{
    public static void main(String[] args){
        //Put tests in here
        try {
            SavingsAccount savings = new SavingsAccount("Ba", 100, 1.2);
            savings.addInterest();
            System.out.println(savings.getBalance());
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}