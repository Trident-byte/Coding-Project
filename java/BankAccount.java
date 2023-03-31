public abstract class BankAccount implements BankAccountInterface {
    private String name;
    private double balance;

    public BankAccount (String name, double initialDeposit) throws Exception {
       // WRITE YOUR CODE HERE
       // If the name does not have more than 2 characters
       // the constructor should throw an Exception
       // Also, if the initialDeposit is negative or equal
       // to zero, it should throw an Exception
        if(name.length() < 2){
            throw new IllegalArgumentException("Name can not be smaller than 2 characters");
        } else if(initialDeposit < 0.01){
            throw new IllegalArgumentException("Minimum deposit is 0.01");
        }

        this.name = name;
        this.balance = initialDeposit;

    }

    @Override
    public void deposit(double amount) throws Exception{
        amountIsNegative(amount);
        balance += amount;
    }

    @Override
    public void withdraw(double amount) throws Exception {
        checkFeasibility(amount);
        balance -= amount;
    }

    @Override
    public void transfer(double amount, BankAccount destination) throws Exception {
        checkFeasibility(amount);
        destination.balance += amount;
        this.balance -= amount;
    }

    public double getBalance(){
        return this.balance;
    }

    public String getName(){
        return this.name;
    }

    //With the same logic, throw an Exception in the deposit
    //method if the amount is negative or equal to zero.
    //Think and implement a condition that could throw an
    //exception in the methods: withdrawal and transfer.

    public void checkFeasibility(double amount) throws Exception{
        amountIsNegative(amount);
        moneyInAccount(amount);
        
    }

    public void amountIsNegative (double amount) throws Exception{
        if(amount < 0.01){
            throw new IllegalArgumentException("Can't have an amount be less than 1 cent");
        }
    }

    public void moneyInAccount(double amount) throws Exception{
        if(amount > balance){
            throw new IllegalArgumentException("There is not enough money in the account");
        } 
    }

    public void emptyBalance() throws Exception{
        if(balance < 0.01){
            throw new IllegalStateException("Cannot add interest to empty account.");
        }
    }
}
