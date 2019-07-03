# Raspberry Pi Temperature Sensor

Mobile and Portable temperature sensor using Phidget Sensors. Sensor is attatched to the Raspberry Pi which then wirelessly transmits data back to a remote computer.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

* Raspberry Pi 3 with Raspbian
* Phidget Interface Kit
* Phidget Precision Temperature Sensor ID:1124_0
* External Remote Computer running a Java IDE
* Remote connection software PuTTY and Xming

Install Java 8 on the Raspberry Pi if it is not already installed:

```
sudo apt-get install oracle-java8-jdk
```

### Installing

#### Install the phidget drivers onto the Raspberry Pi. #### 

Instructions: https://www.phidgets.com/?view=articles&article=GetStartedPhidgetsRaspberry

#### Enable SSH on Raspberry Pi. ####

Instructions: https://www.raspberrypi.org/documentation/remote-access/ssh/

Find the IP Address of Raspberry Pi by entering the following code into the Pi Terminal, is located under wlan0 in inet:

```
ifconfig
```
First download the repo and extract it from the .zip file. Open Netbeans and select "Open Project" and choose SensorGraphProject. Change any serial numbers and port numbers in the source code as needed. Connect Netbeans to the Raspberry Pi by setting up a new run profile. Create a new remote platform following this tutorial: https://www.youtube.com/watch?v=ebHbDlTnV-I

#### Test to ensure that the platform is indeed connected, then run Netbeans Project to install the project onto the Pi. ####

Netbeans will run into an expected "X11 display not found" error.

## Running the tests

Open up the Raspberry Pi terminal using PuTTY. Make sure to enable X11 Forwarding and have Xming opened up. Type into PuTTY the following command:

```
cd '/home/pi/NetBeansProjects//SensorGraphProject'; '/usr/lib/jvm/jdk-8-oracle-arm32-vfp-hflt/jre/bin/java'  -Dfile.encoding=UTF-8   -jar /home/pi/NetBeansProjects//SensorGraphProject/dist/SensorGraphProject.jar
```

This will run the Raspberry Pi Temperature Sensor and start up the GUI on the remote computer screen.

## Deployment

Once running press the "Connect to Sensor" button to turn on the Phidget Sensors. Sensor Reading will automatically update with the current temperature. The "Graph" button will take the ongoing data and graph them out on a chart. The X axis represents time in the form of "Seconds from startup" while the Y axis displays temperature in Celcius.

## Built With

* [Java](https://docs.oracle.com/javase/7/docs/api/) - The programming language used
* [Phidget Library](https://www.phidgets.com/docs/Phidgets_Drivers) - Phidget Sensor Drivers
* [Java Charts](http://www.jfree.org/jfreechart/) - Used to generate Graphs
* [Raspberry Pi 3](https://www.raspberrypi.org/products/raspberry-pi-3-model-b/) - Raspberry Pi 3 Model B
