package ru.job4j.condition;

/**
 * Driver.
 * @author Maxim Azarkov.
 * @version $Id$.
 * @since 0.1.
 */
public class Driver {
    private char license = 'N';

    /**
     * passExamOn - получить права
     * @param category - category A, B or C
     */
    public void passExamOn(char category) {
        this.license = category;
    }

    public boolean hasLicense() {
        return this.license == 'A' || this.license == 'B' || this.license == 'C';
    }

    public boolean canDrive(char category) {
        return this.license == category;
    }

}
