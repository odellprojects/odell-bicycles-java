# O'Dell Bicycles

This application was built with the intention of providing a basic project that utilizes Object Oriented Principles. The code itself is written based on JDK 8. The target of the application is JDK 20. The limitations of the code written is for helping individuals with concepts that will help in studying for the Java Foundations Exam 1Z0-811. There are concepts in this project that are examples for helping an individual study for the Java Programmer I Exam 1Z0-808. This is a console based application. 

New potential concepts introduced in this project include the following:
- Scanner next(pattern) method.
    - This concept takes a pattern to match against and provides a better mechanism for validation.
- The Supplier Functional Interface
    - This is a functional interface and can be used as the assignment target for a lambda expression.
    - It can be used with Method References, but that was not used in this project.

There will be more content added to this project in the future, including Unit Testing. Below is the project definition.

---

Welcome to O'Dell Bicycles. We put your team together so we could get a prototype application written for our company.

We make a range of Road Bikes and Mountain Bikes. We have a default frame color for each of our bike styles. Below will be the listed colors and pricing.  We will also provide those below. Our wheels come in two styles; Wide and normal. Each wheel type has a tire and tube and are specific to each type. We will however offer a white tire as a special-order item for either style.

We also provide some custom options that are in addition to our base model bicycles. A limited-edition golden frame, leather seat and leather grips. These options come with an additional cost, which will be below. For our Road Bikes, we offer 2 styles: 
- Touring
- Vintage. 

For our Mountain Bikes, we offer 2 styles: 
- Downhill
- Cross Country. 

Only our Mountain Bike line uses wide wheels and tires.

Bike Frame colors: 
- Black
- Red
- Blue
- Green
- Chrome

Touring is **$499.99** with a default color of **Blue**

Vintage is **$299.99** with a default color of **Red**

Downhill is **$699.99** with a default color of **Black**

Cross Country is **$599.99** with a default color of **Green**

Each frame has a stamped serial number on it. Each serial number has a prefix and starting number per model. For this prototype application, we will generate these serial numbers during the purchase process. 
- Touring prefix: **TB901** and a starting number of **951357**
- Vintage prefix: **VB801** and a starting number of **753159**
- Downhill prefix: **DB505** and a starting number of **852654**
- Cross Country prefix: **MB605** and a starting number of **258456**

The custom options below will cost in addition to the base price of the bicycle.
- Gold Frame for **$299.99**
- Leather Seat for **$98.99**
- Leather Grips for **$49.99**
- White Tires for **$29.99** each.

We will also offer some basic accessories for our bicycles at a separate cost. Since they will be offered as a separate cost, a customer can just purchase accessories
without buying a bicycle.

Accessories include: 
- helmets
- gloves
- basket
- bell
- tire pump
- lights.