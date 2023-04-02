package edu.stuy.lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void regularCheckingAccount() throws Exception {
        CheckingAccount checkingAccount = new CheckingAccount("Bac", 100);
        CheckingAccount someoneElseCheckingAccount = new CheckingAccount("Bbc", 100);
        assertAll(
                () -> assertEquals("Bac", checkingAccount.getName()),
                () -> assertEquals(100, checkingAccount.getBalance())
        );
        checkingAccount.withdraw(20);
        assertEquals(80.0, checkingAccount.getBalance());
        checkingAccount.deposit(50);
        assertEquals(130.0, checkingAccount.getBalance());
        checkingAccount.transfer(20, someoneElseCheckingAccount);
        assertEquals(110.0, checkingAccount.getBalance());
        assertEquals(120.0, someoneElseCheckingAccount.getBalance());
    }

    @Test
    public void regularSavingAccount() throws Exception {
        SavingsAccount savingsAccount = new SavingsAccount("Bac", 100, 0.04);
        SavingsAccount soneoneElseSavingsAccount = new SavingsAccount("Bbc", 100, 0.04);
        assertAll(
                () -> assertEquals("Bac", savingsAccount.getName()),
                () -> assertEquals(100, savingsAccount.getBalance()),
                () -> assertEquals(0.04, savingsAccount.getInterestRate())
        );

        savingsAccount.withdraw(30);
        assertEquals(70.0, savingsAccount.getBalance());
        savingsAccount.deposit(60);
        assertEquals(130.0, savingsAccount.getBalance());
        savingsAccount.transfer(20, soneoneElseSavingsAccount);
        assertEquals(110.0, savingsAccount.getBalance());
        assertEquals(120.0, soneoneElseSavingsAccount.getBalance());
        savingsAccount.addInterest();
        assertEquals(110.0 * 1.04, savingsAccount.getBalance());

        SavingsAccount negativeInterest = new SavingsAccount("Bac", 100, -0.04);
        negativeInterest.addInterest();
        assertEquals(100 * 0.96, negativeInterest.getBalance());
    }

    @Test
    public void kidSavingAccount() throws Exception {
        SavingsAccountKid savingsAccountKid = new SavingsAccountKid("Bac", 100, 0.04, "Leon");
        SavingsAccountKid soneoneElseSavingsAccountKid = new SavingsAccountKid("Bbc", 100, 0.04, "Fei");
        assertAll(
                () -> assertEquals("Bac", savingsAccountKid.getName()),
                () -> assertEquals(100, savingsAccountKid.getBalance()),
                () -> assertEquals(0.04, savingsAccountKid.getInterestRate()),
                () -> assertEquals("Leon", savingsAccountKid.getParentName())
        );

        savingsAccountKid.withdraw(25);
        assertEquals(75.0, savingsAccountKid.getBalance());
        savingsAccountKid.deposit(55);
        assertEquals(130.0, savingsAccountKid.getBalance());
        savingsAccountKid.transfer(25, soneoneElseSavingsAccountKid);
        assertEquals(105.0, savingsAccountKid.getBalance());
        assertEquals(125.0, soneoneElseSavingsAccountKid.getBalance());
        savingsAccountKid.addInterest();
        assertEquals(105.0 * 1.04, savingsAccountKid.getBalance());
    }

    @Test
    public void accountNameLessThanTwoCharactersShouldThrowException() {
        String twoCharactersName = "Ba";
        assertThrows(Exception.class, () -> new CheckingAccount(twoCharactersName, 100));
        assertThrows(Exception.class, () -> new SavingsAccount(twoCharactersName, 100, 0.04));
        assertThrows(Exception.class, () -> new SavingsAccountKid(twoCharactersName, 100, 0.04, "Leon"));

        String oneCharactersName = "a";
        assertThrows(Exception.class, () -> new CheckingAccount(oneCharactersName, 100));
        assertThrows(Exception.class, () -> new SavingsAccount(oneCharactersName, 100, 0.04));
        assertThrows(Exception.class, () -> new SavingsAccountKid(oneCharactersName, 100, 0.04, "Leon"));
    }

    @Test
    public void accountInitDepositLessThanOrEqualToZeroShouldThrowException() {
        String accountName = "Bac";
        Double zeroInitDeposit = 0.0;
        assertThrows(Exception.class, () -> new CheckingAccount(accountName, zeroInitDeposit));
        assertThrows(Exception.class, () -> new SavingsAccount(accountName, zeroInitDeposit, 0.04));
        assertThrows(Exception.class, () -> new SavingsAccountKid(accountName, zeroInitDeposit, 0.04, "Leon"));

        Double negativeInitDeposit = -5.0;
        assertThrows(Exception.class, () -> new CheckingAccount(accountName, negativeInitDeposit));
        assertThrows(Exception.class, () -> new SavingsAccount(accountName, negativeInitDeposit, 0.04));
        assertThrows(Exception.class, () -> new SavingsAccountKid(accountName, negativeInitDeposit, 0.04, "Leon"));
    }

    @Test
    public void withdrawTooMuch() {
        String accountName = "Bac";
        Double initDeposit = 100.0;
        assertThrows(Exception.class, () -> {
            CheckingAccount account = new CheckingAccount(accountName, initDeposit);
            account.withdraw(101.0);
        });
        assertThrows(Exception.class, () -> {
            SavingsAccount account = new SavingsAccount(accountName, initDeposit, 0.04);
            account.withdraw(101.0);
        });
        assertThrows(Exception.class, () -> {
            SavingsAccountKid account = new SavingsAccountKid(accountName, initDeposit, 0.04, "Leon");
            account.withdraw(101.0);
        });

    }

    @Test
    public void transferTooMuch() {
        String accountName = "Bac";
        Double initDeposit = 100.0;
        assertThrows(Exception.class, () -> {
            CheckingAccount account1 = new CheckingAccount(accountName, initDeposit);
            CheckingAccount account2 = new CheckingAccount(accountName, initDeposit);
            account1.transfer(101.0, account2);
        });
        assertThrows(Exception.class, () -> {
            SavingsAccount account1 = new SavingsAccount(accountName, initDeposit, 0.04);
            SavingsAccount account2 = new SavingsAccount(accountName, initDeposit, 0.04);
            account1.transfer(101.0, account2);
        });
        assertThrows(Exception.class, () -> {
            SavingsAccountKid account1 = new SavingsAccountKid(accountName, initDeposit, 0.04, "Leon");
            SavingsAccountKid account2 = new SavingsAccountKid(accountName, initDeposit, 0.04, "Leon");
            account1.transfer(101.0, account2);
        });

    }

    @Test
    public void cannotWithdrawMoreThanSixTimes() {
        String accountName = "Bac";
        Double initDeposit = 100.0;
        assertThrows(Exception.class, () -> {
            SavingsAccount savingsAccount = new SavingsAccount(accountName, initDeposit, 0.04);
            for (int i = 0; i < 7; i++) {
                savingsAccount.withdraw(1.0);
            }
        });

        assertThrows(Exception.class, () -> {
            SavingsAccountKid savingsAccountKid = new SavingsAccountKid(accountName, initDeposit, 0.04, "Leon");
            for (int i = 0; i < 7; i++) {
                savingsAccountKid.withdraw(1.0, "Leon");
            }
        });
    }

    @Test
    public void onlyParentOnRecordCanWithdrawFromKidSavingAccount() throws Exception {
        SavingsAccountKid savingsAccountKid = new SavingsAccountKid("bac", 100.0, 0.04, "Leon");
        assertThrows(Exception.class, () -> {
            savingsAccountKid.withdraw(20, "Fei");
        });
        savingsAccountKid.withdraw(20, "Leon");
        assertEquals(80.0, savingsAccountKid.getBalance());
    }

    @Test
    public void depositAmountShouldBeGreaterThanZero() {
        String accountName = "Bac";
        Double initDeposit = 100.0;
        assertThrows(Exception.class, () -> {
            CheckingAccount account = new CheckingAccount(accountName, initDeposit);
            account.deposit(-1.0);
        });
        assertThrows(Exception.class, () -> {
            SavingsAccount account = new SavingsAccount(accountName, initDeposit, 0.04);
            account.deposit(-1.0);
        });
        assertThrows(Exception.class, () -> {
            SavingsAccountKid account = new SavingsAccountKid(accountName, initDeposit, 0.04, "Leon");
            account.deposit(-1.0);
        });

        assertThrows(Exception.class, () -> {
            CheckingAccount account = new CheckingAccount(accountName, initDeposit);
            account.deposit(0.0);
        });
        assertThrows(Exception.class, () -> {
            SavingsAccount account = new SavingsAccount(accountName, initDeposit, 0.04);
            account.deposit(0.0);
        });
        assertThrows(Exception.class, () -> {
            SavingsAccountKid account = new SavingsAccountKid(accountName, initDeposit, 0.04, "Leon");
            account.deposit(0.0);
        });
    }

    @Test
    public void cannotWithdrawAmountLessThanZero() {
        String accountName = "Bac";
        Double initDeposit = 100.0;
        assertThrows(Exception.class, () -> {
            CheckingAccount account = new CheckingAccount(accountName, initDeposit);
            account.withdraw(-1.0);
        });
        assertThrows(Exception.class, () -> {
            SavingsAccount account = new SavingsAccount(accountName, initDeposit, 0.04);
            account.withdraw(-1.0);
        });
        assertThrows(Exception.class, () -> {
            SavingsAccountKid account = new SavingsAccountKid(accountName, initDeposit, 0.04, "Leon");
            account.withdraw(-1.0);
        });

    }

    @Test
    public void cannotTransferAmountLessThanZero() {
        String accountName = "Bac";
        Double initDeposit = 100.0;
        assertThrows(Exception.class, () -> {
            CheckingAccount account = new CheckingAccount(accountName, initDeposit);
            CheckingAccount account2 = new CheckingAccount(accountName, initDeposit);
            account.transfer(-1, account2);
        });
        assertThrows(Exception.class, () -> {
            SavingsAccount account = new SavingsAccount(accountName, initDeposit, 0.04);
            SavingsAccount account2 = new SavingsAccount(accountName, initDeposit, 0.04);
            account.transfer(-1, account2);
        });
        assertThrows(Exception.class, () -> {
            SavingsAccountKid account = new SavingsAccountKid(accountName, initDeposit, 0.04, "Leon");
            SavingsAccountKid account2 = new SavingsAccountKid(accountName, initDeposit, 0.04, "Leon");
            account.transfer(-1, account2);
        });

    }

}
