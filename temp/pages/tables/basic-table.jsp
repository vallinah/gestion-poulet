<%@page import="model.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="util.*"%>
<% 
  List<Charge> charges = (List<Charge>) request.getAttribute("charges");
  double chiffre = Double.parseDouble(request.getAttribute("idElevage"));
  double variable = Double.parseDouble(request.getAttribute("idElevage"));
  double fixe = Double.parseDouble(request.getAttribute("idElevage"));
  double marge = Double.parseDouble(request.getAttribute("idElevage"));
                        

%>

<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Skydash Admin</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="../../vendors/feather/feather.css">
  <link rel="stylesheet" href="../../vendors/ti-icons/css/themify-icons.css">
  <link rel="stylesheet" href="../../vendors/css/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- Plugin css for this page -->
  <link rel="stylesheet" href="../../vendors/datatables.net-bs4/dataTables.bootstrap4.css">
  <link rel="stylesheet" href="../../vendors/ti-icons/css/themify-icons.css">
  <link rel="stylesheet" type="text/css" href="js/select.dataTables.min.css">
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="css/vertical-layout-light/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="images/favicon.png" />
</head>
<body>
  <div class="container-scroller">
    <!-- partial:../../partials/_navbar.html -->
    <%@include file="../../partials/_navbar.jsp"%>
    <!-- partial -->

    <div class="container-fluid page-body-wrapper">
      <!-- partial:../../partials/_settings-panel.html -->
      <%@include file="../../partials/_settings-panel.jsp"%>
      <!-- partial -->

      <!-- partial:../../partials/_sidebar.html -->
      <%@include file="../../partials/_sidebar.jsp"%>
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
          <div class="row">
            <div class="col-lg-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Resultats</h4>
                  <div class="table-responsive">
                    <table class="table">
                      <thead>
                        <tr>
                          <th>Type</th>
                          <th>Valeur</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>Chiffre d'affaire</td>
                          <td class="number-format"><%= chiffre%></td>
                        </tr>
                        <tr>
                          <td>Coût variable</td>
                          <td class="number-format"><%=variable %></td>
                        </tr>
                        <tr>
                          <td>Coût fixe</td>
                          <td class="number-format"><%= fixe%></td>
                        </tr>
                        <tr>
                          <td>Marge Global</td>
                          <td class="number-format"><%= marge%></td>
                        </tr>
                        <%-- <tr>
                          <td>Seuil de rentabilité</td>
                          <td class="number-format">53275533</td>
                        </tr> --%>
                      </tbody>
                    </table>
                  </div>
                </div>

                <div class="card-body">
                  <h4 class="card-title">Resultats</h4>
                  <p class="card-description">
                    Aujourd'hui
                  </p>
                  <div class="table-responsive">
                    <h2>Tableau Exemple</h2>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th class="rubriques">RUBRIQUES</th>
                                <th>TOTAL</th>
                                <th>UNITE D'OEUVRE</th>
                                <th>NATURE</th>
                                <th colspan="3">DEMARRAGE</th>
                                <th colspan="3">TRANSITION</th>
                                <th colspan="3">FINITION</th>
                            </tr>
                            <tr>
                                <th></th>
                                <th></th>
                                <th></th>
                                <th></th>
                                <th>%</th>
                                <th>FIXE</th>
                                <th>VARIABLE</th>
                                <th>%</th>
                                <th>FIXE</th>
                                <th>VARIABLE</th>
                                <th>%</th>
                                <th>FIXE</th>
                                <th>VARIABLE</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="rubriques">ACHAT SEMENCES</td>
                                <td class="number-format">4321600</td>
                                <td>KG</td>
                                <td>V</td>
                                <td>0.00%</td>
                                <td></td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td class="rubriques">ACHAT ENGRAIS & ASSIMILES</td>
                                <td class="number-format">60000000</td>
                                <td>KG</td>
                                <td>V</td>
                                <td>0.00%</td>
                                <td></td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td class="rubriques">ACHAT EMBALLAGE</td>
                                <td class="number-format">7796400</td>
                                <td>NB</td>
                                <td>V</td>
                                <td>0.00%</td>
                                <td></td>
                                <td>-</td>
                            </tr>
                            <!-- Ajoute plus de lignes ici si nécessaire -->
                        </tbody>
                    </table>
                    
                  </div>
                </div>

              </div>
            </div>

          </div>
        </div>
        <%@include file="../../partials/_footer.jsp"%>
        <!-- partial -->
      </div>
      <!-- main-panel ends -->
    </div>   
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->

  <!-- plugins:js -->
  <script src="../../vendors/js/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page -->
  <script src="../../vendors/chart.js/Chart.min.js"></script>
  <script src="../../vendors/datatables.net/jquery.dataTables.js"></script>
  <script src="../../vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
  <script src="js/dataTables.select.min.js"></script>

  <!-- End plugin js for this page -->
  <!-- inject:js -->
  <script src="js/off-canvas.js"></script>
  <script src="js/hoverable-collapse.js"></script>
  <script src="js/template.js"></script>
  <script src="js/settings.js"></script>
  <script src="js/format.js"></script>
  <script src="js/todolist.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <script src="js/dashboard.js"></script>
  <script src="js/Chart.roundedBarCharts.js"></script>
  <!-- End custom js for this page-->
</body>

</html>

