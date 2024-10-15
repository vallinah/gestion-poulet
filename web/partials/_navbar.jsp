<!-- partials/_navbar.jsp -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">VotreMarque</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Basculer la navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Accueil <span class="sr-only">(actuel)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Fonctionnalité</a>
      </li>
      <!-- Ajoutez d'autres éléments de navigation ici -->
    </ul>
    <form class="form-inline my-2 my-lg-0" action="recherche" method="get">
      <input class="form-control mr-sm-2" type="search" placeholder="Recherche" aria-label="Recherche" name="query">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Recherche</button>
    </form>
  </div>
</nav>
