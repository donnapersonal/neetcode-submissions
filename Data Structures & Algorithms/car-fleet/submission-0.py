class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        cars = sorted(zip(position, speed))
        fleets = 0
        cur_fleet_time = 0
        for pos, speed in reversed(cars):
            time = (target - pos) / speed
            if time > cur_fleet_time:
                fleets += 1
                cur_fleet_time = time
        
        return fleets