import {FormValidator} from "./formValidator.js";

const titleInput = document.querySelector('input[name="title"]');
const contentInput = document.querySelector('input[name="content"]');
const submitButton = document.querySelector('input[type="submit"]');


const titleValid = new FormValidator(titleInput, /^.{4,30}$/ );
const contentValid = new FormValidator(contentInput, /^.{10,2000}$/);

/**
 * 제출 버튼 클릭시 각 항목 검증 여부 가져와서 확인 후 처리.
 * @param event 이벤트 객체
 */
function onSubmitClick(event){
  const allInputValidList = [titleValid.validation, contentValid.validation];
  for (const valid of allInputValidList){
    if (valid === false){
      alert("정보가 올바르지 않습니다.");
      event.preventDefault();
      return;
    }
  }
}
submitButton.addEventListener("click", onSubmitClick);