package lab10;

class Part {
    private String name;
    private double price;
    private int quantity;

    public Part(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Part{name='" + name + "', price=" + price + ", quantity=" + quantity + "}";
    }
}
