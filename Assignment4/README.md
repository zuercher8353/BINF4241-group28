## Instructions

In the console, one can navigate through the menus
using exit or back respecively. exit quits the smartphone. 

to input a command, write the statements exactly as shown in the menu

the submenu of the device represents a remote control, where buttons 
are mapped with a function (to follow the command pattern). according to the current state
only currently possible commands are shown. Nevertheless the index of the button remains the same.

##Commandhandler Pattern

### Client

We split up the Client of the Command Pattern into two classes: Smartphone and DeviceSetup. The Smartphone acts as a Main, handling the initialization of the DeviceSetup and thus indirectly the initialization of the Devices. The Devices are paired inside a Hashmap to the corresponding CommandHandler. 

The Smartphone Client is responsible for reading an input Device and a input command and handling the menu/submenu printing. It then delegates the corresponding CommandHandler to handle the Command to the specific Device.

The DeviceSetup initializes the buttons (see Invoker) of the corresponding CommandHandler (Invoker), occuping each button with a specific Command, available in the Device. Thus it is responsible for creating a CommandObject.

### Invoker

For each Device we implemented a CommandHandler (Invoker), representing a methophor of a Remote with buttons. These buttons are initially allocated without any function i.e. empty Commands (NoCommands). The function handleCommand inside CommandHandler allows a CommandObject loaded in the button to be execute.

### Concrete Command

Each Concrete Command of every Device is implemented as its own class. These are the loaded into the buttons of the corresponding CommandHandler, ready to be executed on a call of handleCommand() to the CommandHandler. The Concrete Command is then able to prompt the device to perform an action.

### Receiver

##Devices

####Oven

The oven must be switched on first. After switching it on the timer, temperature and program can be set. If the users sets one of this
parameters twice the old parameter gets overwritten by the new one. If all parameters are set the oven can start cooking.
During the cooking process the temperature, the program and the timer can´t be modified. The user can interrupt the
the cooking process which interrupts the cooking and sets all parameters(temperature, timer, program) back to not set. The oven can be switch off at any time, which completely shuts down the device. Check timer returns: the active timer if the oven is running,
,the last set timer if a timer is set or no timer set if no timer is set. If the program Ends it gets into an Ended state, 
which preserves the timer, temperature and program that was previously set. The user can immediately start cooking again or change
any parameter and then start cooking again. 

####Microwave

The microwave must be switched on first. After switching it on the timer and temperature can be set. If the user sets one of this
parameters twice the old parameter gets overwritten by the new one. If all parameters are set the microwave can start baking.
During the baking process the temperature and the timer can´t be modified. The user can interrupt the
the baking process which interrupts the baking and sets all parameters (temperature, timer) back to not set. The microwave can be switched off at any time, which completely shuts down the device. Check timer returns: the active timer if the microwave is running,
,the last set timer if a timer is set or no timer set if no timer is set. If the program ends it gets into the Ended state 
which preserves the timer and temperature that was previously set. The user can immediately start baking again or change
any parameter and then start baking again. 

####Washing Machine

The washing machine must be switched on first. After switching it on, the degree and the washing program can be set. If the user sets one of
this parameters twice the old parameter gets overwritten by the new one. After setting the program an automatic timer is set. If all parameters are set the washing machine can start washing.
During the washing process the program and degree can't be modified. The user can turn off the washing process
which interrupts the washing and resets all parameters (program, degree).
CheckTimer returns the active timer if the washing machine is running, the last set timer if a timer is set or no timer set if no timer is set. 
When the washing program ends the device gets into the Ended state which preserves the program (also the timer) and degree that were previously set.
The user can immediately start washing again or change the parameters and then start washing.


####Dishwasher

The dishwasher must be switched on first. After switching it on, the program can be set. If the user sets this parameter twice
the old parameter gets overwritten by the new one. After setting the program an automatic timer is set. If the program is set the dishwasher can start washing.
During the washing process the program can't be modified. The user can interrupt the washing process which interrupts the washing and resets the program (also the automatic timer).
The dishwasher can be switched off at any time which completely shuts down the device.
CheckTimer returns the active timer if the dishwasher is running, the last set timer if a timer is set or no timer set if no timer is set.
When the program ends the device gets into the Ended state which preserves the program (also the timer) that was previously set.
The user can immediately start washing again or change the program and then start washing.


####Cleaning Robot

The cleaning Robot starts with 100 percent battery. The user can set a timer and after a timer is set he can start cleaning. 
During the cleaning time the user can check the battery status and the percentage of cleaning completion.
When the battery goes to zero or the robot finished cleaning he goes back to the charging base. During the charging time, the user can check battery charging status.
If the robot had to break the cleaning for charging, the user can check the percentage of outstanding cleaning.
After the robot is 100% charged, the robot can finish the outstanding cleaning, if the cleaning was not finished before.
Or a new timer can be set so that the robot can start cleaning again. The robot can end the cleaning and go back to charging base at any time.
This command is also available after charging if the robot didn´t finish the cleaning before charging, if the user doesn´t want that the robot finishes the outstanding cleaning.
