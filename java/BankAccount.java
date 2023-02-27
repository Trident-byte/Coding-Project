public abstract class BankAccount implements BankAccountInterface {
    private String name;
    private double balance;

    public BankAccount (String name, double initialDeposit) throws IllegalArgumentException {
       // WRITE YOUR CODE HERE
       // If the name does not have more than 2 characters
       // the constructor should throw an Exception
       // Also, if the initialDeposit is negative or equal
       // to zero, it should throw an Exception
        if(name.length() > 2){
            throw new IllegalArgumentException("Name can not be longer than 2 characters");
        } else if(initialDeposit < 1){
            throw new IllegalArgumentException("Deposit must be larger than 0");
        }

        this.name = name;
        this.balance = initialDeposit;

    }

    @Override
    public void deposit(double amount) throws IllegalArgumentException{
        if(amount < 0.01){
            throw new IllegalArgumentException("Deposit can't be less than 1 cent");
        }

        balance += amount;
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if(amount <0.01){
            throw new IllegalArgumentException("Can't withdraw an amount less than 1 cent");
        } else if (amount > balance) {
            throw new IllegalStateException("Not enough money in the bank account");
        }

        balance -= amount;
    }

    @Override
    public void transfer(double amount, BankAccount destination) throws Exception {
        if(amount < 0.01){
            throw new IllegalArgumentException("Transfer cannot be less than 1 cent");
        } else if (amount > balance) {
            throw new IllegalStateException("Not enough money in the bank account");
        }

        destination.balance += amount;
        this.balance -= amount;
    }

    public double getBalance(){
        return this.balance;
    }

    public String getName(){
        return this.name;
    }

    protected void setBalance(double balance) throws IllegalStateException{
        if(balance < 0){
            throw new IllegalStateException("Can't have a negative balance");
        }
        this.balance = balance;
    }

    public void setName(String name) throws Exception{
        if (name.length() > 2) {
            throw new IllegalArgumentException("Can't have a name longer than 2 characters");
        }
        this.name = name;
    }
    //With the same logic, throw an Exception in the deposit
    //method if the amount is negative or equal to zero.
    //Think and implement a condition that could throw an
    //exception in the methods: withdrawal and transfer.
}
