package com.example.javastartspringdatarelacjaonetomanymanytoone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OneToManyApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OneToManyApplication.class, args);
		ClientRepository clientRepository = context.getBean(ClientRepository.class);
		ClientOrderRepository clientOrderRepository = context.getBean(ClientOrderRepository.class);

		Client client = new Client("Jan", "Kowalski", "Wysoka 40, 12-345 Chałupkowo");
		clientRepository.save(client);


		ClientOrder order1 = new ClientOrder("Szafa modułowa", "Szafa modułowa BigBox z drzwiami przesuwnymi, 160x240cm", 1900.0,client );
		ClientOrder order2 = new ClientOrder("Łóżko", "Łóżko 160x200 z podnoszonym stelażem i skrzynią", 3200.0,client);
		clientOrderRepository.save(order1);
		clientOrderRepository.save(order2);

		clientOrderRepository.findById(1L).ifPresent(System.out::println);


	}

}
