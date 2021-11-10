package com.example.demo.services;

import com.example.demo.models.Item;
import com.example.demo.models.Order;
import com.example.demo.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class PriceService {

    @Autowired
    ItemRepository itemRepository;
    public Map<String, String> calculatePrice(List<Order> orderList){
        Map<Integer, Integer> orderItemIds = new HashMap<>();
        AtomicInteger itemsQuantity = new AtomicInteger();
        orderList.stream().forEach(o->{
            orderItemIds.put(o.getItemId(),o.getQuantity());
            itemsQuantity.addAndGet(o.getQuantity());
        });
        List<Item> items = itemRepository.findAll().stream().filter(item -> orderItemIds.keySet().contains(new Integer(Math.toIntExact(item.getId())))).collect(Collectors.toList());
        AtomicReference<Float> totalPrice= new AtomicReference<>(0.0f);
        items.stream().forEach(item -> {
            totalPrice.set(totalPrice.get() + item.getPrice() * orderItemIds.get(new Integer(Math.toIntExact(item.getId()))));
        });
        if(itemsQuantity.get()>=4){
            totalPrice.set(totalPrice.get()*0.8f);
        }
        return new HashMap<String, String>(){{put("totalAmount",totalPrice.get().toString());}};
    }
}
