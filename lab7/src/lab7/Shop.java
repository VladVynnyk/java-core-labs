package lab7;

public class Shop {
    private String name;
    private String address;
    private String phoneNumber;

    public Shop(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public class Product {
        private String productName;
        private double price;
        private int stockQuantity;
        private String description;

        public Product(String productName, double price, int stockQuantity, String description) {
            this.productName = productName;
            this.price = price;
            this.stockQuantity = stockQuantity;
            this.description = description;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getStockQuantity() {
            return stockQuantity;
        }

        public void setStockQuantity(int stockQuantity) {
            this.stockQuantity = stockQuantity;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "productName='" + productName + '\'' +
                    ", price=" + price +
                    ", stockQuantity=" + stockQuantity +
                    ", description='" + description + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
    
    public static void main(String[] args) {
        Shop shop = new Shop("Tech Store", "123 Main St", "555-1234");

        Shop.Product product1 = shop.new Product("Laptop", 999.99, 10, "High-end gaming laptop");
        Shop.Product product2 = shop.new Product("Smartphone", 499.99, 20, "Latest model smartphone");

        System.out.println(shop);
        System.out.println(product1);
        System.out.println(product2);
    }
}
