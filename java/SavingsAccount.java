class SavingsAccount extends BankAccount {
   private static final int MAX_WITHDRAW_COUNT = 6;

   private double interestRate;
   private int withdrawCount;

   public SavingsAccount(String name, double initialDeposit, double interestRate)throws Exception {
      super(name, initialDeposit);
      this.interestRate = interestRate;
      this.withdrawCount = 0;
   }
   public void addInterest() throws Exception {
      if(interestRate < 1) {
         throw new IllegalArgumentException("Can have an interest rate that decreases deposit");
      }

      setBalance(getBalance() * interestRate);
   }

   public void withdraw(double amount) throws Exception{
      if(withdrawCount >= MAX_WITHDRAW_COUNT){
         throw new IllegalStateException("Exceeded withdraw limit, can't withdraw anymore money");
      }

      withdrawCount++;
      withdraw(amount);
   }

   public int getWithdrawCount() {
      return withdrawCount;
   }
}