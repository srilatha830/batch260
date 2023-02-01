

package mypack;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test114 
{
	public static void main(String[] args) throws Exception
	{
		//Connect to existing file in HDD
		File f=new File("src\\test\\resources\\datafiles\\exceldata1.xlsx");
		//Take READ permission on that file
		FileInputStream fi=new FileInputStream(f);
		//Consider that file as Excel file(workbook) and shift it to RAM
		Workbook wb=WorkbookFactory.create(fi); 
		//Collect all sheets(Spread sheets) in that workbook
		int nos=wb.getNumberOfSheets();
		System.out.println(nos);
		//Goto each sheet
		for(int i=0;i<nos;i++)
		{
			Sheet sh=wb.getSheetAt(i);
			String shn=sh.getSheetName();
			try
			{
				int nur=sh.getPhysicalNumberOfRows();
				int nuc=sh.getRow(0).getLastCellNum();
				System.out.println(shn+" has "+nur+" rows and "+nuc+" columns");
			}
			catch(NullPointerException ex)
			{
				System.out.println(shn+" is empty");
			}
		}
		//close permissions
		wb.close();
		fi.close();
	}
}