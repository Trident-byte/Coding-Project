abstract class BankAccount implements BankAccountInterface{
    private String name;
    private double balance;

    public BankAccount (String name, double initialDeposit) throws Exception {
       // WRITE YOUR CODE HERE
       // If the name does not have more than 2 characters
       // the constructor should throw an Exception
       // Also, if the initialDeposit is negative or equal
       // to zero, it should throw an Exception
        if(name.length() > 2){
            throw new Exception("Name can not be longer than 2 characters");
        } else if(initialDeposit < 1){
            throw new Exception("Deposit must be larger than 0");
        } else{
            this.name = name;
            this.balance = initialDeposit;
        }
    }

    @Override
    public void deposit(double amount) throws Exception{
        if(amount < 0){
            throw new Exception("Deposit can't be negative");
        } else{
            balance += amount;
        }
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if(amount < 0){
            throw new Exception("Can't withdraw a negative amount");
        } else{
            balance -= amount;
        }
    }

    @Override
    public void transfer(double amount, BankAccount destination) throws Exception {
        if(amount < 0){
            throw new Exception("Can't send a negative amount of money");
        } else{
            destination.balance += amount;
            this.balance -= amount;
        }
    }

    public double getBalance(){
        return this.balance;
    }

    public String getName(){
        return this.name;
    }

    public void setBalance(double balance) throws Exception{
        if(balance > 0){
            this.balance = balance;
        } else{
            throw new Exception("Can't have a negative balance");
        }
    }

    public void setName(String name) throws Exception{
        if(name.length() < 2){
            this.name = name;
        } else{
            throw new Exception("Can't have a name longer than 2 characters");
        }
    }
    //With the same logic, throw an Exception in the deposit
    //method if the amount is negative or equal to zero.
    //Think and implement a condition that could throw an
    //exception in the methods: withdrawal and transfer.
}
