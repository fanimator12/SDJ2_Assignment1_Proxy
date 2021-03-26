package arraylist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest
{
private ArrayList<Integer> arrayList ;


  @BeforeEach void setUp()
  {
    arrayList = new ArrayList<>();

  }

  @AfterEach void tearDown()
  {
    arrayList = null;

  }

  @Test void add()
  {
   arrayList.add(1);
    assertEquals(1,arrayList.size());


  }

  @Test void addZ() {
    assertEquals(0, arrayList.size());
  }

  @Test void add0() {
    arrayList.add(1);
    assertEquals(1, arrayList.size());
  }

  @Test void addM() {
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(3);
    assertEquals(3, arrayList.size());
  }

  @Test void setZ()
  {

    assertThrows(IndexOutOfBoundsException.class,()->arrayList.set(3,1));

  }
  @Test void setOne(){
    arrayList.add(1);
    arrayList.set(0,25);
    assertEquals(25,arrayList.get(0));
  }

  @Test void get()
  {
arrayList.add(1);
assertEquals(1,arrayList.get(0));
  }

  @Test void remove()
  {
    arrayList.add(1);
    arrayList.remove(0);
    assertEquals(0,arrayList.size());
  }


  @Test void indexOf()
  {
    arrayList.add(5255);
    arrayList.add(5525);
    arrayList.add(5253);
    arrayList.add(5251);
    arrayList.add(255);

    assertEquals(255,arrayList.get(4));
  }

  @Test void contains()
  {
    arrayList.add(12);
    assertTrue(arrayList.contains(12));
  }

  @Test void isEmpty()
  {
    assertTrue(arrayList.isEmpty());
  }


  @Test void size()
  {
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(4);
    arrayList.add(5);
    assertEquals(5, arrayList.size());
  }

  @Test void testToString()
  {
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(4);
    arrayList.add(5);
    assertEquals("{1, 2, 3, 4, 5}", arrayList.toString());
  }
}