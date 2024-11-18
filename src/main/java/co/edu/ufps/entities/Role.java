package co.edu.ufps.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name", length=80)
    private String name;
}

