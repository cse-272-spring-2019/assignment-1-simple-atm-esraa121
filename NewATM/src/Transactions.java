
public class Transactions {
		private	double currentBalance=0.0;
		private String [] history = new String [100];
		private int i=0;
		
	public Transactions() {
				
	}
	public void inquiure() {
		
		int temp;
		if(i==5)
		{
              for(temp=0 ; temp<4 ; temp++)
                    history[temp]=history[temp+1];
                           i--;
                             history[4] = "Balance inquire: " +currentBalance;
		}
              else {                 
            	  	history[i++] = "Balance inquire: " +currentBalance;
              }

		
		//history[i] = "Balance inquire :\t "+ currentBalance;
		i++;
	}

	
	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public void deposit(double amount) {
		
		int temp;
		if(i==5)
		{
              for(temp=0 ; temp<4 ; temp++)
                    history[temp]=history[temp+1];
                           i--;
                             history[4] = "Deposite amount: " +amount;
		}
              else {                 
            	  	history[i++] = "Deposit amount: " +amount;
              }

		
		currentBalance += amount;
		//history[i] = "Deposit amount :\t" + amount;
		//i++;
				
	}
	public boolean withDraw(double amount) {
		 int temp;
		if(i==5)
		{
              for(temp=0 ; temp<4 ; temp++)
                    history[temp]=history[temp+1];
                           i--;
                             history[4] = "Withdraw: " +amount;
		}
              else {                 
            	  	history[i++] = "Withdraw: " +amount;
              }

		
				boolean x;
				
			
		if (currentBalance < amount) {
			//System.out.println("amount withdrawn exceeds the current balance!");
		x=false;
		}
		//else if (currentBalance ==0.0 ) {
			//System.out.println("the current balance is 0.0");
			
	//	}
			      
		else {
			    x=true;     
			currentBalance -= amount;
			//history[i] = "withdraw amount :\t   " + amount;
			//i++;
		}	
		return x;
		
	}

	public void prev () {
		i--;
		if(i<0)
			i++;
		
	}
	public void next () {
		i++;
		if(i>4)
		i--;
		
	}
	public String getString() {
		return history[i];
	}
	
	
}

