package services.impl;

import classes.Driver;
import services.DriverService;

import java.util.List;

public class DriverServiceImpl implements DriverService {
    @Override
    public Driver add(Driver driver) {
        return null;
    }

    @Override
    public List<Driver> add(List<Driver> drivers) {
        return null;
    }

    @Override
    public Driver findById(Long id) {
        return null;
    }

    @Override
    public List<Driver> findByName(String name) {
        return null;
    }

    @Override
    public String assignTaxiToDriver(String taxiName, Long driverId) {
        return null;
    }

    @Override
    public String changeTaxiOrDriver(Long driverId, Long taxiId) {
        return null;
    }

    @Override
    public List<Driver> getDriverByTaxiModel(String model) {
        return null;
    }

    @Override
    public void update(String driverName) {

    }
}
