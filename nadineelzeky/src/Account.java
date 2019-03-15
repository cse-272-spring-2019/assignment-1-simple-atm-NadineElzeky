

public class Account {

	private double balance;
	private int count;
	public String[] navigation = new String[5];
	
	
	public Account() {
		super();
		count = 0;
		balance = 0 ;
		
		}
	
	public double getBalance() {
		
		return balance;
	}
	public boolean Withdraw(double balance)
	{
		if (this.balance<balance||balance<=0)
			return false;
		else
		{
		this.balance=this.balance-balance;
		return true;

		}
		
	}
	public static  boolean check(String cardnumber3)
	{
	String	cardnumber1="1111";
		if(cardnumber3.equals(cardnumber1))
			
			return true;
		else
		return false;
		
	}
	public boolean deposit(double balance)
	{
		
		if(balance<=0)
			return false;
		else
			{
			this.balance=this.balance+balance;
			
			}
			return true;
		}
		


		public void navigation(String BalanceAmount)
		{
			
			
			if(count<5)
			{navigation[count]=BalanceAmount;
			count++;
			}
			else
				{
				
					int i;
					for(i=0;i<4;i++)
					{
						String string ;
						string=navigation[i];
						navigation[i]=navigation[i+1];
						
						navigation[i+1]=string;
						
						
					}
					navigation[count-1]=BalanceAmount;
				
					
				}
			
			}
		
		


			






}























