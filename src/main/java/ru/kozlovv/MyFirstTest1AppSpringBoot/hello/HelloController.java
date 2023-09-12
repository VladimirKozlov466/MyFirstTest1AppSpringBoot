package ru.kozlovv.MyFirstTest1AppSpringBoot.hello;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    private List<String> dataArrayList;
    private Map<String, String> dataHashMap;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public void updateArrayList (@RequestParam(value = "word", defaultValue = "") String word) {
        if (dataArrayList == null && word.equals("")) {
            dataArrayList = new ArrayList<>();
        } else {
            if (dataArrayList != null) {
                dataArrayList.add(word);
            }
        }
    }


    @GetMapping("/show-array")
    public String showArrayList(){
        if(dataArrayList != null) {
            return String.format(dataArrayList.toString());
        } else {
            return "Список не создан";
        }
    }


    @GetMapping("/update-map")
    public void updateHashMap (@RequestParam(value = "data", defaultValue = "") String data) {
        if (dataHashMap == null && data.equals("")) {
            dataHashMap = new HashMap<>();
        } else {
            if (dataHashMap != null) {
                dataHashMap.put(data + "KEY", data + "Value");
            }
        }
    }


    @GetMapping("/show-map")
    public String showHashMap() {
        if(dataHashMap != null) {
            return String.format(dataHashMap.toString());
        } else {
            return "Таблица не создана";
        }
    }

    @GetMapping("/show-all-length")
    public String showAllLength() {
        String arrLength;
        String mapLength;

        if(dataArrayList != null) {
            arrLength = Integer.toString(dataArrayList.size());
        } else {
            arrLength = "Список не создан";
        }

        if (dataHashMap != null) {
            mapLength = Integer.toString(dataHashMap.size());
        } else {
            mapLength = "Таблица не создана";
        }
        return "Количество элментов ArrayList: " + arrLength + "   " +
                "Количество элементов HashTable: " + mapLength;
    }
}
