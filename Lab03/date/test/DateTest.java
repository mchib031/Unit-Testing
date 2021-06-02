import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {

  @Test
  void nextDate_tc01() {
    Date today = new Date(1700, 6, 20);
    Date expectedTomorrow = new Date(1700, 6, 21);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc02() {
    Date today = new Date(2005, 4, 15);
    Date expectedTomorrow = new Date(2005, 4, 16);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc03() {
    Date today = new Date(1901, 7, 20);
    Date expectedTomorrow = new Date(1901, 7, 21);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc04() {
    Date today = new Date(3456, 3, 27);
    Date expectedTomorrow = new Date(3456, 3, 28);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc05() {
    Date today = new Date(1500, 2, 17);
    Date expectedTomorrow = new Date(1500, 2, 18);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc06() {
    Date today = new Date(1700, 6, 29);
    Date expectedTomorrow = new Date(1700, 6, 30);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc07() {
    Date today = new Date(1800, 11, 29);
    Date expectedTomorrow = new Date(1800, 11, 30);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc08() {
    Date today = new Date(3453, 1, 29);
    Date expectedTomorrow = new Date(3453, 1, 30);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc09() {
    Date today = new Date(444, 2, 29);
    Date expectedTomorrow = new Date(444, 3, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc10() {
    Date today = new Date(2005, 4, 30);
    Date expectedTomorrow = new Date(2005, 5, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc11() {
    Date today = new Date(3453, 1, 30);
    Date expectedTomorrow = new Date(3453, 1, 31);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc12() {
    Date today = new Date(3456, 3, 30);
    Date expectedTomorrow = new Date(3456, 3, 31);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc13() {
    Date today = new Date(1901, 7, 31);
    Date expectedTomorrow = new Date(1901, 8, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc14() {
    Date today = new Date(3453, 1, 31);
    Date expectedTomorrow = new Date(3453, 2, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc15() {
    Date today = new Date(3456, 12, 31);
    Date expectedTomorrow = new Date(3457, 1, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc16() { // pour septembre
    Date today = new Date(2000, 9, 5);
    Date expectedTomorrow = new Date(2000, 9, 6);
    assertEquals(expectedTomorrow, today.nextDate());
  }

    @Test
  void nextDate_leap() { // leap year alors on choisit 2000 pour que ca soit divisible par 400
    Date today = new Date(2000, 4, 5);
    Date expectedTomorrow = new Date(2000, 4, 6);
    assertEquals(expectedTomorrow, today.nextDate());
  }

   @Test
  void nextDate_2012() { // leap year, on choisit un en fevrier ou il y a 29 jours
    Date today = new Date(2012, 2, 28);
    Date expectedTomorrow = new Date(2012, 2, 29);
    assertEquals(expectedTomorrow, today.nextDate());
  }

     @Test
  void nextDate_2021() { // not leap year, on choisit un en fevrier ou il n'ya pas 29 jour
    Date today = new Date(2021, 2, 28);
    Date expectedTomorrow = new Date(2021, 3, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

    @Test
  void nextDate_equals(){ 
    Object obj = new Object();
    Date date = new Date(1999,3,21);
    assertFalse(date.equals(obj));
}

    @Test
  void nextDate_equals2(){
    Date date = new Date(2021,6,28);
    Date date2 = new Date(2020,8,26);
    assertFalse(date.equals(date2));
}

    @Test
  void nextDate_equals3(){
    Date date = new Date(2021,6,23);
    Date date2 = new Date(2021,7,24);
    assertFalse(date.equals(date2));
}

    @Test
void nextDate_equals4(){
    Date date = new Date(2021,7,20);
    Date date2 = new Date(2021,7,21);
    assertFalse(date.equals(date2));
}

    @Test
  void nextDate_invalid_tc16() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1500, 2, 31)
    );
  }

    @Test
   void nextDate_invalid_tc17() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1500, 2, 29)
    );
  }

  @Test
  void nextDate_invalid_tc18() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(-1, 10, 20)
    );
  }

  @Test
  void nextDate_invalid_tc19() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1458, 15, 12)
    );
  }

  @Test
  void nextDate_invalid_tc20() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1975, 6, -50)
    );
  }

  @Test
void nextDate_invalid_Day() { // test de plus que 31 jours
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1800, 6, 32)
    );
}

@Test
void nextDate_invalid_Day_2() { // test de un mois qui a 30 jours seulement
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(2001, 4, 31)
    );
}

@Test
void nextDate_invalid_Day_3() { // test de plus que 29 jours en fevrier
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(2020, 2, 30)
    );
}
@Test
void nextDate_String(){ // tester la conversion en string de la date
    Date date = new Date(2019,4,3);
    assertEquals("2019/April/3",date.toString());
}
    @Test
void nextDate_setmonth(){
    Date date = new Date(2021,0,20);
    Date date2 = new Date(2021,0,21);
    assertFalse(date.equals(date2));
}


}