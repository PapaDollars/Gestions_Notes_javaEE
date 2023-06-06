
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier ue</title>
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
		<div class="row p-5" >
		<div class="col">
					<h3>Toutes les codes des UE</h3>
		        <table border="1">
		        		<tr>
			        	<th class="p-3 text-success">
				            <c:out value="ID UE" />
				         </th>
				         <th class="p-3 text-success">
				            <c:out value="CODE UE" />
				         </th>
				         <th class="p-3 text-success">
				            <c:out value="CREDIT" />
				         </th>
				         <th class="p-3 text-success">
				            <c:out value="TITRE" />
				         </th>
			        	</tr>
			        	
				        <c:forEach var="ue" items="${ ue }">
			        	<tr>
			        		 <td class="p-2">
					            <c:out value="${ ue.id_ue }" />
					          </td>
					          <td class="p-2">
					            <c:out value="${ ue.code_UE }" />
					          </td>
					          <td class="p-2">
					            <c:out value="${ ue.credit }" />
					          </td>
					          <td class="p-2">
					            <c:out value="${ ue.titre }" />
					          </td>
					          <td>
				          		<form method="get" action="ajouterNote" >
				          		<input type="hidden" value="" name="id_note" />
				          			<button type="submit" class="btn btn-success bold-btn text-white">Modifier</button>
				          		</form>
					          </td>
			            </tr>
				        </c:forEach>
		          </table>
			
			</div>
			<div class="col-2"></div>
			<div class="col-4">
				<h3 class="text-primary">Modifier les UE</h3>
				
				<div class="mt-5 pt-5">
					<form method="post" action="ajouterUE">
					   <div class="form-group">
					      <label for="code_ue">Saisissez le code de l'UE a ajouter...</label>
					      <input type="text" class="form-control" name="code_ue" id="code_ue" placeholder="ict318" required>
					   </div> <br>
					   <div class="form-group">
					      <label for="titre">Titre de l'ue</label>
					      <input type="text" class="form-control" name="titre" id="titre" placeholder="ict318" required>
					   </div> <br>
					   <div class="form-group">
					      <label for="credit">Credit</label>
					      <input type="text" class="form-control" name="credit" id="credit" placeholder="6" required>
					   </div> <br>
					  <button type="submit" class="btn btn-primary bold-btn d-block mx-auto fs-5 mt-5 p-2 text-white">Valider</button> 				
					</form>
					
				</div>
			</div>
			
		</div>
	</div>
	

</body>
</html>