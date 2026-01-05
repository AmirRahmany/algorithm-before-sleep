package main

import "fmt"

func jump(nums []int) int {
	n := len(nums)
	if n==1{
		return 0
	}
	jumps := 0
	currentEnd := 0
	farthest := 0
	for i:=0; i<n-1; i++ {
		if farthest < i + nums[i] {
			farthest = i+nums[i]
		}
		if i == currentEnd{
			jumps++
			currentEnd=farthest
		}
	}
	return jumps
}

func main() {
	var n int
	fmt.Scan(&n)
	nums := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&nums[i])
	}
	fmt.Println(jump(nums))
}