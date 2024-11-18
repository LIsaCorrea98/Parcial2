package co.edu.ufps.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="visit")
public class Visit {

    @Id
    @Column(name="employee_id")
    private int employeeId;

    @ManyToOne
    @MapsId // Usa employeeId como clave principal
    @JoinColumn(name="employee_id", insertable=false, updatable=false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="department_id", nullable=false)
    private Department department;
}


