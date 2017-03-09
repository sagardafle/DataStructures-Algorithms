class BankAccount{
      private int balance = 0;
      private int interestRate = 2;
      static int currentbalance = 0;
      public static void main(String[] args){
            BankAccount bankAccount = new BankAccount();
            
            bankAccount.deposit( 800 );
            bankAccount.deposit( 200 );

            currentbalance = bankAccount.getBalance(); // 1000
            System.out.println("currentbalance "+currentbalance);
 


            bankAccount.addInterest();
            currentbalance = bankAccount.getBalance(); // 1020
            System.out.println("currentbalance "+currentbalance);
 

            bankAccount.withdraw( 20 );

            currentbalance = bankAccount.getBalance(); // 1000
            System.out.println("currentbalance "+currentbalance);
 

            bankAccount.interestRate = 10;

            bankAccount.addInterest();

            currentbalance = bankAccount.getBalance(); // 1100
            System.out.println("currentbalance "+currentbalance);


      }
      
      public int getBalance(){
            return balance;
      }
      
      public void deposit(int depositamount){
            balance += depositamount;
      }
      
      public void addInterest(){
            balance += (balance*interestRate)/100;
      }
      
      public void withdraw(int withdrawamount){
            if(withdrawamount > balance) System.out.println("Insufficient balance. You cannot withdraw more than upto: "+balance);
            balance -= withdrawamount;
      }
}