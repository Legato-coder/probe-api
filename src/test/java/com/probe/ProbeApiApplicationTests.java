package com.probe.service;

import com.probe.dto.CommandRequest;
import com.probe.model.Direction;
import com.probe.model.Probe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProbeServiceTest {

    private final ProbeService service = new ProbeService();

    @Test
    void shouldMoveCorrectly() {
        CommandRequest req = new CommandRequest();
        req.startX = 0;
        req.startY = 0;
        req.direction = Direction.NORTH;
        req.commands = "FFRFF";

        Probe probe = service.execute(req);

        assertEquals(2, probe.getPosition().getX());
        assertEquals(2, probe.getPosition().getY());
        assertEquals(Direction.EAST, probe.getDirection());
    }
}
