package pl.put.poznan.scenario.logic.counting;

import pl.put.poznan.scenario.model.Step;

public class NoActorSteps extends CountingVisitor
{
    private int stepsNumber = 0;

    public int getStepsNumber() {
        return stepsNumber;
    }

    public void count(Step step)
    {
        if(!isActor(step))
            stepsNumber++;
    }

    public void afterCounting()
    {
        stepsNumber = 0;
    }

    private boolean isActor(Step step) {
        if(!step.getActor().equals(""))
            return true;

        return false;
    }
}