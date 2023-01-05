package services.impl;

import Dao.Database;
import classes.Client;
import classes.MyExceptions;
import classes.Taxi;
import enums.TaxiType;
import services.ClientService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class ClientServiceImpl implements ClientService {
    Database database=new Database();
    @Override
    public String addClient(Client client) {
        try {
            System.out.println("Please enter your id: " );
            Long id=new Scanner(System.in).nextLong();
            System.out.println("Please enter your full name: ");
            String fullName=new Scanner(System.in).next();
            System.out.println("Please enter your date of birth: ");
            LocalDate dateOfBirth=LocalDate.parse(new Scanner(System.in).nextLine());
            System.out.println("Please enter  your phone number: ");
            String phoneNumber=new Scanner(System.in).nextLine();
            System.out.println("Please enter your money");
            BigDecimal money=new Scanner(System.in).nextBigDecimal();


                    if (id.describeConstable().isEmpty()) {
                        throw (new MyExceptions("The id can't be empty"));
                    }
                    if (fullName.contains(" ")) {
                        throw (new MyExceptions("Word contains one or more spaces"));
                    }
                    if (dateOfBirth.lengthOfYear() > 0) {
                        throw (new MyExceptions("Date of birth can't be negative"));
                    }
                    if (!phoneNumber.startsWith("+996")) {
                        throw (new MyExceptions("PhoneNumber should start with +996"));
                    }
                    if (money.intValue() >= 0) {
                        throw (new MyExceptions("Money can't be negative"));
                    }
                    Client client1 = new Client(id, fullName, dateOfBirth, phoneNumber, money);
                    database.getClientBase().add(client1);


                }catch(MyExceptions ex){
                    ex.printStackTrace();
                }

        return "Successful created";
    }


    @Override
    public String addClient(List<Client> clients) {
        database.getClientBase().addAll(clients);
        return "Successful created";
    }

    @Override
    public List<Client> getClientByName(String name) {
        List<Client>streamGetName=database.getClientBase().stream().filter(f->f.getFullName().equals(name)).toList();
        return streamGetName;
    }

    @Override
    public Client removeClientById(Long id) {
        int streamId= Math.toIntExact(database.getClientBase().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .get().getId());
        database.getClientBase().remove(streamId);

        return null;
    }

    @Override
    public Taxi orderTaxi(Long clientId, String taxiType) {
        System.out.println("Enter the id of client: ");
        long id = new Scanner(System.in).nextLong();
        for (Client client : database.getClientBase()) {
            if (client.getId().equals(id)) {
                System.out.println("Choose your taxi: ");
                TaxiType taxi1=TaxiType.valueOf(new Scanner(System.in).nextLine());
                for (Taxi taxi : database.getTaxisBase()) {
                    if(taxi.equals(taxi1)){
                       client.setMoney(client.getMoney().subtract(taxi.getTaxiType()
                               .getPricePerKm().add(taxi.getTaxiType().getPriceForLanding())));

                       return taxi;
                    }

                }
        }
    }
      return null;
    }


    @Override
    public Map<Integer, Client> getClientAge() {
    Map<Integer,Client> map = new LinkedHashMap<>();
        for (Client client : database.getClientBase()) {
            int age = Period.between(client.getDateOfBirth(),LocalDate.now()).getYears();
            map.put(age,client);
        }
        return map;
    }

    @Override
    public void universalSorting(String word) {
        System.out.println("Select your word ");
        String word1=new Scanner(System.in).nextLine();
        if(word1.equals("id")){
            database.getClientBase().stream().sorted(Comparator.comparing(Client::getId)).forEach(System.out::println);
        }
        if (word1.equals("fullName")){
            database.getClientBase().stream().sorted(Comparator.comparing(Client::getFullName)).forEach(System.out::println);
        }
        if(word1.equals("date of birth")){
            database.getClientBase().stream().sorted(Comparator.comparing(Client::getDateOfBirth)).forEach(System.out::println);

        }
        if(word1.equals("money")){
            database.getClientBase().stream().sorted(Comparator.comparing(Client::getMoney)).forEach(System.out::println);
        }

    }
}
