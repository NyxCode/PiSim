package de.nyxcode.pi.archimedes;

/* 
 * Copyright (C) Moritz Bischof ("NyxCode")
 * Licensing is defined in the file "LICENSE.txt", which is part of this project.
 */

import javafx.scene.layout.StackPane;

public class ArchimedesPane extends StackPane {
    private final ArchimedesCirclePane circlePane;
    private final ArchimedesPolygonPane polyPane;
    private final ArchimedesStatusPane statusPane;

    public ArchimedesPane(int size) {
        circlePane = new ArchimedesCirclePane(size);
        polyPane = new ArchimedesPolygonPane(size);
        statusPane = new ArchimedesStatusPane(size);
        statusPane.setOnClick(() -> {
            int newEdges = polyPane.getEdges() * 2;
            polyPane.update(newEdges);
            statusPane.setData(newEdges, polyPane.getScope());
        });
        polyPane.update(4);
        statusPane.setData(4, polyPane.getScope());
        this.getChildren().add(circlePane);
        this.getChildren().add(polyPane);
        this.getChildren().add(statusPane);
    }
}
