// This file defines a BlueAstronaut, which is a Player and should
// have all attributes of one. Have BlueAstronaut implement the
// Crewmate interface.

// Variables
// All variables must be not allowed to be directly modified outside
// the class in which they are declared, unless otherwise stated in
// the description of the variable. Hint: there is a specific
// visibility modifier that can do this!
//
// The Blue class must have these variables. Do NOT redeclare any
// instance variables created in the Player class
//
// numTasks - the number of tasks that needs to be completed as an
// integer number
//
// taskSpeed - the speed at which the astronaut is completing each
// task as a positive, nonzero integer number

//Constructors
// A constructor that takes in the name, susLevel, numTasks, and
// taskSpeed and sets all fields accordingly. It must accept the
// variables in the specified order.
// A constructor that takes in just a name and assigns the following
// default values:
// susLevel: 15
// numTasks: 6
// taskSpeed: 10

// Methods
// Do not create any other methods than those specified. Any extra
// methods will result in point deductions. All methods must have the
// proper visibility to be used where it is specified they are used.
//
// emergencyMeeting()
// A Player that is frozen cannot call an emergency meeting.
// Holds a meeting and votes out (freezes) the most suspicious
// individual of the Player objects, only considering Players that are
// not frozen
// The player that has the highest susLevel will be accused of being
// the impostor and will be voted off (This could be them!)
// If two players have the same highest susLevel, no player will be
// voted off.
// Hint: think of an easy way to do this without having to iterate
// through the entire array. Check the Java API for Arrays for a
// method you can use.
// Make sure to change the frozen variable of the player to true when
// voting off players (don’t call freeze!)
// At the end of the vote, check if the game is over using the
// provided method in Player.java
// Does not return anything
//
// completeTask()
// A BlueAstronaut that is frozen cannot complete tasks.
// If taskSpeed is greater than 20, subtract 2 from numTasks.
// Otherwise, subtract 1 from numTasks.
// If numTasks falls below 0, set it to 0
// After BlueAstronaut is done with their tasks, meaning numTasks is
// equal to 0 (only for the first time),
// Print out “I have completed all my tasks”
// Then reduce BlueAstronaut’s susLevel by 50% (round down)
// Does not return anything.
//
// equals(Object o)
// Two BlueAstronauts are equal if they both have the same name,
// frozen, susLevel, numTasks, and taskSpeed
// Returns a boolean
//
// toString() - returns a String describing BlueAstronaut as follows:
// "My name is [name], and I have a suslevel of [susLevel]. I am
// currently (frozen / not frozen). I have [numTasks] left over.”
// If susLevel is greater than 15, return the String in all capital
// letters.
// (Note: replace the values in brackets [] with the actual value)
// You must use the toString() method from the Player class to receive
// full credit.
//
// Getters and Setters as necessary.

public class BlueAstronaut {

}
