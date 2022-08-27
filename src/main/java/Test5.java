import java.util.Arrays;
import java.util.Random;

public class Test5 {
    public static void main(String[] args) {
        String [] arr = new String[10];
        String num = "number ";
        Arrays.stream(arr).map(e -> num + " " + new Random().nextInt(10)).forEach(System.out::println);
        System.out.println("RAVIL");
    }
}
