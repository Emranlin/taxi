package services.impl;

import Dao.Database;
import classes.Taxi;
import enums.TaxiType;
import services.TaxiService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TaxiServiceImpl implements TaxiService {
    Database database=new Database();

    @Override
    public StringBuilder add(Taxi taxi) {
        if (taxi.getYear().isAfter(LocalDate.now().minusYears(10))) {
            database.getTaxisBase().add(taxi);
            return new StringBuilder("Taxi added successfully!");
        } else {
            return new StringBuilder("Taxi invalid!");

        }
    }

    @Override
    public StringBuilder add(List<Taxi> taxis) {
        for (Taxi taxi : taxis) {
           if(taxi.getYear().isAfter(LocalDate.now().minusYears(10))) {
               database.getTaxisBase().addAll(taxis);
           }
        }

        return new StringBuilder("Successful created");
    }

    @Override
    public List<Taxi> findByInitialLetter(String model) {
        List<Taxi>taxiList=database.getTaxisBase().stream()
                .filter(taxi -> taxi.getModel().startsWith(model)).toList();
        return taxiList;
    }

    @Override
    public Map<TaxiType, List<Taxi>> grouping() {
        Map<TaxiType,List<Taxi>>map=database.getTaxisBase().stream()
                .collect(Collectors.groupingBy(Taxi::getTaxiType));
        return map;
    }

    @Override
    public List<Taxi> filterByTaxiType(String taxiType) {
        List<Taxi>taxiList=database.getTaxisBase().stream()
                .filter(taxi -> taxi.getTaxiType().equals(TaxiType.valueOf(taxiType))).toList();
        return taxiList;
    }

    @Override
    public void update(Long id) {
        System.out.println("Select the id: ");
        for (Taxi taxi : database.getTaxisBase()) {
           if( taxi.getId().equals(id)){
               System.out.println("Let's begin updating taxi ");
               List<Taxi> update = database.getTaxisBase().stream().filter(taxi1 -> taxi.getId().equals(id)).toList();
               System.out.print("Current ID: ");
               update.stream().map(Taxi::getId).forEach(System.out::println);
               System.out.println("\nWrite new ID: ");
               update.forEach(taxi1 -> taxi.setId(new Scanner(System.in).nextLong()));
               System.out.println("ID changed successfully");
           }

        }

    }
}
