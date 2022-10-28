package ServiceTests;

import dao.FanDaoImpl;
import model.Fan;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.StockManagerServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class MockitoServiceTest {
    private Fan fan;
    private Fan fan2;

    @Mock
    FanDaoImpl fdi;
    @InjectMocks
    StockManagerServiceImpl wsi;

    @BeforeAll
    void before(){
         fan = new Fan(1,"Test fan", "Test producer", 120, 0.1, 0.1,
                10, 110, "Axial wall- and ceiling-mounted fans");
         fan2 = new Fan(2,"New test fan", "Test producer", 220, 1.0, 1.0,
                0, 220,  "Test description");

    }

    @Test
    void testFindAllMockShouldReturnTrue(){
        given(fdi.findAll()).willReturn(List.of(fan, fan2));
        List<Fan> fans = wsi.findAll();
        assertEquals(2, fans.size());
        assertEquals(fans.get(0).getModelName(), fan.getModelName());
        assertEquals(fans.get(1).getProducerName(), fan2.getProducerName());
        verify(fdi, times(1)).findAll();
    }

    @Test
    void testFindAllMockShouldReturnFalse(){
        given(fdi.findAll()).willReturn(new ArrayList<>());
        List<Fan> fans = wsi.findAll();
        assertNotNull(fans);
        assertEquals(0, fans.size());
        verify(fdi, times(1)).findAll();
    }

    @Test
    void testFindByIdMocksShouldReturnNotNull(){
        given(fdi.findById(fan.getId())).willReturn(fan);
        Fan foundFan = wsi.findById(fan.getId());
        assertNotNull(foundFan);
        verify(fdi, times(1)).findById(fan.getId());

    }

    @Test
    void testFindByIdMocksShouldReturnNull(){
        given(fdi.findById(5)).willReturn(null);
        Fan foundFan = wsi.findById(5);
        assertNull(foundFan);
        verify(fdi, times(1)).findById(anyInt());

    }

    @Test
    void testFindByModelNameShouldReturnTrue(){
        given(fdi.findByModelName(fan.getModelName())).willReturn(fan);
        Fan foundFan = wsi.findByModelName("Test fan");
        assertNotNull(foundFan);
        assertEquals("Test fan", foundFan.getModelName());
        verify(fdi, times(1)).findByModelName("Test fan");
    }

    @Test
    void testFindByModelNameShouldReturnFalse(){
        when(fdi.findByModelName(anyString())).thenReturn(null);
        Fan notFoundFan = wsi.findByModelName("NotExistName");
        assertNull(notFoundFan);
        verify(fdi, times(1)).findByModelName("NotExistName");
    }

    @Test
     void testFindByProducerNameShouldReturnTrue(){
        String producer = "Test producer";
        given(fdi.findByProducer(producer)).willReturn(List.of(fan, fan2));
        List<Fan> fans = wsi.findByProducer(producer);
        assertNotNull(fans);
        assertEquals(2, fans.size());
        verify(fdi, times(1)).findByProducer(anyString());
    }



    @Test
     void testFindByProducerNameShouldReturnFalse(){
        String producer = "Not exist producer";
        given(fdi.findByProducer(producer)).willReturn(List.of());
        List<Fan> fans = wsi.findByProducer(producer);
        assertNotNull(fans);
        assertEquals(0, fans.size());
        verify(fdi, times(1)).findByProducer(anyString());
    }

    @Test
    void testDeleteById(){
        List<Fan> fans = new ArrayList<>(List.of(fan, fan2));
        given(fdi.findAll()).willReturn(fans);
        when(fdi.deleteById(fan.getId())).thenReturn(fans.remove(fan));
        boolean isFanDeleted = wsi.deleteById(fan.getId());
        assertTrue(isFanDeleted);
        assertEquals(1, wsi.findAll().size());
        verify(fdi, times(1)).deleteById(fan.getId());
    }

    @Test
    void testDelete(){
        List<Fan> fans = new ArrayList<>(List.of(fan, fan2));
        given(fdi.findAll()).willReturn(fans);
        when(fdi.delete(fan)).thenReturn(fans.remove(fan));
        boolean isFanDeleted = wsi.delete(fan);
        assertTrue(isFanDeleted);
        assertEquals(1, wsi.findAll().size());
        verify(fdi, times(1)).delete(fan);
    }

    @Test
    void testCreateShouldReturnTrue(){
        when(fdi.create(fan)).thenReturn(true);
        boolean isFanCreated = wsi.create(fan);
        assertTrue(isFanCreated);
        verify(fdi, times(1)).findByModelName(fan.getModelName());
        verify(fdi, times(1)).create(fan);
    }


    @Test
    void testCreateSameNameShouldReturnFalse(){
        given(fdi.findByModelName(fan2.getModelName())).willReturn(fan);
        boolean isFanCreated = wsi.create(fan2);
        assertFalse(isFanCreated);
        verify(fdi, times(1)).findByModelName(fan2.getModelName());
        verify(fdi, times(0)).create(fan);
    }

    @Test
    void testUpdateShouldReturnTrue(){
        when(fdi.update(any(Fan.class))).thenReturn(true);
        boolean isUpdated = wsi.update(fan);
        assertTrue(isUpdated);
        verify(fdi, times(1)).update(fan);
    }
    }