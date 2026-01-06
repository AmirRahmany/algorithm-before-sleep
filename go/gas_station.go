package main

import "fmt"
 
func canCompleteCircuit(gas []int, cost []int) int {
    var n = len(gas)
	t := 0
	s := 0
	index := 0
	for i := 0; i < n; i++ {
		t += gas[i] - cost[i]
		s += gas[i] - cost[i]
		if s < 0 {
			index = i + 1
			s = 0
		}
	}
	if t >= 0 {
		return index	
	} else {	
		return -1
	}
}

func main() {
	var n int
	fmt.Scan(&n)
	gas := make([]int, n)
	cost := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&gas[i])
	}
	for i := 0; i < n;i++ {
		fmt.Scan(&cost[i])
	}
	fmt.Println(canCompleteCircuit(gas , cost))
}