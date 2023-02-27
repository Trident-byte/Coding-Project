interface BankAccountInterface {
    double getBalance();
    String getName();
    void deposit(double amount) throws Exception;
    void withdraw(double amount) throws Exception;
    void transfer(double amount, BankAccount destination) throws Exception;
}