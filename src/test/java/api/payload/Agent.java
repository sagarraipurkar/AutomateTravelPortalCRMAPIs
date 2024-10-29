package api.payload;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Agent {

    private JSONObject data;

    public Agent() {
        File f = new File("C:\\Eclipse New\\NewWorkSpace\\TravelCrmApiAutomation\\testdata\\CreateAgentTestData.json");
        
        try (FileReader fr = new FileReader(f)) {
            JSONTokener jsonToken = new JSONTokener(fr);
            data = new JSONObject(jsonToken);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as needed
        }
    }

    public JSONObject getData() {
        return data;
    }
}
