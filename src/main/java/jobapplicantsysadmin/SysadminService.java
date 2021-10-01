package jobapplicantsysadmin;

public class SysadminService {

    private SysadminService() {}

    public static void getApplicant(String message) {
        if(message.contains("sysadmin")) {
            System.out.println("Application for Sysadmin accepted");
        } else {
            System.out.println("Application for Sysadmin not accepted");
        }
    }

}
