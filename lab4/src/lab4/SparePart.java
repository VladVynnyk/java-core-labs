package lab4;
import java.util.Objects;


//Interface
interface PartOperations {
	void increaseQuantity(int amount);
	void decreaseQuantity(int amount);
}

//Enum for categories of Parts
enum PartCategory {
	ENGINE, BRAKES, SUSPENSION, ELECTRICAL, TRANSMISSION;
}

// Abstract class w
abstract class Part {
	protected String partName;
	protected int quantity;
	protected double unitPrice;

	public Part(String partName, int quantity, double unitPrice) {
		this.partName = partName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public abstract double calculateTotalValue();

	// Basic method (not abstract)
	public void displayPartInfo() {
		System.out.println("Part Name: " + partName + ", Quantity: " + quantity + ", Unit Price: " + unitPrice);
	}
}


public class SparePart extends Part implements PartOperations, Comparable<SparePart>, Cloneable {

    private int storageDuration;
    private PartCategory category;
    
    private static int instanceCount = 0;
    private int instanceNumber;

    public SparePart() {
        super("Unknown Part", 0, 0.0);
        this.storageDuration = 12;
        this.category = PartCategory.ENGINE;
        this.unitPrice = 0.0;
        this.storageDuration = 12;
        instanceCount++;
        this.instanceNumber = instanceCount;
    }

    public SparePart(String partName, int quantity, double unitPrice, int storageDuration, PartCategory category) {
        super(partName, quantity, unitPrice);
        this.partName = partName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.storageDuration = storageDuration;
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
    public void increaseQuantity(int amount) {
        if (amount > 0) {
            this.quantity += amount;
        } else {
            System.out.println("Increase amount must be positive.");
        }
    }

    @Override
    public void decreaseQuantity(int amount) {
        if (amount > 0 && amount <= this.quantity) {
            this.quantity -= amount;
        } else {
            System.out.println("Decrease amount is invalid.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SparePart sparePart = (SparePart) o;
        return quantity == sparePart.quantity && Double.compare(sparePart.unitPrice, unitPrice) == 0 &&
               storageDuration == sparePart.storageDuration && Objects.equals(partName, sparePart.partName) &&
               category == sparePart.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(partName, quantity, unitPrice, storageDuration, category);
    }

    @Override
    public String toString() {
        return "SparePart{" +
                "partName='" + partName + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", storageDuration=" + storageDuration +
                ", category=" + category +
                '}';
    }

    @Override
    public SparePart clone() {
        try {
            return (SparePart) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public int compareTo(SparePart other) {
        return Double.compare(this.unitPrice, other.unitPrice);
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    @Override
    public double calculateTotalValue() {
        return quantity * unitPrice;
    }
    
    
    public static void main(String[] args) {
        Part anonymousPart = new Part("Anonymous Part", 10, 50.0) {
            @Override
            public double calculateTotalValue() {
                return quantity * unitPrice;
            }
        };
        anonymousPart.displayPartInfo();
        System.out.println("Instance count: " + SparePart.getInstanceCount());

        Part part1 = new SparePart("Brake Pad", 50, 15.99, 24, PartCategory.BRAKES);
        Part part2 = new SparePart("Oil Filter", 30, 5.99, 18, PartCategory.ENGINE);
        Part part3 = new SparePart("Battery", 15, 70.0, 36, PartCategory.ELECTRICAL);
        
        

        System.out.println(part1.toString());
        System.out.println(part2.toString());
        System.out.println(part3.toString());

        System.out.println("Comparing part1 and part2: " + part1.equals(part2));

        System.out.println("Available Part Categories:");
        for (PartCategory category : PartCategory.values()) {
            System.out.println(category);
        }

        SparePart clonedPart = ((SparePart) part1).clone();
        System.out.println("Cloned part: " + clonedPart.toString());

        System.out.println("Comparing part1 and part3 by price: " + ((SparePart) part1).compareTo((SparePart) part3));
        
        
        
        Part electronic_part = new ElectronicPart("Microchip", 100, 5.50, 24);

        
        Part[] parts = { part1, part2, part3, electronic_part };

        // Calling methods with dynamic polymorphism
        for (Part part : parts) {
            part.displayPartInfo();
            System.out.println("Total Value: " + part.calculateTotalValue());
            System.out.println();
        }
    }
}
