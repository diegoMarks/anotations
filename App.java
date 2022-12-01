import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
       List<Lista> lista = new ArrayList<>();
       lista.add(new Lista(10));
       lista.add(new Lista(20));
       lista.add(new Lista(30));
       lista.add(new Lista(40));
       lista.add(new Lista(50));
       List<Lista> listaFiltrada = lista.stream().filter(x -> x.getId() > 23).collect(Collectors.toList());
       System.out.println("Lista nova");
    for (int i = 0; i < listaFiltrada.size(); i++) {
        System.out.println(listaFiltrada.get(i).getId());
       }
    }
}