import org.example.Service.LogicaCuenta;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class LogicaCuentaTest {
    @Test
     void agregarSaldoTest_Ok(){
        LogicaCuenta mockLogica= Mockito.mock(LogicaCuenta.class);

        when(mockLogica.agregarSaldo(5, 10000)).thenReturn(true);

        boolean resp = mockLogica.agregarSaldo(5,10000);

        assertTrue(resp);

    }

    @Test
    void agregarSaldo_Error(){
        LogicaCuenta mockLogica = Mockito.mock(LogicaCuenta.class);

        when(mockLogica.agregarSaldo(5,-10)).thenReturn(false);

        boolean resp = mockLogica.agregarSaldo(5,-10);

        assertFalse(resp);
    }

}
