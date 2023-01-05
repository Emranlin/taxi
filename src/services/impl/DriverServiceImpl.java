package services.impl;

import Dao.Database;
import classes.Driver;
import classes.Taxi;
import services.DriverService;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class DriverServiceImpl implements DriverService {
    Database database=new Database();
    @Override
    public Driver add(Driver driver) {
        database.getDriversBase().add(driver);

        return null;
    }

    @Override
    public List<Driver> add(List<Driver> drivers) {
        database.getDriversBase().addAll(drivers);

        return drivers;
    }

    @Override
    public Driver findById(Long id) {

        Driver driver1 = database.getDriversBase().stream()
                .filter(driver -> driver.getId().equals(id)).findAny().get();

        return driver1;
    }

    @Override
    public List<Driver> findByName(String name) {
        List<Driver>list=database.getDriversBase().stream()
                .filter(driver -> driver.getName().equals(name)).toList();

        return list;
    }

    @Override
    public String assignTaxiToDriver(String taxiName, Long driverId) {
        Taxi activeTaxi = null;
        for (Taxi taxi : database.getTaxisBase()) {
            if (taxi.getModel().equals(taxiName)) {
                activeTaxi = taxi;
            }
        }
        for (Driver driver : database.getDriversBase()) {
            if (Objects.equals(driver.getId(), driverId)) {
                driver.setTaxi(activeTaxi);
            }
        }
        return "Successful assigned";
    }

    @Override
    public String changeTaxiOrDriver(Long driverId, Long taxiId) {
        Driver driver1 = null;
        for (Driver driver :database.getDriversBase()) {
            if (driver.getId().equals(driverId)) {
                driver1 = driver;
            }
        }
        Taxi taxi = database.getTaxisBase().stream().filter(x -> x.getId().equals(taxiId)).findAny().get();
        if (driver1.getTaxi() == null) {
            return "Don't found the taxi";
        } else {
            for (Driver driver : database.getDriversBase()) {
                if (driver.getTaxi().equals(taxi)) {
                    return "Taxi is busy";
                } else {
                    driver1.setTaxi(taxi);
                    return "Taxi successfully changed";
                }
            }
        }
        return null;
    }

    @Override
    public List<Driver> getDriverByTaxiModel(String model) {
        List<Driver>list=database.getDriversBase().stream()
                .filter(driver -> driver.getTaxi().getModel().equals(model)).toList();
        return list;
    }

    @Override
    public void update(String driverName) {
        Scanner scanner = new Scanner(System.in);
        List<Driver> update= database.getDriversBase().stream().filter(driver -> driver.getName().equals(driverName)).toList();
        System.out.print("Current Name:  ");
        update.stream().map(Driver::getName).forEach(System.out::println);
        System.out.println("Write new name ");
        update.forEach(driver -> driver.setName(scanner.next()));
        System.out.println("Name update successfully");


    }
}
