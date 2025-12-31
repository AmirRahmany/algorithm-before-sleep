package main

import "fmt"

func isSubsequence(s, t string) bool {
	i, j := 0, 0

	for i < len(s) && j < len(t) {
		if s[i] == t[j] {
			j++
		}
		i++
	}

	return j == len(t)
}


func main(){
	var s,t string
	fmt.Scan(&s,&t)
	fmt.Println(isSubsequence(s,t))
}