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
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.List;
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

    Logger LOGGER = LoggerFactory.getLogger(PizzaScriptTaskTest.class);

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Test
    public void submitPizzaOrderNotValid() {
        Map<String, Object> variableMap = new HashMap<>();
        variableMap.put("amount", 9);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("simplePizza", variableMap);
        assertNotNull(processInstance.getId());
        List<Task> tasks = taskService.createTaskQuery().executionId(processInstance.getId()).list();
        for (Task task : tasks) {
            LOGGER.info("Task {}", task);
        }
    }
}


