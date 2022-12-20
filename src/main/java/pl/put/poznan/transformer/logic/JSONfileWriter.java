package pl.put.poznan.transformer.logic;

import com.google.gson.Gson;
import pl.put.poznan.transformer.model.Scenario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JSONfileWriter {

    public static String writeScenarioToFile(Scenario scenario, String title)
    {
        Gson gson = new Gson();
        String jsonString = gson.toJson(scenario);
        String filename = "src/main/resources/" + title + ".json";
        File file = new File(filename);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(jsonString);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "Nie udało się stworzyć pliku ze scenariuszem.";
        }
        return "Stworzono plik ze scenariuszem o nazawie " + title + ".json";
    }
}
