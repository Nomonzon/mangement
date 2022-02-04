package com.computer.computershop.services;

import com.computer.computershop.entities.Laptops;
import com.computer.computershop.repositories.LaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopServiceImpl implements LaptopService{


    private final LaptopRepo laptopRepo;

    @Autowired
    public LaptopServiceImpl(LaptopRepo laptopRepo) {
        this.laptopRepo = laptopRepo;
    }

    // TO GET ALL LAPTOPS FROM DATABASE
    @Override
    public List<Laptops> getAllLaptops() {
        return laptopRepo.findAll();
    }

    // TO SAVE LAPTOPS TO DATABASE FROM CLIENT LAYER
    @Override
    public Laptops addLaptops(Laptops laptops) {
        return laptopRepo.save(laptops);
    }

    // TO GET LAPTOP BY ID FROM DATABASE
    @Override
    public Laptops getLaptopById(Long id) {
        return laptopRepo.getById(id);
    }

    @Override
    public void deleteLaptop(Long id) {
        laptopRepo.deleteById(id);
    }
}
