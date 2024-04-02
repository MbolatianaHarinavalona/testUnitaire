 package test_unitaire;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
    private Money m12CHF;
    private Money m14CHF;
    private Money m7USD;
    
    @Before
    public void setUp() {
        m12CHF = new Money(12, "CHF");
        m14CHF = new Money(14, "CHF");
        m7USD = new Money(7, "USD"); 
    }
    
   // @Test
   // public void testSimpleAdd() {
   //   Money expected = new Money(26, "CHF");
   //MoneyBag result = m12CHF.add(m14CHF); // Utiliser la méthode add de MoneyBag
   //assertTrue(expected.equals(result)); // comparaison
   // }

    
    @Test
    public void testEquals() {
        assertTrue(!m12CHF.equals(null));
        assertEquals(m12CHF, m12CHF);
        assertEquals(m12CHF, new Money(12, "CHF"));
        assertTrue(!m12CHF.equals(m14CHF));
    }
    
    @Test
    public void testMixedSimpleAdd() {
        // [12 CHF] + [7 USD] == {[12 CHF][7 USD]}
        Money bag[] = { m12CHF, m7USD }; // Suppose m7USD est un objet Money déjà défini
        MoneyBag expected = new MoneyBag(bag);
        MoneyBag result = m12CHF.add(m7USD); // Utiliser la méthode add de MoneyBag
        assertEquals(expected, result);
    }


}