package ru.job4j.condition;

/**
 * TruckerJob.
 */
public class TruckerJob {
    public static void main(String[] args) {
        Driver steve = new Driver();
        System.out.println("Steve wants the trucker job.");
        checkHasLicense(steve);
        checkCanDrive(steve);

        System.out.println("-----------------");
        System.out.println("But Steve wants the trucker job.");
        checkHasLicense(steve);
        steve.passExamOn('B');
        checkCanDrive(steve);

        System.out.println("-----------------");
        System.out.println("But Steve wants the trucker job.");
        checkHasLicense(steve);
        steve.passExamOn('C');
        checkCanDrive(steve);

    }

    private static void checkHasLicense(Driver driver) {
        if (!driver.hasLicense()) {
            System.out.println("Steve need to get a license!");
            driver.passExamOn('A');
        }
    }

    private static void checkCanDrive(Driver driver) {
        if (driver.canDrive('C')) {
            System.out.println("Steve works on truckers!");
        } else if (driver.canDrive('B')) {
            System.out.println("Steve works in taxi!");
        } else {
            System.out.println("Steve does not have a job, but ride on motorbike!");
        }
    }
}
