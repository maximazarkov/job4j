package ru.job4j.condition;

/**
 * Developer -
 * @author Maxim Azarkov.
 * @version $Id$.
 * @since 0.1.
 */
public class Developer {
    private String levelJava = "No";

    /**
     * passExamOn - получить права
     * @param newLevelJava - trainee, junior, middle, FullStack
     */
    public void passLevelJava(String newLevelJava) {
        this.levelJava = newLevelJava;
        System.out.println("Получено звание: " + this.levelJava);
    }

    /**
     * hasLevelJava - проверим, если ли вообще какой-либо уровень в Java
     */
    public boolean hasLevelJava() {
        return this.levelJava.equals("trainee") || this.levelJava.equals("junior") || this.levelJava.equals("middle") || this.levelJava.equals("FullStack");
    }

    /**
     * hasLevelJava - проверим, если ли определенный уровень в Java
     * javaLevel - требуемый уровень Java
     */
    public boolean canJobDeveloper(String javaLevel) {
        return this.levelJava.equals(javaLevel);
    }

}
