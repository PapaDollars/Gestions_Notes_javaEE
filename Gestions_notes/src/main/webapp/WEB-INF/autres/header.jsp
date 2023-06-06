
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <!-- Bootstrap 5 CSS -->
  <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css'>
  <!-- Font Awesome CSS -->
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css'>
  <!-- Google Fonts -->
  <link rel='stylesheet' href='https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@400;700&display=swap'>
  <!-- Bootstrap 5 JS -->
  <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js'></script>

  <title>Header</title>
</head>
<body>
  <section class="fixed-top bg-white">
    <div>
      <div class="container-fluide bg-primary p-2"></div>

    


        <!-- Menu -->
        <div>
          <nav class="navbar navbar-expand-lg navbar-light bg-primary shadow mt-3 p-3">
            <div class="container-fluid">
              <button class="navbar-toggler collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#navbar-content">
                <div class="hamburger-toggle">
                  <div class="hamburger">
                    <span class="navbar-toggler-icon"></span>
                  </div>
                </div>
              </button>
              <div class="collapse navbar-collapse " id="navbar-content">
                <ul class="navbar-nav navbar-expand-lg mr-auto mb-2 mb-lg-0 ">
                  <li class="nav-item bgcategorie">
                    <a class="nav-link active bg-white" aria-current="page" href="/Gestions_notes/">GESTIONS DES NOTES</a>
                  </li>
                <!-- link 1 -->
                  <li class="nav-item text-light">
                    <a class="nav-link text-light" href="/Gestions_notes/ajouter" style="font-size: 100%;">AJOUTER_NOTES</a>
                  </li>
                <!-- link 2 -->
                <li class="nav-item dropdown dropdown-mega position-static pleft">
                  <a class="nav-link text-light" href="/Gestions_notes/modifier" style="font-size: 100%;">MODIFIER_NOTES</a>
                </li>
                <!-- link 5 -->
                <li class="nav-item dropdown dropdown-mega position-static pleft">
                  <a class="nav-link text-warning" href="/Gestions_notes/ajouterEtudiants" style="font-size: 100%;">AJOUTER_ETUDIANTS</a>
                </li>
                <!-- link 5 -->
                <li class="nav-item dropdown dropdown-mega position-static pleft">
                  <a class="nav-link text-warning" href="/Gestions_notes/modifierEtudiants" style="font-size: 100%;">MODIFIER_ETUDIANTS</a>
                </li>
                <!-- link 5 -->
                <li class="nav-item dropdown dropdown-mega position-static pleft">
                  <a class="nav-link text-warning" href="/Gestions_notes/supprimerEtudiants" style="font-size: 100%;">SUPPRIMER_ETUDIANTS</a>
                </li>
                <!-- link 6 -->
                <li class="nav-item dropdown dropdown-mega position-static pleft">
                  <a class="nav-link text-warning" href="/Gestions_notes/ajouterUE" style="font-size: 100%;">AJOUTER_UE</a>
                </li>
                <!-- link 6 -->
                <li class="nav-item dropdown dropdown-mega position-static pleft">
                  <a class="nav-link text-warning" href="/Gestions_notes/modifierUE" style="font-size: 100%;">MODIFIER_UE</a>
                </li>
                <!-- link 6 -->
                <li class="nav-item dropdown dropdown-mega position-static pleft">
                  <a class="nav-link text-warning" href="/Gestions_notes/supprimerUE" style="font-size: 100%;">SUPPRIMER_UE</a>
                </li>
                </ul>
              </div>
            </div>
          </nav>

        </div>
          <!-- Search -->
        <div class="container-fluide ">
          <div class="row align-items-center p-2">
            <div class="col">
	            
            </div>
            <div class="col-2">
            <span>
            	
			</span>

	             <a href="/Gestions_notes/connexion"><button type="button" class="btn btn-danger btn-md">deconnexion</button></a>

            </div>
          </div>
        </div>

    </div>
  </section>
</body>
</html>