package com.service.recla;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("reclas")
public class ReclaRestApi {
    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    ReclaService reclaService ;

    @GetMapping
    public ResponseEntity<List<Recla>> findAll() {
        return ResponseEntity.ok(reclaService.findAll());
    }
    @PostMapping
    public  ResponseEntity create(@RequestBody Recla recla) {
        return ResponseEntity.ok(reclaService.save(recla));
    }
    @GetMapping("/{id}")
    public ResponseEntity <Recla> findById(@PathVariable int id) {
        Optional <Recla> recla = reclaService.findById(id);
        if(!recla.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(recla.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recla> update(@PathVariable int id, @RequestBody Recla recla) {
        if (!reclaService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(reclaService.update(recla,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        if (!reclaService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }

        reclaService.DeleteById(id);

        return ResponseEntity.ok().build();
    }

}