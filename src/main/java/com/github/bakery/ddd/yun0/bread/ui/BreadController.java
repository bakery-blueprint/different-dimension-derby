package com.github.bakery.ddd.yun0.bread.ui;

import com.github.bakery.ddd.yun0.bread.application.BreadService;
import com.github.bakery.ddd.yun0.bread.domain.bread.Bread;
import com.github.bakery.ddd.yun0.bread.domain.bread.BreadType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/breads")
@RestController
public class BreadController {
    private final BreadService breadService;

    @GetMapping
    public ResponseEntity<List<Bread>> getBreads() {
        return ResponseEntity.ok(breadService.getBreads());
    }

    @PostMapping
    public ResponseEntity<Bread> create(BreadType breadType) {
        return ResponseEntity.ok(breadService.create(breadType));
    }

    @PutMapping
    public ResponseEntity<Bread> process(Long id) {
        return ResponseEntity.ok(breadService.process(id));
    }
}
