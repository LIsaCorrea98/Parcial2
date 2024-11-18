package co.edu.ufps.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_n", length=50)
    private String firstName;

    @Column(name="last_n", length=50)
    private String lastName;

    @Column(name="birthdate")
    private Date birthdate;

    @ManyToOne
    @JoinColumn(name="dep_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name="pos_id")
    private Position position;

    @Column(name="entry_date")
    private Date entryDate;

    @OneToMany(mappedBy = "employee")
    private List<Visit> visits;

    @OneToMany(mappedBy = "employee")
    private List<ProjectAssignment> projectAssignments;
}
