package com.finaltest.itemservice.service;

import com.finaltest.itemservice.dto.ItemDto;
import com.finaltest.itemservice.model.ItemModel;

import java.util.List;

public interface _ItemService {

    List<ItemModel> get();
    ItemModel getById(int id);
    ItemDto getByWhat(String value, String method);
    ItemModel AddItems(String name, int Price);
}
