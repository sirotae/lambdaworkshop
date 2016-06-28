package workshop.task_2_2;

import java.util.function.Function;

/**
 * Created by olenasyrota on 6/28/16.
 */
public class Supplier {

    private final String name;
    private final String[] itemNames;

    public Supplier(String name, String[] itemNames) {
        this.name = name;
        this.itemNames = itemNames;
    }

    public String getName() {
        return this.name;
    }

    public String[] getItemNames() {
        return this.itemNames;
    }
}