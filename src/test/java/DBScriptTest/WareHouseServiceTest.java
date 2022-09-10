package DBScriptTest;


import model.Fan;
import org.junit.jupiter.api.*;
import service.WarehouseServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WarehouseServiceTest {
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
        WarehouseServiceImpl wsi = new WarehouseServiceImpl("testdb");
        List<Fan> fans = wsi.findAll();
        assertNotNull(fans);
        assertEquals(5, fans.size());
        fans.forEach(System.out::println);
    }

    @Test
    public void testFindById(){
        WarehouseServiceImpl wsi = new WarehouseServiceImpl("testdb");
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
        WarehouseServiceImpl wsi = new WarehouseServiceImpl("testdb");
        //exception scenario 1
        String name = "xxxxxxxxxx";
        List<Fan> fans = wsi.findByModelName(name);
        assertNotNull(fans);
        assertEquals(0, fans.size());

        //exception scenario 2
        name = "rn";
        fans = wsi.findByModelName(name);
        assertNotNull(fans);
        assertEquals(0, fans.size());

        name = "150 M";
        fans = wsi.findByModelName(name);
        assertNotNull(fans);
        assertEquals(1, fans.size());
    }

    @Test
    public void testFindByProducerName(){
        WarehouseServiceImpl wsi = new WarehouseServiceImpl("testdb");
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
        WarehouseServiceImpl wsi = new WarehouseServiceImpl("testdb");
        Fan fan = wsi.findById(2);
        wsi.delete(fan);
        assertEquals(4, wsi.findAll().size()); // test all row in the table
        assertNull(wsi.findById(fan.getId()));
    }

    @Test
    public void testDeleteById(){
        WarehouseServiceImpl wsi = new WarehouseServiceImpl("testdb");

        wsi.deleteById(1);
        assertEquals(4, wsi.findAll().size()); // test all row in the table

        //test the new deleted row
        Fan deletedFan = wsi.findById(1);
        assertNull(deletedFan);
    }

    @Test
    public void testCreate(){
        WarehouseServiceImpl wsi = new WarehouseServiceImpl("testdb");

        //test create row
        Fan fan = new Fan(6,"Test fan", "Test producer", 120, 0.1, 0.1,
                10, 110, "Moscow", "Axial wall- and ceiling-mounted fans");
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
        Fan existingFan = new Fan("100 VKO", "Test producer", 120, 0.1, 0.1,
                10,  "Samara", "Axial wall- and ceiling-mounted fans");
        wsi.create(existingFan);
        List<Fan> fansSameNames = wsi.findByModelName(existingFan.getModelName());
        assertEquals(6, wsi.findAll().size());
        assertEquals(1, fansSameNames.size());
        assertEquals("Samara", fansSameNames.get(0).getLocation());
        assertNotEquals(existingFan.getQuantity(), fansSameNames.get(0).getQuantity());

        //test new inserted row with model name existing in table but second location
        Fan fanMoscow = new Fan("125 M3", "Test producer", 20, 0.1, 0.1,
                0,  "Moscow", "Axial wall- and ceiling-mounted fans");
        wsi.create(fanMoscow);
        List<Fan> fansSameNamesVariousLocations = wsi.findByModelName(fanMoscow.getModelName());
        assertEquals(7, wsi.findAll().size());
        assertEquals(2, fansSameNamesVariousLocations.size());
        assertNotEquals(fansSameNamesVariousLocations.get(0).getLocation(), fansSameNamesVariousLocations.get(1).getLocation());

        //test inserted row with model name existing in table but third location
        Fan fanKazan = new Fan("125 M3", "Test producer", 20, 0.1, 0.1,
                0,  "Kazan", "123");
        wsi.create(fanKazan);
        assertEquals(8, wsi.findAll().size());
        assertEquals(3, wsi.findByModelName(fanKazan.getModelName()).size());

        //test inserted row with model name existing in table when exist three location
        Fan fanSamara = new Fan("125 M3", "Test producer", 20, 0.1, 0.1,
                0,  "Samara","123");
        wsi.create(fanSamara);
        assertEquals(8, wsi.findAll().size());
        assertEquals(3, wsi.findByModelName(fanSamara.getModelName()).size());
    }

    @Test
    public void testUpdate(){
        WarehouseServiceImpl wsi = new WarehouseServiceImpl("testdb");
        Fan fan = wsi.findById(2);
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
