package co.edu.ufps.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name", length=200)
    private String name;

    @Column(name="description", columnDefinition="TEXT")
    private String description;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    @OneToMany(mappedBy = "project")
    private List<ProjectAssignment> projectAssignments;
}
