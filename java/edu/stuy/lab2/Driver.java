package edu.stuy.lab2;

class Driver{
    public static void main(String[] args){
        //Put tests in here
        try {
            //Testing checking account
            CheckingAccount bank1 = new CheckingAccount("Bac", 100);
            //Expecting The name of the checking account, bank1 is Bac
            System.out.println("The name of the checking account, bank1 is " + bank1.getName());
            //Expecting The balance of the checking account, bank1 is 100.0
            System.out.println("The balance of the checking account, bank1 is " + bank1.getBalance());

            //Expecting error: Name can not be smaller than 2 characters
//          CheckingAccount bank3 = new CheckingAccount("Ba", 100);

            //Expecting error: Deposit must be larger than 0
//          CheckingAccount bank4 = new CheckingAccount("Ba", 0);

            bank1.deposit(100);
            //Expecting After depositing 100 into bank1 the balance is 200.0
            System.out.println("After depositing 100 into bank1 the balance is " + bank1.getBalance());

            //Expecting error: Can't have an amount be less than 1 cent
//          bank1.deposit(0);

            bank1.withdraw(20);
            //Expecting After withdrawing 50 from bank1 the balance is 180.0
            System.out.println("After withdrawing 50 from bank1 the balance is " + bank1.getBalance());

            //Expecting error: Can't have an amount be less than 1 cent
//          bank1.withdraw(-1);

            //Expecting error Not enough money in the bank account
//          bank1.withdraw(500);

            CheckingAccount bank2 = new CheckingAccount("Bc", 100);

            bank1.transfer(60, bank2);
            //Expecting The current balance for bank1 is 120.0
            System.out.println("The current balance for bank1 is " + bank1.getBalance());
            //Expecting The current balance for bank2 is 160.0
            System.out.println("The current balance for bank2 is " + bank2.getBalance()); //Expecting 160

            //Expecting error: Can't have an amount be less than 1 cent
//          bank1.transfer(-10, bank2);
            //Expecting error: Not enough money in the bank account
//          bank1.transfer(150, bank2);
            //Expecting error: cannot find symbol
//          bank2.transfer(160, bank3);

            SavingsAccount savings = new SavingsAccount("Bd", 100, 0.2);
            //Expecting The current interest rate for savings is 0.2
            System.out.println("The current interest rate for savings is " + savings.getInterestRate());
            //Expecting The number of withdrawals is 0
            System.out.println("The number of withdrawals is " + savings.getWithdrawCount());



            //Expecting error: Must have an interest between, but not including 0 and 1
//           SavingsAccount savings2 = new SavingsAccount("Bd", 100, -0.2);

            savings.addInterest();
            //Expecting The balance of saving is now 120.0
            System.out.println("The balance of saving is now " + savings.getBalance());

            savings.withdraw(10);
            //Expecting The balance of saving is now 110.0
            System.out.println("The balance of saving is now " + savings.getBalance());
            //Expecting The withdraw count for savings is now 1
            System.out.println("The withdraw count for savings is now " + savings.getWithdrawCount());

            //Expecting on final iteration an error: Exceeded withdraw limit, can't withdraw anymore money
//          for(int i = 0; i < 6; i++){
//              savings.withdraw(10);
//          }

//          savings.withdraw(110);
            //Expecting error: Exceeded withdraw limit, can't withdraw anymore money
//          savings.addInterest();

            SavingsAccountKid savingsAccountKid = new SavingsAccountKid("Bj", 100, 0.2, "Dad" );
            //Expecting The parent name in savingsAccountKid is Dad
            System.out.println("The parent name in savingsAccountKid is " + savingsAccountKid.getParentName());

            savingsAccountKid.withdraw(60, "Dad");
            //Expecting The balance in savingsAccountKid after withdrawing 60 is 40.
            System.out.println("The balance in savingsAccountKid after withdrawing 60 is " + savingsAccountKid.getBalance());






        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}