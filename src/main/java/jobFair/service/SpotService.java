/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobFair.service;

import javax.transaction.Transactional;
import jobFair.dao.SpotRepository;
import jobFair.model.Spot;
import org.springframework.stereotype.Service;

/**
 *
 * @author justinas
 */
@Service
@Transactional
public class SpotService {
    
    private final SpotRepository repository;

    public SpotService(SpotRepository repository) {
        this.repository = repository;
    }
    
    public void save(Spot spot){
        repository.save(spot);
    }
    
}
