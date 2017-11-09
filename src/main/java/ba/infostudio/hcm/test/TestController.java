package ba.infostudio.hcm.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/test")
@CrossOrigin("*")
public class TestController {
    @Autowired
    private TestInterface testInterface;

    @GetMapping("/get")
    public Iterable<TestModel> getAll(){
        return this.testInterface.findAll();
    }

    @PostMapping("/post")
    public TestModel addTest(@RequestBody TestModel testModel) {
        return this.testInterface.save(testModel);
    }

}
