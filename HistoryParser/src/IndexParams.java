
public class IndexParams {

	private int value;
	private boolean isInt;
	private boolean isValid;
	
	IndexParams(int indexInput, boolean isInt){
		
		this.value = indexInput;
		this.isInt = isInt;
		
		//if value is greater than zero set valid to true
		if (value >= 0 ) {
			isValid = true;
		} else {
			isValid = false;
		}//end if else
		
	}//end constructor
	
	public int getValue() {
		return value;
	}//end getValue
	
	public Boolean isInteger() {
		return isInt;
	}//end isInteger()
	
	public Boolean isCorrect() {
		return isValid;
	}//end isCorrect()
	
}//end
