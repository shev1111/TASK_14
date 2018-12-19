package com.shev.dao;

import com.shev.model.Item;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemDAOTest {
    private static Item testItem = new Item("test", 101010, 111);
    private static int testId = 0;
    private static int testUpPrice = 10101;

    @Test
    public void insertRetrieveItem() throws Exception {
       Item expItem = ItemDAO.insertItem(testItem);
       assertNotNull(expItem);
       assertEquals(testItem.getTitle(), expItem.getTitle());
       assertEquals(testItem.getPrice(), expItem.getPrice());
       assertEquals(testItem.getAvailability(), expItem.getAvailability());
       testItem = ItemDAO.retrieveItemByTitle("test");
       testId = testItem.getItemId();
       testItem.setPrice(testUpPrice);
       assertTrue(testId==testItem.getItemId());
    }


    @Test
    public void updateDeleteItem() throws Exception {
        Item expItem = ItemDAO.updateItem(testItem);
        assertEquals(testItem.getPrice(),expItem.getPrice());
        ItemDAO.deleteItem(testItem.getItemId());
        Item testDelete = ItemDAO.retrieveItem(testItem.getItemId());
        assertTrue(testDelete.getTitle()==null);
    }

}