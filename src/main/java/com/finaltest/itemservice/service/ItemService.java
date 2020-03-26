package com.finaltest.itemservice.service;

import com.finaltest.itemservice.ItemRepo._ItemRepo;
import com.finaltest.itemservice.dto.ItemDto;
import com.finaltest.itemservice.model.ItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ItemService implements _ItemService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    _ItemRepo ItemRepo;

    @Override
    public List<ItemModel> get() {
        List<ItemModel> data = new ArrayList<>();
        ItemRepo.findAll().iterator().forEachRemaining(data::add);
        return data;
    }

    @Override
    public ItemModel getById(int id) {
        return ItemRepo.findById(id).get();
    }

    @Override
    public ItemDto getByWhat(String value, String method) {
        Query query = null;
        if (method.equals("name")) {
            query = entityManager.createQuery("FROM ItemModel WHERE name = :value").setParameter("value", value);
        }
        else if (method.equals("price")) {
            query = entityManager.createQuery("FROM ItemModel WHERE Price = :value").setParameter("value", Integer.parseInt(value));

        } else { return null; }

        List<ItemModel> res = query.getResultList();
        if (res.size() > 0) {
            ItemModel iM = res.get(0);
            ItemDto data = new ItemDto();
            data.setNameItem(iM.getNameItem());
            data.setPrice(iM.getPrice());
            return data;

        } else { return null; }
    }

    @Override
    public ItemModel AddItems(String name, int Price) {
        ItemModel data = new ItemModel();
        data.setNameItem(name);
        data.setPrice(Price);
        ItemRepo.save(data);
        return data;
    }
}
