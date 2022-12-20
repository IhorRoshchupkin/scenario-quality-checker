package pl.put.poznan.scenario.logic.displaying;

import pl.put.poznan.scenario.model.Step;

abstract public class DisplayingVisitor
{
    public abstract void display(Step step, String parentNum, int level);
    public abstract void afterDisplaying();
}
