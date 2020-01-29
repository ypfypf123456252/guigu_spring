package spel;

public class Car {
    private String brand;
    private double price;
    //轮胎周长
    private double tyrePerimeter;

    public Car() {
    }

    public Car(String brand, double price, double tyrePerimeter) {
        this.brand = brand;
        this.price = price;
        this.tyrePerimeter = tyrePerimeter;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTyrePerimeter() {
        return tyrePerimeter;
    }

    public void setTyrePerimeter(double tyrePerimeter) {
        this.tyrePerimeter = tyrePerimeter;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", tyrePerimeter=" + tyrePerimeter +
                '}';
    }
}
