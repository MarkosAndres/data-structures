package com.markos;

import com.markos.linkedlist.SinglyLinkedList;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.is;

public class SinglyLinkedListTest {

    private SinglyLinkedList list;

    @Before
    public void setup() {
        list = new SinglyLinkedList(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.insert(9);
    }

    @Test
    public void insertTwoValuesTest() {
        assertThat(list.insert(100), is(true));
        assertThat(list.insert(45), is(true));
        assertThat(list.toArrayList().toString(), is("[5, 6, 7, 8, 9, 100, 45]"));
    }

    @Test
    public void searchFirstNodeTest() {
        assertThat(list.search(5), is(true));
    }

    @Test
    public void searchMiddleNodeTest() {
        assertThat(list.search(7), is(true));
    }

    @Test
    public void searchLastNodeTest() {
        assertThat(list.search(9), is(true));
    }

    @Test
    public void searchNonExistingNodeTest() {
        assertThat(list.search(91), is(false));
    }

    @Test
    public void listSizeTest() {
        assertThat(list.toArrayList().size(), is(5));
    }

    @Test
    public void listContentTest() {
        List<Integer> arrayList = list.toArrayList();
        int value = 4;

        for(int i = 0; i < arrayList.size(); i++) {
            assertThat(arrayList.get(i), is(++value));
        }
    }

    @Test
    public void deleteFirstNode() {
        assertThat(list.delete(5), is(true));
        assertThat(list.toArrayList().toString(), is("[6, 7, 8, 9]"));
    }

    @Test
    public void deleteMiddleNode() {
        assertThat(list.delete(7), is(true));
        assertThat(list.toArrayList().toString(), is("[5, 6, 8, 9]"));
    }

    @Test
    public void deleteLastNode() {
        assertThat(list.delete(9), is(true));
        assertThat(list.toArrayList().toString(), is("[5, 6, 7, 8]"));
    }

    @Test
    public void deleteNonExistingTest() {
        assertThat(list.delete(19), is(false));
        assertThat(list.toArrayList().toString(), is("[5, 6, 7, 8, 9]"));
    }

}
