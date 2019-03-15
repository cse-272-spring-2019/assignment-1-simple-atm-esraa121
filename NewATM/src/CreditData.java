
public class CreditData {
	private String creditNum = new String("1234567");
	private String pinCode = new String("123");

	public CreditData() {

	}

	public CreditData(String creditNum, String pinCode) {
		this.creditNum = creditNum;
		this.pinCode = pinCode;

	}

	public void setcreditNum(String creditNum) {
		this.creditNum = creditNum;

	}

	public void setcreditPass(String pinCode) {

		this.pinCode = pinCode;

	}

	public String getcreditNum() {
		return creditNum;
	}

	public String getpinCode() {
		return pinCode;
	}

	public boolean Validate(String num, String pass) {
		this.creditNum = "1234567";
		this.pinCode = "123";
		boolean val = false;

		if (num.equals(creditNum) && pass.equals(pinCode)) {

			val = true;
		}

		return val;
	}
}
