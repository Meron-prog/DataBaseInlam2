package clientinterface;

import DBTabels.*;
import repositories.*;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import static clientinterface.State.*;

public class KundInterface {

    private final KunderRepository kunderRepository;
    private final ProduktRepository produktRepository;
    private final MärkeRepository märkeRepository;
    private final OrderRepository orderRepository;
    private final InehållRepository inehållRepository;
    private final BetygRepository betygRepository;

    private State state;

    private Produkt produkt;
    private String userName;
    private Kunder customer;
    private List<Produkt> productsShowedToUser;
    private List<Märke> allaMärken;
    private String userRating;


    public KundInterface(KunderRepository kunderRepository, ProduktRepository produktRepository,
                         MärkeRepository märkeRepository, OrderRepository orderRepository,
                         InehållRepository inehållRepository, BetygRepository betygRepository) {
        this.kunderRepository = kunderRepository;
        this.produktRepository = produktRepository;
        this.märkeRepository = märkeRepository;
        this.orderRepository = orderRepository;
        this.inehållRepository = inehållRepository;
        this.betygRepository = betygRepository;
    }

    public void start() {
        state = INPUT_USERNAME;

        while (true) {
            showTextToUser();
            String userInput = getUserInput();
            handleUserInput(userInput);
        }
    }

    private void showTextToUser() {
        switch (state) {
            case INPUT_USERNAME:
                System.out.println("Ange ditt användernamn: ");
                break;
            case INPUT_PASSWORD:
                System.out.println("Ange ditt lösenord: ");
                break;
            case SELECT_PRODUCT:
                showProductsToUser();
                break;
            case HANDLE_PRODUCT:
                showProductDetailsToUser();
                break;
            case RATE_PRODUCT:
                askUserToRateProdukt();
                break;
            case COMMENT_PRODUCT:
                askUserToCommentProdukt();
                break;
            case HANDLE_ORDER:
                showOrdersTouser();
                break;
            case ORDER_CONFIRMED:
                bekräftelse();
                break;
            default:
                System.out.println("Okänd state " + state + " avslutar i panik.");
                System.exit(-1);
        }
        System.out.println("Eller ange 0 för att avsluta");
    }


