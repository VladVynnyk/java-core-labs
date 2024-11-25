package lab4;

import java.util.Objects;

public class ElectronicPart extends Part {
    private int warrantyMonths;

    public ElectronicPart(String partName, int quantity, double unitPrice, int warrantyMonths) {
        super(partName, quantity, unitPrice);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        if (warrantyMonths >= 0) {
            this.warrantyMonths = warrantyMonths;
        } else {
            System.out.println("Warranty duration must be non-negative!");
        }
    }

    @Override
    public double calculateTotalValue() {
        return quantity * unitPrice + warrantyMonths * 2; // Додаємо вартість гарантії
    }

    @Override
    public void displayPartInfo() {
        System.out.println("Electronic Part - Name: " + partName + ", Quantity: " + quantity + 
                           ", Unit Price: " + unitPrice + ", Warranty: " + warrantyMonths + " months");
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElectronicPart that = (ElectronicPart) o;
        return quantity == that.quantity &&
               Double.compare(that.unitPrice, unitPrice) == 0 &&
               warrantyMonths == that.warrantyMonths &&
               Objects.equals(partName, that.partName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partName, quantity, unitPrice, warrantyMonths);
    }

}