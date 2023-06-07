
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
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
		
	<div class="container-fluide mt-5">
		<div class="row p-5" >
		<div class="col mb-5">
				
				<form method="get" action="Acceuil">
						<div class="col-md-5">
							<select class="form-select" aria-label="Default select example">
							  <optgroup label="Codes ue">
							     <c:forEach var="ue"  items="${ ue }">
							     		
									  <option value="${ ue.code_ue }">
									  		<c:out value="${ ue.code_ue }" />
	
									  </option>
						        </c:forEach>
							  </optgroup>
							  
							</select>
						</div>
						<div class="col-md-2">
							<input type="submit" class="btn btn-primary" value="Connecter">
						</div>
							
					</form>
				    
			</div>

			<div class="row">
					<h3>Listes de toutes les notes</h3>
					<table border="1" class="table table-bordered">
				        
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
				            <c:out value="AGE" />
				         </th>
				          <th class="p-3 text-success">
				            <c:out value="ADRESSE" />
				         </th>
				         <th class="p-3 text-success">
				            <c:out value="CODE UE" />
				         </th>
				         <th class="p-3 text-success">
				            <c:out value="NOTES CC" />
				         </th>
				         <th class="p-3 text-success">
				            <c:out value="NOTES TP" />
				         </th>
				         <th class="p-3 text-success">
				            <c:out value="NOTES SN" />
				         </th>
			        	</tr>
				     
				        <c:forEach var="etudiant" items="${ etudiant }">
			        	<tr>
			        		  <td class="p-3">
					             <c:out value="${ etudiant.matricule }"/>
					          </td>
					          <td class="p-3">
					            <c:out value="${ etudiant.nom }"/>
					          </td>
					          <td class="p-3">
					            <c:out value="${ etudiant.prenom }" />
					          </td>
					          <td class="p-3">
					            <c:out value="${ etudiant.age }" />
					          </td>
					          <td class="p-3">
					            <c:out value="${ etudiant.adresse }" />
					          </td>
					          <td class="p-3">
					             <c:out value="${ etudiant.code_ue }" />
					          </td>
					          <td class="p-3">
					             <c:out value="${ etudiant.cc }" />
					          </td>
					          <td class="p-3">
					             <c:out value="${ etudiant.tp }" />
					          </td>
					          <td class="p-3">
					            <c:out value="${ etudiant.sn }" />
					          </td>
					          
			            </tr>
				        </c:forEach>
		          </table>
			</div>
			
			
		</div>
	</div>
	

	
</body>
</html>