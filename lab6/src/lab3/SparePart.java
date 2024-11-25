package lab3;


public class SparePart implements Comparable<SparePart>{


    private String partName; 
    private int quantity;     
    private double unitPrice; 
    private int storageDuration; 
    
    private static int instanceCount = 0;
    private int instanceNumber;

    public SparePart() {
        this.partName = "Unknown Part";
        this.quantity = 0;
        this.unitPrice = 0.0;
        this.storageDuration = 12;
        instanceCount++;
        this.instanceNumber = instanceCount;
    }

    public SparePart(String partName, int quantity, double unitPrice, int storageDuration) {
        setPartName(partName);
        setQuantity(quantity);
        setUnitPrice(unitPrice);
        setStorageDuration(storageDuration);
        instanceCount++;
        this.instanceNumber = instanceCount;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        if (partName != null && !partName.isEmpty()) {
            this.partName = partName;
        } else {
            System.out.println("Part name cannot be empty.");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Quantity cannot be negative!");
        }
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        if (unitPrice > 0) {
            this.unitPrice = unitPrice;
        } else {
            System.out.println("Unit price must be positive!");
        }
    }

    public int getStorageDuration() {
        return storageDuration;
    }

    public void setStorageDuration(int storageDuration) {
        if (storageDuration > 0 && storageDuration <= 60) {
            this.storageDuration = storageDuration;
        } else {
            System.out.println("Storage duration must be between 1 and 60 months!");
        }
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }

    public void displayInfo() {
        System.out.println("Spare Part " + partName + ", quantity: " + quantity + ", unit price: " + unitPrice + ", storage duration: " + storageDuration + " months");
        System.out.println("SPARE PART " + partName.toUpperCase() + ", QUANTITY: " + quantity + ", UNIT PRICE: " + unitPrice + ", STORAGE DURATION: " + storageDuration + " MONTHS");
    }
    
    @Override
    public int compareTo(SparePart other) {
        return Double.compare(this.unitPrice, other.unitPrice);
    }

    public static void main(String[] args) {
        SparePart part1 = new SparePart();
        SparePart part2 = new SparePart("Brake Pad", 50, 15.99, 24);
        SparePart part3 = new SparePart("Oil Filter", 30, 5.99, 18);

        part1.displayInfo();
        part2.displayInfo();
        part3.displayInfo();

        SparePart[] partsArray = { part1, part2, part3 };
        System.out.println("\nDisplaying all spare parts from array:");
        for (SparePart part : partsArray) {
            part.displayInfo();
            System.out.println("Instance number: " + part.getInstanceNumber());
            System.out.println();
        }
    }
}
