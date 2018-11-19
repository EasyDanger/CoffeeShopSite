# CoffeeShopSite
Project to create a mock, but fully functional employee login site for a coffee shop with dubious motivation

This project was originally planned to be an employee login site allowing for employees to login and view menu items and the basic information of other employees. Employees with the "Admin" attribute were authorized with further privileges, allowing them to delete and edite both menu items and employees, as well as bestowing "Admin" rights. 

As the project evolved, customer rights were added. Customers have access to the menu and can place orders, adding items to their virtual shopping cart and eventually a simulated checkout. The cart is emptied upon "payment."

All users, whether customer or employee, have access to their own information on their profile, and can change any of their information. Customers and employees are stored as to separate tables. This is in part because the Customer class was developed after the Employee class, which was developed prior to the introduction of sessions. Both tables have since been converted to take advantage of sessions.

The coffee shop may or may not be run by some sort of non-human entity, but that's not really important to the code.

This project was developed as a multi-part coding lab as part of the Grand Circus curriculum in the fall of 2018. It is a webapp that uses Spring MVC, Hibernate, and MySQL. It was developed on Windows 10 and tested in Opera 56.

<div align="right">-Ed Carter</div> 
<div align="right">@EasyDanger</div>
<div align="right">in/CarterCommaEd </div>
<div align="right">github.com/EasyDanger</div>
