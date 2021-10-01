package jobapplicantproducer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class JopApplicantProducer {

    private static final String EXCHANGE_NAME = "applicant";

    public static void main(String[] args) throws IOException, TimeoutException {
        var producer = new Producer();
        //message to SYSADMIN
        producer.publishMessage("Applicant to sysadmin", EXCHANGE_NAME, "job.sysadmin");
        System.out.println("Message to Sysadmin sent");
        //message to SOFTWAREDEV
        producer.publishMessage("Applicant to softwaredev", EXCHANGE_NAME, "job.swdev");
        System.out.println("Softwaredev");
        //message to OTHERS
        producer.publishMessage("Another applicant", EXCHANGE_NAME, "job.others.*");
        System.out.println("Message to Others sent");

    }

}
