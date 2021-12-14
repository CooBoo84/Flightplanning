package se.iths.flightplanning;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import se.iths.flightplanning.entity.UserEntity;


@Component
public class UserMsgReceiver {
    @JmsListener(destination = "user")
    public void reviewUserMessage(UserEntity userEntity) {

        System.out.println("Received and created userEntity: " + userEntity);
        System.out.println("Name: " + userEntity.getFirstName() + " " + userEntity.getLastName());
        System.out.println("Email: " + userEntity.getEmail());
        System.out.println("Phone number: " + userEntity.getTelephone());

    }
}
