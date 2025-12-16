package com.probe.service;

import com.probe.dto.CommandRequest;
import com.probe.model.Direction;
import com.probe.model.Position;
import com.probe.model.Probe;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class ProbeService {

    private static final int GRID_SIZE = 10;
    private static final Set<Position> OBSTACLES;

    static {
        Set<Position> temp = new HashSet<>();
        temp.add(new Position(3, 3));
        OBSTACLES = Collections.unmodifiableSet(temp);
    }

    public Probe execute(CommandRequest request) {
        Probe probe = new Probe(
                new Position(request.startX, request.startY),
                request.direction
        );

        for (char c : request.commands.toCharArray()) {
            switch (c) {
                case 'L':
                    probe.setDirection(probe.getDirection().left());
                    break;
                case 'R':
                    probe.setDirection(probe.getDirection().right());
                    break;
                case 'F':
                    move(probe, 1);
                    break;
                case 'B':
                    move(probe, -1);
                    break;
                default:
                    break;
            }
        }
        return probe;
    }

    private void move(Probe probe, int step) {
        int dx = 0, dy = 0;

        switch (probe.getDirection()) {
            case NORTH: dy = step; break;
            case SOUTH: dy = -step; break;
            case EAST:  dx = step; break;
            case WEST:  dx = -step; break;
        }

        Position next = new Position(
                probe.getPosition().getX() + dx,
                probe.getPosition().getY() + dy
        );

        if (isValid(next)) {
            probe.move(dx, dy);
        }
    }

    private boolean isValid(Position p) {
        return p.getX() >= 0 && p.getY() >= 0 &&
               p.getX() < GRID_SIZE && p.getY() < GRID_SIZE &&
               !OBSTACLES.contains(p);
    }
}
