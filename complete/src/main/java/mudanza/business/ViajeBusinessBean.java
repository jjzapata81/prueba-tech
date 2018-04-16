package mudanza.business;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ViajeBusinessBean implements ViajeBusiness {

    @Override
    public Integer calcularViajes(List<Integer> elementos) {

        int viajes = 0;
        List<Integer> bolsa = new ArrayList<>();
        while (!elementos.isEmpty()) {
            Collections.sort(elementos);
            int indexElementoMasPesado = elementos.size() - 1;
            bolsa.add(elementos.get(indexElementoMasPesado));
            elementos.remove(indexElementoMasPesado);
            if (elementos.isEmpty())
                return viajes;
            while (pesoBolsaInferior50(bolsa)) {
                final int indexElementoMenosPesado = 0;
                bolsa.add(elementos.get(indexElementoMenosPesado));
                elementos.remove(indexElementoMenosPesado);
            }
            viajes++;
            bolsa.clear();
        }
        return viajes;
    }

    private boolean pesoBolsaInferior50(List<Integer> bolsa) {
        return bolsa.get(0) * bolsa.size() <= 50;

    }

    public List<List<Integer>> leerDatos(String cadenaInput) {
        cadenaInput = cadenaInput.replace("=", "");
        List<Integer> elementos;
        List<List<Integer>> elementosXDia = new ArrayList<>();

        String[] splitInfo = cadenaInput.split("%2C");
        List<Integer> datos = new ArrayList<>();

        for (String ele : splitInfo) {
            datos.add(Integer.valueOf(ele));
        }

        int i = 1;
        while (i < datos.size()) {
            int nDatos = datos.get(i);
            int rangoIni = i + 1;
            int rangoFin = rangoIni + nDatos;
            elementos = new ArrayList<>(datos.subList(rangoIni, rangoFin));
            elementosXDia.add(new ArrayList<>(elementos));
            elementos.clear();
            i = rangoFin;
        }
        return elementosXDia;
    }
}
