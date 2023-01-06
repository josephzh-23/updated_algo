package Graph;

import java.util.*;

public class busRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {

            Map<Integer, List<Integer>> busRoutes = new HashMap<>();

            for(int i = 0; i<routes.length; i++){

                // loop thru the routes
                for(int j = 0; j< routes[i].length; j++){
                    // add route to the bus if it doesn't exist yet
                    busRoutes.putIfAbsent(routes[i][j], new ArrayList<>());
                    //record the bus number
                    busRoutes.get(routes[i][j]).add(i);
                }
            }


            HashSet<Integer> visitedBusNumber = new HashSet<>();

            // That's the queue we are adding here
            Queue<Integer> busStops = new LinkedList<>();

            int numberOfBuses = 0;

            while(!busStops.isEmpty()){
                int size = busStops.size();
                for(int i = 0; i< size; i++){
                    // pull out the first stop
                    int stop = busStops.poll();

                    if(stop == target) return numberOfBuses;
                    List<Integer> busNumbers = busRoutes.get(stop);

                    // grab each stop in the bus number
                    for(int number : busNumbers){
                        if(visitedBusNumber.contains(number)) continue;

                        visitedBusNumber.add(number);

                        for(int j = 0; j< routes[number].length; i++){

                            // add the routes of the bus number to the q
                            busStops.add(routes[number][j]);
                        }
                    }
                }

                numberOfBuses++;


            }
            return numberOfBuses;
    }
}
