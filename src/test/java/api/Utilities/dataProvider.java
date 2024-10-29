package api.Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utilies.xlLeadUtility;

public class dataProvider {

	@DataProvider(name = "dataLead")
	public String[][] getAllData() throws IOException {
		String path = "C:\\Eclipse New\\NewWorkSpace\\TravelCrmApiAutomation\\testdata\\CreateLeadTestData.xlsx";
		xlLeadUtility xl = new xlLeadUtility(path);

		int rownum = xl.getRowCount("Sheet1");
		int colcount = xl.getCellCount("Sheet1", 1);

		// Ensure valid rownum and colcount
		if (rownum <= 0 || colcount <= 0) {
			throw new RuntimeException("No data found in the Excel sheet.");
		}

		String appdata[][] = new String[rownum - 1][colcount]; // Adjusted to account for header

		for (int i = 1; i < rownum; i++) { // Start from 1 if the first row is headers
			for (int j = 0; j < colcount; j++) {
				appdata[i - 1][j] = xl.getCellData("Sheet1", i, j);
			}
		}
		return appdata;
	}
}
