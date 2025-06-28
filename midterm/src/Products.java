public abstract class Products {
    private String name;
    private int productId;
    private String description;
    protected double price; // Protected, so it's accessed in product & electronic directly
    private String color;

    // constructor without the price
    public Products(String name, int productId, String description, String color) {
        this.name = name;
        this.productId = productId;
        this.description = description;
        this.color = color;
        // Price is not set in the constructor anymore.
    }

//GETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    //SETTERS
    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    // 'setPrice' is now a protected method, not abstract
    protected  abstract void setPrice(double price);


    public abstract String getTypeOfProduct();

    // The toString method
    @Override
    public String toString() {
        return "Name: " + name +
                "\nProduct ID: " + productId +
                "\nDescription: " + description +
                "\nPrice: $" + price + // Now we're showing the price directly from the protected field.
                "\nColor: " + color;
    }
}
