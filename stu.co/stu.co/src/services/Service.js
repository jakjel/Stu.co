import http from "../http-common";

const get = id => {
  return http.get(`/recipes/${id}`, {headers: {Authorization: `Bearer ${localStorage.getItem('user')}`}});
};
const getAll = () => {
  return http.get(`/recipes/all`, {headers: {Authorization: `Bearer ${localStorage.getItem('user')}`}});
};
const getAllWithIngredient = (ingredient) => {
  return http.get(`/recipes/all/${ingredient}`, {headers: {Authorization: `Bearer ${localStorage.getItem('user')}`}});
};
const getAllUsers = () => {
  return http.get(`/users/all`, {headers: {Authorization: `Bearer ${localStorage.getItem('user')}`}});
};
const getUserById = (id) => {
  return http.get(`/users/${id}`, {headers: {Authorization: `Bearer ${localStorage.getItem('user')}`}});
}
const getAllWithUsername = (username) => {
  return http.get(`/users/all/${username}`, {headers: {Authorization: `Bearer ${localStorage.getItem('user')}`}});
};
const getAllIngredientsByRecipeId = (recipeId) => {
  return http.get(`/recipes/ingredients/${recipeId}`, {headers: {Authorization: `Bearer ${localStorage.getItem('user')}`}})
};
const signUp = (data) => {
  const response = http.post('/users', (data));
  return response;
}
const getGroupsByUserId = (userId) => {
  return http.get(`/expenses/groups/${userId}`, {headers: {Authorization: `Bearer ${localStorage.getItem('user')}`}})
}
const getExpensesByGroupId = (groupId) => {
  return http.get(`/expenses/${groupId}`, {headers: {Authorization: `Bearer ${localStorage.getItem('user')}`}});
}
const createGroup = (data) => {
  const response = http.put(`expenses/groups`, (data), {headers: {Authorization: `Bearer ${localStorage.getItem('user')}`}});
  return response;
}
const createExpense = (data) => {
  const response = http.put(`/expenses`, (data), {headers: {Authorization: `Bearer ${localStorage.getItem('user')}`}});
  return response;
}



const RecipesService = {
    get,
    getAll,
    getAllWithIngredient,
    getAllUsers,
    getAllWithUsername,
    getAllIngredientsByRecipeId,
    getUserById,
    signUp,
    getGroupsByUserId,
    getExpensesByGroupId,
    createGroup,
    createExpense
  };
export default RecipesService;