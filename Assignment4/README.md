## Instructions

In the console, one can navigate through the menus
using exit or back respecively. exit quits the smartphone. 

to input a command, write the statements exactly as shown in the menu

the submenu of the device represents a remote control, where buttons 
are mapped with a function (to follow the command pattern). according to the current state
only currently possible commands are shown. Nevertheless the index of the button remains the same.

##Devices

####Oven

The oven must be switched on first. After switching it on the timer, temperature and program can be set. If the users sets one of this
parameters twice the old parameter gets overwritten be the new one. If all parameters are set the oven can start cooking.
During the cooking process the temperature, the program and the timer can´t be modified. The user can interrupt the
the cooking process which interrupts the cooking and sets all parameters(temperature, timer, program) back to not set. The oven can be switch off at any time, which completely shuts down the device. Check timer returns: the active timer if the oven is running,
,the last set timer if a timer is set or no timer set if no timer is set. If the program Ends it gets into an Ended state, 
which preserves the timer, temperature and program that was previously set. The user can immediately start cooking again or change
any parameter and then start cooking again. 

####Microwave

The microwave must be switched on first. After switching it on the timer and temperature can be set. If the users sets one of this
parameters twice the old parameter gets overwritten be the new one. If all parameters are set the microwave can start baking.
During the baking process the temperature and the timer can´t be modified. The user can interrupt the
the baking process which interrupts the baking and sets all parameters(temperature, timer) back to not set. The microwave can be switch off at any time, which completely shuts down the device. Check timer returns: the active timer if the microwave is running,
,the last set timer if a timer is set or no timer set if no timer is set. If the program Ends it gets into an Ended state, 
which preserves the timer and temperature that was previously set. The user can immediately start baking again or change
any parameter and then start baking again. 



####Cleaning Robot

The cleaning Robot starts with 100 percent battery. The user can set a timer and after a timer is set he can start cleaning. 
During the cleaning time the user can check the battery status and the percentage of cleaning completion.
When the battery goes to zero or the robot finished cleaning he goes back to the charging base. During the charging time, the user can check battery charging status.
If the robot had to break the cleaning for charging, the user can check the percentage of outstanding cleaning.
After the robot is 100% charged, the robot can finish the outstanding cleaning, if the cleaning was not finished before.
Or a new timer can be set so that the robot can start cleaning again. The robot can end the cleaning and go back to charging base at any time.
This command is also available after charging if the robot didn´t finish the cleaning before charging, if the user doesn´t want that the robot finishes the outstanding cleaning.
