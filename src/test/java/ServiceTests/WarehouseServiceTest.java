package ServiceTests;

import model.Fan;
import org.junit.jupiter.api.*;
import service.WarehouseServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WarehouseServiceTest {
    WarehouseServiceImpl wsi = new WarehouseServiceImpl("testdb");
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
        List<Fan> fans = wsi.findAll();
        assertNotNull(fans);
        assertEquals(5, fans.size());
        fans.forEach(System.out::println);
    }

    @Test
    public void testFindById(){
        //exception scenario
        Fan fan = wsi.findById(100);
        assertNull(fan);

        //standard scenario
        fan = wsi.findById(2);
        assertNotNull(fan);
        //'125 M', 'Vents',  '247', '0,2', '0,2', '10'
        assertEquals("125 M", fan.getModelName());
        assertEquals("Vents", fan.getProducerName());
        assertEquals(247, fan.getQuantity());
    }

    @Test
    public void testFindByModelName(){
        //exception scenario 1
        String name = "xxxxxxxxxx";
        Fan fan = wsi.findByModelName(name);
        assertNull(fan);

        //exception scenario 2
        name = "rn";
        fan = wsi.findByModelName(name);
        assertNull(fan);

        name = "150 M";
        fan = wsi.findByModelName(name);
        assertNotNull(fan);
    }

    @Test
    public void testFindByProducerName(){
        //exception scenario 1
        String producer = "xxxxxxxxxx";
        List<Fan> fans = wsi.findByProducer(producer);
        assertNotNull(fans);
        assertEquals(0, fans.size());

        //exception scenario 2
        producer = "rn";
        fans = wsi.findByProducer(producer);
        assertNotNull(fans);
        assertEquals(0, fans.size());

        producer = "Vents";
        fans = wsi.findByProducer(producer);
        assertNotNull(fans);
        assertEquals(5, fans.size());
    }

    @Test
    public void testDelete(){
        Fan fan = wsi.findById(2);
        wsi.delete(fan);
        assertEquals(4, wsi.findAll().size()); // test all row in the table
        assertNull(wsi.findById(fan.getId()));
    }

    @Test
    public void testDeleteById(){

        wsi.deleteById(1);
        assertEquals(4, wsi.findAll().size()); // test all row in the table

        //test the new deleted row
        Fan deletedFan = wsi.findById(1);
        assertNull(deletedFan);
    }

    @Test
    public void testCreate(){

        //test create row
        Fan fan = new Fan(6,"Test fan", "Test producer", 999, 0.9, 0.9,
                990, 9,  "Axial wall- and ceiling-mounted fans");
        wsi.create(fan);
        assertNotNull(wsi.findById(fan.getId()));
        assertTrue(5 < (fan.getId()));
        assertEquals(6, wsi.findAll().size());

        //test the new inserted row
        Fan foundFan = wsi.findById(fan.getId());
        assertEquals(fan.getModelName(), foundFan.getModelName());
        assertEquals(fan.getProducerName(), foundFan.getProducerName());
        assertEquals(fan.getQuantity(), foundFan.getQuantity());

        //test new inserted row with model name existing in table
        Fan existingFan = new Fan("100 VKO", "New producer", 200, 0.5, 0.5,
                20, "New axial wall- and ceiling-mounted fans");
        boolean isAdded = wsi.create(existingFan);
        assertFalse(isAdded);
        assertNotEquals(wsi.findByModelName("100 VKO"), existingFan);
        assertEquals(6, wsi.findAll().size());
    }

    @Test
    public void testUpdate(){
        Fan fan = wsi.findById(2);
        String newModelName = "newModelName";
        String newProducer = "newProducer";
        int newQuantity = 100;
        double newVolume = 10.5223;
        double newWeight = 99.8889;
        int newInOrder = 5;
        String newDescription = "Test description";

        fan.setModelName(newModelName);
        fan.setProducerName(newProducer);
        fan.setQuantity(newQuantity);
        fan.setVolume(newVolume);
        fan.setWeight(newWeight);
        fan.setInOrder(newInOrder);
        fan.setDescription(newDescription);
        wsi.update(fan);

        //test the new updated row
        Fan updatedFan = wsi.findById(fan.getId());
        assertEquals(newModelName, updatedFan.getModelName());
        assertEquals(newProducer, updatedFan.getProducerName());
        assertEquals(newQuantity, updatedFan.getQuantity());
        assertEquals(newVolume, updatedFan.getVolume());
        assertEquals(newWeight, updatedFan.getWeight());
        assertEquals(newInOrder, updatedFan.getInOrder());
        assertEquals(newQuantity-newInOrder, updatedFan.getFreeStock());
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
