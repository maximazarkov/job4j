package ru.job4j.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;


/**
 * Теперь давайте рассмотрим варианты реализации шаблона singleton. Приведенные шаблоны можно использовать
 * только в однопоточном программировании.
 *
 * Так стоит упомянуть, что шаблоны делятся с ленивой загрузкой и энергичной.
 *
 * Ленивая загрузка (Lazy loading) происходит, когда мы явно обращаемся к объекту. Происходит его загрузка.
 *
 * Энергичная загрузка (Eager loading) - загружает объект сразу после старта виртуальной машины.
 *
 * 1. enum. Eager loading. [1]
 * В JDK 1.5 появилось новое ключевое слово enum. Оно используется для создания ограниченного количество объектов.
 * 2. static field. Lazy loading. [2]
 * Для того, чтобы закрыть возможность создавать экземпляр класса, нам нужно явно создать конструтор по умолчанию и
 * присвоить ему модификатор private.
 * 3. static final field. Eager loading. [3]
 * Этот вариант вариант похож на предыдущей. Основное отличие, мы сразу создаем и инициализируем объект.
 * 4. private static final class. Lazy loading. [4]
 * Последний вариант объект класса находиться в поле внутреннего класса.
 * */
//public enum TrackerSingle {                       // [1]
//    INSTANCE; // Зедсь мы указываем перечисления     [1]
public class TrackerSingle {                        // [2][3][4]
    //private static TrackerSingle instance;          // [2]
    //private static final TrackerSingle INSTANCE = new TrackerSingle();  // [3]

    //Конструкторы и методы.
    private TrackerSingle() {}                      // [2][3][4]

    public static TrackerSingle getInstance(){      // [2][3]
        //if(instance == null) {                      // [2]
        //    instance = new TrackerSingle();         // [2]
        //}                                           // [2]
        //return instance;                            // [2]
        //return INSTANCE;                            // [3]
        return Holder.INSTANCE;                     // [4]
    }                                               // [2][3][4]

    public Item add(Item model) {   // [1][2][3][4]
        return model;               // [1][2][3][4]
    }

    private static final class Holder {                                    // [4]
        private static final TrackerSingle INSTANCE = new TrackerSingle(); // [4]
    }                                                                      // [4]

    public static void main(String[] args) {    // [1][2][3][4]
        //TrackerSingle tracker = new TrackerSingle();  //ошибка! нельзя создать объект от статического класса или перечисления [1]
        //TrackerSingle tracker = TrackerSingle.INSTANCE; // ENUM. применяется для доступа к статическому элементу [1]
        TrackerSingle tracker = TrackerSingle.getInstance(); // [2][3][4]
    }   // [1][2][3][4]
}
