package com.sbrf.reboot.equalshashcode;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class EqualsHashCodeTest {

    @RequiredArgsConstructor
    class Car {
        String model;
        String color;
        Calendar releaseDate;
        int maxSpeed;

        @Override
        public boolean equals(Object o) {

            //Рефлексивность: объект должен равняться самому себе
            if (o == this) {
                return true;
            }

            //Определенность, симметричность, транзитивность:
            //проверка ссылки на null и сравнение на совпадение классов
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }

            Car transferredCar = (Car) o;

            //Согласованность:
            //Проверка по равенству полей
            return maxSpeed == transferredCar.maxSpeed
                    && Objects.equals(model, transferredCar.model)
                    && Objects.equals(color, transferredCar.color)
                    && Objects.equals(releaseDate, transferredCar.releaseDate);
        }

        @Override
        public int hashCode() {

            /* Одинаковые значения при неизменности полей;
            Одно и то же значение у равных объектов;
            У неравных объектов разные значения с определенной долей вероятности. */

            int result = 23;
            result = 19 * result + (model != null ? model.hashCode() : 0);
            result = 19 * result + (color != null ? color.hashCode() : 0);
            result = 19 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
            result = 19 * result + maxSpeed;

            return result;
        }
    }

    @Test
    public void checkConsistent() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, Calendar.JANUARY, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Mercedes";
        car2.color = "black";
        car2.releaseDate = new GregorianCalendar(2020, Calendar.JANUARY, 25);
        car2.maxSpeed = 10;


        Assertions.assertTrue(car1.equals(car2));
    }

    @Test
    public void failCheckConsistent() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, Calendar.JANUARY, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Mercedes";
        car2.color = "black";
        car2.releaseDate = new GregorianCalendar(2020, Calendar.JANUARY, 25);
        car2.maxSpeed = 10;

        boolean equalityWithoutChanges = car1.equals(car2);
        car2.color = "white";
        boolean equalityWithChanges = car1.equals(car2);

        Assertions.assertFalse(equalityWithoutChanges && equalityWithChanges);
    }

    @Test
    public void checkReflexivity() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Assertions.assertTrue(car1.equals(car1));
    }

    @Test
    public void checkEqualsWithNull() {
        Car car1 = new Car();

        Assertions.assertFalse(car1.equals(null));
    }

    @Test
    public void  checkSymmetry() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, Calendar.JANUARY, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Mercedes";
        car2.color = "black";
        car2.releaseDate = new GregorianCalendar(2020, Calendar.JANUARY, 25);
        car2.maxSpeed = 10;

        Assertions.assertTrue(car1.equals(car2) && car2.equals(car1));
    }

    @Test
    public void checkTransitivity() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, Calendar.JANUARY, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Mercedes";
        car2.color = "black";
        car2.releaseDate = new GregorianCalendar(2020, Calendar.JANUARY, 25);
        car2.maxSpeed = 10;

        Car car3 = new Car();
        car3.model = "Mercedes";
        car3.color = "black";
        car3.releaseDate = new GregorianCalendar(2020, Calendar.JANUARY, 25);
        car3.maxSpeed = 10;

        Assertions.assertTrue(car1.equals(car2) && car2.equals(car3) && car1.equals(car3));
    }

    @Test
    public void assertFalseEquals() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, Calendar.JANUARY, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Audi";
        car2.color = "white";
        car2.releaseDate = new GregorianCalendar(2017, Calendar.JANUARY, 25);
        car2.maxSpeed = 10;

        Assertions.assertFalse(car1.equals(car2));
    }

    @Test
    public void successEqualsHashCode() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, Calendar.JANUARY, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Mercedes";
        car2.color = "black";
        car2.releaseDate = new GregorianCalendar(2020, Calendar.JANUARY, 25);
        car2.maxSpeed = 10;

        Assertions.assertEquals(car1.hashCode(), car2.hashCode());

    }

    @Test
    public void failEqualsHashCode() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, Calendar.JANUARY, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Audi";
        car2.color = "white";
        car2.releaseDate = new GregorianCalendar(2017, Calendar.JANUARY, 25);
        car2.maxSpeed = 10;

        Assertions.assertNotEquals(car1.hashCode(), car2.hashCode());

    }


}
