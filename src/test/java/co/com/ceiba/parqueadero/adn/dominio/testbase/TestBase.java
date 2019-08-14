package co.com.ceiba.parqueadero.adn.dominio.testbase;

import static org.junit.Assert.fail;
import java.util.function.Supplier;
import org.junit.Assert;

	public class TestBase {
	    private static final String FUE_LANZADA = " Pero fue lanzada ";
	    private static final String SE_ESPERABA = "Se esperaba la excepcion ";

	    public static <T> void assertThrows(Supplier<T> supplier, Class<? extends Exception> exception, String message) {
	        try {
	            supplier.get();
	            fail();
	        } catch (Exception e) {
	            Assert.assertTrue(SE_ESPERABA + exception.getCanonicalName() + FUE_LANZADA
	                    + e.getClass().getCanonicalName(), exception.isInstance(e));
	            Assert.assertTrue(e.getMessage().contains(message));
	        }
	    }

	    public static void assertThrows(Thunk thunk, Class<? extends Exception> exception, String message) {
	        try {
	            thunk.execute();
	            fail();
	        } catch (Exception e) {
	            Assert.assertTrue(SE_ESPERABA + exception.getCanonicalName() + FUE_LANZADA
	                    + e.getClass().getCanonicalName(), exception.isInstance(e));
	            Assert.assertTrue(e.getMessage().contains(message));
	        }
	    }

	    @FunctionalInterface
	    public interface Thunk {
	        void execute();
	    }
}


