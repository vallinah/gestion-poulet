<%@page import="model.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
        <div class="content-wrapper">
          <div class="row">
            <div class="col-12 grid-margin">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Insertion Charges</h4>
                  <form class="form-sample">
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
                            <input type="number" name="unité_oeuvre" class="form-control" />
                          </div>
                        </div>
                      </div>
                    </div>
                      <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">TYpe charge</label>
                          <div class="col-sm-9">
                            <select name="id_type_charge" class="form-control">
                            <% 
                                List<Client> clients = (List<Client>) request.getAttribute("clients");
                                if (clients != null && !clients.isEmpty()) {
                                    for (int i = 0; i < clients.size(); i++) { 
                                        Client client = clients.get(i);
                            %>
                              <option value="">Directe</option>
                              <option value="">Indirecte</option>
                            <% %>
                            </select>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group row">
                          <label name="" class="col-sm-3 col-form-label">Charges</label>
                          <div class="col-sm-9">
                            <select class="form-control">
                              <option>incorporable</option>
                              <option>non incorporable</option>
                              <option>suplétives</option>
                            </select>
                          </div>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Analyse des coûts</label>
                          <div class="col-sm-4">
                            <div class="form-check">
                              <label class="form-check-label">
                                <input type="radio" class="form-check-input" name="" id="membershipRadios1" value="">
                                Variable
                              </label>
                            </div>
                          </div>
                          <div class="col-sm-5">
                            <div class="form-check">
                              <label class="form-check-label">
                                <input type="radio" class="form-check-input" name="" id="membershipRadios2" value="">
                                Fixe
                              </label>
                            </div>
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
                            <input type="number" name="" class="form-control" />
                          </div>
                        </div>
                      </div>
                    </div>
                    
                    <div class="row">
                      <div class="col-md-12">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Transition</label>
                          <div class="col-sm-9">
                            <input type="number" name="" class="form-control" />
                          </div>
                        </div>
                      </div>
                    </div>
                    
                    <div class="row">
                      <div class="col-md-12">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Finition</label>
                          <div class="col-sm-9">
                            <input type="number" name="" class="form-control" />
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
       