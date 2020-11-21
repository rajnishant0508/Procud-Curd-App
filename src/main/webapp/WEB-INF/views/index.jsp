<html>
<head>
<%@include file="./base.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">

   body{
     margin: 0;
	 padding: 0;
     background: url("https://images.unsplash.com/photo-1493723843671-1d655e66ac1c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80");
     height: 100%;
     width: 100%;
     background-size: cover;
     overflow-x: hidden;
   }
 
</style>

</head>
<body>
     <div class="container mt-3">
         <div class="row">
             <div class="col-md-12">
               <h1 class="text-center mb-3">Welcome to product App</h1>
               <table class="table">
				  <thead class="thead-dark">
				    <tr>
				      <th scope="col">Serial No</th>
				      <th scope="col">Product Name</th>
				      <th scope="col">Product Description</th>
				      <th scope="col">Price</th>
				      <th scope="col">Action</th>
				    </tr>
				  </thead>
				  <tbody>
					  <c:forEach items="${product }" var="p">
					     <tr>
					      <th scope="row">${p.id }</th>
					      <td>${p.name }</td>
					      <td>${p.description }</td>
					      <td>&#x20B9; ${p.price }</td>
					      <td>
					         <a href="delete/${p.id }" ><i class="fa fa-trash fa-2x text-danger" aria-hidden="true"></i></a>
					         <a href="update/${p.id }" ><i class="fa fa-pen-nib fa-2x" aria-hidden="true" style="margin-left:15px;"></i></a>
					      </td>
					    </tr>
					  </c:forEach>
				  </tbody>
				</table>
				<div class="text-center mt-3">
				   <a href="add-product" class="btn btn-outline-success">Add Product</a>
				</div>
             </div>         
         </div>
     </div>
</body>
</html>
