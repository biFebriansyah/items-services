package com.finaltest.itemservice.ItemRepo;

import com.finaltest.itemservice.model.ItemModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface _ItemRepo extends CrudRepository<ItemModel, Integer> {
}
