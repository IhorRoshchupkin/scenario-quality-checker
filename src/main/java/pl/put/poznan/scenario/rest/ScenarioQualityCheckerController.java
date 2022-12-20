package pl.put.poznan.scenario.rest;

import com.google.gson.JsonSyntaxException;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.scenario.logic.JSONfileReader;
import pl.put.poznan.scenario.logic.JSONfileWriter;
import pl.put.poznan.scenario.logic.JSONtoObject;
import pl.put.poznan.scenario.logic.counting.AllSteps;
import pl.put.poznan.scenario.logic.counting.CountingVisitor;
import pl.put.poznan.scenario.logic.counting.KeywordsSteps;
import pl.put.poznan.scenario.logic.counting.NoActorSteps;
import pl.put.poznan.scenario.logic.displaying.DisplayingVisitor;
import pl.put.poznan.scenario.logic.displaying.ScenarioLevelViewer;
import pl.put.poznan.scenario.logic.displaying.ScenarioViewer;
import pl.put.poznan.scenario.model.Scenario;


@RestController
public class ScenarioQualityCheckerController
{

    @RequestMapping(method = RequestMethod.GET, path = "/all-steps/{filename}")
    public int countAllSteps(@PathVariable String filename)
    {
        String JSONfile = new JSONfileReader().toString(filename);

        if(JSONfile == "{}" || JSONfile == "")
            return 0;

        Scenario scenario;
        try {
            scenario = JSONtoObject.getObject(JSONfile);
        }
        catch (JsonSyntaxException e) {
            return 0;
        }

        CountingVisitor visitor = new AllSteps();
        scenario.acceptCounting(visitor);
        int result = ((AllSteps) visitor).getStepsNumber();
        visitor.afterCounting();
        return result;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/keywords-steps/{filename}")
    public int countKeyWordsSteps(@PathVariable String filename)
    {
        String JSONfile = new JSONfileReader().toString(filename);

        if(JSONfile == "{}" || JSONfile == "")
            return 0;

        Scenario scenario;
        try {
            scenario = JSONtoObject.getObject(JSONfile);
        }
        catch (JsonSyntaxException e) {
            return 0;
        }

        CountingVisitor visitor = new KeywordsSteps();
        scenario.acceptCounting(visitor);
        int result = ((KeywordsSteps) visitor).getStepsNumber();
        visitor.afterCounting();
        return  result;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/no-actor-steps/{filename}")
    public int countNoActorSteps(@PathVariable String filename)
    {
        String JSONfile = new JSONfileReader().toString(filename);

        if(JSONfile == "{}" || JSONfile == "")
            return 0;

        Scenario scenario;
        try {
            scenario = JSONtoObject.getObject(JSONfile);
        }
        catch (JsonSyntaxException e) {
            return 0;
        }

        CountingVisitor visitor = new NoActorSteps();
        scenario.acceptCounting(visitor);
        int result = ((NoActorSteps) visitor).getStepsNumber();
        visitor.afterCounting();
        return  result;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/show-scenario/{filename}")
    public String showScenario(@PathVariable String filename)
    {
        String JSONfile = new JSONfileReader().toString(filename);

        Scenario scenario;
        try {
            scenario = JSONtoObject.getObject(JSONfile);
        }
        catch (JsonSyntaxException e) {
            return "Błędna struktura scenariusza.";
        }

        DisplayingVisitor visitor = new ScenarioViewer();
        scenario.acceptDisplaying(visitor);
        return ((ScenarioViewer) visitor).getScenarioText();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/show-scenario/{level}/{filename}")
    public String showLevelScenario(@PathVariable String filename, @PathVariable int level)
    {
        String JSONfile = new JSONfileReader().toString(filename);

        Scenario scenario;
        try {
            scenario = JSONtoObject.getObject(JSONfile);
        }
        catch (JsonSyntaxException e) {
            return "Błędna struktura scenariusza.";
        }

        DisplayingVisitor visitor = new ScenarioLevelViewer(level);
        scenario.acceptDisplaying(visitor);
        return ((ScenarioLevelViewer) visitor).getScenarioText();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add-scenario/{title}")
    public String addScenario(@PathVariable String title, @RequestBody Scenario scenario)
    {
        return JSONfileWriter.writeScenarioToFile(scenario, title);
    }
}

