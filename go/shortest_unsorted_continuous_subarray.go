package main

import "fmt"

func findUnsortedSubarray(nums []int) int {
	n := len(nums)

	ll := n
	rr := -1

	maxSeen := nums[0]
	for l := 1; l < n; l++ {
		if nums[l] < maxSeen {
			rr = l
		} else {
			maxSeen = nums[l]
		}
	}

	if rr == -1 {
		return 0
	}

	minSeen := nums[n-1]
	for l := n - 2; l >= 0; l-- {
		if nums[l] > minSeen {
			ll = l
		} else {
			minSeen = nums[l]
		}
	}

	return rr - ll + 1
}


func main(){
	var n int
	fmt.Scan(&n)
	nums := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&nums[i])
	}
	fmt.Println(findUnsortedSubarray(nums))
}