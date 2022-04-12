/** Test the Flik class.*/
public class Flik_test {
    @org.junit.Test
    public void TestFlik(){
        int[] input1 = {128,128};
        boolean output1 = true;
        boolean rst1 = Flik.isSameNumber(input1[0],input1[1]);
        org.junit.Assert.assertEquals(output1,rst1);
    }
}
