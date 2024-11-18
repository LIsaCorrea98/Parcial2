package co.edu.ufps.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.ufps.entities.ProjectAssignment;
import co.edu.ufps.repositories.ProjectAssignmentRepository;
import java.util.List;

@Service
public class ProjectAssignmentService {

    @Autowired
    private ProjectAssignmentRepository projectAssignmentRepository;

    /**
     * Lista los empleados asignados a un proyecto junto con sus roles.
     *
     * @param projectId El ID del proyecto.
     * @return Lista de asignaciones del proyecto.
     */
    public List<ProjectAssignment> listEmployeesInProject(int projectId) {
        return projectAssignmentRepository.findByProjectId(projectId);
    }
}
