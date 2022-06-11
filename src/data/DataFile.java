package data;

import utilities.Xls_Reader;

public class DataFile {
	
Xls_Reader readXL = new Xls_Reader("C:\\testing\\frameworkExcel.xlsx");
	
	public String wrongEmail =readXL.getCellData("Sheet1", "WrongEmail", 2);
	public String wrongPassword = readXL.getCellData("Sheet1", 1, 2) ;
	public String emailWithSpeacialChar = readXL.getCellData("Sheet1", 2, 2) ;
	public String globalErr = readXL.getCellData("Sheet1", 3, 2) ;
	public String specialCharEmailErr = readXL.getCellData("Sheet1", 4, 2) ;
	public String emptyEmailErr =readXL.getCellData("Sheet1", 5, 2) ;
	public String emptyPasswordErr =readXL.getCellData("Sheet1", 6, 2) ;
	
	//this is datafile
}
