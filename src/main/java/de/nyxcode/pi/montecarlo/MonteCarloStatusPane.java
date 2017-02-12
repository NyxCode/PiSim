package de.nyxcode.pi.montecarlo;

/* 
 * Copyright (C) Moritz Bischof ("NyxCode")
 * Licensing is defined in the file "LICENSE.txt", which is part of this project.
 */

import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import lombok.Setter;

@Setter
public class MonteCarloStatusPane extends BorderPane {
    private final int size;
    private final BorderPane elements = new BorderPane();
    private final Pane textPane = new VBox();
    private final Font font = new Font(22);
    private Runnable onNextButtonClick;

    public MonteCarloStatusPane(int size) {
        textPane.setBackground(new Background(new BackgroundFill(new Color(0, 0, 0, 0.7D), null, null)));
        textPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.MEDIUM)));

        setData(0, 0, 0);
        this.elements.setLeft(textPane);
        this.elements.setRight(new Button("\nPunkte generieren\n\n ") {{
            this.setOnAction(e -> onNextButtonClick.run());
        }});
        this.setBottom(elements);
        this.size = size;
    }
    public void setData(int points, int inside, double pi) {
        textPane.getChildren().clear();
        textPane.getChildren().add(getText("Punkte: " + points));
        textPane.getChildren().add(getText("Punkte im Kreis: " + inside));
        textPane.getChildren().add(getText("π: " + pi));
    }
    private Text getText(String text) {
        Text t = new Text(text);
        t.setFill(Color.WHITE);
        t.setFont(font);
        return t;
    }
}

