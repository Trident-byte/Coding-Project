class Driver{
    public static void main(String[] args){
        //Put tests in here
        try {
            //Testing checking account
            CheckingAccount bank1 = new CheckingAccount("Ba", 100);
            System.out.println("The name of the checking account, bank1 is " + bank1.getName()); //Expecting Ba
            System.out.println("The balance of the checking account, bank1 is " + bank1.getBalance()); //Expecting 100

//          CheckingAccount bank3 = new CheckingAccount("Bac", 100);
//          CheckingAccount bank4 = new CheckingAccount("Ba", 0);

            bank1.deposit(100);
            System.out.println("After depositing 100 into bank1 the balance is " + bank1.getBalance()); //Expecting 200

//          bank1.deposit(0);

            bank1.withdraw(20);
            System.out.println("After withdrawing 50 from bank1 the balance is " + bank1.getBalance()); //Expecting 180

//          bank1.withdraw(-1);
//          bank1.withdraw(500);

            CheckingAccount bank2 = new CheckingAccount("Bc", 100);

            bank1.transfer(60, bank2);
            System.out.println("The current balance for bank1 is " + bank1.getBalance());//Expecting 120
            System.out.println("The current balance for bank2 is " + bank2.getBalance()); //Expecting 160

            

            SavingsAccount savings = new SavingsAccount("Ba", 100, 1.2);

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}