class FormValidator {
  constructor(element, regex) {
    this.element = element;
    this.regex = regex;
    this.validation = false;
    this.element.addEventListener('change', (event) => {
      this.validate(event.target.value);
    });
  }

  validate(targetValue) {
    this.validation = this.regex.test(targetValue);
  }
}