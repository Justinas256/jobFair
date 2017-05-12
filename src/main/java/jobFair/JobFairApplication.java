package jobFair;

import jobFair.model.JobFairData;
import jobFair.service.JobFairDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobFairApplication {

        @Autowired
        private JobFairDataService jobFairDataService;
        
        //jobFairDataService.save(new JobFairData("2017 JOB FAIR", "2017-12-12", "Leuven"));
        
	public static void main(String[] args) {
            SpringApplication.run(JobFairApplication.class, args);
	}
}
