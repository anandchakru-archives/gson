# gson
Gson SubType Serialize/DeSerialize Example

## Execution
Open `com.rathnas.main.GsonSerializer`
Run As -> Java Application

## Sample Output
```
Ser Dog: {
  "legs": 4,
  "wings": 0,
  "name": "Dog",
  "noise": {
    "noise": "barking",
    "type": "com.rathnas.vo.sub.nested.Barking"
  },
  "type": "com.rathnas.vo.sub.Animal"
}
Des Dog: Animal [legs=4, wings=0, noise=NestedAbstractClass [noise=barking]]



Ser Bird: {
  "legs": 1,
  "wings": 2,
  "name": "Bird",
  "noise": {
    "noise": "chirping",
    "type": "com.rathnas.vo.sub.nested.Chirping"
  },
  "type": "com.rathnas.vo.sub.Bird"
}
Des Bird: Bird [legs=1, wings=2, noise=NestedAbstractClass [noise=chirping]]

```
