package com.springbootapplication.h2demo;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {
    @Autowired
    private ItemRepo itemRepo;
    @GetMapping("/{item_number}")
    public Item getItem(@PathVariable String item_number){
        Item item = itemRepo.findById(item_number).orElse(null);
        return item;
    }

    @GetMapping("/")
    @ApiOperation( value = "List of the inventory",
            notes = "Find all the items in the inventory", response = Item.class)
    public List<Item> getAllItems(){
        List<Item> items = new ArrayList<>();
        itemRepo.findAll().forEach(items::add);
        return items;
    }

    @PostMapping("/")
    public Item addItem(@RequestBody Item item){
        itemRepo.save(item);
        return item;
    }

    @PostMapping("/{item_number}")
    public Item delete_item(@RequestBody String item_number){
        Item item = itemRepo.findById(item_number).orElse(null);
        itemRepo.deleteById(item_number);
        return item;
    }

    @PutMapping("/items/{item_number}/w/{amount}")
    @ApiOperation( value = "Withdrawal quantity of a specific item from stock",
            notes = "Make a withdrawal of the item assuming that quantity exists in the inventory and return it with the new quantity", response = Item.class)
    public Item withdrawalItem(@PathVariable String item_number, @PathVariable Integer amount) {
        Item item = itemRepo.findById(item_number).orElse(null);
        Integer current_amount = item.getAmount() ;
        int new_amount = current_amount - amount;
        if(new_amount < 1)
        {
            System.out.println("the new quantity is negative " +new_amount
                    +" and therefore you can NOT make this item withdrawal");
            return item;
        }
        item.setAmount(new_amount);
        itemRepo.save(item);
        return item;
    }

    @PutMapping("/items/{item_number}/d/{amount}")
    @ApiOperation( value = "Deposit quantity of a specific item to stock",
            notes = "Make a deposit of an item and return it with the new quantity", response = Item.class)
    public Item depositItem(@PathVariable String item_number, @PathVariable Integer amount) {
        Item item = itemRepo.findById(item_number).orElse(null);
        Integer current_amount = item.getAmount() ;
        int new_amount = current_amount + amount;
        item.setAmount(new_amount);
        itemRepo.save(item);
        return item;
    }


}
