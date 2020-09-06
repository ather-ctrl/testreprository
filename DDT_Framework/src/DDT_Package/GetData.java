package DDT_Package;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetData
{
	public static String[][] ReadExcel(String fileName, String sheetName) throws FileNotFoundException{
		File file = new File("TestData.xlsx");
		FileInputStream inp= new FileInputStream(file);
		Workbook wb =new XSSFWorkbook(inp);
		Sheet sh = wb.getSheet(sheetName);
		int rowNum = sh.getLastRowNum();
		int colNum = sh.getRow(0).getLastCellNum();
		String[][] data = new String[rowNum][colNum];
		for(int i=0; i<rowNum;i++){
			Row row =sh.getRow(i);
			for(int j=0;j<colNum;j++){
				String value = null;
				if(row.getCell(j).getCellType() == XSSFCell.CELL_TYPE_STRING){
					value = row.getCell(j).getStringCellValue();
				}
				else if(row.getCell(j).getCellType() ==XSSFCell.CELL_TYPE_NUMERIC)
				{
					value = String.valueOf(row.getCell(j).getNumericCellValue());
				}
				data[i][j]=value;
			}
		}
		return data;
	}
}