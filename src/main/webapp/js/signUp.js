import formValidation from "./formValidation.js"

const accountInput = document.querySelector('input[name="account"]');
const passwordInput = document.querySelector('input[name="password"]');
const passwordConfirmInput = document.querySelector('input[name="passwordConfirm"]');
const nameInput = document.querySelector('input[name="name"]');
const emailInput = document.querySelector('input[name="email"]');

let accountValid = new formValidation(accountInput,/^[a-z0-9]{5,9}$/);
let passwordValid = new formValidation(passwordInput,  /^[a-z0-9`~!@#$%^&*()-_=+]{6,15}$/);
let passwordConfirmValid = new formValidation(passwordConfirmInput, /^[a-z0-9`~!@#$%^&*()-_=+]{6,15}$/);
let nameValid = new formValidation(nameInput, /^[ㄱ-ㅎ|가-힣]{3,4}$/);
let emailValid = new formValidation(emailInput, /^[-0-9A-Za-z!#$%&'*+/=?^_`{|}~.]+@[-0-9A-Za-z!#$%&'*+/=?^_`{|}~]+[.][0-9A-Za-z]/);

/**
 * 아이디 인풋 이벤트핸들러
 * @param event
 */
function onAccountChange(event){
  accountValid.isValidate(event.target.value);
}

/**
 * 비밀번호 이벤트핸들러
 * @param event
 */
function onPasswordChange(event){
  passwordValid.isValidate(event.target.value);
}

/**
 * 비밀번호 확인 이벤트핸들러
 */
function onPasswordConfirmChange(event){
  passwordConfirmValid.isValidate(event.target.value)
}

/**
 * 이름 이벤트핸들러
 * @param event
 */
function onNameChange(event){
  nameValid.isValidate(event.target.value)
}

/**
 * 이메일 이벤트핸들러
 * @param event
 */
function onEmailChange(event){
  emailValid.isValidate(event.target.value)
}

// 각 input 이벤트리스너 등록
accountInput.addEventListener("change",onAccountChange);
passwordInput.addEventListener("change", onPasswordChange);
passwordConfirmInput.addEventListener("change", onPasswordConfirmChange);
nameInput.addEventListener("change", onNameChange);
emailInput.addEventListener("change", onEmailChange);
