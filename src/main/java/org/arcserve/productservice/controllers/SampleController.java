package org.arcserve.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/sampleMethod")
    public void sampleMethod() {
        // This is a sample method
        System.out.println("This is a sample method in SampleController");
    }

    @GetMapping("/hello")
    public String sayHello() {
        // This is a sample method
        System.out.println("Hello from SampleController");
        return "Hello from SampleController";
    }

    @GetMapping("/hi")
    public String sayHi() {
        // This is a sample method
        System.out.println("Hi from SampleController");
        return "Hi from SampleController";
    }
    @GetMapping("/hello/{name}")
    public String sayHelloToName(@PathVariable("name") String name) {
        // This is a sample method
        System.out.println("Hello " + name + " from SampleController");
        return "Hello " + name + " from SampleController";
    }

    @GetMapping("/hello/{name}/{age}")
    public String sayHelloToNameAndAge(@PathVariable("name") String name, @PathVariable("age") int age) {
        // This is a sample method
        System.out.println("Hello " + name + ", you are " + age + " years old from SampleController");
        return "Hello " + name + ", you are " + age + " years old from SampleController";
    }
}
