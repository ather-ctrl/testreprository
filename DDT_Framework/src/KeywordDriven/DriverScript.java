package KeywordDriven;

public class DriverScript
{

 public static void main(String[] args) throws Exception 
 {
 //Declaring the path of the Excel file with the name of the Excel file
 String sPath = "DataEngine.xlsx"; 
 //Here we are passing the Excel path and SheetName as arguments to connect with Excel file
 ReadExcelData.setExcelFile(sPath, "Sheet");
 //Hard coded values are used for Excel row & columns for now     
 //Hard coded values are used for Excel row & columns for now    
 //In later chapters we will replace these hard coded values with varibales    //This is the loop for reading the values of the column 3 (Action Keyword) row by row
 for (int iRow=1;iRow<=7;iRow++)
 {
 String sActions = ReadExcelData.getCellData(iRow, 1); 
 
 //Comparing the value of Excel cell with all the keywords in the "Actions" class
 if(sActions.equals("openApp")) {
	 Actions.launchApp();
 }
 else if(sActions.equals("inputuser"))
 { 
 //This will execute if the excel cell value is 'openBrowser'    
 //Action Keyword is called here to perform action
 Actions.input_Username();
 }
 else if(sActions.equals("inputpwd"))
 {
 Actions.input_Password();
 }
 else if(sActions.equals("closeApp"))
 {
 Actions.closeApp();
 } 
 }
 }
}


