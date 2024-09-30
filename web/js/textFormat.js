document.addEventListener('DOMContentLoaded', function() {
const elements = document.querySelectorAll('.number-format');

elements.forEach((element) => {
    // On récupère le contenu texte de l'élément, et on s'assure que c'est un nombre
    const number = parseFloat(element.textContent);
    
    if (!isNaN(number)) {
    // On formate le nombre avec des espaces entre milliers
    const formattedNumber = number.toLocaleString('fr-FR');
    element.textContent = formattedNumber;
    }
});
});
