package Dynamic_programming

// Take cur item or not take cur item

// Basically current item [idx :3 and capacity: 4] would be calcualted
// twice here, so we store the results

// Use a 2d array to store the results here


/*
https://www.youtube.com/watch?v=cJ21moQpofY&t=610s
Video by Eric Programming William Fiest
		            Capacity
   Data	         Index	0	1	2	3	4	5   6
v1= 1, w1 = 1  	0	0	0	1	1	1	1   1   1
V2 = 6, w2 =2   	1	0	1	6	7	7	7   7
V3 = 10, w3 = 3  	2	0	1	6	10  11	16  17
V4 = 16, w4 = 5	    3	0
At (0,1), since capacity =1 can't take value v1 =2 with w1 =3,
so the value will be 0
At (1, 4), can take value 2, since capacity =4, wt = 1, so cap-wt = 3
At (2, 4), look at value at (1, 3) and (1, 4)


                        here, we take the max at position
 */
// TC: O(n*c)   n # of rows c # of column

