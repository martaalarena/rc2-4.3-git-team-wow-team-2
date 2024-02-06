package net.toyland.store.controllers.toys;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/toys")
public class ToyController {

    // COMPLETE THIS
}


@PostMapping
public ResponseEntity<ToyResponse> createToy(@RequestBody ToyRequest toyRequest) {
    Toy toy = new Toy(toyRequest.getName(), toyRequest.getBrand(), toyRequest.getPrice());
    toyRepository.save(toy);
    ToyResponse toyResponse = mapToToyResponse(toy);
    return ResponseEntity.status(HttpStatus.CREATED).body(toyResponse);
}