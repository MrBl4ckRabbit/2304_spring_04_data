package by.itclass;

import by.itclass._02_spring_jpa.config.AppConfig;
import by.itclass._02_spring_jpa.entities.Airplane;
import by.itclass._02_spring_jpa.repositories.AirplaneRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var repository = context.getBean(AirplaneRepository.class);

//        var boeing736 = context.getBean("boeing736", Airplane.class);
//        System.out.println("We just bought an airplane: " + boeing736);
//
//        boeing736 = repository.save(boeing736);
//        System.out.println("We just registered an airplane: " + boeing736);
//
//        boeing736.setPlaces(160);
//        boeing736 = repository.save(boeing736);
//        System.out.println("We changed places in boeing: " + boeing736);

        System.out.println(repository.findByModel("AirBus-300"));
        System.out.println(repository.findByModelAndPlaces("AirBus-300", 100));
        System.out.println(repository.findByModelLike("%736"));
        System.out.println("******************************");
        repository.findByIdBetween(2,10).forEach(System.out::println);


    }
}
