package co.edu.ufps.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.ufps.entities.Position;
import co.edu.ufps.repositories.PositionRepository;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    // b. Buscar una posición por id
    public Position findPositionById(int id) {
        return positionRepository.findById(id).orElse(null);
    }
}
