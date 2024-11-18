package co.edu.ufps.entities;
import co.edu.ufps.entities.Visit;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name", length=100)
    private String name;

    @ManyToOne
    @JoinColumn(name="chief_id")
    private Employee chief;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    @OneToMany(mappedBy = "department")
    private List<Visit> visits;
}
