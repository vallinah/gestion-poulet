      <nav class="sidebar sidebar-offcanvas" id="sidebar">
        <ul class="nav">
          <li class="nav-item">
            <a class="nav-link" href="index.html">
              <i class="icon-grid menu-icon"></i>
              <span class="menu-title">Dashboard</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#form-elements" aria-expanded="false" aria-controls="form-elements">
              <i class="icon-columns menu-icon"></i>
              <span class="menu-title">Insertion</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="form-elements">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"><a class="nav-link" href="getCharge?action=insert">Charge</a></li>
                <li class="nav-item"><a class="nav-link" href="pages\forms\insertCout.jsp">Coût</a></li>
                <li class="nav-item"><a class="nav-link" href="getElevage">Poulet</a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="getCharge?action=list&idElevage=1" aria-expanded="false" aria-controls="tables" data-toggle="collapse">
                <i class="icon-grid-2 menu-icon"></i>
                <span class="menu-title">Résultats</span>
                <i class="menu-arrow"></i>
            </a>
          </li>
        </ul>
      </nav>  