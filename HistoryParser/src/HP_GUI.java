import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HP_GUI {

	private JFrame HistoryParserFrame;			//main Frame to hold everything in
	private String UI_title = "History Parser";	//Title of main frame
	private int UI_height = 600;				//Height of the UI
	private int UI_width = 500;					//Width of the UI
	private int grid_row = 3;					//number of rows for UI
	private int grid_col = 1;					//number of columns for UI
	
	
	private JPanel firstRow;					//Holds the first row which will hold the message box
		
		private JTextArea messageBoard;				//textArea to inform user of status and errors
	
	private JPanel secondRow;					//Holds the second row which will hold the inputs
	
		private JTextArea filenamePromt;			//label for where to put file name
		private JTextArea sitenamePromt;			//label for where to put site name
		private JTextArea siteindexPromt;			//label for where to put site index
		
		private JTextField filenameInput;			//text field to put filename into
		private JTextField sitenameInput;			//text field to put sitename into
		private JTextField siteindexInput;			//text field to put site index into
	
	private JPanel thirdRow;					//Holds the third row which will hold the buttons
	
		private JButton execute;					//Button to let program start
	
	public HP_GUI() {
		
		//TODO add calls to initialize methods
		
	}//end constructor
	
	private void initializeGUI() {
		
		HistoryParserFrame = new JFrame(UI_title);			//Create new GUI frame
		HistoryParserFrame.setSize(UI_width, UI_height);	//set size to private values
		
		HistoryParserFrame.setLayout(new GridLayout(grid_row,grid_col));	//make a grid layout usiprivate values
		
	}//end initializeGUI()
	
}//end HP_GUI
