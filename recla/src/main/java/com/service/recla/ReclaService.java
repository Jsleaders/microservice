package com.service.recla;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReclaService {
    @Autowired
    ReclaRepository reclaRepository;

    public List<Recla> findAll() {
        return reclaRepository.findAll();
    }

 
    public List<Recla> findBySubject(String subject) {
        return reclaRepository.findReclaBySubject(subject);
    }

    public Optional<Recla> findById(int ID) {
        return reclaRepository.findById(ID);
    }

    
    public Recla save(Recla recla) {
        return reclaRepository.save(recla);
    }

    public Recla update(Recla newrecla, int id) {
        Recla oldrecla = reclaRepository.findById(id).get();

            if(!oldrecla.getSubject().isEmpty()) {
                oldrecla.setMessage(newrecla.getMessage());
                oldrecla.setSubject(newrecla.getSubject());
                oldrecla.setUsername(newrecla.getUsername());
                return  reclaRepository.save(oldrecla);
            }
            return  oldrecla ;
    }

    public void DeleteById(int id) {
        reclaRepository.deleteById(id);
    }
}
