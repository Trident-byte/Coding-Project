package edu.stuy.lab2;

public class SavingsAccount extends BankAccount {
   private static final int MAX_WITHDRAW_COUNT = 6;

   private double interestRate;
   private int withdrawCount;

   public SavingsAccount(String name, double initialDeposit, double interestRate)throws Exception {
      super(name, initialDeposit);
      if(interestRate <= 0 || interestRate >= 1){
         throw new IllegalArgumentException("Must have an interest between, but not including 0 and 1");
      }
      this.interestRate = interestRate;
      this.withdrawCount = 0;
   }
   public void addInterest() throws Exception {
      emptyBalance();
      double interest = getBalance() * interestRate;
      deposit(interest);
   }

   public void withdraw(double amount) throws Exception{
      if(withdrawCount >= MAX_WITHDRAW_COUNT){
         throw new IllegalStateException("Exceeded withdraw limit, can't withdraw anymore money");
      }

      withdrawCount++;
      super.withdraw(amount);
   }

   public int getWithdrawCount() {
      return withdrawCount;
   }

   public double getInterestRate(){
      return interestRate;
   }
}