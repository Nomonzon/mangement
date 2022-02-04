package com.computer.computershop.services;

import com.computer.computershop.entities.Laptops;

import java.util.List;

public interface LaptopService {
    List<Laptops> getAllLaptops();

    Laptops addLaptops(Laptops laptops);

    Laptops getLaptopById(Long id);

    void deleteLaptop(Long id);
}
