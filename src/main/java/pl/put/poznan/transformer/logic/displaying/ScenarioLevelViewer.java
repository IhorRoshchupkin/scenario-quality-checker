package pl.put.poznan.transformer.logic.displaying;

import pl.put.poznan.transformer.model.Step;

public class ScenarioLevelViewer extends DisplayingVisitor
{
    private String scenarioText = "";
    private int desiredLevel = 0;

    public ScenarioLevelViewer(int desiredLevel) { this.desiredLevel = desiredLevel; }

    public String getScenarioText() {
        return scenarioText;
    }

    public void setScenarioText(String scenarioText) {
        this.scenarioText = scenarioText;
    }

    public int getDesiredLevel() {
        return desiredLevel;
    }

    public void setDesiredLevel(int desiredLevel) {
        this.desiredLevel = desiredLevel;
    }

    @Override
    public void display(Step step, String parentNum, int level)
    {
        if(level < desiredLevel) {
            for (int i = 0; i < level; i++)
                scenarioText += "- - ";
            scenarioText += parentNum + " ";
            for (int i = 0; i < step.getContent().size(); i++)
                scenarioText += step.getContent().get(i) + " ";
            scenarioText += "</br>";
        }
    }

    @Override
    public void afterDisplaying()
    {
        scenarioText = "";
        desiredLevel = 0;
    }
}
