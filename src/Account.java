import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {
	//variables
		private int customerNumber;
		private int pinNumber;
		private double  checkingBalance=0;
		private double savingBalance=0;
		
		Scanner input = new Scanner(System.in);
		DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

		public Account() {
			
		}
		public Account(int customerNumber, int pinNumber ) {
			this.customerNumber = customerNumber;
			this.pinNumber = pinNumber;
		}
		public Account(int customerNumber,int pinNumber, double checkingBalance,double savingBalance) {
			this.customerNumber = customerNumber;
			this.pinNumber = pinNumber;
			this.checkingBalance = checkingBalance;
			this.savingBalance = savingBalance; 
		}
		public int setCustomerNumber(int customerNumber) {
			this.customerNumber = customerNumber;
			return customerNumber;
		}
		public int getCustomerNumber(int customerNumber) {
			this.customerNumber = customerNumber;
			return customerNumber;
		}
		public int setPinNumber(int pinNumber) {
			this.pinNumber = pinNumber;
			return pinNumber;
		}
		public int getPinNumber() {
			return pinNumber;
		}
		public double getcheckingBalance() {
			return checkingBalance;
		}
		public double getSavingBalance() {
			return savingBalance;
		}
		public double calcCheckingWithdraw(double amount) {
			checkingBalance = (savingBalance-amount);
			return checkingBalance;
		}
		public double calcSavingWithdraw(double amount) {
			savingBalance = (savingBalance-amount);
			return savingBalance;
		}
		public double calcCheckingDeposit(double amount) {
			checkingBalance = (savingBalance+amount);
			return checkingBalance;
		}
		public double calcSavingDeposit(double amount) {
			savingBalance = (savingBalance+amount);
			return savingBalance;
		}
		public void calcCheckingTransfer(double amount) {
			checkingBalance = (savingBalance-amount);
			savingBalance = (savingBalance + amount);
		}
		public void calcSavingtransfer(double amount) {
			savingBalance = (savingBalance+amount);
			savingBalance = (savingBalance - amount);
			
		}
		
		public void getCheckingWithdrawInput() {
			boolean end = false;
			while(!end) {
				try {
					System.out.println("\nCurrent Checkings Account Blance is :" +moneyFormat.format(checkingBalance));
					System.out.println("\nAmount you want to withdraw from your account is:" );
					double amount = input.nextDouble();
					if((checkingBalance-amount)>=0 && amount >=0) {
						calcCheckingWithdraw(amount);
						System.out.println("\nCurrent Checkings Account Blance is :" +moneyFormat.format(checkingBalance));
						end =true;
					}
					else {
						System.out.println("\nBalance cannot be negative!");
					}
					
					}
				catch(InputMismatchException e) {
					System.out.println("Invalid Input!!");
					input.next();
				}
				
			}
		}
		
		public void getSavingWithdrawInput() {
			boolean end = false;
			while(!end) {
				try {
					System.out.println("\nCurrent Checkings Account Blance is :" +moneyFormat.format(savingBalance));
					System.out.println("\nAmount you want to withdraw from your account is:" );
					double amount = input.nextDouble();
					if((checkingBalance-amount)>=0 && amount >=0) {
						calcSavingWithdraw(amount);
						System.out.println("\nCurrent Checkings Account Blance is :" +moneyFormat.format(savingBalance));
						end =true;
					}
					else {
						System.out.println("\nBalance cannot be negative!");
					}
					
					}
				catch(InputMismatchException e) {
					System.out.println("Invalid Input!!");
					input.next();
				}
				
			}
		}
		
		public void getCheckingDepositInput() {
			boolean end = false;
			while(!end) {
				try {
					System.out.println("\nCurrent Checkings Account Blance is :" +moneyFormat.format(checkingBalance));
					System.out.println("\nAmount you want to withdraw from your account is:" );
					double amount = input.nextDouble();
					if((checkingBalance+amount)>=0 && amount >=0) {
						calcCheckingDeposit(amount);
						System.out.println("\nCurrent Checkings Account Blance is :" +moneyFormat.format(checkingBalance));
						end =true;
					}
					else {
						System.out.println("\nBalance cannot be negative!");
					}
					
					}
				catch(InputMismatchException e) {
					System.out.println("Invalid Input!!");
					input.next();
				}
				
			}
		}
		
		public void getSavingDepositInput() {
			boolean end = false;
			while(!end) {
				try {
					System.out.println("\nCurrent Checkings Account Blance is :" +moneyFormat.format(savingBalance));
					System.out.println("\nAmount you want to withdraw from your account is:" );
					double amount = input.nextDouble();
					if((savingBalance+amount)>=0 && amount >=0) {
						calcCheckingWithdraw(amount);
						System.out.println("\nCurrent Checkings Account Blance is :" +moneyFormat.format(savingBalance));
						end =true;
					}
					else {
						System.out.println("\nBalance cannot be negative!");
					}
					
					}
				catch(InputMismatchException e) {
					System.out.println("Invalid Input!!");
					input.next();
				}
				
			}
		}
		
		public void getTransferInput(String accType) {
			boolean end = false;
			while(!end) {
				try {
					if(accType.equals("checkings")) {
						System.out.println("\nSelect an account you wish to tranfers funds to:");
						System.out.println("\n1.Savings:");
						System.out.println("\n2.Exit:");
						System.out.println("\n3.Choice:");
						int Choice = input.nextInt();
						
						switch(Choice) {
						case 1:
							System.out.println("\nCurrent Checking Balance:" +moneyFormat.format(checkingBalance));
							System.out.println("\nAmount you want to deposit into your Savings Account:");
							double amount = input.nextDouble();
							if((savingBalance+amount)>=0 &&(checkingBalance-amount)>=0&&amount>=0) {
								calcCheckingTransfer(amount);
								System.out.println("\nCurrent Saving Balance:" +moneyFormat.format(savingBalance));
								System.out.println("\nCurrent Checking Balance:" +moneyFormat.format(checkingBalance));
								end =true;
							}
							else {
								System.out.println("\nBalance cannot be negative!");	
							}
						case 2:
							return;
						default:
							System.out.println("Invalid Input!!");
							break;
						}
						
					}
					
					if(accType.equals("savings")) {
						System.out.println("\nSelect an account you wish to tranfers funds to:");
						System.out.println("\n1.Checkings:");
						System.out.println("\n2.Exit:");
						System.out.println("\n3.Choice:");
						int Choice = input.nextInt();
						
						switch(Choice) {
						case 1:
							System.out.println("\nCurrent Saving Balance:" +moneyFormat.format(savingBalance));
							System.out.println("\nAmount you want to deposit into your Checking Account:");
							double amount = input.nextDouble();
							if((checkingBalance+amount)>=0 &&(savingBalance-amount)>=0&&amount>=0) {
								calcSavingtransfer(amount);
								System.out.println("\nCurrent Saving Balance:" +moneyFormat.format(savingBalance));
								System.out.println("\nCurrent Checking Balance:" +moneyFormat.format(checkingBalance));
								end =true;
							}
							else {
								System.out.println("\nBalance cannot be negative!");	
							}
						case 2:
							return;
						default:
							System.out.println("Invalid Input!!");
							break;
					
				}
				
				}
			}
				catch(InputMismatchException e) {
					System.out.println("\nInvalid Input");
					input.next();
		}
		
	}
		}
}
