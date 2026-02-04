package com.clearconcepts.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.clearconcepts.pojo.User;

public class ExcelReadeUtility {

	public static Iterator<User> readExcel() throws InvalidFormatException, IOException {

		User userObject = null;
		List<User> listOfUser = new ArrayList<User>();
		File file = new File(System.getProperty("user.dir") + "\\Testdata\\logindata.xlsx");
		XSSFWorkbook xssfworkbook = new XSSFWorkbook(file);
		XSSFSheet xssfsheet = xssfworkbook.getSheet("Sheet1");
		Iterator<Row> iteratorRow = xssfsheet.iterator();
		System.out.println(iteratorRow.toString());
		iteratorRow.next();
		while (iteratorRow.hasNext()) {
			Row row = iteratorRow.next();

			Cell cell1 = row.getCell(0);
			Cell cell2 = row.getCell(1);

			userObject = new User(cell1.toString(), cell2.toString());

			listOfUser.add(userObject);
			System.out.println("added value" + listOfUser.toString());
			System.out.println("Total rows read = " + listOfUser.size());

		}

		xssfworkbook.close();
		return listOfUser.iterator();

	}

}
