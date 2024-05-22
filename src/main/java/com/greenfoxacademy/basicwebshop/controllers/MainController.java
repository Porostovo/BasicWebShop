package com.greenfoxacademy.basicwebshop.controllers;

import com.greenfoxacademy.basicwebshop.items.Item;
import com.greenfoxacademy.basicwebshop.warehouse.Warehouse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {
    private final Warehouse warehouse = new Warehouse();

    @GetMapping("/webshop")
    public String showMainPage(Model model) {
        List<Item> items = warehouse.getWarehouse();
        model.addAttribute("items", items);
        return "webshop";
    }

    @GetMapping("/onlyAvailable")
    public String showOnlyAvailable(Model model) {
        List<Item> items = warehouse.getWarehouse();

        items = items.stream()
                .filter(c -> c.getQuantity() > 0)
                .collect(Collectors.toList());

        model.addAttribute("items", items);
        return "webshop";
    }

    @GetMapping("/cheapestFirst")
    public String showcheapestFirst(Model model) {
        List<Item> items = warehouse.getWarehouse();

        items =  items.stream()
                .sorted(Comparator.comparingDouble(Item::getPrice))
                .collect(Collectors.toList());

        model.addAttribute("items", items);
        return "webshop";
    }

    @GetMapping("/containsNike")
    public String showcontainsNike(Model model) {
        List<Item> items = warehouse.getWarehouse();

        items = items.stream()
                .filter(x -> x.getDescription().toLowerCase().contains("nike") || x.getName().toLowerCase().contains("nike"))
                .collect(Collectors.toList());

        model.addAttribute("items", items);
        return "webshop";
    }

    @GetMapping("/averageStock")
    public String showAverageStock(Model model) {
        List<Item> items = warehouse.getWarehouse();
        double average = items.stream().collect(Collectors.averagingDouble(Item::getQuantity));
        model.addAttribute("average", average);
        model.addAttribute("text", "Average stock: ");
        model.addAttribute("name", "");
        return "averageStock";
    }

    @GetMapping("/mostExpensiveAvailable")
    public String showMostExpensiveAvailable(Model model) {
         List<Item> items = warehouse.getWarehouse();

        Item maxItem = items.stream()
                .max(Comparator.comparing(Item::getPrice))
                .orElse(null);

        assert maxItem != null;
        model.addAttribute("name", maxItem.getName());
        model.addAttribute("text", " Most expensive item: ");
        return "averageStock";
    }

    @PostMapping("/webshop")
    public String postSearch(@RequestParam String searchBar, Model model){
        List<Item> items = warehouse.getWarehouse();
        items = items.stream()
                .filter(x -> x.getDescription().toLowerCase().contains(searchBar.toLowerCase()) ||
                        x.getName().toLowerCase().contains(searchBar.toLowerCase()))
                .collect(Collectors.toList());

        model.addAttribute("items", items);
        return "webshop";
    }

    @GetMapping("/filterByType")
    public String showMainPage1(Model model) {
        List<Item> items = warehouse.getWarehouse();
        model.addAttribute("items", items);
        return "webshop";
    }
    @GetMapping("/pricesInEuro")
    public String showMainPage2(Model model) {
        List<Item> items = warehouse.getWarehouse();
        model.addAttribute("items", items);
        return "webshop";
    }
    @GetMapping("/pricesInCrown")
    public String showMainPage3(Model model) {
        List<Item> items = warehouse.getWarehouse();
        model.addAttribute("items", items);
        return "webshop";
    }
}
