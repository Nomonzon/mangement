package com.computer.computershop.repositories;

import com.computer.computershop.entities.Laptops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepo extends JpaRepository<Laptops, Long> {
}
