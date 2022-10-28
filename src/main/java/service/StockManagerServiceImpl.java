package service;

import dao.FanDaoImpl;
import model.Fan;

import java.util.List;

public class StockManagerServiceImpl implements StockManagerService<Integer, String, Fan> {
    private FanDaoImpl fdi;

    public StockManagerServiceImpl(String properties) {
        this.fdi = new FanDaoImpl(properties);
    }

    public StockManagerServiceImpl(FanDaoImpl fdi){
        this.fdi = fdi;
    }

    public StockManagerServiceImpl(){
    this.fdi = new FanDaoImpl("database");
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
    public Fan findByModelName(String name) {
        return fdi.findByModelName(name);
    }

    @Override
    public List<Fan> findByProducer(String producer) {
        return fdi.findByProducer(producer);
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
        Fan fanFromDB = fdi.findByModelName(entity.getModelName());
        if(fanFromDB != null){
            return false;
       }
        return fdi.create(entity);
    }


    @Override
    public boolean update(Fan entity) {

         return fdi.update(entity);
    }

}
