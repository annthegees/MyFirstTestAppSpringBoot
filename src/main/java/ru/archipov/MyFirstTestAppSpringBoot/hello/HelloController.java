package ru.archipov.MyFirstTestAppSpringBoot.hello;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    private final List<String> list = new ArrayList<>();
    private final Map<Integer, String> hashMap = new HashMap<>();

    private int counter = 0;

    @GetMapping("/hello")
    public String hello(@RequestParam(value ="name", defaultValue = "World") String name)
    {
        return  String.format("Hello %s!", name);
    }
    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value ="s", defaultValue = " ") String s)
    {
        list.add(s);
        return (s);
    }
    @GetMapping("/show-array")
    public String showArrayList() {
        return "Список: " + list;
    }
    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value ="s", defaultValue = " ") String s) {
        hashMap.put(counter++, s);
        return (s);
    }

    @GetMapping("/show-map")
    public String showHashMap() {
        return "Map: " + hashMap;
    }


    @GetMapping("/show-all-lenght")
    public String showAllLength() {
        return "В списке: " + list.size() + "в map: " + hashMap.size();
    }
}
