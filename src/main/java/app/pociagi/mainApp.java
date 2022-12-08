package app.pociagi;

import app.pociagi.db.Objects.*;
import app.pociagi.db.Utils.DatabaseHandler;
import app.pociagi.db.Utils.FindRide;
import app.pociagi.db.Utils.FindStop;
import app.pociagi.db.Utils.FindUser;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class mainApp extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main_menuv2.fxml"));
        stage.setTitle("Hello!");
        stage.setResizable(false); //jesli zaczniemy rozciagac okno to bedzie brzydkie, do poprawy
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) throws ParseException {
        String rideDate = "2022-12-06";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(rideDate);
        System.out.println(FindRide.findByConIdRideDate(1, date).getID());
//        DatabaseHandler handler = DatabaseHandler.getInstance();
//        String sql = "SELECT * FROM STATIONS";
//        ResultSet rs = handler.executeQuery(sql);
//        handler.printData(rs);
//        launch();
//        handler.finish();
    }
}