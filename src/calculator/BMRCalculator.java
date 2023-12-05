import java.util.Scanner;

public class BMRCalculator {

    public static double calculateBMR(double weight, double height, int age, String sex) {

        double heightCm = height * 2.54;


        if (sex.equalsIgnoreCase("M")) {
            return 10 * weight + 6.25 * heightCm - 5 * age + 5;
        } else {
            return 10 * weight + 6.25 * heightCm - 5 * age - 161;
        }
    }

    public static double calculateBMI(double weight, double height) {

        double heightM = height * 0.0254;
        return weight / (heightM * heightM);
    }

    public static double[] calculateHealthyWeight(double height) {

        double lowEndHealthyWeight = height * 0.3937007874;
        double highEndHealthyWeight = height * 0.5394321638;
        return new double[]{lowEndHealthyWeight, highEndHealthyWeight};
    }

    public static String getBodyType(double bmi) {
        if (bmi < 18.5) {
            return "UNDERWEIGHT";
        } else if (bmi < 25) {
            return "HEALTHY";
        } else if (bmi < 30) {
            return "OVERWEIGHT";
        } else {
            return "OBESE";
        }
    }

    public static void displayResults(String name, int age, String sex, double weight, double height, double bmr, double bmi, String bmiCategory, double lowEndHealthyWeight, double highEndHealthyWeight) {
        System.out.println("\n" + name + " is a " + age + " year old " + sex + ".");
        System.out.println("BMR: " + bmr + " kcal");
        System.out.println("BMI: " + bmi + ", " + bmiCategory);
        System.out.println("Recommended healthy weight range: " + lowEndHealthyWeight + " kg to " + highEndHealthyWeight + " kg");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.print("Enter sex (M/F): ");
        String sex = scanner.next();
        System.out.print("Enter weight (in lbs): ");
        double weight = scanner.nextDouble();
        System.out.print("Enter height (in inches): ");
        double height = scanner.nextDouble();

        double bmr = calculateBMR(weight, height, age, sex);
        double bmi = calculateBMI(weight, height);
        String bmiCategory = getBodyType(bmi);
        double[] healthyWeightRange = calculateHealthyWeight(height);
        double lowEndHealthyWeight = healthyWeightRange[0];
        double highEndHealthyWeight = healthyWeightRange[1];

        displayResults(name, age, sex, weight, height, bmr, bmi, bmiCategory, lowEndHealthyWeight, highEndHealthyWeight);
    }
}