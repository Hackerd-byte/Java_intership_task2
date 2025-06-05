import java.util.Scanner;
// base calss
class Server{
  protected long ac_no;
  protected double balance;
  protected String ac_holder_name;
  public Server(String name,long no,double bal){
    this.ac_no=no;
    this.ac_holder_name=name;
    this.balance=bal;
  }
  public void display(){
    System.out.println("Account holder name:"+ac_holder_name);
    System.out.println("Account number:"+ac_no);
    System.out.println("Balance:"+balance);
  }
  public void Deposit(long deposit){
    System.out.println("Amount ₹"+deposit+"was deposited.");
    balance+=deposit;
  }
  public void Withdraw(long withdraw){
    if(withdraw<=balance){
      System.out.println("Amount ₹"+withdraw+" was withdrawed.");
      balance-=withdraw;
    }
    else{
      System.out.println("Insufficient amount");
    }
  }
  public void checkbalance(){
    System.out.println("Balance:"+balance);
    }
  
}
//  subclass1
class SavingsAccount extends Server{
  double interestrate=0.05;
  public SavingsAccount(String name,long no,double bal){
    super(name,no,bal);
  }
  public void Interest(){
    double interest=balance*interestrate;
    balance+=interest;
    System.out.println("Balance with Interest:"+interest);
  }
}
// sub class2
class CurrentAccount extends Server{
  double overdraftlimit=1000.0;
  public CurrentAccount(String name,long no,double bal){
    super(name,no,bal);
  }
  @Override
  public void Withdraw(long withdraw){
    if(withdraw<=balance+overdraftlimit){
      System.out.println("Amount ₹"+withdraw+"was withdrawed.");
      balance-=withdraw;
    }
    else{
      System.out.println("Overdraftlimit Exceeded.");
    }
  }
}
//Main class
public class BankSystem{
  public static void main(String[] args){
    Scanner ip=new Scanner(System.in);
    Server account=null;
    System.out.println(".....Welcome to ABC Bank.....");
    System.out.print("Enter your name:");
    String name=ip.nextLine();
    System.out.print("Enter your Account number:");
    long no=ip.nextLong();
    System.out.print("Enter your Balance:");
    double bal=ip.nextDouble();
    System.out.println("Type 1.Savings Account\nType 2.Current Account");
    System.out.print("Enter Type:");
    int type=ip.nextInt();
    if(type==1){
      account=new SavingsAccount(name,no,bal);
    }
    else{
      account=new CurrentAccount(name,no,bal);
    }
    account.display();
    int ch;
    do{
      System.out.println("1.Deposit\n2.Withdraw\n3.Check Balance\n4.Intrest\n5.Exit");
      System.out.print("Enter your choice:");
      ch=ip.nextInt();
      switch(ch){
        case 1:
          System.out.print("Enter amount:");
          long deposit=ip.nextLong();
          account.Deposit(deposit);
          break;
        case 2:
          System.out.print("Enter Amount:");
          long withdraw=ip.nextLong();
          account.Withdraw(withdraw);
          break;
        case 3:
          account.checkbalance();
          break;
        case 4:
          if(account instanceof SavingsAccount){
            ((SavingsAccount)account).Interest();
          }
          else{
            System.out.println("Not Interest for Current Account");
          }
          break;
        case 5:
          System.out.println("....Thank you Welcome Again......");
          break;
        default :
          System.out.println("Enter invalid option");
        }
    }while(ch!=5);
  }
}