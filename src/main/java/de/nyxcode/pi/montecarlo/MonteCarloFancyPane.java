package de.nyxcode.pi.montecarlo;

/* 
 * Copyright (C) Moritz Bischof ("NyxCode")
 * Licensing is defined in the file "LICENSE.txt", which is part of this project.
 */

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class MonteCarloFancyPane extends StackPane {
    private final Paint slightTransparent = new Color(0, 0, 0, 0.2D);
    private final Paint transparent = new Color(0, 0, 0, 0.1D);

    public MonteCarloFancyPane(int size) {
        this.getChildren().add(new Pane() {{
            Rectangle rect = new Rectangle(size, size, transparent);
            this.getChildren().add(rect);
        }});
        this.getChildren().add(new Pane() {{
            Circle circle = new Circle(size, size, size, slightTransparent);
            this.getChildren().add(circle);
        }});
    }
}
