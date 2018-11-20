/**
unirest.post("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/cuisine")
.header("X-Mashape-Key", "LXzcPFdd0bmshjIVVfXmEp6yFA50p1qp1zvjsnSJeYk1fA9jro")
.header("X-Mashape-Host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
.header("Content-Type", "application/x-www-form-urlencoded")
.send("ingredientList=3 oz pork shoulder")
.send("title=Pork roast with green beans")
.end(function (result) {
  console.log(result.status, result.headers, result.body);
});


Function Post Classify Cuisine
 */
