package co.edu.ufps.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import co.edu.ufps.entities.Project;
import co.edu.ufps.entities.ProjectAssignment;
import co.edu.ufps.repositories.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    /**
     * Crea un nuevo proyecto.
     *
     * @param project El proyecto a crear.
     * @return El proyecto guardado.
     */
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    /**
     * Lista todos los proyectos disponibles.
     *
     * @return Lista de proyectos.
     */
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    /**
     * Obtiene un proyecto por su ID.
     *
     * @param id El ID del proyecto.
     * @return El proyecto encontrado, o null si no existe.
     */
    public Project getProjectById(int id) {
        return projectRepository.findById(id).orElse(null);
    }
    
    @Autowired
    private ProjectAssignmentService projectAssignmentService;

    /**
     * Lista los empleados de un proyecto junto con sus roles.
     *
     * @param projectId El ID del proyecto.
     * @return Lista de asignaciones del proyecto.
     */
    public List<ProjectAssignment> listEmployeesWithRoles(int projectId) {
        return projectAssignmentService.listEmployeesInProject(projectId);
    }


    /**
     * Elimina un proyecto por su ID.
     *
     * @param id El ID del proyecto.
     */
    public void deleteProject(int id) {
        projectRepository.deleteById(id);
    }
}
