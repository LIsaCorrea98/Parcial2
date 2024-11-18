

package co.edu.ufps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import co.edu.ufps.entities.Employee;
import co.edu.ufps.entities.ProjectAssignment;
import co.edu.ufps.services.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // a. Listar empleados
    @GetMapping
    public List<Employee> listEmployees() {
        return employeeService.listEmployees();
    }

    // d. Actualizar un empleado
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    // e. Buscar un empleado e incluir su salario
    @GetMapping("/{id}")
    public Employee getEmployeeWithSalary(@PathVariable int id) {
        return employeeService.getEmployeeWithSalary(id);
    }

    // f. Agregar un empleado a un proyecto con un rol específico
    @PostMapping("/{employeeId}/projects/{projectId}/roles/{roleId}")
    public ProjectAssignment addEmployeeToProject(@PathVariable int employeeId, @PathVariable int projectId, @PathVariable int roleId) {
        return employeeService.addEmployeeToProject(employeeId, projectId, roleId);
    }

    // g. Agregar departamentos a un empleado
    @PutMapping("/{employeeId}/departments/{departmentId}")
    public Employee addDepartmentToEmployee(@PathVariable int employeeId, @PathVariable int departmentId) {
        return employeeService.addDepartmentToEmployee(employeeId, departmentId);
    }

    // i. Desasociar un departamento de un empleado
    @PutMapping("/{employeeId}/departments/remove")
    public Employee removeDepartmentFromEmployee(@PathVariable int employeeId) {
        return employeeService.removeDepartmentFromEmployee(employeeId);
    }
}
