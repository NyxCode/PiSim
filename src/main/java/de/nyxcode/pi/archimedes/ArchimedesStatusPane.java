package de.nyxcode.pi.archimedes;

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
public class ArchimedesStatusPane extends BorderPane {
    private final int size;
    private final BorderPane elements = new BorderPane();
    private final Pane textPane = new VBox();
    private final Font font = new Font(22);
    private Runnable onClick;

    public ArchimedesStatusPane(int size) {
        this.size = size;
        textPane.setBackground(new Background(new BackgroundFill(new Color(0, 0, 0, 0.7D), null, null)));
        textPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.MEDIUM)));

        setData(0, 0);
        this.elements.setLeft(textPane);
        this.elements.setRight(new Button("Ecken verdoppeln") {{
            this.setOnAction(e -> onClick.run());
        }});
        this.setBottom(elements);
    }
    public void setData(int edges, double area) {
        textPane.getChildren().clear();
        textPane.getChildren().add(getText("Ecken: " + edges));
        textPane.getChildren().add(getText("Umfang: " + area));
    }
    private double round(double num, int places) {
        return Math.round(num * (places * 10D)) / (places * 10D);
    }
    private Text getText(String text) {
        Text t = new Text(text);
        t.setFill(Color.WHITE);
        t.setFont(font);
        return t;
    }
}
