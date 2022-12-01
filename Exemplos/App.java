import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        List<Lista> lista = new ArrayList<>();
        lista.add(new Lista(10, "Diego", 10.50));
        lista.add(new Lista(20, "Marcos", 1.99));
        lista.add(new Lista(30, "Angélica", 100.00));
        lista.add(new Lista(40, "Marcelo", 5.50));
        lista.add(new Lista(50, "Apolo", 99.90));
        List<Lista> listaFiltrada = lista.stream().filter(x -> x.getId() > 23).collect(Collectors.toList());
        System.out.println("Lista nova");
        
        /**for (int i = 0; i < listaFiltrada.size(); i++) {
            System.out.println(listaFiltrada.get(i).getId());
        }*/
        
        listaFiltrada.forEach(x -> x.getId());

        lista.sort(Comparator.comparing(Lista::getPreço));
        lista.forEach(System.out::print);

    }

}