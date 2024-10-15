<!DOCTYPE html>
<html lang="fr">

<head>
  <meta charset="UTF-8">
  <title>Votre Application JSP</title>
  <!-- Ajoutez vos liens CSS ici, par exemple Bootstrap -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>
  <div class="container-scroller">
    <!-- Partial: _navbar.jsp -->
    <%@ include file="partials/_navbar.jsp" %>
    <!-- Fin du Partial -->

    <div class="container-fluid page-body-wrapper">
      <!-- Partial: _settings-panel.jsp -->
      <%@ include file="partials/_settings-panel.jsp" %>
      <!-- Fin du Partial -->

      <!-- Partial: _sidebar.jsp -->
      <%@ include file="partials/_sidebar.jsp" %>
      <!-- Fin du Partial -->

      <div class="main-panel">
        <!-- Votre contenu principal ici -->
        <div class="content">
          <h1>Bienvenue sur Gestion de poulet</h1>
          <p>Contenu de la page principale.</p>
        </div>

        <!-- Partial: _footer.jsp -->
        <%@ include file="partials/_footer.jsp" %>
        <!-- Fin du Partial -->
      </div>
      <!-- Fin de main-panel -->
    </div>
    <!-- Fin de page-body-wrapper -->
  </div>
  <!-- Fin de container-scroller -->

  <!-- Ajoutez vos scripts JS ici, par exemple jQuery et Bootstrap -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
