package utilities;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import appointments.Appointment;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
*
*
* @author: Nabeel Raza
*/

public class Main extends Application {
    private static Stage ps;



    @Override
    public void start(Stage primaryStage) throws Exception {
        ps = primaryStage;
        ps.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("../login/login.fxml"));
        ps.getIcons().add(new Image("/style/hospital.png"));
        ps.setTitle("Hospital");
        ps.setScene(new Scene(root, 800, 600));
        ps.show();
    } public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        LocalDate today = LocalDate.now();
        Database db = new Database();
        ArrayList<Appointment> list = db.getAppointments();
        for (Appointment a : list) {
            int cmp = a.getDate().compareTo(today);
            if (cmp < 0) {
                db.deleteAppointment(a);
            }
        }
    }
}
