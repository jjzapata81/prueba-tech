package mudanza.business;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Ignore
@RunWith(MockitoJUnitRunner.class)
public class ViajeBusinessBeanTest {

    @InjectMocks
    private ViajeBusinessBean viajeBusinessBean;


    @Test
    public void calcularViajes() {
        List<Integer> reqCaso1 = new ArrayList<>(Arrays.asList(1, 30, 1, 30));
        List<Integer> reqCaso2 = new ArrayList<>(Arrays.asList(20, 20, 20));
        List<Integer> reqCaso3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        List<Integer> reqCaso4 = new ArrayList<>(Arrays.asList(9, 19, 29, 39, 49, 59));
        List<Integer> reqCaso5 = new ArrayList<>(Arrays.asList(32, 56, 76, 8, 44, 60, 47, 85, 71, 91));
        Integer result1 = viajeBusinessBean.calcularViajes(reqCaso1);
        Integer result2 = viajeBusinessBean.calcularViajes(reqCaso2);
        Integer result3 = viajeBusinessBean.calcularViajes(reqCaso3);
        Integer result4 = viajeBusinessBean.calcularViajes(reqCaso4);
        Integer result5 = viajeBusinessBean.calcularViajes(reqCaso5);
        Assert.assertEquals(2, result1.intValue());
        Assert.assertEquals(1, result2.intValue());
        Assert.assertEquals(2, result3.intValue());
        Assert.assertEquals(3, result4.intValue());
        Assert.assertEquals(8, result5.intValue());
    }

    @Test

    public void leerDatos() {
        // List<Integer> cadenaInput = new ArrayList<>(Arrays.asList(2, 4, 30, 30, 1, 1, 3, 20, 20, 20));
        String cadenaInput = "2,4,30,30,1,1,3,20,20,20";
        List<List<Integer>> result = viajeBusinessBean.leerDatos(cadenaInput);
        Assert.assertEquals(result.get(0).get(0).intValue(), 30);
        Assert.assertEquals(result.get(0).get(1).intValue(), 30);
        Assert.assertEquals(result.get(0).get(2).intValue(), 1);
        Assert.assertEquals(result.get(0).get(3).intValue(), 1);
        Assert.assertEquals(result.get(1).get(0).intValue(), 20);
        Assert.assertEquals(result.get(1).get(1).intValue(), 20);
        Assert.assertEquals(result.get(1).get(2).intValue(), 20);
    }
}