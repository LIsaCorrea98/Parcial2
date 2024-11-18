package co.edu.ufps.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import co.edu.ufps.entities.Employee;
import co.edu.ufps.entities.ProjectAssignment;
import co.edu.ufps.repositories.EmployeeRepository;
import co.edu.ufps.repositories.DepartmentRepository;
import co.edu.ufps.repositories.ProjectAssignmentRepository;
import co.edu.ufps.repositories.ProjectRepository;
import co.edu.ufps.repositories.RoleRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectAssignmentRepository projectAssignmentRepository;

    @Autowired
    private RoleRepository roleRepository;

    // a. Listar empleados
    public List<Employee> listEmployees() {
        return employeeRepository.findAll();
    }

    // d. Actualizar un empleado
    public Employee updateEmployee(int id, Employee updatedEmployee) {
        if (employeeRepository.existsById(id)) {
            updatedEmployee.setId(id);
            return employeeRepository.save(updatedEmployee);
        }
        return null;
    }

    // e. Buscar un empleado e incluir su salario
    public Employee getEmployeeWithSalary(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // f. Agregar un empleado a un proyecto con un rol específico
    public ProjectAssignment addEmployeeToProject(int employeeId, int projectId, int roleId) {
        if (employeeRepository.existsById(employeeId) && projectRepository.existsById(projectId) && roleRepository.existsById(roleId)) {
            ProjectAssignment assignment = new ProjectAssignment();
            assignment.setEmployee(employeeRepository.findById(employeeId).get());
            assignment.setProject(projectRepository.findById(projectId).get());
            assignment.setRole(roleRepository.findById(roleId).get());
            return projectAssignmentRepository.save(assignment);
        }
        return null;
    }

    // g. Agregar departamentos a un empleado
    public Employee addDepartmentToEmployee(int employeeId, int departmentId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null && departmentRepository.existsById(departmentId)) {
            employee.setDepartment(departmentRepository.findById(departmentId).get());
            return employeeRepository.save(employee);
        }
        return null;
    }

    // i. Desasociar un departamento de un empleado
    public Employee removeDepartmentFromEmployee(int employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            employee.setDepartment(null);
            return employeeRepository.save(employee);
        }
        return null;
    }
}
