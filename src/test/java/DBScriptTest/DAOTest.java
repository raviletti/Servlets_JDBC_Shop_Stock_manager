package DBScriptTest;


import dao.FanDaoImpl;
import model.Fan;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DAOTest {
    TestDBService testDBService = new TestDBService("testdb");
    @BeforeAll
    void beforeAll() {
        testDBService.createTestTable();
    }
    @BeforeEach
    void beforeEach(){
        testDBService.insertTestTable();
    }

    @Test
    public void testFindAll(){
        FanDaoImpl fdi = new FanDaoImpl("testdb");
        List<Fan> fans = fdi.findAll();
        assertNotNull(fans);
        assertEquals(5, fans.size());
        fans.forEach(System.out::println);
    }

    @Test
    public void testFindById(){
        FanDaoImpl fdi = new FanDaoImpl("testdb");
        //exception scenario
        Fan fan = fdi.findById(100);
        assertNull(fan);

        //standard scenario
        fan = fdi.findById(2);
        assertNotNull(fan);
        //'125 M', 'Vents',  '247', '0,2', '0,2', '10'
        assertEquals("125 M", fan.getModelName());
        assertEquals("Vents", fan.getProducerName());
        assertEquals(247, fan.getQuantity());
    }

    @Test
    public void testFindByModelName(){
        FanDaoImpl fdi = new FanDaoImpl("testdb");
        //exception scenario 1
        String name = "xxxxxxxxxx";
        List<Fan> fans = fdi.findByModelName(name);
        assertNotNull(fans);
        assertEquals(0, fans.size());

        //exception scenario 2
        name = "rn";
        fans = fdi.findByModelName(name);
        assertNotNull(fans);
        assertEquals(0, fans.size());

        name = "150 M";
        fans = fdi.findByModelName(name);
        assertNotNull(fans);
        assertEquals(1, fans.size());
    }

    @Test
    public void testFindByProducerName(){
        FanDaoImpl fdi = new FanDaoImpl("testdb");
        //exception scenario 1
        String producer = "xxxxxxxxxx";
        List<Fan> fans = fdi.findByProducer(producer);
        assertNotNull(fans);
        assertEquals(0, fans.size());

        //exception scenario 2
        producer = "rn";
        fans = fdi.findByProducer(producer);
        assertNotNull(fans);
        assertEquals(0, fans.size());

        producer = "Vents";
        fans = fdi.findByProducer(producer);
        assertNotNull(fans);
        assertEquals(5, fans.size());
    }

    @Test
    public void testDelete(){
        FanDaoImpl fdi = new FanDaoImpl("testdb");
        Fan fan = fdi.findById(2);
        fdi.delete(fan);
        assertEquals(4, fdi.findAll().size()); // test all row in the table
        assertNull(fdi.findById(fan.getId()));
    }

    @Test
    public void testDeleteById(){
        FanDaoImpl fdi = new FanDaoImpl("testdb");

        fdi.deleteById(1);
        assertEquals(4, fdi.findAll().size()); // test all row in the table

        //test the new deleted row
        Fan deletedFan = fdi.findById(1);
        assertNull(deletedFan);
    }

    @Test
    public void testCreate(){
            FanDaoImpl fdi = new FanDaoImpl("testdb");
            Fan fan = new Fan(6,"Test fan", "Test producer", 120, 0.1, 0.1,
                    10, 110, "Moscow", "Axial wall- and ceiling-mounted fans");
            fdi.create(fan);
            assertNotNull(fdi.findById(fan.getId()));
            assertTrue(5 < (fan.getId())); // test correct id
            assertEquals(6, fdi.findAll().size()); // test all row in the table

            //test the new inserted row
            Fan foundFan = fdi.findById(fan.getId());
            assertEquals(fan.getModelName(), foundFan.getModelName());
            assertEquals(fan.getProducerName(), foundFan.getProducerName());
            assertEquals(fan.getQuantity(), foundFan.getQuantity());
    }

    @Test
    public void testUpdate(){
        FanDaoImpl fdi = new FanDaoImpl("testdb");
        Fan fan = fdi.findById(2);
        fdi.create(fan);
        String newModelName = "newModelName";
        String newProducer = "newProducer";
        int newQuantity = 100;
        double newVolume = 10.5223;
        double newWeight = 99.8889;
        int newInOrder = 5;
        String newLocation = "Saints Petersburg";
        String newDescription = "Test description";

        fan.setModelName(newModelName);
        fan.setProducerName(newProducer);
        fan.setQuantity(newQuantity);
        fan.setVolume(newVolume);
        fan.setWeight(newWeight);
        fan.setInOrder(newInOrder);
        fan.setLocation(newLocation);
        fan.setDescription(newDescription);
        fdi.update(fan);

        //test the new updated row
        Fan updatedFan = fdi.findById(fan.getId());
        assertEquals(newModelName, updatedFan.getModelName());
        assertEquals(newProducer, updatedFan.getProducerName());
        assertEquals(newQuantity, updatedFan.getQuantity());
        assertEquals(newVolume, updatedFan.getVolume());
        assertEquals(newWeight, updatedFan.getWeight());
        assertEquals(newInOrder, updatedFan.getInOrder());
        assertEquals(newQuantity-newInOrder, updatedFan.getFreeStock());
        assertEquals(newLocation, updatedFan.getLocation());
        assertEquals(newDescription, updatedFan.getDescription());



    }

     @AfterEach
     void afterEach(){
         testDBService.truncateTestTable();
     }

     @AfterAll
     void afterAll(){
         testDBService.deleteTestTable();
     }
}
