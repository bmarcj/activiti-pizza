package org.pizza.service.orderValidation;

import org.springframework.stereotype.Component;

/**
 * Service for validating orders of pizzas.
 */
@Component
public class OrderValidationService {

    public void validatePizzaCount(){
        System.out.println("Validating the pizza count in the order.");
    }

}
