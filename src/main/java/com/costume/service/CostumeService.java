package com.costume.service;

import com.costume.model.Costume;
import com.costume.repository.CostumeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Servicio de la entidad Costume
@Service
public class CostumeService {

    @Autowired
    private CostumeRepository costumeRepository;

    public List<Costume> getAll() {
        return costumeRepository.getAll();
    }
    public Optional<Costume> getCostume(int id) {
        return costumeRepository.getCostume(id);
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

    public  Costume update(Costume costume){
        if (costume.getId() != null){
            Optional<Costume> costume_bd = costumeRepository.getCostume(costume.getId());
            if (!costume_bd.isEmpty()){
                if (costume.getName() != null){
                    costume_bd.get().setName(costume.getName());
                }

                if (costume.getBrand() != null){
                    costume_bd.get().setBrand(costume.getBrand());
                }

                if (costume.getYear() != null){
                    costume_bd.get().setYear(costume.getYear());
                }

                if (costume.getDescription() != null){
                    costume_bd.get().setDescription(costume.getDescription());
                }

                if (costume.getCategory() != null){
                    costume_bd.get().setCategory(costume.getCategory());
                }

                costumeRepository.save(costume_bd.get());
                return  costume_bd.get();


            }
        }

        return  costume;
    }

    public boolean deleteCostume(int id){
        Optional<Costume> costume  = costumeRepository.getCostume(id);
        if (costume.isEmpty()){
            return  false;
        }else {
            costumeRepository.delete(costume.get());
            return  true;
        }
    }
}
