package main

import "fmt"

func main() {
	var n, target int
	fmt.Scan(&n, &target)
	m := make(map[int]int)

	for i := 0; i < n; i++ {
		var num int
		fmt.Scan(&num)
		idx, ok := m[target-num]
		if ok {
			fmt.Println(idx+1, i+1)
			return
		}
		m[num] = i
	}
	fmt.Println(-1)

}
