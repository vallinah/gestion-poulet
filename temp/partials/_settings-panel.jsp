<!-- partials/_settings-panel.jsp -->
<div class="settings-panel">
  <h3>Paramètres</h3>
  <form action="enregistrerParametres" method="post">
    <div class="form-group">
      <label for="parametre1">Paramètre 1</label>
      <input type="text" class="form-control" id="parametre1" name="parametre1" value="${parametre1}">
    </div>
    <!-- Ajoutez d'autres champs de paramètres ici -->
    <button type="submit" class="btn btn-primary">Enregistrer</button>
  </form>
</div>
