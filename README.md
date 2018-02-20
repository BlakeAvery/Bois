# Bois: Vague airline reservation system

An airline reservation system. Idea taken from that one github repo with all the beginning 
program designs.

**What does this do?**

The program should generate a list of flights. You can then do 3 
things: Search for a flight, book a number of seats on a flight, or
print out the list of flights.

**What needs to be fixed?**

Currently, if the flight is not found, the program returns the first
flight in the list. This was not the original behavior. A bug in the
thingy that checked if the flight was found resulted in the program 
returning a generic empty object for everything other than the last
flight in the list. So that's one.

**License**

This program is licensed under the Apache License 2.0. Check the 
LICENSE file for the full text of the license. I may decide to change
the license later. The latest version of the program is always on Github, 
along with the latest license. If you're unsure of the license the 
program is under, check the [BlakeAvery/Bois](https://github.com/BlakeAvery/Bois) repo.