package by.itclass;

import by.itclass._02_spring_jpa.config.AppConfig;
import by.itclass._02_spring_jpa.entities.Airplane;
import by.itclass._02_spring_jpa.entities.Passenger;
import by.itclass._02_spring_jpa.repositories.AirplaneRepository;
import by.itclass._02_spring_jpa.repositories.PassengerRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var repository = context.getBean(AirplaneRepository.class);
        var passRepository = context.getBean(PassengerRepository.class);

//        var boeing736 = context.getBean("boeing736", Airplane.class);
//        System.out.println("We just bought an airplane: " + boeing736);
//
//        boeing736 = repository.save(boeing736);
//        System.out.println("We just registered an airplane: " + boeing736);
//
//        boeing736.setPlaces(160);
//        boeing736 = repository.save(boeing736);
//        System.out.println("We changed places in boeing: " + boeing736);

//        System.out.println(repository.findByModel("AirBus-300"));
//        System.out.println(repository.findByModelAndPlaces("AirBus-300", 100));
//        System.out.println(repository.findByModelLike("%736"));
//        System.out.println("******************************");
//        repository.findByIdBetween(2,10).forEach(System.out::println);

//        repository.selectAllSamolet().forEach(System.out::println);

//        System.out.println(repository.concreteSamolet("Air%", 300));

//        repository.bigPlane().forEach(System.out::println);

        var passengers = (List<Passenger>) context.getBean("passengers");
        passRepository.saveAll(passengers);

        var boeing = context.getBean("boeing736", Airplane.class);
        repository.save(boeing);

    }
}
