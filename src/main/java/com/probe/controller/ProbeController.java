package com.probe.controller;

import com.probe.dto.CommandRequest;
import com.probe.model.Probe;
import com.probe.service.ProbeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/probe")
@Tag(name = "Probe Controller")
public class ProbeController {

    private final ProbeService service;

    public ProbeController(ProbeService service) {
        this.service = service;
    }

    @Operation(summary = "Execute probe commands")
    @PostMapping("/execute")
    public Probe execute(@RequestBody CommandRequest request) {
        return service.execute(request);
    }
}
