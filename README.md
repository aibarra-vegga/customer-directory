# Customer Directory
Java application that allows to do a create, update, delete and search with customers in local.
It has menu where you can select 13, different options.
```
1: Create user
2: Update user
3: Delete user
4: Find user by ID 
5: Find user by Email
6: Find user by Name 
7: Find user by Surname 
8: Find user by City 
9: Find user by Country
10: List all customers 
11: List all deleted
12: Test user
13: Test user 
```
It has 2 directories, 1 for active customers and 1 for the deleted ones, when you do a delete the customer with the NIF you delete goes to that directory, and if you update a customer the older values of that customer go to the directory of deleted customers.

This program also have search functionalities to find any customer by any value of the customers, the find methods return a list of customers with the matching values.
You can see all active customers or see all the deleted customers.

The values of the customers have a very soft validation, except for the NIF, and the country have to be in Spanish language
