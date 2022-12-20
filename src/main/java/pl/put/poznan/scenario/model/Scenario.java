package pl.put.poznan.scenario.model;

import pl.put.poznan.scenario.logic.counting.CountingVisitor;
import pl.put.poznan.scenario.logic.displaying.DisplayingVisitor;
import pl.put.poznan.scenario.logic.displaying.ScenarioLevelViewer;
import pl.put.poznan.scenario.logic.displaying.ScenarioViewer;

import java.util.List;


public class Scenario
{
    private String title;
    private List<String> actors;
    private List<String> sysactors;
    private List<Step> steps;

    public Scenario() { }

    public void acceptCounting(CountingVisitor visitor)
    {
        for(Step step : steps)
        {
            step.acceptCounting(visitor);
        }
    }

    public void acceptDisplaying(DisplayingVisitor visitor)
    {
        if(visitor instanceof ScenarioViewer)
            ((ScenarioViewer)visitor).setScenarioText("<strong>" + this.title + "</strong></br></br>");
        if(visitor instanceof ScenarioLevelViewer)
            ((ScenarioLevelViewer)visitor).setScenarioText("<strong>" + this.title + "</strong></br></br>");
        for(Step step : steps)
        {
            step.acceptDisplaying(visitor, "", 0);
        }
    }

    public String getTitle() {
        return title;
    }

    public List<String> getActors() {
        return actors;
    }

    public List<String> getSysactors() {
        return sysactors;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public void setSysactors(List<String> sysactors) {
        this.sysactors = sysactors;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
}