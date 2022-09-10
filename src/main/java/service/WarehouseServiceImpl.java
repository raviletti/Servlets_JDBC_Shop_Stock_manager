package service;

import dao.FanDaoImpl;
import model.Fan;

import java.sql.SQLException;
import java.util.List;

public class WarehouseServiceImpl implements WarehouseServise<Integer, String, Fan> {
    
    FanDaoImpl fdi = new FanDaoImpl("database");

    @Override
    public List<Fan> findAll() {
        return fdi.findAll();
    }

    @Override
    public Fan findById(Integer id) {
        return fdi.findById(id);
    }

    @Override
    public List<Fan> findByModelName(String name) {
        return fdi.findByModelName(name);
    }

    @Override
    public List<Fan> findByProducer(String producer) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return fdi.deleteById(id);

    }

    @Override
    public boolean delete(Fan entity) {
        return fdi.delete(entity);
    }

    @Override
    public boolean create(Fan entity) throws SQLException {
        List<Fan> fanList = fdi.findByModelName(entity.getModelName());
        boolean createResult = false;
        switch (fanList.size()){
            case 0 :
                createResult = fdi.create(entity);
            case 1 :
                fanList.get(0).setQuantity(fanList.get(0).getQuantity() + entity.getQuantity());
                  fdi.update(fanList.get(0));
            case 2 :
                for(Fan fan : fanList){
                   if (fan.getLocation().equals(entity.getLocation())) {
                       fan.setQuantity(fan.getQuantity() + entity.getQuantity());
                       fdi.update(fan);
                   }
                   //to refactor with streams
                }
        }

        return createResult;
    }

    @Override
    public Fan update(Fan entity) {

         return fdi.update(entity);
    }
}
