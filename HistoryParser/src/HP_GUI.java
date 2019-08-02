import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HP_GUI {

	private JFrame HistoryParserFrame;			//main Frame to hold everything in
	private String UI_title = "History Parser";	//Title of main frame
	private int UI_height = 600;				//Height of the UI
	private int UI_width = 300;					//Width of the UI
	private int grid_row = 2;					//number of rows for UI
	private int grid_col = 1;					//number of columns for UI
	
	//list of labels
	private String filename_label = "File Name";
	private String sitename_label = "Site Name";
	private String siteindex_label = "Site Index";
	private String execute_button_label = "Get Site List";
	
	//list of error messages
	private String not_a_number = "Please write a number for the index\n";
	private String not_valid_number = "It should be a positive number\n";
	private String no_file_found = "ERROR:\nNo such file exists!\n"
			+ "Make sure file names is correct\n"
			+ "or that file is in the same directory as executable";
	private String no_site_name_found = "ERROR:\nThe site you have given doesn't match any of the sites in the file!";
	private String index_out_of_bounds = "ERROR:\nThe number you put in is too large!";
	
	private JPanel firstRow;					//Holds the first row which will hold the message box
		
		private JLabel filenamePrompt;			//label for where to put file name
		private JLabel sitenamePrompt;			//label for where to put site name
		private JLabel siteindexPrompt;			//label for where to put site index
		
		private JTextField filenameInput;			//text field to put filename into
		private JTextField sitenameInput;			//text field to put sitename into
		private JTextField siteindexInput;			//text field to put site index into
	
		private JButton execute;					//Button to let program start

	private JPanel secondRow;					//Holds the second row which will hold the inputs
		
		private JTextArea messageBoard;				//textArea to inform user of status and errors
	
	public HP_GUI() {
		
		//TODO add calls to initialize methods
		initializeGUI();
		initialize();
		
		
		HistoryParserFrame.setVisible(true);
		
	}//end constructor
	
	
	/*
	 * initialize function to draw frame and set sizes
	 */
	private void initializeGUI() {
		
		HistoryParserFrame = new JFrame(UI_title);			//Create new GUI frame
		HistoryParserFrame.setSize(UI_width, UI_height);	//set size to private values
		
		HistoryParserFrame.setLayout(new GridLayout(grid_row,grid_col));	//make a grid layout usiprivate values
		
	}//end initializeGUI()
	
	/*
	 * initialize function to setup inputs
	 */
	private void initialize() {
		
		//create new JPanel
		firstRow = new JPanel();
		
		//Create GridBagLayout for firstRow Panel and a GridBagCOnstraint object to set contraints for components
		GridBagLayout firstRowLayout =  new GridBagLayout();
		GridBagConstraints firstRowConstraints = new GridBagConstraints();
		
		
		//set layout of JPanel to GridBagLayout
		firstRow.setLayout(firstRowLayout);
		
		//set file name prompt and input and set size
		filenamePrompt = new JLabel(filename_label);
		filenameInput = new JTextField();
		filenameInput.setPreferredSize(new Dimension(200,20));
		
		//set site name prompt and input and set size
		sitenamePrompt = new JLabel(sitename_label);
		sitenameInput = new JTextField();
		sitenameInput.setPreferredSize(new Dimension(200,20));
		
		//set site index prompt and input and set size
		siteindexPrompt = new JLabel(siteindex_label);
		siteindexInput = new JTextField();
		siteindexInput.setPreferredSize(new Dimension(200,20));
		
		//set button
		execute = new JButton(execute_button_label);
		execute.addActionListener(actionListener);

		//add filename prompt
		firstRowConstraints.fill = GridBagConstraints.HORIZONTAL;
		firstRowConstraints.gridx = 0;
		firstRowConstraints.gridy = 0;
		firstRowConstraints.gridwidth = 1;
		firstRow.add(filenamePrompt, firstRowConstraints);
		
		//add filename input field
		firstRowConstraints.fill = GridBagConstraints.HORIZONTAL;
		firstRowConstraints.gridx = 1;
		firstRowConstraints.gridy = 0;
		firstRowConstraints.gridwidth = 2;
		firstRow.add(filenameInput, firstRowConstraints);
		
		//add sitename input prompt
		firstRowConstraints.fill = GridBagConstraints.HORIZONTAL;
		firstRowConstraints.gridx = 0;
		firstRowConstraints.gridy = 1;
		firstRowConstraints.gridwidth = 1;
		firstRow.add(sitenamePrompt, firstRowConstraints);
		
		//add sitename input field
		firstRowConstraints.fill = GridBagConstraints.HORIZONTAL;
		firstRowConstraints.gridx = 1;
		firstRowConstraints.gridy = 1;
		firstRowConstraints.gridwidth = 2;
		firstRow.add(sitenameInput, firstRowConstraints);
		
		//add site index prompt
		firstRowConstraints.fill = GridBagConstraints.HORIZONTAL;
		firstRowConstraints.gridx = 0;
		firstRowConstraints.gridy = 2;
		firstRowConstraints.gridwidth = 1;
		firstRow.add(siteindexPrompt, firstRowConstraints);
		
		//add sitename input field
		firstRowConstraints.fill = GridBagConstraints.HORIZONTAL;
		firstRowConstraints.gridx = 1;
		firstRowConstraints.gridy = 2;
		firstRowConstraints.gridwidth = 2;
		firstRow.add(siteindexInput, firstRowConstraints);
		
		//add button
		firstRowConstraints.fill = GridBagConstraints.HORIZONTAL;
		firstRowConstraints.gridx = 1;
		firstRowConstraints.gridy = 3;
		firstRowConstraints.gridwidth = 1;
		firstRow.add(execute, firstRowConstraints);
		
		//add to frame
		HistoryParserFrame.add(firstRow);
		
		//add second row
		secondRow = new JPanel();
		//Create GridBagLayout for firstRow Panel and a GridBagCOnstraint object to set contraints for components
		GridBagLayout secondRowLayout =  new GridBagLayout();
		GridBagConstraints secondRowConstraints = new GridBagConstraints();
		
		//set text Area
		messageBoard = new JTextArea(10,25);
		messageBoard.setWrapStyleWord(true);
				
		secondRowConstraints.fill = GridBagConstraints.CENTER;
		secondRow.add(messageBoard,secondRowConstraints);
				
		HistoryParserFrame.add(secondRow);
		
	}//end initializeDisplay()
	
	private void indexNotNumber() {
		
		messageBoard.setText(not_a_number);
		
	}//end indexNotNumber
	
	private void displayNoFileError() {
		messageBoard.setText(no_file_found);
	}//end diplayNoFileError()
	
	private void displyNoSiteError() {
		messageBoard.setText(no_site_name_found);
	}//end diaplyNoSiteError()
	
	private void indexOutofBounds() {
		messageBoard.setText(index_out_of_bounds);
	}//end indexOutofBounds()
	
	/*
	 * Action listners to handle iunteraction with UI
	 */
	ActionListener actionListener = new ActionListener() {
		
		public void actionPerformed(ActionEvent event) {
			
			if (event.getSource() == execute) {
				
				IndexParams currentIndex = indexValid(getSiteIndex());
				ErrorMessagePiece indexError = indexErrorMessage(currentIndex);
				
				if (indexError.exists()) {
					
					messageBoard.setText(indexError.getErrorMessage());
					
				} else {
					messageBoard.setText("Good Job Kyle!!");
					messageBoard.append("\ntest");
				}//end
				
			}//end if
			
		}//end actionPerformed
		
	};//end action listener
	
	/*
	 * Methods for getting info from inputs
	 */
	private String getFileName() {
		return filenameInput.getText();
	}//end getFilename
	
	private String getSiteName() {
		return sitenameInput.getText();
	}//end getFileName
	
	private String getSiteIndex() {
		return siteindexInput.getText();
	}//end
	
	/*
	 * Check function for checking input
	 */
	private IndexParams indexValid(String indexInput) {
		
		IndexParams temp; 
		
		try {
			temp = new IndexParams(Integer.parseInt(indexInput),true); 
		} catch(NumberFormatException e) {
			temp = new IndexParams(0,false); 
		}
		
		return temp;
		
	}//end indexValid(String indexInput)
	
	private ErrorMessagePiece indexErrorMessage(IndexParams currentIndexParams) {
		
		ErrorMessagePiece temp = new ErrorMessagePiece();
		
		IndexParams currentIndex = indexValid(getSiteIndex());
		
		if (!currentIndex.isInteger()) {
			temp.addToMessage(not_a_number);
		}//if index is not an integer
		
		if (!currentIndex.isCorrect()) {
			temp.addToMessage(not_valid_number);
		}//if index is not a valid number
		
		return temp;
		
		//messageBoard.setText(message);
		//System.out.println("Value: " + currentIndex.getValue() + "\nisInt: " + currentIndex.isInteger() + "\nisValid: " + currentIndex.isCorrect());
		
	}//end indexErrorMessage()
	
}//end HP_GUI
