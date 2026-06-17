import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

 class FindCheapestFlightTests {


    @Test
    void find_cheapest_flights_within_k_stops() {
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0, dst = 3, k = 1;

        final TravelAgency travelAgency = new TravelAgency();
        int price = travelAgency.findCheapestPrice(n, flights, src, dst, k);
        int output = 700;
        assertThat(price).isEqualTo(output);
    }

    @Test
    void find_cheapest_flights_within_1_stop() {
        int n = 3;
        int[][] flights = {{0,1,100}, {1,2,100}, {0,2,500}};
        int src = 0, dst = 2, k = 1;

        final TravelAgency travelAgency = new TravelAgency();
        int price = travelAgency.findCheapestPrice(n, flights, src, dst, k);
        int output = 200;
        assertThat(price).isEqualTo(output);
    }

     @Test
     void find_cheapest_flights_within_0_stop() {
         int n = 3;
         int[][] flights = {{0,1,100}, {1,2,100}, {0,2,500}};
         int src = 0, dst = 2, k = 0;

         final TravelAgency travelAgency = new TravelAgency();
         int price = travelAgency.findCheapestPrice(n, flights, src, dst, k);
         int output = 500;
         assertThat(price).isEqualTo(output);
     }

     @Test
     void find_cheapest_flights_within_1_stops() {
         int n = 5;
         int[][] flights = {{4,1,1}, {1,2,3}, {0,3,2},{0,4,10},{3,1,1},{1,4,3}};
         int src = 2, dst = 1, k = 1;

         final TravelAgency travelAgency = new TravelAgency();
         int price = travelAgency.findCheapestPrice(n, flights, src, dst, k);
         int output = -1;
         assertThat(price).isEqualTo(output);
     }

}
