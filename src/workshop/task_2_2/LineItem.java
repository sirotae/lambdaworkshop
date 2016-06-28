package workshop.task_2_2;

import java.util.function.Function;

/**
 * Created by olenasyrota on 6/28/16.
 */
public class LineItem {

    private String name;
    private final double value;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return this.value;
    }

    public LineItem(String name, double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.name + " $ " + this.getValue();
    }
}