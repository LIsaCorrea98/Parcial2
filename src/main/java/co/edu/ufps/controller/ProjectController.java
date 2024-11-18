package co.edu.ufps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import co.edu.ufps.entities.ProjectAssignment;
import co.edu.ufps.services.ProjectAssignmentService;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectAssignmentService projectAssignmentService;

    /**
     * Endpoint para listar los empleados de un proyecto con sus roles.
     *
     * @param projectId El ID del proyecto.
     * @return Lista de asignaciones con empleados y roles.
     */
    @GetMapping("/{projectId}/employees")
    public List<ProjectAssignment> listEmployeesWithRoles(@PathVariable int projectId) {
        return projectAssignmentService.listEmployeesInProject(projectId);
    }
}
