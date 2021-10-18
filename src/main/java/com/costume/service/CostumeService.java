package com.costume.service;

import com.costume.model.Costume;
import com.costume.repository.CostumeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostumeService {

    @Autowired
    private CostumeRepository costumeRepository;

    public List<Costume> getAll() {
        return costumeRepository.getAll();
    }

    public Costume save(Costume costume) {
        if (costume.getId() == null) {
            return costumeRepository.save(costume);
        } else {
            Optional<Costume> unDisfraz = costumeRepository.getCostume(costume.getId());

            if (unDisfraz.isEmpty()) {
                return costumeRepository.save(costume);
            } else {
                return costume;
            }
        }
    }
}
