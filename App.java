import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class App{
    public static void main(String[] args) {
        
        System.out.println(ChronoUnit.MONTHS.between(LocalDate.of(2022, 07, 01), LocalDate.now()));
    }
}