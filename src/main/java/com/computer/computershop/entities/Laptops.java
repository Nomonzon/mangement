package com.computer.computershop.entities;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Laptops {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    // NOT NULL
    @Column(nullable = false)
    private String model;

    private String processor;

    @Column(nullable = false)
    private Integer RAM;

    @Column(nullable = false)
    private Integer storage;

    private String modelBattery;

//    mAH
    private int battery;

    //15.6, 12,14 inches can be more portable
    private String screenSize;

    @Column(nullable = false)
    private Double price;

    private Integer number;

    //C помощью этой аннотации соединяется таблицы
    //MANY laptops TO MANY arrivalTime
    @ManyToMany
    private List<ArrivalTime> arrivalTime;
}
