package org.pizza.service.orderValidation;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.runtime.Execution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Service for validating orders of pizzas.
 */
@Component("orderValidationService")
public class OrderValidationService {

    Logger LOGGER = LoggerFactory.getLogger(OrderValidationService.class);

    public void validatePizzaCount(int amount, DelegateExecution execution){

        Boolean pizzaOrderToOven = amount < 10;
        execution.setVariable("pizzaOrderToOven", pizzaOrderToOven);
        LOGGER.info("Pizza numbers: {}", amount);
    }

}
