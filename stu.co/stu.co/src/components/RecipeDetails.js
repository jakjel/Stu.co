import React, {useState} from "react";
import Counter from "../components/Counter";
import RecipesService from "../services/Service";

export default function RecipeDetails(props) {

    //here i need a function getAllIngredientByRecipeID
    const retrieveAllIngredientsByRecipeId = () => {
        RecipesService.getAllIngredientsByRecipeId(props.recipe.id)
            .then(response => {
                setIngredients(response.data.ingredients);
                }
            )
        .catch(err => {
            setIngredients([]);
            }
        );
    };
    // const [ingredients, setIngredients] = useState(props.recipe.ingredients);
    const [amount, setAmount] = useState(props.recipe.amount_of_people);
    const [ingredients, setIngredients] = useState(retrieveAllIngredientsByRecipeId);

    const updateAmount = (newAmount) =>{
        setAmount(newAmount);
    }

    //counts total price of all ingredients
    // const grandTotal = ingredients.reduce((total, ingredient) => (
    //     total + ingredient.price * amount
    // ),0).toFixed(2); 

    return (
            <div className='ingredients-container'>
                <h1>{props.recipe.title}</h1>
                <hr/>
                <h2><i>Description</i></h2>
                <p>{props.recipe.description}</p>
            <table>
                <thead>
                    <tr>
                    <th>
                        Ingredient
                    </th>
                    <th>
                        Price
                    </th>
                    <th>
                        Amount/Unit
                    </th>
                </tr>
                </thead>
                <tbody>{ingredients && ingredients.map(consistance1 => (
                    <tr key={consistance1.id}>
                        <td>
                        {consistance1.name_of_ingredient}
                    </td>
                    <td>
                         {consistance1.price}€💸
                    </td>
                    <td>
                        {consistance1.amount_unit}
                    </td>
                </tr>    
                ))}</tbody> 
            </table>
            
            {/* <h2 className="total-price">{grandTotal}€💸</h2> */}
            <Counter amountOfPeople={props.recipe.amount_of_people} updateAmount={updateAmount}/>
            </div>
    )
}