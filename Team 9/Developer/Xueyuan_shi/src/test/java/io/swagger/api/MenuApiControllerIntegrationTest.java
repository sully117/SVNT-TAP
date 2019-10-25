//package io.swagger.api;
//
//import io.swagger.model.Item;
//import io.swagger.model.ListOfItems;
//
//import java.util.*;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MenuApiControllerIntegrationTest {
//
//    @Autowired
//    private MenuApi api;
//
//    @Test
//    public void replaceMenuTest() throws Exception {
//        List<Item> body = Arrays.asList(new Item());
//        ResponseEntity<Void> responseEntity = api.replaceMenu(body);
//        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
//    }
//
//    @Test
//    public void retriveMenuTest() throws Exception {
//        String storeName = "storeName_example";
//        String menuType = "menuType_example";
//        ResponseEntity<List<ListOfItems>> responseEntity = api.retriveMenu(storeName, menuType);
//        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
//    }
//
//}
