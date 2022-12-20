package pl.put.poznan.scenario.logic.counting;

import pl.put.poznan.scenario.model.Step;

import java.util.List;

/**
 * Klasa do zliczania kroków zawierających slowa kluczowe
 *
 */
public class KeywordsSteps extends CountingVisitor
{
    private int stepsNumber = 0;

    public int getStepsNumber() { return stepsNumber; }

    /**
     * Zlicza liczbę kroków zawierających słowa kluczowe.
     *
     * @param step  aktualnie odwiedzany krok
     */
    public void count(Step step)
    {
        if(isKeyword(step))
            stepsNumber++;
    }
    /**
     * Ustawia stepsNumber na zero
     */
    public void afterCounting()
    {
        stepsNumber = 0;
    }

    /**
     * Sprawdza czy krok zawiera slowa kluczowe
     * @param step krók do sprawdzenia
     * @return  true jezeli krok zawiera slowo kluczowe bądz false jezeli nie zawiera
     */
    private static boolean isKeyword(Step step)
    {
        List<String> content = step.getContent();
        return content.get(0).equals("IF") || content.get(0).equals("FOR EACH") || content.get(0).equals("ELSE");
    }
}
