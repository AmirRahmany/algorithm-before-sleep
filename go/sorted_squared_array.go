package main

import "fmt"

func sortedSquares(nums []int) []int {
	n := len(nums)
	result := make([]int, n)
	left, right := 0, n-1
	pos := n - 1
	for left <= right {
		leftSquare := nums[left] * nums[left]
		rightSquare := nums[right] * nums[right]
		if leftSquare > rightSquare {
			result[pos] = leftSquare
			left++
		} else {
			result[pos] = rightSquare
			right--
		}
		pos--
	}	
	return result
}

func main() {
	var n int
	fmt.Scan(&n)
	nums := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&nums[i])
	}
	result := sortedSquares(nums)	
	for _, v := range result {
		fmt.Print(v, " ")
	}
}