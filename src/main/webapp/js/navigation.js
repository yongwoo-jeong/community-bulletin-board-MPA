const allAnchor = document.querySelectorAll('a.nav__anchor');
const currentPath = window.location.pathname;

allAnchor.forEach(element => {
  if (element.getAttribute("href") === currentPath){
    element.style.color ="red";
  }
})

