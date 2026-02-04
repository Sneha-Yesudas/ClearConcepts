import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		
		File file =new File(System.getProperty("user.dir")+"\\Testdata\\logindata.xlsx");
		
		XSSFWorkbook xssfworkbook=new XSSFWorkbook(file);
		XSSFSheet xssfSheet=xssfworkbook.getSheet("Sheet1");
		Iterator<Row> rowIterator=xssfSheet.iterator();
		rowIterator.next();
//		System.out.println(rowIterator.next().toString());
		List<User>  userList=new ArrayList<User>();
		
		while(rowIterator.hasNext()) {
			Row row=rowIterator.next();
			Cell cell1=row.getCell(0);
			Cell cell2=row.getCell(1);
			User user=new User(cell1.toString(),cell2.toString());
			userList.add(user);
			
			System.out.println(userList.size());
			System.out.println(userList.toString());
			
		}
		System.out.println(userList.size());
		System.out.println(userList.toString());
		
		
		
	}

}
