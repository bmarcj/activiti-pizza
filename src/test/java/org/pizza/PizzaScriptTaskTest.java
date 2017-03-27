package org.pizza;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pizza.service.MyApp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * An example test for the pizza service.
 *
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MyApp.class})
@IntegrationTest
public class PizzaScriptTaskTest {

    Logger LOGGER = LoggerFactory.getLogger(PizzaScriptTaskTest.class);

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Test
    public void submitPizzaOrderNotValid() {
        Map<String, Object> variableMap = new HashMap<>();
        variableMap.put("amount", 9);
        ProcessInstance processInstance1 = runtimeService.startProcessInstanceByKey("simplePizza", variableMap);
        assertNotNull(processInstance1.getId());
        List<Task> tasks = taskService.createTaskQuery().executionId(processInstance1.getId()).list();
        assertEquals("Should be 1 task", tasks.size(), 1);

        variableMap.put("amount", 10);
        ProcessInstance processInstance2 = runtimeService.startProcessInstanceByKey("simplePizza", variableMap);
        tasks = taskService.createTaskQuery().executionId(processInstance2.getId()).list();
        assertEquals("Should be no tasks", tasks.size(), 0);
    }
}


