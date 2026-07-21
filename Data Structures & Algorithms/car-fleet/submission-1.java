class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (car1, car2) -> Integer.compare(car2[0], car1[0]));

        int fleets = 0;
        double curFleetTime = 0.0;
        for (int[] car : cars) {
            double time = (double) (target - car[0]) / car[1];
            if (time > curFleetTime) {
                fleets ++;
                curFleetTime = time;
            }
        }
        return fleets;
    }
}
