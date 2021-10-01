package jobapplicantsoftwaredevelopment;

public class SoftwaredevelopmentService {

    private SoftwaredevelopmentService() {}

    public static void getApplicant(String message) {
        if(message.contains("Devlopment")) {
            System.out.println("Applicant is accepted");
        } else {
            System.out.println("Applicant is not accepted");
        }
    }
}
