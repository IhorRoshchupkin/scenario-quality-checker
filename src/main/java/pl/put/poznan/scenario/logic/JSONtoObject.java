package pl.put.poznan.scenario.logic;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import pl.put.poznan.scenario.model.Scenario;

public class JSONtoObject
{

    public static Scenario getObject(String scenarioJSON) throws JsonSyntaxException
    {
        Gson gson = new Gson();
        return gson.fromJson(scenarioJSON, Scenario.class);
    }
}