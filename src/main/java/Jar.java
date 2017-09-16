import java.util.Random;

public class Jar {

    private String itemName;
    private int numItems;
    private int maxNumItems;

    public Jar(String itemName, int maxNumItems) {
        this.itemName = itemName;
        this.maxNumItems = maxNumItems;
    }

    public void fill() {
        Random random = new Random();
        numItems = random.nextInt(maxNumItems) + 1;
    }

    public String getItemName() {
        return itemName;
    }

    public int getNumItems() {
        return numItems;
    }

    public int getMaxNumItems() {
        return maxNumItems;
    }

}