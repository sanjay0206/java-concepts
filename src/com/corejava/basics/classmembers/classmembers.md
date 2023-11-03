Static Variables:
* Shared among all instances of a class.
* Initialized when the class is loaded.
* Only one copy of the static variable that is shared by all instances.
* Associated with the class itself rather than with any specific instance of the class.
* Modifications to static variables affect all instances of the class.

Non-Static (Instance) Variables:
* Unique to each instance of a class.
* Created when an object is created using the 'new' keyword.
* Destroyed when the object is destroyed.
* Each instance of the class has its own copy of the non-static variable.
* Changes made to these variables in one instance do not affect the values of these variables in other instances

How to determine whether any field or method is Static or Non-static?
* Non-Static -> If method or a field that you're creating only makes sense for an individual object or instance of the class
* Static -> If something is more at the class level or something that should be the same or a shared value among all of your class
then it probably makes more sense to be static
