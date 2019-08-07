db connection
userprofile


- course
-- user
-- movie

Student
	Address
		Zipcode

-- Setter method
-- setXXX

-- Autowiring
	
-	 none --> ref
	 byName -->
		- name of the propery must be name of the 		  bean
		- uses no-arg constructor ( default 		  constructor)
		- and setter method for injecting the dependency 
	 byType -->
		- property by the Type of the bean
		- no-arg constructor and setter method
		- if two bean existing of same type, then 		  it will throw exception
	 constructor
		- uses only arg- constructor
		- parameter name must match with the name 		  of the bean
		- you can define overloaded arg-		 constructors - will decide based on the 		 number of arguments matching with name
		 of the bean
		- overloaded constructors with individual                  dependencies, then it will choose the                     last constructor to inject the                  dependency
	
				
			
