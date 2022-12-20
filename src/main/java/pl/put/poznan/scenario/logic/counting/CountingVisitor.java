package pl.put.poznan.scenario.logic.counting;

import pl.put.poznan.scenario.model.Step;

abstract public class CountingVisitor
{
    public abstract void count(Step step);
    public abstract void afterCounting();
}
