package net.toyland.store.controllers.toys;

import org.springframework.web.bind.annotation.RestController;

import net.toyland.store.persistence.toys.Toy;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/toys")
public class ToyController {
    @GetMapping("/{id}")
    public ResponseEntity<ToyResponse> getToyById(@PathVariable Long id) {
        Optional<Toy> toyOptional = toyRepository.findById(id);
        if(toyOptional.isPresent()) {
            Toy toy = toyOptional.get();
            ToyResponse toyResponse = mapToToyResponse(toy);
            return ResponseEntity.ok(toyResponse);
        }
        return ResponseEntity.notFound().build();
    }
    
}
