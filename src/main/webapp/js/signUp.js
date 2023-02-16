import formValidation from "./formValidation.js"

const accountInput = document.querySelector('input[name="account"]');
const passwordInput = document.querySelector('input[name="password"]');
const passwordConFirmInput = document.querySelector('input[name="passwordConfirm"]');
const nameInput = document.querySelector('input[name="name"]');
const emailInput = document.querySelector('input[name="email"]');

function onAccountInput(event){
  console.log("start");
  let newValid = new formValidation(accountInput,5,9,/^[a-z0-9]*$/);
  newValid.isValidate(event.target.value);
}


accountInput.addEventListener("change",onAccountInput);

// export default init;