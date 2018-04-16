package mudanza.business;

import java.util.List;

public interface ViajeBusiness {
    Integer calcularViajes(List<Integer> objetos);

    List<List<Integer>> leerDatos(String info);
}
