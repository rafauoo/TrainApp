package app.pociagi.db.Objects;

import java.util.HashMap;

/**
 * <h2> Discount </h2>
 * Representation of data from a row from DISCOUNTS database table.
 * <p></p>
 * <b>Note:</b> Object is created (by constructors) only locally independently of Database.
 * It can get data from Database but it does not have to. To push object to Database use:
 * object.pushToDB();
 * <p></p>
 * Objects are immutable (only change of nullable attributes is possible)
 * @author rafal
 * @since 2022-12-07
 */
public class Discount extends DBObject{
    private final String name;
    private final String value;

    /**
     * <h2> Create Discount Object </h2>
     * Creates a discount object
     * @param id discount id (PK)
     * @param name name of discount that will be displayed
     * @param value how much discount is (%)
     * <p>
     * @author rafal
     * @since 2022-12-07
     */
    public Discount(Integer id, String name, String value) {
        super(id);
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    /**
     * <h2> Push object to Database (Table DISCOUNTS)</h2>
     * Pushes created object to database with set attributes.
     * <p>
     * @author rafal
     * @since 2022-12-07
     */
    @Override
    public void pushToDB() {
        HashMap<String, Object> dict = new HashMap<>();
        dict.put("ID", this.getID());
        dict.put("NAME", this.name);
        dict.put("VALUE", this.value);
        super.data = dict;
        super.table = "DISCOUNTS";
        super.pushToDB();
    }
}