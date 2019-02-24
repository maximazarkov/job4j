package ru.job4j.condition;

/**
 * DeveloperJob.
 */
public class DeveloperJob {
    public static void main(String[] args) {
        Developer max = new Developer();
        System.out.println("Ты хочешь стать Java разработчиком?");
        checkHasLevelJava(max);
        checkCanJobdeveloper(max);

        System.out.println("-----------------");
        System.out.println("Но ты все же хочешь стать Java разработчиком");
        checkHasLevelJava(max);
        checkCanJobdeveloper(max);
        max.passLevelJava("junior");
        checkHasLevelJava(max);
        checkCanJobdeveloper(max);

        System.out.println("-----------------");
        System.out.println("Уже не плохо! Но Java разработчику есть куда расти! Удачи!");
        checkHasLevelJava(max);
        checkCanJobdeveloper(max);
        max.passLevelJava("middle");
        checkHasLevelJava(max);
        checkCanJobdeveloper(max);

        System.out.println("-----------------");
        System.out.println("А ты упертый...!");
        checkHasLevelJava(max);
        checkCanJobdeveloper(max);
        max.passLevelJava("FullStack");
        checkHasLevelJava(max);
        checkCanJobdeveloper(max);
    }

    private static void checkHasLevelJava(Developer dev) {
        if (!dev.hasLevelJava()) {
            System.out.println("Тебе нужно поучиться... Извини.!");
            dev.passLevelJava("trainee");
        }
    }

    private static void checkCanJobdeveloper(Developer dev) {
        if (dev.canJobDeveloper("FullStack")) {
            System.out.println("Отлично! Ты достоен зарабатывать не менее $2000 в месяц!");
        } else if (dev.canJobDeveloper("middle")) {
            System.out.println("Middle! Замечательно! можно постараться найти работу на $1000-$1500 в месяц");
        } else if (dev.canJobDeveloper("junior")) {
            System.out.println("Junior! Не плохо! Но максимум, на что можешь рассчитывать - на $1000 в месяц.");
        } else {
            System.out.println("Ты стажер?Эх! тебе учиться и учиться... о нормальной работе только мечатать...");
        }
    }
}
