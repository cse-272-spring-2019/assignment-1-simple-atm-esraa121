
public class Transactions {
	private double currentBalance = 0.0;
	private String[] history = new String[100];
	private int i = 0;

	public Transactions() {

	}

	public void inquiure() {

		int temp;
		if (i == 5) {
			for (temp = 0; temp < 4; temp++)
				history[temp] = history[temp + 1];
			i--;
			history[4] = "Balance inquire: " + currentBalance;
		} else {
			history[i++] = "Balance inquire: " + currentBalance;
		}

		
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public void deposit(double amount) {

		int temp;
		if (i == 5) {
			for (temp = 0; temp < 4; temp++)
				history[temp] = history[temp + 1];
			i--;
			history[4] = "Deposite amount: " + amount;
		} else {
			history[i++] = "Deposit amount: " + amount;
		}

		currentBalance += amount;
		

	}

	public boolean withDraw(double amount) {
		int temp;
		

		boolean x;

		if (currentBalance < amount) {
		
			x = false;
		}
		
		else {
			if (i == 5) {
				for (temp = 0; temp < 4; temp++)
					history[temp] = history[temp + 1];
				i--;
				history[4] = "Withdraw: " + amount;
			} else {
				history[i++] = "Withdraw: " + amount;
			}
			x = true;
			currentBalance -= amount;
			
		}
		return x;

	}

	public void prev() {
		i--;
		if (i < 0)
			i++;

	}

	public void next() {
		i++;
		if (i > 4)
			i--;

	}

	public String getString() {
		return history[i];
	}

}
