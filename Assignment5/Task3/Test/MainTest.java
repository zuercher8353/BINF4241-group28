import org.junit.*;

/**
Testing the functionality of the Main
 */
public class MainTest {

/**
 * Test weather checkSyntaxInput return the same String if correct input or 'error' else
 */
@Test
public void testSyntaxValidation(){
        Assert.assertEquals("Should return same String", Main.checkSyntaxInput("green7", "green7"));
        Assert.assertEquals("Should return error on wrong input", Main.checkSyntaxInput("green9","error"));
        Assert.assertEquals("Should return error on wrong input", Main.checkSyntaxInput("abcde2","error"));
}
}