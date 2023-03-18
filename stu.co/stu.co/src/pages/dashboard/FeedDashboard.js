import React, { useState, useEffect } from "react";
import RecipesService from "../../services/Service";
import RecipesVideosList from "../../components/RecipesVideosList";
import SearchBar from "../../components/SearchBar";
import myLogo from "../../images/stuco-logo.png";
import NavBar from "../../components/NavBar";
import NavbarTop from "../../components/NavBarTop";
import { useNavigate } from "react-router-dom";
import AuthService from "../../services/AuthService";


export default function FeedDashboard() {
   let navigate = useNavigate();

  const [notFound, setNotFound] = useState(false);
  const [ingredient, setIngredient] = useState("");
  const [recipes, setRecipes] = useState([]);

  const retrieveRecipesWithSearchedIngredient = (ingredient) => {
    RecipesService.getAllWithIngredient(ingredient)
      .then(response => {
        setRecipes(response.data.recipes);
      }
      )
      .catch(err => {
        if(err.response.status === 404){
          setNotFound(true);
          setRecipes([]);
        }
      }
      );
  };

  useEffect(() => {
    if (ingredient !== "") {
      retrieveRecipesWithSearchedIngredient(ingredient);
    }
    else {
      retrieveRecipes();
    }
  }, [ingredient]);

  //retrieves all recipes
  const retrieveRecipes = async () => {
    await RecipesService.getAll()
      .then(response => {
        setNotFound(false);
        setRecipes(response.data.recipes); //dulezity rict recipes!!! jinak array inside of an array
      })
      .catch(err => {
        if(err.response.status === 403){
          navigate("/unauthorized");
        }else if(err.response.status === 0){
          // should be changed
          AuthService.logout();
          navigate("/");
        }
      });
  };

  //this one is sent to child component and from there sets value of ingredient
  const textChangedIngredient = e => {
    setIngredient(e.target.value);
  }
    return (
      <div>
        <NavbarTop />
        <img className="logo" src={myLogo} alt="logo" />
        <h1 className="heading">Feed🎥</h1>
        <SearchBar textChanged={textChangedIngredient} text={"Search for ingredience..."} />
        {
          notFound? <p className="no-results">Sorry, we couldn't find any results</p> : <RecipesVideosList recipes={recipes} />
        }
        <NavBar />
      </div>
    )
  }
