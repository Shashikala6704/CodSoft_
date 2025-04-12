public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(5000); // Start with ₹5000
        ATM atm = new ATM(userAccount);
        atm.showMenu();
    }
}
