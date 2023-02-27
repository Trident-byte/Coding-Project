class SavingsAccountKid extends SavingsAccount{
   private String parentName;
   public SavingsAccountKid(String name, double initialDeposit, double interestRate, String parentName)
           throws Exception {
      // implement the constructor
      super(name, initialDeposit, interestRate);
      this.parentName = parentName;
   }
   public void withdraw(double amount, String parentName)throws Exception {
   // WRITE YOUR CODE HERE
   // Check if the parameter parentName is equals to the
   // instance variable parentName before withdrawing from
   // the account
      if(!parentName.equals(this.parentName)){
         throw new IllegalArgumentException("Parent name entered is different than the one connecting to the account.");
      }

      withdraw(amount);
   }
}