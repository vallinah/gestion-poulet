<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <title>Votre Application JSP</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Feather Icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.28.0/feather.min.css" rel="stylesheet">
    <!-- Votre CSS personnalisé -->
    <link href="assets/css/styles.css" rel="stylesheet">
</head>

<body>
    <!-- Navbar -->
    <%@ include file="partials/_navbar.jsp" %>

    <div class="container-fluid">
        <div class="row">
            <!-- Sidebar -->
            <%@ include file="partials/_sidebar.jsp" %>
            <!-- Settings Panel -->

            <!-- Main Content -->
            <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
                <!-- Settings Panel Toggle Button -->
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <h1 class="h2">Tableau de Bord</h1>
                    <button class="btn btn-outline-secondary" type="button" data-bs-toggle="offcanvas" data-bs-target="#settingsPanel" aria-controls="settingsPanel">
                        <span data-feather="settings"></span> Paramètres
                    </button>
                </div>
                <!-- Votre contenu principal ici -->
                <p>Bienvenue sur votre application JSP améliorée avec un panneau de paramètres.</p>
            </main>
        </div>
    </div>


    <!-- Footer -->
    <%@ include file="partials/_footer.jsp" %>

    <!-- Bootstrap JS et dépendances -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Feather Icons -->
    <script src="https://unpkg.com/feather-icons"></script>
    <!-- Votre JS personnalisé -->
    <script src="assets/js/scripts.js"></script>
    <script>
        // Initialisation des icônes Feather
        feather.replace();
    </script>
</body>

</html>
