public class Electronics extends Products {
    // Constructor now doesn't handle the 'price'. it's done by setPriceMethod here
    public Electronics(String name, int productId, String description, double originalPrice, String color) {
        super(name, productId, description, color); // Price REMOVED
        setPrice(originalPrice); // Setting price with discount
    }

    // The 'setPrice' method now handles the price with discount logic.
    @Override
    protected void setPrice(double originalPrice) {
        double finalPrice = originalPrice - (0.10 * originalPrice); // Applying a 10% discount.
        this.price = finalPrice; // Calling the 'setPrice' of  products class
    }

    // returns the type of product.
    @Override
    public String getTypeOfProduct() {
        return "Electronics";
    }
}
