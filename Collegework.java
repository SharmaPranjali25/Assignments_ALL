import java.util.Scanner;

public class Collegework {
	public static void main(String[] args) {
		System.out.println("COLLEGE ALLOTMENT ORDER");
		System.out.println("* * * * * * * * * * * * ");
		
		//CANDIDATE NAME
		System.out.print("Candidate Name: ");
		Scanner sc= new Scanner(System.in);
		sc.nextLine();
		
		//ADDRESS
		System.out.print("Address: ");
		sc.nextLine();
		
		
		//COLLEGE CAMPUS
		System.out.print("College-Campus: ");
		 sc.nextLine();
		
		//TAKING CGPA AS CRITERIA FOR BRANCH- CONTROL STATEMENTS:
		System.out.println("----------------------");
		System.out.print("Enter Current CGPA: ");
		int cg=sc.nextInt();
		sc.nextLine();
		
		if(cg>10) {
			System.out.println("Invalid cgpa");
		}
		else if(cg>=9 && cg<=10) {
			System.out.println("Your Branch is Computer Science");
		}
		else if(cg>=7 && cg<9) {
			System.out.println("Your Bracnch is Electrical");
		}
		else if(cg>=5 && cg<7) {
			System.out.println("Your Branch is Mechanical");
		}
		else {
			System.out.println("Your are not Eligible to sit into any Branch");
		}
		System.out.println("* * * * * * * * * * * * * * * *");
		
		
		//RANK BASED UNIVERSITY - SWITCH STATEMENT:
		System.out.println("Enter the Rank Range of JEE-Exam");
		int rank= sc.nextInt();	

		
		if (rank >= 1 && rank <= 1000) {
            System.out.println("You are allotted to Bombay University");
        } else if (rank <= 2000) {
            System.out.println("You are allotted to Pune University");
        } else if (rank <= 3000) {
            System.out.println("You are allotted to Hyderabad University");
        } else if (rank <= 4000) {
            System.out.println("You are allotted to Vellore University");
        } else if (rank <= 5000) {
            System.out.println("You are allotted to Delhi University");
        }
        else {
            	System.out.println("No university available for your rank.");
            }
		sc.close();

        }

		
		
	}

