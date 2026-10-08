package ece;

import java.util.*;

public class Oops{

    static Scanner sc = new Scanner(System.in);

    // Scholarship class
    static class Scholarship {
        String name;
        String provider;
        String educationLevel;
        String course;
        String state;
        String category;
        double incomeLimit;
        double minimumPercentage;
        double minimumCGPA;
        boolean femaleOnly;
        boolean disabilityRequired;
        boolean firstGraduateRequired;
        String requiredDocuments;
        String deadline;
        String amount;
        String officialLink;

        Scholarship(String name, String provider, String educationLevel,
                    String course, String state, String category,
                    double incomeLimit, double minimumPercentage,
                    double minimumCGPA, boolean femaleOnly,
                    boolean disabilityRequired,
                    boolean firstGraduateRequired,
                    String requiredDocuments, String deadline,
                    String amount, String officialLink) {

            this.name = name;
            this.provider = provider;
            this.educationLevel = educationLevel;
            this.course = course;
            this.state = state;
            this.category = category;
            this.incomeLimit = incomeLimit;
            this.minimumPercentage = minimumPercentage;
            this.minimumCGPA = minimumCGPA;
            this.femaleOnly = femaleOnly;
            this.disabilityRequired = disabilityRequired;
            this.firstGraduateRequired = firstGraduateRequired;
            this.requiredDocuments = requiredDocuments;
            this.deadline = deadline;
            this.amount = amount;
            this.officialLink = officialLink;
        }
    }

    // Check eligibility
    static String checkEligibility(
            Scholarship s,
            String education,
            String course,
            String state,
            String category,
            double income,
            double percentage,
            double cgpa,
            String gender,
            boolean disability,
            boolean firstGraduate) {

        ArrayList<String> failed = new ArrayList<>();

        // Education check
        if (!s.educationLevel.equalsIgnoreCase("Any")
                && !s.educationLevel.equalsIgnoreCase(education)) {
            failed.add("Education level does not match");
        }

        // Course check
        if (!s.course.equalsIgnoreCase("Any")
                && !s.course.equalsIgnoreCase(course)) {
            failed.add("Course does not match");
        }

        // State check
        if (!s.state.equalsIgnoreCase("All")
                && !s.state.equalsIgnoreCase(state)) {
            failed.add("State requirement not satisfied");
        }

        // Category check
        if (!s.category.equalsIgnoreCase("All")
                && !s.category.equalsIgnoreCase(category)) {
            failed.add("Category requirement not satisfied");
        }

        // Income check
        if (income > s.incomeLimit) {
            failed.add("Family income exceeds the limit");
        }

        // Percentage check
        if (percentage < s.minimumPercentage) {
            failed.add("Academic percentage is below the minimum requirement");
        }

        // CGPA check
        if (cgpa < s.minimumCGPA) {
            failed.add("CGPA is below the minimum requirement");
        }

        // Female-only check
        if (s.femaleOnly && !gender.equalsIgnoreCase("Female")) {
            failed.add("This scholarship is available only for female students");
        }

        // Disability check
        if (s.disabilityRequired && !disability) {
            failed.add("Disability certificate/requirement is not satisfied");
        }

        // First graduate check
        if (s.firstGraduateRequired && !firstGraduate) {
            failed.add("First graduate requirement is not satisfied");
        }

        if (failed.size() == 0) {
            return "POTENTIALLY ELIGIBLE";
        }

        return "NOT ELIGIBLE";
    }

    // Display scholarship details
    static void displayScholarship(Scholarship s) {

        System.out.println("\n---------------------------------------------");
        System.out.println("Scholarship Name : " + s.name);
        System.out.println("Provider         : " + s.provider);
        System.out.println("Education Level  : " + s.educationLevel);
        System.out.println("Course           : " + s.course);
        System.out.println("State            : " + s.state);
        System.out.println("Category         : " + s.category);
        System.out.println("Income Limit     : Rs." + s.incomeLimit);
        System.out.println("Minimum %        : " + s.minimumPercentage);
        System.out.println("Minimum CGPA     : " + s.minimumCGPA);
        System.out.println("Scholarship Amt  : " + s.amount);
        System.out.println("Deadline         : " + s.deadline);
        System.out.println("Required Docs    : " + s.requiredDocuments);
        System.out.println("Official Link    : " + s.officialLink);
        System.out.println("---------------------------------------------");
    }

