package com.example.demo.Service;

import com.example.demo.Entities.House;
import com.example.demo.Entities.User;
import com.example.demo.Repositories.HouseRepo;
import com.example.demo.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {

    private final HouseRepo houseRepo;

    @Autowired
    public HouseService(HouseRepo houseRepo) {

        this.houseRepo = houseRepo;
    }


    public House findById(Long id){
        return houseRepo.findById(id).orElse(null);
    }

    public List<House> findAll(){
        return houseRepo.findAll();
    }

    public House saveHouse(House house){
        return houseRepo.save(house);
    }

    public void deleteById(Long id){
        houseRepo.deleteById(id);
    }
}
