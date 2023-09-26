package com.example.demo.Repositories;

import com.example.demo.Entities.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepo extends JpaRepository<House , Long> {

}
