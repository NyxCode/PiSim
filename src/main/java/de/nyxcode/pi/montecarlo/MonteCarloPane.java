package de.nyxcode.pi.montecarlo;

/* 
 * Copyright (C) Moritz Bischof ("NyxCode")
 * Licensing is defined in the file "LICENSE.txt", which is part of this project.
 */

import javafx.scene.layout.StackPane;


public class MonteCarloPane extends StackPane {
    private static final int POINTS = 5000;
    private final MonteCarloPointsPane pointsPane;
    private final MonteCarloFancyPane fancyPane;
    private final MonteCarloStatusPane statusPane;

    public MonteCarloPane(int size) {
        this.pointsPane = new MonteCarloPointsPane(size);
        this.fancyPane = new MonteCarloFancyPane(size);
        this.statusPane = new MonteCarloStatusPane(size);
        statusPane.setOnNextButtonClick(() -> {
            for(int x = 0; x < 50; x++) pointsPane.addRandomPoint();
            statusPane.setData(pointsPane.getPoints(),
                    pointsPane.getPointsInside(),
                    pointsPane.calculatePi());
        });
        this.getChildren().add(pointsPane);
        this.getChildren().add(fancyPane);
        this.getChildren().add(statusPane);
    }
}
