<%@page import="model.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<% 
  List<ChargeAnalytique> chargeAnalytiques = (List<ChargeAnalytique>) request.getAttribute("chargeAnalytiques");
  List<AnalytiqueDesCouts> analytiqueDesCouts = (List<AnalytiqueDesCouts>) request.getAttribute("analytiqueDesCouts");
  List<TypeCharge> typeCharges = (List<TypeCharge>) request.getAttribute("typeCharges");

%>
        <div class="content-wrapper">
          <div class="row">
            <div class="col-12 grid-margin">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Insertion Charges</h4>
                  <form class="form-sample" action="traitementCharge" method="post" enctype="multipart/form-data">
                    <p class="card-description">
                      First
                    </p>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Nom</label>
                          <div class="col-sm-9">
                            <input type="text" name="nom" class="form-control" />
                          </div>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-md-6">
                          <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Prix Unitaire</label>
                            <div class="col-sm-9">
                              <input class="form-control" name="prix_unitaire" type="number"/>
                            </div>
                          </div>
                        </div>
                      <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Unité d'oeuvre</label>
                          <div class="col-sm-9">
                            <input type="text" name="unité_oeuvre" class="form-control" />
                          </div>
                        </div>
                      </div>
                    </div>
                      <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Type charge</label>
                          <div class="col-sm-9">
                            <select name="id_type_charge" class="form-control">
                            <% 
                                for (TypeCharge type : typeCharges) { 
                            %>
                              <option value="<%= type.getId()%>"><%= type.getNom()%></option>
                            <% } %>
                            </select>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group row">
                          <label name="" class="col-sm-3 col-form-label">Charge Analytique</label>
                          <div class="col-sm-9">
                            <select class="form-control" name="id_charge_analytique">
                              <% 
                                for (ChargeAnalytique chargeAnalytique : chargeAnalytiques) { 
                            %>
                              <option value="<%= chargeAnalytique.getId()%>"><%= chargeAnalytique.getNom()%></option>
                            <% } %>
                            </select>
                          </div>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Analyse des coûts</label>
                          <div class="col-sm-4">
                          <select class="form-control" name="id_analytique_coût">
                            <% 
                                for (AnalytiqueDesCouts analytiqueDesCout : analytiqueDesCouts) { 
                            %>
                              <option value="<%= analytiqueDesCout.getId()%>"><%= analytiqueDesCout.getNom()%></option>
                            <% } %>
                            </select>
                          </div>
                        </div>
                      </div>
                    </div>
                    <p class="card-description">
                      Etapes
                    </p>
                    <div class="row">
                      <div class="col-md-12">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Démarage</label>
                          <div class="col-sm-9">
                            <input type="number" name="pourcentage_démarrage" class="form-control" />
                          </div>
                        </div>
                      </div>
                    </div>
                    
                    <div class="row">
                      <div class="col-md-12">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Transition</label>
                          <div class="col-sm-9">
                            <input type="number" name="pourcentage_transition" class="form-control" />
                          </div>
                        </div>
                      </div>
                    </div>
                    
                    <div class="row">
                      <div class="col-md-12">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Finition</label>
                          <div class="col-sm-9">
                            <input type="number" name="pourcentage_finition" class="form-control" />
                          </div>
                        </div>
                      </div>
                    </div>

                    <button type="button" class="btn btn-primary btn-icon-text">
                        <i class="ti-file btn-icon-prepend"></i>
                        Submit
                    </button>
                    
                  </form>
                </div>
              </div>
            </div>
          </div>
       