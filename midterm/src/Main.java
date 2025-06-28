import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Input dialog for product information
        String name = JOptionPane.showInputDialog("Product name:");
        int productId = Integer.parseInt(JOptionPane.showInputDialog("Product ID:"));
        String description = JOptionPane.showInputDialog("Product description:");
        // The price is now manipulated in clothes or electronics classes
        double price = Double.parseDouble(JOptionPane.showInputDialog("Product price:"));
        String color = JOptionPane.showInputDialog("Product color:");
        String type = JOptionPane.showInputDialog("Enter product type (Clothes/Electronics):").toLowerCase();

        Products product; // Prof change = create a variable of product type outside dont assign object here


        if (type.equals("clothes")) {
            product = new Clothes(name, productId, description, price, color);
        } else if (type.equals("electronics")) {
            product = new Electronics(name, productId, description, price, color);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid product type entered. Please enter 'Clothes' or 'Electronics'.");
            return;
        }


        JOptionPane.showMessageDialog(null, product.toString() + "\nType: " + product.getTypeOfProduct());
    }
}
