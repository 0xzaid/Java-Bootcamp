# Bootcamp3 Justification

## List the advantages and disadvantages of using numeric integer type and Java string

### Advantages of numeric integer type:
1. Easier for sorting
2. More efficiently stored than String
3. Can perform calculations on integers

### Disadvantages of numeric integer type:
1. Limited to few characters
2. ignores zeros before numbers e.g. 0099999 will be 99999

### Advantages of Java String:
1. More characters to choose from
2. If we used Strings to store numbers that start with 0s it will keep it, but using an integer with numbers starting with 0, Java will ignore it e.g. 0099999 will be 99999

### Disadvantages of Java String:
1. Harder to sort than integers
2. Cannot perform calculations on Strings

### Final decision is to use Java Strings, justification:
* buyerId might contain characters too not just integers
* Wont ignore id's that start with 0s
* Efficiency isn't that important due to low amount of information
* Dont need to sort by buyerId, can sort by givenName
* Dont need to perform calculations anyway

## givenName and lastName
* Using givenName and familyName rather than firstName and lastName to avoid confusion because different cultures have 
  different understanding of first and last names.

## Justification for Arraylist over Array
* Arraylist is dynamic, doesnt have a fixed size
* Can add new Cars easily

## Design a buyer list display method
* prints a list of all buyers without duplicates
* what class should hold this method

1. Create a Buyer type Arraylist called buyer_array
2. A for-loop can check the car_array for every buyer
3. If the buyer id in car_array does not exist in the new buyer_array, then add it to buyer_array.
4. Else, buyer is already added to the list and is a duplicate, so skip to the next element.
5. After looping through using car_array's length for every buyer, return the list of buyers with 
   Buyer's description() method

