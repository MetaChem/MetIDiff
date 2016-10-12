package settings;

/**
 * Created by lmn on 10/11/16.
 */

import java.util.*;

public class ProtoSetting {
    protected Map<String, String> propByUser;
    protected final String INPUTFILE_PATH;
    protected final String MS_DATABASEFILE_PATH;
    protected final String MS_TOLERANCE_PPM;

    protected ProtoSetting(){
        INPUTFILE_PATH = "InputFile_Path";
        MS_DATABASEFILE_PATH = "MS_DatabaseFile_Path";
        MS_TOLERANCE_PPM = "MS_Tolerance(ppm)";
        propByUser = new HashMap<>();
    }
}