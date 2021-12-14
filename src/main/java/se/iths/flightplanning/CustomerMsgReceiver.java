package se.iths.flightplanning;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import se.iths.flightplanning.entity.CustomerEntity;
import se.iths.flightplanning.entity.UserEntity;


@Component
public class CustomerMsgReceiver {
    @JmsListener(destination = "user")
    public void reviewCustomerMessage(CustomerEntity customerEntity) {

        System.out.println("Received and created customerEntity: " + customerEntity);
        System.out.println("Name: " + customerEntity.getFirstName() + " " + customerEntity.getLastName());
        System.out.println("Email: " + customerEntity.getEmail());
        System.out.println("Phone number: " + customerEntity.getTelephone());

    }
}
