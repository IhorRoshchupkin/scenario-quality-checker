package pl.put.poznan.scenario.logic.displaying;

import pl.put.poznan.scenario.model.Step;

public class ScenarioViewer extends DisplayingVisitor {
    private String scenarioText = "";

    public String getScenarioText() {
        return scenarioText;
    }

    public void setScenarioText(String scenarioText) {
        this.scenarioText = scenarioText;
    }

    @Override
    public void display(Step step, String parentNum, int level) {
        for (int i = 0; i < level; i++)
            scenarioText += "- - ";
        scenarioText += parentNum + " ";
        for (int i = 0; i < step.getContent().size(); i++)
            scenarioText += step.getContent().get(i) + " ";
        scenarioText += "</br>";
    }

    @Override
    public void afterDisplaying() {
        scenarioText = "";
    }
}
