package main

import "fmt"

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}

func candy(ratings []int) int {
	n := len(ratings)
	l := 1
	sum := 0
	maximum := make([]int, n)
	for i := 0; i < n; i++ {
		maximum[i] = 1
	}

	for i := 1; i < n; i++ {
		if ratings[i] > ratings[i-1] { 
			l++	
		} else {
			l = 1
		}
		maximum[i] = l
	}
	l=1
	for i := n - 2; i >= 0; i-- {
		if ratings[i] > ratings[i+1] {	
			l++
		} else {
			l = 1
		}
		maximum[i] = max(maximum[i], l)
	}
	for i := 0; i < n; i++ {
		// fmt.Println(maximum[i])
		sum += maximum[i]
	}

	return sum 
}

func main() {
	var n int
	fmt.Scan(&n)
	ratings := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&ratings[i])
	}
	fmt.Println(candy(ratings))
}

