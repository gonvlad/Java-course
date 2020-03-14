package com.company.practice1;
import by.gsu.pms.BusinessTrip;

public class Runner {
    public static void main(String[] args) {
        BusinessTrip[] businessTrips = new BusinessTrip[7];

        businessTrips[0] = new BusinessTrip("Alex Thompson", 23000, 1);
        businessTrips[1] = new BusinessTrip("Pablo Escobar", 23000, 10);
        businessTrips[3] = new BusinessTrip("Virginia Vallejo", 29100, 3);
        businessTrips[4] = new BusinessTrip("Gustavo Gaviria", 34750, 7);
        businessTrips[5] = new BusinessTrip("Olivia Johnson", 12500, 4);
        businessTrips[6] = new BusinessTrip();

        for (int i = 0; i < businessTrips.length; ++i) {
            if (i != 2) {
                businessTrips[i].show();
            }
        }

        businessTrips[businessTrips.length - 1].setExpenses(23600);

        System.out.printf("Duration = %d\n\n", businessTrips[0].getDaysInTrip() + businessTrips[1].getDaysInTrip());

        for (int i = 0; i < businessTrips.length; ++i)
            if (i != 2) System.out.println(businessTrips[i].toString());

        System.out.printf("\nTotal expenses sum is: %d\n\n", businessTrips[0].getTotal() +
                                                               businessTrips[1].getTotal() +
                                                               businessTrips[3].getTotal() +
                                                               businessTrips[4].getTotal() +
                                                               businessTrips[5].getTotal() +
                                                               businessTrips[6].getTotal());

        int maxTotalIndex = 0;
        for (int i = 0; i < businessTrips.length; ++i) {
            if (i != 2 && businessTrips[maxTotalIndex].getTotal() < businessTrips[i].getTotal()) {
                maxTotalIndex = i;
            }
        }
        System.out.printf("%s has maximum total expenses.\n", businessTrips[maxTotalIndex].getAccount());
    }
}
