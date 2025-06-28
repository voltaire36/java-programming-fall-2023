public class Clothes extends Products {
    // Constructor now doesn't handle the 'price'. it's done by setPriceMethod here
    public Clothes(String name, int productId, String description, double originalPrice, String color) {
        super(name, productId, description, color); // Price REMOVED
        setPrice(originalPrice); // Setting price with discount
    }

    // The 'setPrice' method now handles the price with discount
    @Override
    protected void setPrice(double originalPrice) {
        double finalPrice = originalPrice - (0.20 * originalPrice); // Applying a 20% discount.
        this.price = finalPrice; // Calling the 'setPrice' of  products class
    }

    // returns the type of product.
    @Override
    public String getTypeOfProduct() {
        return "Clothes";
    }
}
