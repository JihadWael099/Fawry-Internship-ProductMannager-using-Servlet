package ProductModel;

public class Product {

    private String name;
    private double price;
    private int id;
    public String getName() {
        if(name==null)throw new RuntimeException("null name");
        return name;
    }

    public void setName(String name) {
        if(name.length()>=100)throw new RuntimeException("Product name too long");
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price<0)throw new RuntimeException("Price not allowed");
        this.price = price;
    }
}
