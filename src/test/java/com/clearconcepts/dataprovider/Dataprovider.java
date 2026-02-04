package com.clearconcepts.dataprovider;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import com.clearconcepts.pojo.User;
import com.clearconcepts.utilities.ExcelReadeUtility;

public class Dataprovider {

	@DataProvider(name = "dataproviderformexcel")
	public Iterator<User> readExcelData() throws InvalidFormatException, IOException {
     return com.clearconcepts.utilities.ExcelReadeUtility.readExcel();
	}

}
