package Dao;

import classes.Client;
import classes.Driver;
import classes.Taxi;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Database {
    private Set<Client> clientBase=new HashSet<>();
    private Set<Driver>driversBase=new HashSet<>();
    private Set<Taxi>taxisBase=new HashSet<>();



    public Set<Client> getClientBase() {
        return clientBase;
    }

    public void setClientBase(Set<Client> clientBase) {
        this.clientBase = clientBase;
    }

    public Set<Driver> getDriversBase() {
        return driversBase;
    }

    public void setDriversBase(Set<Driver> driversBase) {
        this.driversBase = driversBase;
    }

    public Set<Taxi> getTaxisBase() {
        return taxisBase;
    }

    public void setTaxisBase(Set<Taxi> taxisBase) {
        this.taxisBase = taxisBase;
    }

    @Override
    public String toString() {
        return "Database{" +
                "clientBase=" + clientBase +
                ", driversBase=" + driversBase +
                ", taxisBase=" + taxisBase +
                '}';
    }


//    Set<Client> clients = new LinkedHashSet<>();
//    Set<Driver>drivers = new LinkedHashSet<>();
//    Set<Taxi>taxis = new LinkedHashSet<>();
//    Set<License>licenses = new LinkedHashSet<>();
//
//    public Set<Client> getClients() {
//        return clients;
//    }
//
//    public void setClients(Set<Client> clients) {
//        this.clients = clients;
//    }
//
//    public Set<Driver> getDrivers() {
//        return drivers;
//    }
//
//    public void setDrivers(Set<Driver> drivers) {
//        this.drivers = drivers;
//    }
//
//    public Set<Taxi> getTaxis() {
//        return taxis;
//    }
//
//    public void setTaxis(Set<Taxi> taxis) {
//        this.taxis = taxis;
//    }
//
//    public Set<License> getLicenses() {
//        return licenses;
//    }
//
//    public void setLicenses(Set<License> licenses) {
//        this.licenses = licenses;
//    }
//
}
