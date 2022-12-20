package pl.put.poznan.transformer.logic.counting;

import pl.put.poznan.transformer.model.Step;

/**
 * Ksasa do zliczania wszystkich kroków
 *
 */
public class AllSteps extends CountingVisitor
{
    private int stepsNumber = 0;

    /**
     * Funkcja, która zwracania liczby kroków w scenariusze
     * @return liczba kroków w scenariusze
     */
    public int getStepsNumber() {
        return stepsNumber;
    }

    /**
     * Funkcja do liczenia kroków
     * @param step  aktualnie odwiedzany krok
     */
    public void count(Step step)
    {
        stepsNumber++;
    }

    /**
     * Ustawia stepsNumber na zero
     */
    public void afterCounting()
    {
        stepsNumber = 0;
    }
}
