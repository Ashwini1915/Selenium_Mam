package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	public Workbook wb;

	public String fetchDataFromExcelFile(String sheetname, int rowindex, int cellindex)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/VtigerTestData.xlsx");
		wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rowindex).getCell(cellindex).toString();
		return data;
	}

	public void writeBackDataToExcel(String sheetname, int rowindex, int cellindex, String value) throws Exception {
		FileInputStream fis = new FileInputStream("./src/test/resources/VtigerTestData.xlsx");
		wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row r = sh.getRow(rowindex);
		Cell c = r.createCell(cellindex);
		c.setCellValue(value);
		FileOutputStream fos = new FileOutputStream("./src/test/resources/VtigerTestData.xlsx");
		wb.write(fos);
	}

	public void closeExcelFile() throws IOException {
		wb.close();
	}

//	public void  fetchMultipleData(String sheetname) throws Exception {
//		FileInputStream fis = new FileInputStream("./src/test/resources/VtigerTestData.xlsx");
//		wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet(sheetname);
//
//		for (int i = 0; i <= sh.getLastRowNum(); i++) {
//			for (int j = 0; j < sh.getRow(i).getLastCellNum(); j++) {
//
//				String data = sh.getRow(i).getCell(j).toString();
//
//			}
//		}
//		
//	}

}
