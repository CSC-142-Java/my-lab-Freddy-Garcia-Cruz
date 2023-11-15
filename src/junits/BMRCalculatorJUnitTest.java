//package junits;
//
//import static calculator.BMRCalculator.computeBMI;
//import static calculator.BMRCalculator.computeBMR;
//import static calculator.BMRCalculator.getAge;
//import static calculator.BMRCalculator.getBodyType;
//import static calculator.BMRCalculator.getBurnRate;
//import static calculator.BMRCalculator.getHeight;
//import static calculator.BMRCalculator.getName;
//import static calculator.BMRCalculator.getWeight;
//import static calculator.BMRCalculator.getWeightCategory;
//import static calculator.BMRCalculator.isValidBodyType;
//import static calculator.BMRCalculator.isValidHeight;
//import static calculator.BMRCalculator.isValidInteger;
//import static calculator.BMRCalculator.isValidWeight;
//import static calculator.BMRCalculator.computeHighEndHealthyWeight;
//import static calculator.BMRCalculator.computeLowEndHealthyWeight;
//import static calculator.BMRCalculator.start;
//
//import java.util.NoSuchElementException;
//import java.util.Scanner;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//
//public class BMRCalculatorJUnitTest {
//
//    @Test
//    void testComputeBMI(){
//
//        int  height = getHeight(new Scanner("5'9\""));
//
//        double  weight1 = 120.8;
//        double  weight2 = 145.3;
//        double  weight3 = 180.4;
//        double  weight4 = 210.4;
//
//        double bmiValue1 = computeBMI(weight1, height);
//        double bmiValue2 = computeBMI(weight2, height);
//        double bmiValue3 = computeBMI(weight3, height);
//        double bmiValue4 = computeBMI(weight4, height);
//
//        double expectedBMIValue1 = (weight1 / (height * height)) * 703.0;
//        double expectedBMIValue2 = (weight2 / (height * height)) * 703.0;
//        double expectedBMIValue3 = (weight3 / (height * height)) * 703.0;
//        double expectedBMIValue4 = (weight4 / (height * height)) * 703.0;
//
//
//        System.out.println();
//        System.out.println();
//        System.out.println("-------------- TEST VALID INPUT  --------------------");
//        System.out.printf("Actual : %5.1f , Expected : %5.1f \n", bmiValue1, expectedBMIValue1);
//        System.out.printf("Actual : %5.1f , Expected : %5.1f \n", bmiValue2, expectedBMIValue2);
//        System.out.printf("Actual : %5.1f , Expected : %5.1f \n", bmiValue3, expectedBMIValue3);
//        System.out.printf("Actual : %5.1f , Expected : %5.1f \n", bmiValue4, expectedBMIValue4);
//
//        assertEquals(String.format("%.2f", bmiValue1), String.format("%.2f", expectedBMIValue1));
//        assertEquals(String.format("%.2f", bmiValue2), String.format("%.2f", expectedBMIValue2));
//        assertEquals(String.format("%.2f", bmiValue3), String.format("%.2f", expectedBMIValue3));
//        assertEquals(String.format("%.2f", bmiValue4), String.format("%.2f", expectedBMIValue4));
//
//        System.out.println();
//        System.out.println();
//    }
//
//
//    @Test
//    void testComputeFemaleBMR(){
//
//        int  height = getHeight(new Scanner("5'5\""));
//
//        double  weight1 = 118.3;
//        double  weight2 = 123.8;
//        double  weight3 = 141.5;
//        double  weight4 = 202.4;
//
//        int age1 = 19;
//        int age2 = 27;
//        int age3 = 47;
//        int age4 = 61;
//
//        char bodyType = 'F';
//
//        double bmrValue1 = computeBMR(age1, bodyType, weight1, height);
//        double bmrValue2 = computeBMR(age2, bodyType, weight2, height);
//        double bmrValue3 = computeBMR(age3, bodyType, weight3, height);
//        double bmrValue4 = computeBMR(age4, bodyType, weight4, height);
//        double bmrValue5 = computeBMR(age2, bodyType, weight3, height);
//        double bmrValue6 = computeBMR(age4, bodyType, weight1, height);
//        double bmrValue7 = computeBMR(age3, bodyType, weight4, height);
//        double bmrValue8 = computeBMR(age1, bodyType, weight2, height);
//
//        double expectedBMRValue1 = 4.54545 * weight1 + 15.875 * height - 5 * age1 - 161;
//        double expectedBMRValue2 = 4.54545 * weight2 + 15.875 * height - 5 * age2 - 161;
//        double expectedBMRValue3 = 4.54545 * weight3 + 15.875 * height - 5 * age3 - 161;
//        double expectedBMRValue4 = 4.54545 * weight4 + 15.875 * height - 5 * age4 - 161;
//        double expectedBMRValue5 = 4.54545 * weight3 + 15.875 * height - 5 * age2 - 161;
//        double expectedBMRValue6 = 4.54545 * weight1 + 15.875 * height - 5 * age4 - 161;
//        double expectedBMRValue7 = 4.54545 * weight4 + 15.875 * height - 5 * age3 - 161;
//        double expectedBMRValue8 = 4.54545 * weight2 + 15.875 * height - 5 * age1 - 161;
//
//
//        System.out.println();
//        System.out.println();
//        System.out.println("-------------- TEST VALID INPUT  --------------------");
//        System.out.printf("Actual : %5.1f    ,    Expected : %5.1f \n", bmrValue1, expectedBMRValue1);
//        assertEquals(bmrValue1, expectedBMRValue1);
//        System.out.printf("Actual : %5.1f    ,    Expected : %5.1f \n", bmrValue2, expectedBMRValue2);
//        assertEquals(bmrValue2, expectedBMRValue2);
//        System.out.printf("Actual : %5.1f    ,    Expected : %5.1f \n", bmrValue3, expectedBMRValue3);
//        assertEquals(bmrValue3, expectedBMRValue3);
//        System.out.printf("Actual : %5.1f    ,    Expected : %5.1f \n", bmrValue4, expectedBMRValue4);
//        assertEquals(bmrValue4, expectedBMRValue4);
//        System.out.printf("Actual : %5.1f    ,    Expected : %5.1f \n", bmrValue4, expectedBMRValue4);
//        assertEquals(bmrValue5, expectedBMRValue5);
//        System.out.printf("Actual : %5.1f    ,    Expected : %5.1f \n", bmrValue4, expectedBMRValue4);
//        assertEquals(bmrValue6, expectedBMRValue6);
//        System.out.printf("Actual : %5.1f    ,    Expected : %5.1f \n", bmrValue4, expectedBMRValue4);
//        assertEquals(bmrValue7, expectedBMRValue7);
//        System.out.printf("Actual : %5.1f    ,    Expected : %5.1f \n", bmrValue4, expectedBMRValue4);
//        assertEquals(bmrValue8, expectedBMRValue8);
//
//        System.out.println();
//        System.out.println();
//    }
//
//    @Test
//    void testComputeMaleBMR(){
//
//        int  height = getHeight(new Scanner("5'10\""));
//
//        double  weight1 = 141.8;
//        double  weight2 = 167.3;
//        double  weight3 = 180.4;
//        double  weight4 = 210.4;
//
//        int age1 = 24;
//        int age2 = 35;
//        int age3 = 42;
//        int age4 = 61;
//
//        char bodyType = 'M';
//
//        double bmrValue1 = computeBMR(age1, bodyType, weight1, height);
//        double bmrValue2 = computeBMR(age2, bodyType, weight2, height);
//        double bmrValue3 = computeBMR(age3, bodyType, weight3, height);
//        double bmrValue4 = computeBMR(age4, bodyType, weight4, height);
//        double bmrValue5 = computeBMR(age2, bodyType, weight3, height);
//        double bmrValue6 = computeBMR(age4, bodyType, weight1, height);
//        double bmrValue7 = computeBMR(age3, bodyType, weight4, height);
//        double bmrValue8 = computeBMR(age1, bodyType, weight2, height);
//
//        double expectedBMRValue1 = 4.54545 * weight1 + 15.875 * height - 5 * age1 + 5;
//        double expectedBMRValue2 = 4.54545 * weight2 + 15.875 * height - 5 * age2 + 5;
//        double expectedBMRValue3 = 4.54545 * weight3 + 15.875 * height - 5 * age3 + 5;
//        double expectedBMRValue4 = 4.54545 * weight4 + 15.875 * height - 5 * age4 + 5;
//        double expectedBMRValue5 = 4.54545 * weight3 + 15.875 * height - 5 * age2 + 5;
//        double expectedBMRValue6 = 4.54545 * weight1 + 15.875 * height - 5 * age4 + 5;
//        double expectedBMRValue7 = 4.54545 * weight4 + 15.875 * height - 5 * age3 + 5;
//        double expectedBMRValue8 = 4.54545 * weight2 + 15.875 * height - 5 * age1 + 5;
//
//
//        System.out.println();
//        System.out.println();
//        System.out.println("-------------- TEST VALID INPUT  --------------------");
//        System.out.printf("Actual : %5.1f    ,    Expected : %5.1f \n", bmrValue1, expectedBMRValue1);
//        assertEquals(bmrValue1, expectedBMRValue1);
//        System.out.printf("Actual : %5.1f    ,    Expected : %5.1f \n", bmrValue2, expectedBMRValue2);
//        assertEquals(bmrValue2, expectedBMRValue2);
//        System.out.printf("Actual : %5.1f    ,    Expected : %5.1f \n", bmrValue3, expectedBMRValue3);
//        assertEquals(bmrValue3, expectedBMRValue3);
//        System.out.printf("Actual : %5.1f    ,    Expected : %5.1f \n", bmrValue4, expectedBMRValue4);
//        assertEquals(bmrValue4, expectedBMRValue4);
//        System.out.printf("Actual : %5.1f    ,    Expected : %5.1f \n", bmrValue4, expectedBMRValue4);
//        assertEquals(bmrValue5, expectedBMRValue5);
//        System.out.printf("Actual : %5.1f    ,    Expected : %5.1f \n", bmrValue4, expectedBMRValue4);
//        assertEquals(bmrValue6, expectedBMRValue6);
//        System.out.printf("Actual : %5.1f    ,    Expected : %5.1f \n", bmrValue4, expectedBMRValue4);
//        assertEquals(bmrValue7, expectedBMRValue7);
//        System.out.printf("Actual : %5.1f    ,    Expected : %5.1f \n", bmrValue4, expectedBMRValue4);
//        assertEquals(bmrValue8, expectedBMRValue8);
//
//        System.out.println();
//        System.out.println();
//    }
//
//
//    @Test
//    void testComputeHighEndHealthyWeight(){
//
//        System.out.println("******* START -> TEST HEALTHY WEIGHT HIGH END ********");
//
//        int height1 = getHeight(new Scanner("5'9\""));
//        int height2 = getHeight(new Scanner("5'1\""));
//        int height3 = getHeight(new Scanner("5'5\""));
//
//        double  weight1 = computeHighEndHealthyWeight(height1);
//        double  weight2 = computeHighEndHealthyWeight(height2);
//        double  weight3 = computeHighEndHealthyWeight(height3);
//
//        double  expectedWeight1 = (24.9 / 703.0) * (height1 * height1);
//        double  expectedWeight2 = (24.9 / 703.0) * (height2 * height2);
//        double  expectedWeight3 = (24.9 / 703.0) * (height3 * height3);
//
//        System.out.println();
//        System.out.println();
//        System.out.println("-------------- TEST VALID INPUT  --------------------");
//        System.out.printf("Actual : %5.1f    ,    Expected : %5.1f \n", weight1, expectedWeight1);
//        assertEquals(weight1, expectedWeight1);
//        System.out.printf("Actual : %5.1f    ,    Expected : %5.1f \n", weight2, expectedWeight2);
//        assertEquals(weight2, expectedWeight2);
//        System.out.printf("Actual : %5.1f    ,    Expected : %5.1f \n", weight3, expectedWeight3);
//        assertEquals(weight3, expectedWeight3);
//
//        System.out.println();
//        System.out.println();
//        System.out.println("***************** END -> TEST WEIGHT ******************");
//        System.out.println();
//        System.out.println();
//    }
//
//
//    @Test
//    void testComputeLowEndHealthyWeight(){
//
//        System.out.println("******* START -> TEST HEALTHY WEIGHT HIGH END ********");
//
//        int height1 = getHeight(new Scanner("5'9\""));
//        int height2 = getHeight(new Scanner("5'1\""));
//        int height3 = getHeight(new Scanner("5'5\""));
//
//        double weight1 = computeLowEndHealthyWeight(height1);
//        double weight2 = computeLowEndHealthyWeight(height2);
//        double weight3 = computeLowEndHealthyWeight(height3);
//
//        double expectedWeight1 = (18.5 / 703.0) * (height1 * height1);
//        double expectedWeight2 = (18.5 / 703.0) * (height2 * height2);
//        double expectedWeight3 = (18.5 / 703.0) * (height3 * height3);
//
//        System.out.println();
//        System.out.println();
//        System.out.println("-------------- TEST VALID INPUT  --------------------");
//        System.out.printf("Actual : %5.1f , Expected : %5.1f \n", weight1, expectedWeight1);
//        assertEquals(weight1, expectedWeight1);
//        System.out.printf("Actual : %5.1f , Expected : %5.1f \n", weight2, expectedWeight2);
//        assertEquals(weight2, expectedWeight2);
//        System.out.printf("Actual : %5.1f , Expected : %5.1f \n", weight3, expectedWeight3);
//        assertEquals(weight3, expectedWeight3);
//
//        System.out.println();
//        System.out.println();
//        System.out.println("***************** END -> TEST WEIGHT ******************");
//        System.out.println();
//        System.out.println();
//    }
//
//    @Test
//    void testGetAge(){
//        System.out.println("************* START -> TEST AGE ******************");
//
//        int age1 = 19;
//        int age2 = 61;
//
//        System.out.println();
//        System.out.println("++++++++++++++++ TEST VALID AGE ENTRY  ++++++++++++++++++");
//        assertEquals(age1, getAge(new Scanner("19")));
//        assertEquals(age2, getAge(new Scanner("61")));
//        System.out.println("\nSUCCESS\n");
//
//        System.out.println();
//        System.out.println("++++++++++++++++ TEST INVALID AGE ENTRY  ++++++++++++++++++");
//
//        String  inputValues = "NineTeen\n9Teen\n19";
//        Scanner scanner     = new Scanner(inputValues);
//        scanner.useDelimiter("\n");
//
//        assertEquals(age1, getAge(scanner));
//        assertThrows(Exception.class, () -> getAge(new Scanner("Nineteen")));
//
//        System.out.println();
//        System.out.println("\nSUCCESS\n");
//        System.out.println();
//        System.out.println("*************** END -> TEST AGE ******************");
//        System.out.println();
//    }
//
//
//    @Test
//    void testGetBodyType(){
//        System.out.println("************* START -> TEST BODY TYPE ******************");
//
//        char type1 = 'F';
//        char type2 = 'M';
//
//        System.out.println();
//        System.out.println("++++++++++++++++ TEST VALID BODY TYPE ENTRY  ++++++++++++++++++");
//        assertEquals(type1, getBodyType(new Scanner("Female")));
//        assertEquals(type2, getBodyType(new Scanner("Male")));
//        System.out.println("\nSUCCESS\n");
//
//        System.out.println();
//        System.out.println("++++++++++++++++ TEST INVALID BODY TYPE ENTRY  ++++++++++++++++++");
//
//        String  inputValues = "Scroll\nRollie\nBanker\nQuinten\nMale";
//        Scanner scanner     = new Scanner(inputValues);
//        scanner.useDelimiter("\n");
//
//        assertEquals(type2, getBodyType(scanner));
//        assertThrows(Exception.class, () -> getBodyType(new Scanner("Nebulous")));
//
//        System.out.println();
//        System.out.println("\nSUCCESS\n");
//        System.out.println();
//        System.out.println("*************** END -> TEST BODY TYPE ******************");
//        System.out.println();
//    }
//
//
//    @Test
//    void testGetBurnRate(){
//        System.out.println("************* START -> TEST BURN RATE ******************");
//        assertEquals("LOW", getBurnRate(1080.0));
//        assertEquals("MODERATE", getBurnRate(1530.0));
//        assertEquals("HIGH", getBurnRate(2125.0));
//        System.out.println("************* END -> TEST BURN RATE ******************");
//    }
//
//
//    @Test
//    void testGetHeight(){
//
//        System.out.println("************* START -> TEST HEIGHT ******************");
//
//        double  height1 = 12 * 5 + 9;   // 5ft , 9 in.
//        double  height2 = 12 * 4 + 10;  // 4ft , 10 in.
//        double  height3 = 12 * 6 + 4;   // 6ft , 4 in.
//
//        System.out.println();
//        System.out.println("++++++++++++++++ TEST VALID HEIGHT ENTRY  ++++++++++++++++++");
//        assertEquals(height1, getHeight(new Scanner("5'9\"")));
//        assertEquals(height2, getHeight(new Scanner("4'10\"")));
//        assertEquals(height3, getHeight(new Scanner("6'4\"")));
//        System.out.println("\nSUCCESS\n");
//
//        System.out.println();
//        System.out.println("++++++++++++++++ TEST INVALID HEIGHT ENTRY  ++++++++++++++++++");
//
//        String  inputValues = "5,6\nfin5,8\nfeet5.7\n5,6inches\n5'9\"";
//        Scanner scanner     = new Scanner(inputValues);
//        scanner.useDelimiter("\n");
//
//        assertEquals(height1, getHeight(scanner));
//        assertThrows(Exception.class, () -> getHeight(new Scanner("5ft9inches")));
//
//        System.out.println();
//        System.out.println("\nSUCCESS\n");
//        System.out.println();
//        System.out.println("*************** END -> TEST HEIGHT ******************");
//        System.out.println();
//    }
//
//
//    @Test
//    void testGetName(){
//
//        System.out.println("************* START -> TEST NAME ******************");
//
//        System.out.println();
//        System.out.println("++++++++++++++++ TEST FULL NAME ENTRY  ++++++++++++++++++");
//        assertEquals("Jack Knight", getName(new Scanner("Jack Knight")));
//        System.out.println("\nSUCCESS\n");
//
//        System.out.println();
//        System.out.println("++++++++++++++++ TEST NO SPACE NAME ENTRY  ++++++++++++++++++");
//
//        //Starting spaces are the only thing I think are invalid at the moment.
//        String  inputValues = "  \nMartin Frost";
//        Scanner scanner     = new Scanner(inputValues);
//        scanner.useDelimiter("\n");
//
//        assertNotEquals("Martin Frost", getName(scanner));
//        assertThrows(Exception.class, () -> getName(new Scanner("   ")));
//
//        System.out.println();
//        System.out.println("\nSUCCESS\n");
//        System.out.println();
//        System.out.println("*************** END -> TEST NAME ******************");
//        System.out.println();
//    }
//
//    @Test
//    void testGetWeight(){
//
//        System.out.println("************* START -> TEST WEIGHT ******************");
//
//        double  weight1 = 120.8;
//        double  weight2 = 145.3;
//        double  weight3 = 181.4;
//
//        System.out.println();
//        System.out.println("++++++++++++++++ TEST VALID INPUT  ++++++++++++++++");
//        assertEquals(weight1, getWeight(new Scanner("120.8")));
//        assertEquals(weight2, getWeight(new Scanner("145.3")));
//        assertEquals(weight3, getWeight(new Scanner("181.4 lbs")));
//        System.out.println("\nSUCCESS\n");
//        System.out.println();
//
//        System.out.println("++++++++++++++++ TEST INVALID INPUTS  ++++++++++++++++++");
//        String values = "pop95, globe81, true, 'a', 145.8";
//        Scanner scanner = new Scanner(values);
//        scanner.useDelimiter(", ");
//
//        assertEquals(145.8, getWeight(new Scanner(values)));
//        assertThrows(NoSuchElementException.class, () -> getWeight(new Scanner("push85")));
//        assertThrows(NoSuchElementException.class, () -> getWeight(new Scanner("156.34pop")));
//        System.out.println("\nSUCCESS\n");
//        System.out.println();
//
//        System.out.println("***************** END -> TEST WEIGHT ******************");
//        System.out.println();
//        System.out.println();
//    }
//
//    @Test
//    void testGetWeightCategory(){
//        System.out.println("************* START -> TEST WEIGHT CATEGORY ******************");
//        assertEquals("UNDERWEIGHT", getWeightCategory(17.3));
//        assertEquals("HEALTHY", getWeightCategory(21.2));
//        assertEquals("OVERWEIGHT", getWeightCategory(27.4));
//        assertEquals("OBESE", getWeightCategory(38.3));
//        System.out.println("************* END -> TEST WEIGHT CATEGORY ******************");
//    }
//
//    @Test
//    void testIsValidBodyType(){
//        System.out.println("************* START -> TEST IS VALID BODY TYPE ******************");
//        assertTrue(isValidBodyType("Male"));
//        assertTrue(isValidBodyType("Female"));
//        assertFalse(isValidBodyType("Liquid"));
//        assertFalse(isValidBodyType("Gas"));
//        System.out.println("************* END -> TEST IS VALID BODY TYPE ******************");
//    }
//
//    @Test
//    void testIsValidHeight(){
//        System.out.println("************* START -> TEST IS VALID HEIGHT ******************");
//        assertTrue(isValidHeight("5'6\""));
//        assertTrue(isValidHeight("5'9\""));
//        assertFalse(isValidHeight("5ft6in"));
//        assertFalse(isValidHeight("5ft9in"));
//        System.out.println("************* END -> TEST IS VALID HEIGHT ******************");
//    }
//
//    @Test
//    void testIsValidInteger(){
//        System.out.println("************* START -> TEST IS VALID INTEGER ******************");
//        assertTrue(isValidInteger("12"));
//        assertFalse(isValidInteger("Twelve"));
//        System.out.println("************* END -> TEST IS VALID INTEGER ******************");
//    }
//
//    @Test
//    void testIsValidWeight(){
//        System.out.println("************* START -> TEST IS VALID WEIGHT ******************");
//        assertTrue(isValidWeight("146.1"));
//        assertFalse(isValidWeight("OneFortySix"));
//        System.out.println("************* END -> TEST IS VALID WEIGHT ******************");
//    }
//
//
//    @Test
//    void testStart(){
//
//        System.out.println("************* START -> START ******************");
//        System.out.println();
//        System.out.println();
//        System.out.println("++++++++++++++++ SHOW OUTPUT  ++++++++++++++++++");
//        System.out.printf("Start -> STOP : %s", start('q'));
//        assertEquals('q', start('q'));
//        System.out.println();
//        System.out.println("***************** END -> TEST WEIGHT ******************");
//        System.out.println();
//        System.out.println();
//    }
//
//}
