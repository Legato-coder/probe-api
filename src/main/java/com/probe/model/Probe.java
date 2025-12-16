package com.probe.model;

import java.util.ArrayList;
import java.util.List;

public class Probe {

    private Position position;
    private Direction direction;
    private List<Position> visited = new ArrayList<>();

    public Probe(Position start, Direction direction) {
        this.position = start;
        this.direction = direction;
        visited.add(start);
    }

    public void move(int dx, int dy) {
        position = new Position(position.getX() + dx, position.getY() + dy);
        visited.add(position);
    }

    public Position getPosition() { return position; }
    public Direction getDirection() { return direction; }
    public void setDirection(Direction direction) { this.direction = direction; }
    public List<Position> getVisited() { return visited; }
}
