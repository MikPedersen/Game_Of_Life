import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainView extends Application {
    private Button run;
    private Cell[][] celler;
    private Game simulation;
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        stage.setTitle("Game of life");
        simulation = new Game();
        celler = simulation.getSpilleplade();
        updateScene(celler, root);
        Scene scene = new Scene(root, 450 ,500);

        run = new Button();
        run.setText("Run 50 iterations");
        run.setOnAction((ActionEvent event) -> {
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(1500),
                    ae -> evolve(simulation, root)));
            timeline.setCycleCount(50);
            timeline.play();

        });

        run.setPrefWidth(150);
        run.setLayoutY(450);
        run.setLayoutX(100);

        root.getChildren().add(run);


        stage.setScene(scene);
        stage.show();
    }

    public void evolve(Game gameCell, Pane root) {
        celler = simulation.getSpilleplade();
        gameCell.update();
        updateScene(celler, root);

    }

    public void updateScene(Cell[][] grid, Pane root) {
        root.getChildren().removeAll();
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid.length; j++) {
                int resolution = 20;
                int x = i* resolution;
                int y = j* resolution;
                Circle circle = new Circle(x + 1, y + 1, 10);
                circle.setLayoutX(10);
                circle.setLayoutY(10);
                if (grid[i][j].getAlive()) {
                    circle.setFill(Color.DEEPPINK);
                } else {
                    circle.setStroke(Color.GRAY);
                    circle.setFill(Color.GRAY);

                }
                root.getChildren().add(circle);
            }

        }
    }


}
