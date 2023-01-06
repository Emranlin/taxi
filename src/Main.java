

import Dao.Database;
import classes.Client;
import classes.Driver;
import classes.License;
import classes.Taxi;
import enums.Gender;
import enums.TaxiType;
import services.impl.ClientServiceImpl;
import services.impl.DriverServiceImpl;
import services.impl.TaxiServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Client> clients = new ArrayList<>(List.of(
                new Client(1L,"Khafiz",LocalDate.of(2000,11,1),"0501167662",new BigDecimal(2000)),
                new Client(2L,"Bekjan",LocalDate.of(2001,9,1),"0507276253",new BigDecimal(3000)),
                new Client(3L,"Dastan",LocalDate.of(2002,12,1),"0709889090",new BigDecimal(1000)),
                new Client(4L,"Argen",LocalDate.of(2003,8,1),"0501258255",new BigDecimal(4000)),
                new Client(5L,"Bekzat",LocalDate.of(2004,2,1),"0709770099",new BigDecimal(22000))
        ));

        License license1 = new License(1L,LocalDate.of(2010,1,1),LocalDate.of(2030,2,2));
        License license2 = new License(2L,LocalDate.of(2010,1,1),LocalDate.of(2030,2,2));
        License license3 = new License(3L,LocalDate.of(2010,1,1),LocalDate.of(2030,2,2));
        License license4 = new License(4L,LocalDate.of(2010,1,1),LocalDate.of(2030,2,2));
        License license5 = new License(5L,LocalDate.of(2010,1,1),LocalDate.of(2030,2,2));
        List<License>licenses =new ArrayList<>(List.of(license1,license2,license3,license4,license5));

        Taxi taxi1 = new Taxi(1L,"Mercedes-Benz","01kg2323ADS","red",LocalDate.ofYearDay(2012,2), TaxiType.BUSINESS);
        Taxi taxi2 = new Taxi(2L,"Matize","09kg156AKA","black",LocalDate.ofYearDay(2017,2),TaxiType.COMFORT);
        Taxi taxi3 = new Taxi(3L,"AUDI","01kg001KGZ","blue",LocalDate.ofYearDay(2015,2),TaxiType.BUSINESS);
        Taxi taxi4 = new Taxi(4L,"Honda_Fit","04kg888FGJ","yellow",LocalDate.ofYearDay(2013,2),TaxiType.STANDART);
        Taxi taxi5 = new Taxi(5L,"Daewoo","08kg128ARU","white",LocalDate.ofYearDay(2012,2),TaxiType.BUSINESS);
        List<Taxi>taxis = new ArrayList<>(List.of(taxi1,taxi2,taxi3,taxi4,taxi5));

        Driver driver1 = new Driver(1L,"Nurlan","Saburov", Gender.MALE,"0507575734",license1,new BigDecimal(2000),taxi1);
        Driver driver2 = new Driver(2L,"Azim","Shukurbekov",Gender.MALE,"0700491871",license2,new BigDecimal(2000),taxi2);
        Driver driver3 = new Driver(3L,"Kalys","Kachkynov",Gender.MALE,"0777443454",license3,new BigDecimal(2000),taxi3);
        Driver driver4 = new Driver(4L,"Aibek","Amanturov",Gender.MALE,"0555457212",license4,new BigDecimal(2000),taxi4);
        Driver driver5 = new Driver(5L,"Damir","Kyzaev",Gender.MALE,"0709562526",license5,new BigDecimal(2000),taxi5);
        List<Driver>drivers = new ArrayList<>(List.of(driver1,driver2,driver3,driver4,driver5));
        Database database = new Database();
        ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.addClient(clients);
        DriverServiceImpl driverService = new DriverServiceImpl();
        driverService.add(drivers);
        TaxiServiceImpl taxiService = new TaxiServiceImpl();
        taxiService.add(taxis);
        while (true) {
            System.out.println("""
                    1 - client
                    2 - driver
                    3 - taxi""");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("""
                            1 - get client by name
                            2 - remuve client by id
                            3 - order taxi
                            4 - get client age
                            5 - universalSorting
                                                    """);
                    switch (scanner.nextInt()) {
                        case 1:
                            String f = scanner.nextLine();
                            System.out.println(clientService.getClientByName(scanner.nextLine()));
                            break;
                        case 2:
                            System.out.println(clientService.removeClientById(scanner.nextLong()));
                            break;
                        case 3:
                            System.out.println(clientService.orderTaxi(scanner.nextLong(), scanner.nextLine()));
                            break;
                        case 4:
                            System.out.println(clientService.getClientAge());
                            break;
                        case 5:
                            String d = scanner.nextLine();
                            clientService.universalSorting(scanner.nextLine());
                            break;
                        default:
                            System.out.println("error");
                    }
                    break;
                case 2:
                    System.out.println("""
                            1 - fi by id
                            2 -fi by name
                            3 - assignTaxiToDriver
                            4 - changeTaxiOrDriver
                            5 - getDriverByTaxiModel
                            6 - update by name
                            """);
                    switch (scanner.nextInt()){
                        case 1:
                            System.out.println(driverService.findById(scanner.nextLong()));
                            break;
                        case 2:
                            System.out.println(driverService.findByName(scanner.nextLine()));
                            break;
                        case 3:
                            System.out.println(driverService.assignTaxiToDriver(String.valueOf(scanner.nextLong()), scanner.nextLong()));
                            break;
                        case 4:
                            System.out.println(driverService.changeTaxiOrDriver(scanner.nextLong(), scanner.nextLong()));
                            break;
                        case 5:
                            System.out.println(driverService.getDriverByTaxiModel(scanner.nextLine()));
                            break;
                        case 6:
                            driverService.update(scanner.nextLine());
                            break;
                    }
                    break;
                case 3:
                    System.out.println("""
                            1 - findByInitialLetter
                            2 - grouping
                            3 - filterByTaxiType
                            4 - update""");
                    switch (scanner.nextInt()){
                        case 1:
                            System.out.println(taxiService.findByInitialLetter(scanner.nextLine()));
                            break;
                        case 2:
                            System.out.println(taxiService.grouping());
                            break;
                        case 3:
                            System.out.println(taxiService.filterByTaxiType(scanner.nextLine()));
                            break;
                        case 4:
                            taxiService.update(scanner.nextLong());
                            break;
                        default:
                            System.out.println("error");


                    }


                    break;
                default:
                    System.out.println("error");
            }

        }
    }
}
