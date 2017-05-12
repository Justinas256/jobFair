/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobFair.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import jobFair.dao.LoginDataRepository;
import jobFair.model.LoginData;
import org.springframework.stereotype.Service;

/**
 *
 * @author GreKar
 */

@Service
@Transactional
public class LoginDataService {
    
    private LoginDataRepository repository;

    public LoginDataService(LoginDataRepository repository) {
        this.repository = repository;
    }
    
    public List<LoginData> findAll() {
        List<LoginData> loginData = new ArrayList<>();
        for(LoginData data: repository.findAll()) {
            loginData.add(data);
	}
        return loginData; 
    }
    
    public void save(LoginData loginData) {
        repository.save(loginData);
    } 
    
    public LoginData geLoginDataById(long id) {
        return repository.findOne(id);
    }
    
    public void deleteLoginDataById(long loginDataId) {
	repository.delete(loginDataId);
    }
    
    public void delete(LoginData loginData) {
	repository.delete(loginData);
    }
    
}