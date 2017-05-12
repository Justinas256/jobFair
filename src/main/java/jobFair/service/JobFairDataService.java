/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobFair.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import jobFair.dao.JobFairDataRepository;
import jobFair.model.JobFairData;
import org.springframework.stereotype.Service;

/**
 *
 * @author justinas
 */
@Service
@Transactional
public class JobFairDataService {
    
    private JobFairDataRepository repository;

    public JobFairDataService(JobFairDataRepository repository) {
        this.repository = repository;
    }
    
    public List<JobFairData> findAll() {
        List<JobFairData> jobFairs = new ArrayList<>();
        for(JobFairData jobFair: repository.findAll()) {
            jobFairs.add(jobFair);
	}
        return jobFairs; 
    }
    
    public void save(JobFairData jobFairData) {
        repository.save(jobFairData);
    } 
    
}
