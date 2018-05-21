package com.pracitce.person.spring;

import com.pracitce.person.db.entity.Person;
import com.pracitce.person.db.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class Controller {

    @Autowired
    private PersonRepository repository;

    @RequestMapping("/save")
    public String process() {
        repository.save(new Person("John", 34, "064123456", "john@mail.com"));
        return "Done";
    }

    @RequestMapping("/savemore")
    public String processMore() {

        repository.saveAll(Arrays.asList(
                new Person("Adam", 32, "065123456", "adam@mail.com"),
                new Person("Kim", 56, "061123456", "kim@mail.com"),
                new Person("David", 20, "065456123", "david@mail.com"),
                new Person("Peter", 19, "062123456", "peter@mail,com")));

        return "Done";
    }

    @RequestMapping("/findall")
    public String findAll(){
        String result = "";
        for(com.pracitce.person.db.entity.Person cust : repository.findAll()){
            result += cust.toString() + "<br>";
        }
        return result;
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";
        result = repository.findById(id).toString();
        return result;
    }

    @RequestMapping("/findbyname")
    public String fetchDataByName(@RequestParam("name") String name){
        String result = "";

        for(Person cust: repository.findByName(name)){
            result += cust.toString() + "<br>";
        }
        return result;
    }


}
