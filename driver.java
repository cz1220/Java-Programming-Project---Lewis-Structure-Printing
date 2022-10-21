
public class driver {
    public static void main(String[] args) {
        LewisTreePrinting<String> example = new LewisTreePrinting<>();
        example.setRoot("N");
        example.Add("C", "East");
        example.Add("A", "South");
        example.Move("North");
        example.Move("West");
        example.Add("K", "South");
        example.Add("M", "West");
        example.Print();
    }
}
