/**
 * Created by Sagar on 3/22/2017.
 */
function placeAnOrder(ordernumber) {
    console.log("Order number: ", ordernumber);

    cookAndDeliverFood(function () {
        console.log("Delivering order: ", ordernumber);
    });
}
    function cookAndDeliverFood(callback) {
        setTimeout(callback, 5000);
    }

//Simulate users web request
    placeAnOrder(1);
    placeAnOrder(2);
    placeAnOrder(3);
    placeAnOrder(4);
    placeAnOrder(5);
    placeAnOrder(6);
