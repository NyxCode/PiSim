package de.nyxcode.pi.archimedes;

/* 
 * Copyright (C) Moritz Bischof ("NyxCode")
 * Licensing is defined in the file "LICENSE.txt", which is part of this project.
 */

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ArchimedesCirclePane extends StackPane {
    public ArchimedesCirclePane(int size) {
        Circle circle = new Circle(size / 2D, new Color(0, 0, 0, 0.2D));
        this.getChildren().add(circle);

    }
}
