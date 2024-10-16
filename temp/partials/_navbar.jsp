<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="assets/images/logo.png" alt="Logo" width="30" height="30" class="d-inline-block align-text-top">
            Poulet
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Basculer la navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Accueil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Fonctionnalités</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Tarifs</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
            </ul>
            <form class="d-flex" action="recherche" method="get">
                <input class="form-control me-2" type="search" placeholder="Recherche" aria-label="Recherche" name="query">
                <button class="btn btn-outline-success" type="submit">Recherche</button>
            </form>
        </div>
    </div>
</nav>
