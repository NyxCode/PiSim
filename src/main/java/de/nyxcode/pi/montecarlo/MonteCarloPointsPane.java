package de.nyxcode.pi.montecarlo;

/* 
 * Copyright (C) Moritz Bischof ("NyxCode")
 * Licensing is defined in the file "LICENSE.txt", which is part of this project.
 */

import de.nyxcode.pi.Vector2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
public class MonteCarloPointsPane extends Pane {
    private final int windowSize;
    private final List<Vector2D> points = new LinkedList<>();

    public void addRandomPoint() {
        double rand1 = Math.random() * windowSize;
        double rand2 = Math.random() * windowSize;
        addPoint(new Vector2D(rand1, rand2));
    }

    private void addPoint(Vector2D vec) {
        Circle circle = new Circle(3, Color.BLACK);
        circle.setCenterX(vec.getX());
        circle.setCenterY(vec.getY());
        this.getChildren().add(circle);
        points.add(vec);
    }

    public int getPoints() {
        return points.size();
    }

    public int getPointsInside() {
        int c = 0;
        for (Vector2D vec : points) {
            Vector2D shifted = new Vector2D(windowSize - vec.getX(), windowSize - vec.getY());
            double length = shifted.length();
            if (length <= windowSize) c++;
        }
        return c;
    }

    public double calculatePi() {
        if (points.size() == 0) return -1D;
        return (4D * getPointsInside()) / points.size();
    }

}
