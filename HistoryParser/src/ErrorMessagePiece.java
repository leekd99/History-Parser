
public class ErrorMessagePiece {
	private String message;
	private boolean isError;
	
	public ErrorMessagePiece(){
		
		message = "Error:\n";
		isError = false;
		
	}//end constructor
	
	public void addToMessage(String msg) {
		
		this.message = this.message.concat(msg);
		isError = true;
		
	}//end addToMessage
	
	public boolean exists() {
		return isError;
	}//end checkForError()
	
	public String getErrorMessage() {
		return message;
	}//end getErrorMessage()
	
}//end
