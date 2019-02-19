package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Test
 * @author Maxim Azarkov (aza-maxim@yandex.ru)
 * @version $Id$
 * @since 0.2 (20.02.2019)
  */

public class CalculateTest {
     /**
     * Test echo(name).
     */
	/*public void when...Then... () {}*/
	@Test
    public void whenTakeNameThenThreeEchoPlusName(){
		//Определяем ввод данных
		String input="Azarkov Maxim";
		// определяем ожидаемый результат (или поведение)
		String expect="Echo, echo, echo : Azarkov Maxim";
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
    public void whenTakeNullThenThreeEchoPlusNull(){
		//Определяем ввод данных
		String input="Null";
		// определяем ожидаемый результат (или поведение)
		String expect="Echo, echo, echo : Null";
		//Составление списка действий и сценария. После выполния будет произведено какое-то действие, изменено состояние программы, либо выведено результат
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		//завершающий этап. Сравнение реального и ожидаемого резальтатов программы
		assertThat(result, is(expect));
    }


    /**
     * Test add.
     */
	/*public void when...Then... () {}*/
	@Test
    public void whenAddOneToOneThenTwo(){
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Calculate.main(null);
		assertThat(
			out.toString(),
			is(
				String.format(
					"hello Job4j%s",
					System.getProperty("line.separator")
				)
			)
		);
    }
}
