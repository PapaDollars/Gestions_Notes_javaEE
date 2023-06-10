
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
  <!-- Bootstrap 5 CSS -->
  <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css'>
  <!-- Font Awesome CSS -->
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css'>
  <!-- Google Fonts -->
  <link rel='stylesheet' href='https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@400;700&display=swap'>
  <!-- Bootstrap 5 JS -->
  <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js'></script>
  
</head>
<body>
	
	<div class="mb-5"></div> 

	<div class="container">
		<div class="row p-5" >
			<div class="col-4">
				<img alt="" class="bg-info" src="https://swiver.io/wp-content/uploads/2022/04/TVA-deductible-TD.webp" width="1200px" height="800px" />
			</div>
			<div class="col-4">
				
				<div class="mt-5 p-5 bg-white">
					<h3 class="mb-5 text-primary">Se connecter</h3>
					
					<form method="post" action="seconnecter">
					  <div class="form-group">
					    <label for="adresse">Adresse email</label>
					    <input type="email" class="form-control" id="adresse" name="username" aria-describedby="emailHelp" placeholder="Enter email" />
					  </div> <br>
					  <div class="form-group">
					    <label for="password">Mot de passe</label>
					    <input type="password" class="form-control" name="password" id="password" placeholder="******" />
					  </div>
					  <button type="submit" class="btn btn-primary text-light d-block mx-auto bold-btn fs-5 mt-5 p-2">connexion</button>
					</form>
					<c:if test="${ !empty form.resultat }"><p class="text-secondary"><c:out value="${form.resultat}" /></p></c:if>
				</div>
			</div>	
			
		</div>
	</div>
</body>
</html>