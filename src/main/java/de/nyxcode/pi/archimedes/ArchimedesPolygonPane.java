package de.nyxcode.pi.archimedes;

/* 
 * Copyright (C) Moritz Bischof ("NyxCode")
 * Licensing is defined in the file "LICENSE.txt", which is part of this project.
 */

import de.nyxcode.pi.Vector2D;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import lombok.Getter;

import static java.lang.Math.*;

@Getter
public class ArchimedesPolygonPane extends Pane {
    private final int size;
    private int edges;
    private double scope;

    public ArchimedesPolygonPane(int size) {
        this.size = size;
    }

    public void update(int nEdges) {
        this.getChildren().clear();
        drawShape(nEdges);
        this.edges = nEdges;
        this.scope = nEdges * sin(PI / nEdges) * cos(PI / nEdges);
    }

    private void drawShape(int nEdges) {
        Vector2D firstVec = null;
        Vector2D lastVec = null;
        for (double c = 0; c < 2*PI; c += 2D*PI / nEdges) {
            Vector2D vec = new Vector2D(
                    Math.cos(c) * size / 2 + size / 2,
                    Math.sin(c) * size / 2 + size / 2);
            Circle circle = new Circle(vec.getX(), vec.getY(), 3);
            this.getChildren().add(circle);
            Line toCenter = new Line(vec.getX(), vec.getY(), size / 2D, size / 2D);
            this.getChildren().add(toCenter);
            if (lastVec != null) {
                Line line = new Line(lastVec.getX(), lastVec.getY(), vec.getX(), vec.getY());
                this.getChildren().add(line);
            }
            if(firstVec == null) firstVec = vec;
            lastVec = vec;
        }
        Line line = new Line(firstVec.getX(), firstVec.getY(), lastVec.getX(), lastVec.getY());
        this.getChildren().add(line);
    }

}
