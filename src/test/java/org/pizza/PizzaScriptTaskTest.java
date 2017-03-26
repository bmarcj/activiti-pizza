package org.pizza;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pizza.service.MyApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;


/**
 * An example test for the pizza service.
 *
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MyApp.class})
@IntegrationTest
public class PizzaScriptTaskTest {

    @Autowired
    private RuntimeService runtimeService;

    @Test
    public void submitPizzaOrderNotValid() {
        Map<String, Object> variableMap = new HashMap<>();
        variableMap.put("amount", 11);
        ProcessInstance processInstance  = runtimeService.startProcessInstanceByKey("simplePizza", variableMap);
        assertNotNull(processInstance.getId());
    }
}


