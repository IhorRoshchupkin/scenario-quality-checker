package pl.put.poznan.transformer.logic.counting;

import pl.put.poznan.transformer.model.Step;

abstract public class CountingVisitor
{
    public abstract void count(Step step);
    public abstract void afterCounting();
}
