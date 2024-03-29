package app;

@Product(name = "orange", quota = 12)
public class ProductInfo {
    @Product
    public String getData() {
        return "No data...";
    }
}
