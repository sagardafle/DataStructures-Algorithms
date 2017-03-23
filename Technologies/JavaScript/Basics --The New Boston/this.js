/**
 * Created by Sagar on 3/22/2017.
 */
var normal = {
          printFirstName: function () {
                    console.log(this === normal); //true.
          }
}
normal.printFirstName(); //returns true as normal is the object that is calling the method.

function globalusage() {
          console.log(this === global); //true
}
globalusage(); //global (main) calls the function.