    private String getUserInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().trim();
    }

    private void handleUserInput(String userInput) {
        if (userInput.equals("0")) {
            System.out.println("Tack för besöket.");
            System.exit(0);
        }

        switch (state) {
            case INPUT_USERNAME:
                userName = userInput;
                state = INPUT_PASSWORD;
                break;
            case INPUT_PASSWORD:
                userLogin(userInput);
                break;
            case SELECT_PRODUCT:
                selectProduct(userInput);
                break;
            case HANDLE_PRODUCT:
                handleProduct(userInput);
                break;
            case RATE_PRODUCT:
                rateProdukt(userInput);
                break;
            case COMMENT_PRODUCT:
                commentProdukt(userInput);
                break;
            case HANDLE_ORDER:
                handleOrder(userInput);
                break;
            case ORDER_CONFIRMED:
                state = INPUT_USERNAME;
                break;

            default:
                System.out.println("Okänd state " + state + " avslutar i panik.");
                System.exit(-1);
        }
    }


    private void selectProduct(String userInput) {
        produkt = productsShowedToUser.get(Integer.parseInt(userInput) - 1);
        state = HANDLE_PRODUCT;
    }

    private void userLogin(String password) {
        customer = kunderRepository.getCustomer(userName, password);
        if (customer == null) {
            System.out.println("Fel användernamn eller lösenord");
            state = INPUT_USERNAME;
            return;
        }
        System.out.println("Välkommen " + customer.getFörNamn() + " " + customer.getEfterNamn());
        System.out.println(" ");
        state = SELECT_PRODUCT;
    }

    private void addToOrder(String userInput) {
        Produkt produkt = productsShowedToUser.get(Integer.parseInt(userInput) - 1);
        int produktId = produkt.getProduktId();
        int kundid = customer.getKunderId();

        List<Orders> kundensOrders = orderRepository.getAllOrdersFromKund(kundid);


        System.out.println(kundensOrders);
        if (userInput == "1") {
            System.out.println("Ange id på dem skor du vill lägga till i din order:");

        } else {
            System.out.println(kundensOrders);
        }

    }

    private void showProductsToUser() {
        productsShowedToUser = produktRepository.getAllProductsInStock();
        allaMärken = märkeRepository.getAllMarksInStock();

        for (int i = 0; i < productsShowedToUser.size(); i++) {
            Produkt produkt = productsShowedToUser.get(i);
            System.out.println((i + 1) + " : " +  getNameFromMärkeId(produkt.getMärkeid()) + " " + produkt.getFarg() + " "
                    + produkt.getStorlek() + " " + produkt.getPris());
        }
        System.out.println("Ange id på de skor du vill lägga titta på:");
        System.out.println(" ");
    }

    private String getNameFromMärkeId(int märkeid) {
        for (Märke märke : allaMärken) {
            if (märke.getMärkeId() == märkeid) {
                return märke.getNamn();
            }
        }
        return "Okänt märke";
    }

    private void showProductDetailsToUser() {
        System.out.println(getNameFromMärkeId(produkt.getMärkeid()) + " " + produkt.getFarg() + " " + produkt.getStorlek() + " " + produkt.getPris());
        int produktID = produkt.getProduktId();
        double medelbetyg = betygRepository.getMedelbetygForProduct(produktID);
        if(medelbetyg == 0) {
            System.out.println("Det finns inga betyg för produkten än");
        } else {
            System.out.println("Medelbetyg för produkten är: " + medelbetyg);
        }
        List<Betyg> allaBetyg = betygRepository.getAllBetygForProduct(produktID);
        System.out.println("Kunders kommentarer:");
        for (Betyg betyg : allaBetyg) {
            System.out.println(betyg.getKomment());
        }
        System.out.println(" ");
        System.out.println("Vad vill du göra med produkten: ");
        System.out.println("1. Lägg till i order.");
        System.out.println("2. Ge betyg.");
        System.out.println("3. Inget, jag vill välja en annan produkt.");
    }

    private void handleProduct(String userInput) {
        switch (userInput) {
            case "1":
                List<Orders> order = orderRepository.getCurrentOrdersFromKund(customer.getKunderId());
                if(order.isEmpty()) {
                    System.out.println(inehållRepository.addToOrder(produkt.getProduktId(), customer.getKunderId(), -1));
                } else {
                    int orderid = order.get(0).getOrdersId();
                    System.out.println(inehållRepository.addToOrder(produkt.getProduktId(), customer.getKunderId(), orderid));
                }
                state = HANDLE_ORDER;
                break;
            case "2":
                state = RATE_PRODUCT;
                break;
            case "3":
                state = SELECT_PRODUCT;
                break;
        }

    }

    private void askUserToRateProdukt() {
        System.out.println("Vilket betyg ger du produkten 1 till 5?");
    }

    private void rateProdukt(String userInput) {
        userRating = userInput;
        state = COMMENT_PRODUCT;
    }

    private void askUserToCommentProdukt() {
        System.out.println("Skriv in kommentar: ");
    }

    private void commentProdukt(String userInput) {
        // Spara till databasen

        state = HANDLE_PRODUCT;
    }

    private void showOrdersTouser() {
        System.out.println("beställningar!");

        List<Orders> order = orderRepository.getCurrentOrdersFromKund(customer.getKunderId());

        List<Inehåll> ordersInehåll = inehållRepository.getOrdersInehåll(order.get(0).getOrdersId());
        Set<Integer> produktIds = ordersInehåll.stream().map(i -> i.getProduktId()).collect(Collectors.toSet());
        List<Produkt> produkts = produktRepository.getAllProducts(produktIds);
        for (Inehåll inehåll:ordersInehåll) {
            Produkt produkt = produkts.stream().filter(p -> p.getProduktId() == inehåll.getProduktId()).findFirst().get();
            System.out.println(getNameFromMärkeId(produkt.getMärkeid()) + " " + produkt.getFarg() + " " + produkt.getStorlek() + " " + produkt.getPris());
        }
        System.out.println();
        System.out.println("1. confirm your order");
        System.out.println("2. Lägg till mer produkt i order.");
    }


    private void handleOrder(String userInput) {
        switch (userInput) {
            case "1":
                List<Orders> order = orderRepository.getCurrentOrdersFromKund(customer.getKunderId());
                orderRepository.setOrderToBestalld(order.get(0).getOrdersId());
                state = ORDER_CONFIRMED;
                break;
            case "2":
                Produkt produkt = productsShowedToUser.get(Integer.parseInt(userInput) - 1);
                state = SELECT_PRODUCT;
                break;
        }

    }

    private void bekräftelse() {
        System.out.println("Your order is confirmd");
        System.out.println("Thank you for chossing us!");
    }
}
