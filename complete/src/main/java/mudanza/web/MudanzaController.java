package mudanza.web;

import mudanza.business.ViajeBusinessBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MudanzaController {

    @Autowired
    private ViajeBusinessBean viajeBusinessBean;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/calcularViajes")
    public List<Integer> calcularViajes(@RequestBody String info) {
        List<Integer> viajesxDia = new ArrayList<>();
        List<List<Integer>> elementosXDia = viajeBusinessBean.leerDatos(info);
        for (List<Integer> elementos : elementosXDia) {
            viajesxDia.add(viajeBusinessBean.calcularViajes(elementos));
        }
        return viajesxDia;
    }
}
