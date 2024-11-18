package co.edu.ufps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import co.edu.ufps.entities.Position;
import co.edu.ufps.services.PositionService;

@RestController
@RequestMapping("/positions")
public class PositionController {

    @Autowired
    private PositionService positionService;

    // b. Buscar una posición por id
    @GetMapping("/{id}")
    public Position findPositionById(@PathVariable int id) {
        return positionService.findPositionById(id);
    }
}
