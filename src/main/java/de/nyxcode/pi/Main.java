package de.nyxcode.pi;

/* 
 * Copyright (C) Moritz Bischof ("NyxCode")
 * Licensing is defined in the file "LICENSE.txt", which is part of this project.
 */

import de.nyxcode.pi.archimedes.ArchimedesPane;
import de.nyxcode.pi.montecarlo.MonteCarloPane;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static int size = 600;

    public static void main(String[] args) {
        if(args.length != 0) size = Integer.parseInt(args[0]);
        Application.launch(Main.class);
    }

    public void start(Stage stage) throws Exception {
        stage.setTitle("Moritz Bischof - PI");
        stage.setResizable(false);
        stage.setScene(new Scene(new VBox(20) {{
            this.setAlignment(Pos.CENTER);
            this.getChildren().add(new Button("Archimedes") {{
                this.setOnAction(event -> {
                    Pane pane = new ArchimedesPane(size);
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(new Scene(pane, size, size));
                    stage.show();
                });
            }});
            this.getChildren().add(new Button("Monte Carlo") {{
                this.setOnAction(event -> {
                    Pane pane = new MonteCarloPane(size);
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(new Scene(pane, size, size));
                    stage.show();
                });
            }});

        }}, size, size));
        stage.show();
    }

}
