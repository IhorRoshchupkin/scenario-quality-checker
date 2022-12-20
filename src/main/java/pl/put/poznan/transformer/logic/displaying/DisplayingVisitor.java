package pl.put.poznan.transformer.logic.displaying;

import pl.put.poznan.transformer.model.Step;

abstract public class DisplayingVisitor
{
    public abstract void display(Step step, String parentNum, int level);
    public abstract void afterDisplaying();
}
