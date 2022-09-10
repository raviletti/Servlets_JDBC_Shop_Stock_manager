package service;

import dao.FanDaoImpl;
import model.Fan;

import java.util.List;

public class WarehouseServiceImpl implements WarehouseServise<Integer, String, Fan> {
    private FanDaoImpl fdi = new FanDaoImpl("database");

    public WarehouseServiceImpl() {
    }

    public WarehouseServiceImpl(String properties) {
        this.fdi = new FanDaoImpl(properties);
    }

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
    public boolean create(Fan entity) {
        boolean isCreated = false;
        List<Fan> fanList = fdi.findByModelName(entity.getModelName());

        switch (fanList.size()){
            case 0 :
                fdi.create(entity);
                isCreated = true;
                break;
            case 1 :
                Fan foundFan = fanList.get(0);
               if(entity.getLocation().equals(foundFan.getLocation())){
                   foundFan.setQuantity(foundFan.getQuantity() + entity.getQuantity());
                   fdi.update(foundFan);
                   isCreated = true;
                   break;
               }
               else fdi.create(entity);

               break;
            default:
                for(Fan fan : fanList){
                if(entity.getLocation().equals(fan.getLocation())){
                    fan.setQuantity(fan.getQuantity() + entity.getQuantity());
                    fdi.update(fan);
                    isCreated = true;
                }
            }
                if(!isCreated){
                    fdi.create(entity);
                    break;
                }
        }
        return isCreated;
    }

    @Override
    public Fan update(Fan entity) {

         return fdi.update(entity);
    }

    public FanDaoImpl getFdi() {
        return fdi;
    }

    public void setFdi(FanDaoImpl fdi) {
        this.fdi = fdi;
    }
}
