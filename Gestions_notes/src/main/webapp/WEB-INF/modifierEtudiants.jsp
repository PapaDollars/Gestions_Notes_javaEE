
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier Etudiants</title>
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

	<div class="mb-5">
		<%@include file="autres/header.jsp" %></div> <br><br>		
		
	<div class="container mt-5">
		<div class="row pt-5" >
		<div class="col">
					<h3>La liste des etudiants</h3>
					<table border="1">
					<tr>
			        	<tr>
			        	<th class="p-3 text-success">
				            <c:out value="MATRICULE" />
				         </th>
				         <th class="p-3 text-success">
				            <c:out value="NOM" />
				         </th>
				         <th class="p-3 text-success">
				            <c:out value="PRENOM" />
				         </th>
				         <th class="p-3 text-success">
				            <c:out value="SEXE" />
				         </th>
				         <th class="p-3 text-success">
				            <c:out value="AGE" />
				         </th>
				         <th class="p-3 text-success">
				            <c:out value="ADRESSE" />
				         </th>
				         <th class="p-3 text-success">
				            <c:out value="TELEPHONE" />
				         </th>
			        	</tr>
			        	
				        <c:forEach var="etudiant" items="${ etudiant }">
			        	<tr>
					          <td class="p-3">
					            <c:out value="${ etudiant.matricule }" />
					          </td>
					          <td class="p-3">
					            <c:out value="${ etudiant.nom }" />
					          </td>
					          <td class="p-3">
					            <c:out value="${ etudiant.prenom }" />
					          </td>
					          <td class="p-3">
					            <c:out value="${ etudiant.sexe }" />
					          </td>
					          <td class="p-3">
					            <c:out value="${ etudiant.age }" />
					          </td>
					          <td class="p-3">
					            <c:out value="${ etudiant.adresse }" />
					          </td>
					          <td class="p-3">
					            <c:out value="${ etudiant.telephone }" />
					          </td>
					          <td class="p-3">
					            	<form method="get" action="ModifierEtudiants" >
							  		<input type="hidden" value="${ etudiant.id_etudiant }" name="id_etudiant"/>
							  			<button type="submit" class="btn btn-primary bold-btn text-white">EDIT</button>
							  		</form>
									
					          </td>
			            </tr>
				        </c:forEach>
		          </table>
			</div>
			<div class="col-4">
				<h3 class="text-primary">Modifier les etudiants</h3>
				
				<div class=" pt-5">
					<form method="post" action="ModifierEtudiants">
					   <div class="form-group">
					      <label for="matricule">Matricule :</label>
					      <input type="text" class="form-control" name="matricule"  id="matricule" value="${ p.matricule }" placeholder="10M1010" required>
					   </div> <br>
					   <div class="form-group">
					      <label for="nom">Nom :</label>
					      <input type="text" class="form-control" name="nom" id="nom" value="${ p.nom }" placeholder="Ali" required>
					   </div> <br>
					   <div class="form-group">
					      <label for="prenom">Prenom :</label>
					      <input type="text" class="form-control" name="prenom" id="prenom" value="${ p.prenom }" placeholder="Baba" required>
					   </div> <br>
					   <div class="form-group">
					      <label for="sexe">Sexe :</label>
					      <input type="text" class="form-control" name="sexe" id="sexe" value="${ p.sexe } "placeholder="masculin" required>
					   </div> <br>
					   <div class="form-group">
					      <label for="sexe">AGE :</label>
					      <input type="text" class="form-control" name="age" value="${ p.age }" id="sexe" placeholder="masculin" required>
					   </div> <br>
					   <div class="form-group">
					      <label for="sexe">ADRESSE :</label>
					      <input type="text" class="form-control" name="adresse"  value="${ p.adresse }" id="sexe" placeholder="masculin" required>
					   </div> <br>
					   <div class="form-group">
					      <label for="sexe">TELEPHONE :</label>
					      <input type="text" class="form-control" name="telephone" id="sexe" value="${ p.telephone }" placeholder="masculin" required>
					   </div> <br>
					  <button type="submit" class="btn btn-primary bold-btn d-block mx-auto fs-5 mt-5 p-2 text-white">Modifier Maintenant</button> 				
					</form>
				</div>
			</div>
			
			
		</div>
	</div>
	

</body>
</html>