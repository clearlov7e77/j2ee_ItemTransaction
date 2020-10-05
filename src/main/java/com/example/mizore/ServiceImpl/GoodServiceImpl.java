package com.example.mizore.ServiceImpl;

import com.example.mizore.Bean.Good;
import com.example.mizore.Dao.GoodMapper;
import com.example.mizore.Service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    GoodMapper goodMapper;


    @Override
    public int insertGood(Good good) {
        if(goodMapper.getGood(good.getName())==null){
            goodMapper.insertGood(good);
            return 1;
        }
        else return -1;
    }

    @Override
    public int deleteGood(String  name) {
        if(goodMapper.getGood(name)==null){
            return -1;
        }
        else{
            int id=goodMapper.getGood(name).getId();
            goodMapper.deleteGood(id);
            return 1;
        }
    }

    @Override
    public Good findGood(String name) {
        return goodMapper.getGood(name);
    }

    @Override
    public Good findGood(int id){return goodMapper.getGoodbyid(id);}

    @Override
    public int updateGood(String name, int price) {
        if(goodMapper.getGood(name)==null){
            return -1;
        }
        else{
            int id=goodMapper.getGood(name).getId();
            goodMapper.updatePrice(id,price);
            return 1;
        }
    }
    @Override
    public List<Good> getgoodbytype(String type){
        return goodMapper.getGoodbyType(type);
    }

    @Override
    public List<Good> getallgood(){
        return goodMapper.getallGood();
    }

    @Override
    public List<Good> getgoodbyname(String name){
            return goodMapper.getGoodbyName(name);
    }
}
