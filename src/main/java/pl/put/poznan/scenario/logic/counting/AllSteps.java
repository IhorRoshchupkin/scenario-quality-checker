package pl.put.poznan.scenario.logic.counting;

import pl.put.poznan.scenario.model.Step;

public class AllSteps extends CountingVisitor
{
    private int stepsNumber = 0;

    public int getStepsNumber() {
        return stepsNumber;
    }

    public void count(Step step)
    {
        stepsNumber++;
    }

    public void afterCounting()
    {
        stepsNumber = 0;
    }
}
