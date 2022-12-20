package pl.put.poznan.transformer.model;

import pl.put.poznan.transformer.logic.counting.CountingVisitor;
import pl.put.poznan.transformer.logic.displaying.DisplayingVisitor;

import java.util.List;

public class Step
{
    private Integer stepNum;
    private String actor;
    private List<String> content;
    private List<Step> substeps;
    private List<Integer> returnPath;

    public Step() { }

    public void acceptCounting(CountingVisitor visitor)
    {
        visitor.count(this);
        if(!this.substeps.isEmpty())
            for(Step step : substeps)
                step.acceptCounting(visitor);
    }

    public void acceptDisplaying(DisplayingVisitor visitor, String num, int level)
    {
        num += "<strong>" + this.stepNum + ".</strong>";
        visitor.display(this, num, level);
        if(!this.substeps.isEmpty()) {
            level++;
            for (Step step : substeps)
                step.acceptDisplaying(visitor, num, level);
        }
    }

    public Integer getStepNum() {
        return stepNum;
    }

    public void setStepNum(Integer stepNum) {
        this.stepNum = stepNum;
    }

    public String getActor() { return actor; }

    public void setActor(String actor) { this.actor = actor; }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public List<Step> getSubsteps() {
        return substeps;
    }

    public void setSubsteps(List<Step> substeps) {
        this.substeps = substeps;
    }

    public List<Integer> getReturnPath() {
        return returnPath;
    }

    public void setReturnPath(List<Integer> returnPath) {
        this.returnPath = returnPath;
    }
}