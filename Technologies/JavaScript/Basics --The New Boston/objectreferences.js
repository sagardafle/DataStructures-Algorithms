/**
 * Created by Sagar on 3/22/2017.
 */

/** Whenever we assign something to an existing object, we just assign the reference to the old obj.
 * If we change something via reference variable, it will be reflected in the original object property.
 * @type {{favFood: string, favMovie: string}}
 */
var Sagar = {
          favFood: "Indian",
          favMovie: "border"
};

var RefToSagar = Sagar;
RefToSagar.favFood = "Chinese";

console.log(RefToSagar.favFood); //Chinese
