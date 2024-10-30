package api.Utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderLead {
	
    @DataProvider(name = "dataLead")
    public String[][] getAllData() throws IOException {
    	String path = "C:\\Eclipse New\\NewWorkSpace\\TravelCrmApiAutomation\\testdata\\CreateLeadTestData (1).xlsx";
        xlLeadUtility xl = new xlLeadUtility(path);
        System.out.println(xl);
        int rownum = xl.getRowCount("Sheet1");
        int colcount = xl.getCellCount("Sheet1", 1);

        if (rownum <= 0 || colcount <= 0) {
            throw new RuntimeException("No data found in the Excel sheet.");
        }

        String[][] appdata = new String[rownum - 1][colcount]; 

        for (int i = 1; i < rownum; i++) {
            for (int j = 0; j < colcount; j++) {
                appdata[i - 1][j] = xl.getCellData("Sheet1", i, j);
            }
        }
        return appdata;
    }
}