    public static void main(String[] args) {

        System.out.println("=================================================");
        System.out.println("       SCHOLARSHIP ELIGIBILITY CHECKER");
        System.out.println("=================================================");

        // User details
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Gender (Male/Female/Other): ");
        String gender = sc.nextLine();

        System.out.print("Enter State: ");
        String state = sc.nextLine();

        System.out.print("Enter Category (SC/ST/OBC/General): ");
        String category = sc.nextLine();

        System.out.print("Enter Education Level (UG/PG/Diploma): ");
        String education = sc.nextLine();

        System.out.print("Enter Course (CSE/ECE/EEE/MECH/IT/Any): ");
        String course = sc.nextLine();

        System.out.print("Enter Year of Study: ");
        int year = sc.nextInt();

        System.out.print("Enter 10th Percentage: ");
        double tenth = sc.nextDouble();

        System.out.print("Enter 12th Percentage: ");
        double twelfth = sc.nextDouble();

        System.out.print("Enter CGPA: ");
        double cgpa = sc.nextDouble();

        System.out.print("Enter Annual Family Income: Rs.");
        double income = sc.nextDouble();

        System.out.print("Is your college Government or Private? ");
        sc.nextLine();
        String collegeType = sc.nextLine();

        System.out.print("Are you a First Graduate? (Yes/No): ");
        String firstGraduateInput = sc.nextLine();

        System.out.print("Do you have a Disability Certificate? (Yes/No): ");
        String disabilityInput = sc.nextLine();

        boolean firstGraduate =
                firstGraduateInput.equalsIgnoreCase("Yes");

        boolean disability =
                disabilityInput.equalsIgnoreCase("Yes");

        // Create scholarship database
        ArrayList<Scholarship> scholarships = new ArrayList<>();

        scholarships.add(new Scholarship(
                "Merit Scholarship",
                "Educational Welfare Department",
                "UG",
                "Any",
                "All",
                "All",
                500000,
                75,
                6.0,
                false,
                false,
                false,
                "Mark Sheet, Income Certificate, Bonafide Certificate",
                "Check official portal",
                "Rs.25,000 per year",
                "Official Government Scholarship Portal"
        ));

        scholarships.add(new Scholarship(
                "Women Education Scholarship",
                "Women Education Department",
                "UG",
                "Any",
                "All",
                "All",
                300000,
                70,
                6.0,
                true,
                false,
                false,
                "Mark Sheet, Income Certificate, Bonafide Certificate",
                "Check official portal",
                "Rs.30,000 per year",
                "Official Government Scholarship Portal"
        ));

        scholarships.add(new Scholarship(
                "First Graduate Scholarship",
                "State Education Department",
                "UG",
                "Any",
                "Tamil Nadu",
                "All",
                500000,
                60,
                5.0,
                false,
                false,
                true,
                "First Graduate Certificate, Income Certificate, Bonafide Certificate",
                "Check official portal",
                "As per government rules",
                "Official Tamil Nadu Scholarship Portal"
        ));

        scholarships.add(new Scholarship(
                "SC/ST Student Scholarship",
                "Social Welfare Department",
                "UG",
                "Any",
                "All",
                "SC",
                300000,
                60,
                5.0,
                false,
                false,
                false,
                "Community Certificate, Income Certificate, Mark Sheet",
                "Check official portal",
                "As per government rules",
                "Official Scholarship Portal"
        ));

        scholarships.add(new Scholarship(
                "Engineering Student Scholarship",
                "Higher Education Department",
                "UG",
                "Any",
                "All",
                "All",
                400000,
                65,
                6.0,
                false,
                false,
                false,
                "Mark Sheets, Bonafide Certificate, Income Certificate",
                "Check official portal",
                "Rs.20,000 per year",
                "Official Scholarship Portal"
        ));

        int potentiallyEligible = 0;
        int notEligible = 0;

        System.out.println("\n\n=================================================");
        System.out.println("              ELIGIBILITY RESULTS");
        System.out.println("=================================================");

        System.out.println("\nStudent Name    : " + name);
        System.out.println("Age             : " + age);
        System.out.println("Gender          : " + gender);
        System.out.println("State           : " + state);
        System.out.println("Category        : " + category);
        System.out.println("Education       : " + education);
        System.out.println("Course          : " + course);
        System.out.println("Year            : " + year);
        System.out.println("10th Percentage : " + tenth);
        System.out.println("12th Percentage : " + twelfth);
        System.out.println("CGPA            : " + cgpa);
        System.out.println("Family Income   : Rs." + income);
        System.out.println("College Type    : " + collegeType);
        System.out.println("First Graduate  : " + firstGraduateInput);
        System.out.println("Disability      : " + disabilityInput);

        // Check every scholarship
        for (Scholarship s : scholarships) {

            String result = checkEligibility(
                    s,
                    education,
                    course,
                    state,
                    category,
                    income,
                    twelfth,
                    cgpa,
                    gender,
                    disability,
                    firstGraduate
            );

            displayScholarship(s);

            System.out.println("Eligibility Status : " + result);

            if (result.equals("POTENTIALLY ELIGIBLE")) {

                potentiallyEligible++;

                System.out.println("Reason:");
                System.out.println("✓ All available eligibility conditions are satisfied.");
                System.out.println("⚠ Final eligibility must be verified using the official scholarship rules.");

            } else {

                notEligible++;

                System.out.println("Reason:");

                if (!s.educationLevel.equalsIgnoreCase("Any")
                        && !s.educationLevel.equalsIgnoreCase(education)) {
                    System.out.println("✗ Education level does not match.");
                }

                if (!s.course.equalsIgnoreCase("Any")
                        && !s.course.equalsIgnoreCase(course)) {
                    System.out.println("✗ Course does not match.");
                }

                if (!s.state.equalsIgnoreCase("All")
                        && !s.state.equalsIgnoreCase(state)) {
                    System.out.println("✗ State requirement not satisfied.");
                }

                if (!s.category.equalsIgnoreCase("All")
                        && !s.category.equalsIgnoreCase(category)) {
                    System.out.println("✗ Category requirement not satisfied.");
                }

                if (income > s.incomeLimit) {
                    System.out.println("✗ Family income exceeds the limit.");
                }

                if (twelfth < s.minimumPercentage) {
                    System.out.println("✗ 12th percentage is below the required percentage.");
                }

                if (cgpa < s.minimumCGPA) {
                    System.out.println("✗ CGPA is below the required CGPA.");
                }

                if (s.femaleOnly
                        && !gender.equalsIgnoreCase("Female")) {
                    System.out.println("✗ Female student requirement not satisfied.");
                }

                if (s.disabilityRequired && !disability) {
                    System.out.println("✗ Disability requirement not satisfied.");
                }

                if (s.firstGraduateRequired && !firstGraduate) {
                    System.out.println("✗ First Graduate requirement not satisfied.");
                }
            }
        }

        // Final summary
        System.out.println("\n=================================================");
        System.out.println("                  FINAL SUMMARY");
        System.out.println("=================================================");

        System.out.println("Student Name             : " + name);
        System.out.println("Potentially Eligible     : " + potentiallyEligible);
        System.out.println("Not Eligible             : " + notEligible);
        System.out.println("Total Scholarships       : " + scholarships.size());

        System.out.println("\nIMPORTANT:");
        System.out.println("The result is only a preliminary eligibility check.");
        System.out.println("Always verify the latest rules, documents and deadline");
        System.out.println("on the official scholarship website before applying.");

        System.out.println("\n=================================================");
        System.out.println("       THANK YOU FOR USING THE SYSTEM");
        System.out.println("=================================================");

        sc.close();
    }
}