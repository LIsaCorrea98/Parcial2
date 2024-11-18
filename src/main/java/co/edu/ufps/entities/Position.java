package co.edu.ufps.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name", length=100)
    private String name;

    @Column(name="salary")
    private double salary;

    @OneToMany(mappedBy = "position")
    private List<Employee> employees;
}
