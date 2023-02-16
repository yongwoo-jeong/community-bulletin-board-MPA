/**
 * 유저 입력값 검증을 위한 클래스
 */
class FormValidation{
  /**
   * 생성자
   * @param targetNode 타겟이 되는 HTML 엘리먼트 노드
   * @param maxLength 문자열 최대 길이
   * @param minLength 문자열 최소 길이
   * @param regex 정규식
   */
  constructor(targetNode, maxLength, minLength ,regex) {
    this.targetNode = targetNode.parentNode;
    this.maxLength = maxLength;
    this.minLength = minLength;
    this.regex = regex;
  }

  /**
   * 폼 검증
   * @param formValue event.target.value
   */
  isValidate(formValue){
    if (formValue){
      if (formValue.length < this.minLength || formValue.length > this.maxLength || !this.regex.test(formValue)){
        const newElement = document.createElement("span");
        newElement.innerText = '형식 불일치';
        newElement.style.color = 'red';
        this.targetNode.appendChild(newElement);
      }
    }
  }
}

export default FormValidation;