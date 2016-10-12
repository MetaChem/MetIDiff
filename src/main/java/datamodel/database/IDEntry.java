package datamodel.database;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lmn on 10/12/16.
 * IDLevel-- Show the num of the parameters in each entry
 * Level 0-- Code, Database Name
 * Level 1-- Level 0, molname
 */
public class IDEntry {
    protected String code;
    protected String databaseName;
    protected HashMap<Item, String> idMap;
    protected int idLevel;

    public enum Item {molName};

    public IDEntry(String code, String databaseName){
        this.code = code;
        this.databaseName = databaseName;
        this.idMap = new HashMap<>();
        this.idLevel = idMap.size();
    }

    public void setIDItem(Item item, String value){
        this.idMap.put(item,value);
        this.idLevel = idMap.size();
    }

    public String getIdMap(Item item){return idMap.get(item);}
    public HashMap<Item, String> getIdMaps(){return idMap;}

    public String getCode(){return code;}
    public String getDatabaseName(){return databaseName;}
    public int getIDLevel(){return idLevel;}

    public void copyIDEntry(IDEntry idEntry){
        this.code = idEntry.getCode();
        this.databaseName = idEntry.getDatabaseName();
        this.idMap = idEntry.getIdMaps();
        this.idLevel = idEntry.getIDLevel();
    }

    public String toString(){
        StringBuilder tempStr = new StringBuilder();
        tempStr.append("Code-").append(this.code).append("\n")
                .append("Database-").append(this.databaseName).append("\n")
                .append("IDLevel-").append(this.idLevel).append("\n");
        for (Map.Entry<Item, String> tempEntry:idMap.entrySet()){
            tempStr.append(tempEntry.getKey()).append("-").append(tempEntry.getValue()).append("\n");
        }
        return tempStr.toString();
    }
}
