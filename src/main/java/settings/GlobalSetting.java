package settings;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lmn on 10/11/16.
 */


public class GlobalSetting extends ProtoSetting{
    public GlobalSetting(String InputFile_Path){
        super();
        setProperty(INPUTFILE_PATH,InputFile_Path);
        setProperty(MS_DATABASEFILE_PATH,"src/main/resources/e_MS_DB");
        setProperty(MS_TOLERANCE_PPM,"10");
    }

    public <T> void setProperty(String Property_Name, T Property_Value){
        String temp_Property_Value = Property_Value.toString();
        propByUser.put(Property_Name, temp_Property_Value);
    }
    public void setProperties(HashMap<String, Object> Property_Pair){
        for (Map.Entry<String, Object> tempEntry:Property_Pair.entrySet()) {
            setProperty(tempEntry.getKey(),tempEntry.getValue());
        }
    }

    public String getProperty(String Property_Name){
        return propByUser.get(Property_Name);
    }

    public String toString(){
        StringBuilder tempStr = new StringBuilder();
        for (Map.Entry<String, String> tempEntry:propByUser.entrySet()) {
            tempStr.append(tempEntry.getKey()).append("---").append(tempEntry.getValue()).append("\n");
        }
        return tempStr.toString();
    }

    public void readSettings(String propFilePath) throws IOException {
        BufferedReader propFileReader = new BufferedReader(new FileReader(propFilePath));
        String line = "";
        while ((line = propFileReader.readLine()) != null){
            line = line.trim();
            if (line.startsWith("#") || line.startsWith("//") || line.length() == 0) continue;
            if (!line.contains("=")) continue;
            String[] tempStr = line.split("=");
            tempStr[0] = tempStr[0].trim();
            tempStr[1] = tempStr[1].trim();
            setProperty(tempStr[0],tempStr[1]);
        }
        propFileReader.close();
    }

    public void writeSettings(String proFilePath) throws IOException {
        BufferedWriter propFileWriter = new BufferedWriter(new FileWriter(proFilePath));
        propFileWriter.write(toString());
        propFileWriter.close();
    }
}
