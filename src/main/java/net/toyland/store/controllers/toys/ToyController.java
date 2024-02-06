package net.toyland.store.controllers.toys;

import org.springframework.web.bind.annotation.RestController;

import net.toyland.store.persistence.toys.Toy;
import net.toyland.store.persistence.toys.ToyRepository;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/toys")
public class ToyController {

    private final ToyRepository toyRepository;

    public ToyController(ToyRepository toyRepository) {
        this.toyRepository = toyRepository;

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteToy(@PathVariable Long id) {
        Optional<Toy> toyOptional = toyRepository.findById(id);
        if (toyOptional.isPresent()) {
            toyRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
