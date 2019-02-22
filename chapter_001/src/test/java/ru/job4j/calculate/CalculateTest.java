package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Maxim Azarkov (aza-maxim@yandex.ru).
 * @version $Id$.
 * @since 0.2 (22.02.2019).
 */

public class CalculateTest {
	/**
	 * Test echo(name).
	 */
	/*public void when...Then... () {}*/
	@Test
	public void whenTakeNameThenThreeEchoPlusName() {
		//Определяем ввод данных
		String input = "Azarkov Maxim";
		// определяем ожидаемый результат (или поведение)
		String expect = "Echo, echo, echo : Azarkov Maxim";
		//Составление списка действий и сценария. После выполния будет произведено какое-то действие, изменено состояние программы, либо выведено результат
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		//завершающий этап. Сравнение реального и ожидаемого резальтатов программы
		assertThat(result, is(expect));
	}

	/**
	 * Test echo(null) NPE.
	 */
	@Test
	public void whenTakeNullThenThreeEchoPlusNull() {
		//Определяем ввод данных
		String input = "Null";
		// определяем ожидаемый результат (или поведение)
		String expect = "Echo, echo, echo : Null";
		//Составление списка действий и сценария. После выполния будет произведено какое-то действие, изменено состояние программы, либо выведено результат
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		//завершающий этап. Сравнение реального и ожидаемого резальтатов программы
		assertThat(result, is(expect));
	}

	/**
	 * Test add.
	 */
	@Test
	public void whenAddOnePlusTwoThenThree() {
        //Определяем ввод данных
        double first = 1D;
        double second = 2D;
        // определяем ожидаемый результат (или поведение)
        double expect = 3D;
        //Составление списка действий и сценария. После выполния будет произведено какое-то действие, изменено состояние программы, либо выведено результат
		Calculate calc = new Calculate();
        calc.add(first, second);
		double result = calc.getResult();
        //завершающий этап. Сравнение реального и ожидаемого резальтатов программы
        assertThat(result, is(expect));
	}

    /**
     * Test subtract.
     */
    @Test
    public void whenAddThreeSubtractTwoThenOne() {
        //Определяем ввод данных
        double first = 3D;
        double second = 2D;
        // определяем ожидаемый результат (или поведение)
        double expect = 1D;
        //Составление списка действий и сценария. После выполния будет произведено какое-то действие, изменено состояние программы, либо выведено результат
        Calculate calc = new Calculate();
        calc.subtruct(first, second);
        double result = calc.getResult();
        //завершающий этап. Сравнение реального и ожидаемого резальтатов программы
        assertThat(result, is(expect));
    }

    /**
     * Test div.
     */
    @Test
    public void whenAddFourDivTwoThenTwo() {
        //Определяем ввод данных
        double first = 4D;
        double second = 2D;
        // определяем ожидаемый результат (или поведение)
        double expect = 2D;
        //Составление списка действий и сценария. После выполния будет произведено какое-то действие, изменено состояние программы, либо выведено результат
        Calculate calc = new Calculate();
        calc.div(first, second);
        double result = calc.getResult();
        //завершающий этап. Сравнение реального и ожидаемого резальтатов программы
        assertThat(result, is(expect));
    }

    /**
     * Test add.
     */
    @Test
    public void whenAddTwoMultipleTreeThenSix() {
        //Определяем ввод данных
        double first = 2D;
        double second = 3D;
        // определяем ожидаемый результат (или поведение)
        double expect = 6D;
        //Составление списка действий и сценария. После выполния будет произведено какое-то действие, изменено состояние программы, либо выведено результат
        Calculate calc = new Calculate();
        calc.multiple(first, second);
        double result = calc.getResult();
        //завершающий этап. Сравнение реального и ожидаемого резальтатов программы
        assertThat(result, is(expect));
    }


}
