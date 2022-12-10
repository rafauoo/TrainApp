package app.pociagi.utils;

import app.pociagi.db.Objects.Station;
import app.pociagi.db.Objects.User;
import app.pociagi.db.Utils.DatabaseHandler;
import app.pociagi.db.Utils.Route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AppData {
    private static final AppData INSTANCE = new AppData();
    public User user = null;
    public String pickedSource = null;
    public String pickedDestination = null;
    public Route pickedRoute;

    public Station from = null;
    public Station destination = null;

    public DatabaseHandler dbHandler;
    public Map<String, Integer> buyTicketData = new HashMap<String, Integer>();
    public ArrayList<Integer> pickedConnection;
    private AppData() {}

    public static AppData getInstance() {
        return INSTANCE;
    }
}
