/**
 * Created by Sagar on 3/22/2017.
 */
function User() {
          this.name = "";
          this.life = 100;
          this.giveLife = function giveLife(targetUser) {
                    targetUser.life += 1;
                    console.log(this.name + " just gave 1 life to " + targetUser.name);
          }
}

var Sagar = new User();
var Vikas = new User();

Sagar.name = "Sagar";
Vikas.name = "Vikas";

Sagar.giveLife(Vikas);
console.log("Sagar life: " + Sagar.life);
console.log("Vikas life: " + Vikas.life);

/*Use of prototype to add new properties and functions into User object.
 * These properties and functions will be applied to all the references of user. */

User.prototype.defaultage = 0;
console.log("Sagar defaultage: " + Sagar.defaultage);
console.log("Vikas defaultage: " + Vikas.defaultage);

User.prototype.takeLife = function takeLife(targetUser) {
          console.log(this.name + " just took 3 lives away from " + targetUser.name);
          targetUser.life -= 3;
          console.log(targetUser.name + " life: " + targetUser.life);
}

Sagar.takeLife(Vikas)

/*OUTPUT: 
Sagar just gave 1 life to Vikas
Sagar life: 100
Vikas life: 101
Sagar defaultage: 0
Vikas defaultage: 0
Sagar just took 3 lives away from Vikas
Vikas life: 98
 */
