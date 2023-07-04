package com.example.graphQL.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Test{
    private String name;
}

@Controller
public class TestController {
    @QueryMapping
    public List<Test> TestQuery(){
        return List.of(new Test("Hello"));
    }

    @SchemaMapping(typeName = "Mutation", field = "AddTest")
    public Test AddTest(@Argument String name){
        return new Test(name);
    }

    @SchemaMapping(typeName = "Mutation", field = "EditTest")
    public Test EditTest(@Argument String name){
        Test test = new Test("Hello there");
        test.setName(name);
        return test;
    }

    @SchemaMapping(typeName = "Mutation", field = "DeleteTest")
    public List<Test> DeleteTest(@Argument String name){
        List<Test> tests = new ArrayList<>();
        tests.add(new Test("hello world"));
        tests.add(new Test("hi there"));
        Optional<Test> testOpt = tests.stream().filter(i -> i.getName().equals(name)).findFirst();
        testOpt.ifPresent(tests::remove);
        return tests;
    }
}
