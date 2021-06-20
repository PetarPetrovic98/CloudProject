# Cinema Booking App <img src="https://imagizer.imageshack.com/img924/9722/4EcBJs.png" alt="Icon"  width="25" />

#### A student Cloud project

- This is the frontend part of the Cloud project, made using JavaFX and Scene Builder.
- The backend part's documentation is available [here](https://github.com/JimboMan123/CloudBackend/blob/989da7e8464c78ccdd8026fba62b86d20aa8fb59/README.md).



Startup by running `Main` and the app will first display:

- The `logInPage` where we implemented authentication, that checks with the Cloud database.
  * For testing purposes enter for:
  
  * username: admin
  
  * password: pass
  
    <img src="https://imagizer.imageshack.com/img924/4238/VbTocM.png" alt="Log in"  width="500"/>
  
    
  
- Upon successful authentication, the scene switches to the `welcomePage`, where we one can:
  - View Films
  
  - View Bookings
  
    <img src="https://imagizer.imageshack.com/img924/6217/eAYqRO.png" alt="Welcome" width="500" />
  
    
  
- By choosing `View Bookings` a table opens up, showing already booked information for the current user. If there's any.
  - There are two buttons with options to go back or log out. And these are consistent with almost every scene in this app.
  
    <img src="https://imagizer.imageshack.com/img923/2384/Dd96Ly.png" alt="View Bookings" width="500" />
  
    
  
- By choosing  the `View Films` button, 5 current cinema movie posters are shown.
  
  <img src="https://imagizer.imageshack.com/img924/1964/80vSJA.png" alt="Films" width="500" />
  
  
  
  - Clicking on any of the posters, the movie details are displayed:
    - Title, rating, duration, genre, synopsis, date and time of showing, as well as the price.
    - A `Book Now` button, if one wishes to book the current viewed movie.
    
    <img src="https://imagizer.imageshack.com/img922/5659/qHifBA.png" alt="Cruella" width="500" />
    
    
  
- By clicking the `Book Now` the scene changes to the `cinemaBookingView`,  where one can see:
  - The name of the movie and time are shown above as a reminder. (There is but one showing per day, therefore there isn't an option to choose a time.)
  - And pick a desired date for the movie.
    - By doing so, the seat colors will show if the seat has been already booked or not (red or green).
    - Then the user can pick a seat or more.
    - The price will be calculated as well.
    - And finish the booking by clicking the `Book now` button.

<img src="https://imagizer.imageshack.com/img922/5249/trZzjq.png" alt="Cinema booking" width="500" />
