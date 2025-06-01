### What is Cloning in Java?

Cloning in Java is the process of creating an exact copy of an object. It is done using the `clone()` method from the `Object` class. Cloning can be of two types: shallow cloning and deep cloning.

#### Uses of Cloning

- **Copy Objects**: Quickly create a copy of an object without manually copying all fields.
- **Prototyping**: Use prototypes to create objects based on an existing object template.
- **Performance**: Improve performance by reusing objects instead of creating new ones from scratch.
- **State Preservation**: Save the state of an object at a particular point in time and revert to it later if needed.

### Shallow Cloning

- **New Object Creation**: A new object is made.
- **Field Copying**: The fields (variables) of the original object are copied directly to the new object.
- **Reference Fields**: If a field is a reference (points to another object), only the reference (address) is copied.
- **Shared Sub-objects**: Both the original and the cloned object will point to (share) the same sub-objects.

### Deep Cloning

- **New Object Creation**: A new object is made.
- **Field Copying**: All fields of the original object are copied to the new object.
- **Independent Copies**: If a field is a reference, a new copy of the referenced object is also made.
- **Independent Sub-objects**: The new object and the original object do not share sub-objects; each has its own separate copy.

### Example Summary

- **Shallow Clone**: Changes in the sub-object of the clone affect the original.
- **Deep Clone**: Changes in the sub-object of the clone do not affect the original.
