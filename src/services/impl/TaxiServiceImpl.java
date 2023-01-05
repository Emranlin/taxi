package services.impl;

import Dao.Database;
import classes.Taxi;
import enums.TaxiType;
import services.TaxiService;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaxiServiceImpl implements TaxiService {
    Database database = new Database();

    @Override
    public StringBuilder add(Taxi taxi) {
        Set<Taxi> taxis = new LinkedHashSet<>(database.getTaxisBase());
        if (taxi.getYear().isAfter(LocalDate.of(2010, 1, 1))) {
            taxis.add(taxi);
        }
        database.setTaxisBase(taxis);

        return new StringBuilder("Added Taxis");
    }

    @Override
    public StringBuilder add(List<Taxi> taxis) {
        Set<Taxi> taxis1 = new LinkedHashSet<>(this.database.getTaxisBase());
        for (Taxi taxi : taxis) {
            if (taxi.getYear().isAfter(LocalDate.of(2010, 1, 1))) {
                taxis1.add(taxi);
            }
            database.setTaxisBase(taxis1);
        }
        return new StringBuilder("Added Taxis (List)!");
    }

    @Override
    public List<Taxi> findByInitialLetter(String model) {
        List<Taxi> taxis = new ArrayList<>();
        for (Taxi taxi : database.getTaxisBase()) {
            if(taxi.getModel().startsWith(String.valueOf(model.charAt(0)))){
                taxis.add(taxi);
            }
        }
        return taxis;
    }

    @Override
    public Map<TaxiType, List<Taxi>> grouping() {
        return database.getTaxisBase().stream().collect(Collectors.groupingBy(Taxi::getTaxiType));
    }

    @Override
    public List<Taxi> filterByTaxiType(String taxiType) {
        List<Taxi> tax = database.getTaxisBase().stream().filter(s-> s.getTaxiType().name().equals(taxiType.toUpperCase())).toList();
        return tax;
    }

    @Override
    public void update(Long id) {
        while (true) {
            System.out.println("Выберите что вы хотите изменить:");
            System.out.println("""
                    1-> id изменить:
                    2-> taxi type изменить:
                    3-> 
                    """);
            long id1 = new Scanner(System.in).nextLong();
            switch ((int) id1) {
                case 1:
                    for (Taxi taxi : this.database.getTaxisBase()) {
                        if (taxi.getId() == id) {
                            System.out.println("Write new id!!!");
                            Long idc1 = new Scanner(System.in).nextLong();
                            taxi.setId(idc1);
                        }
                    }
            }

        }

    }
}