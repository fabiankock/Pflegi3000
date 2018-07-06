package comfabiankockpflegi3000.github.pflegi3000.database.tables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "insurance")
public class InsuranceEntity {

    @DatabaseField(columnName = "iId", generatedId = true) private int id;
    @DatabaseField(columnName = "Name") private String name;
    @DatabaseField(columnName = "Type") private String type;

    public InsuranceEntity(){}
    public InsuranceEntity(String name, String type){

        this.name = name;
        this.type = type;
    }

    /*----------------Getter----------------*/
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    /*----------------Setter----------------*/

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
