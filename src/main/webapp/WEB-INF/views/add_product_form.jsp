<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp" %>
</head>
<body>
   <div class="container">
      <div class="row">
        <div class="col-md-6 offset-md-3">
          <h1>Fill the Product Details</h1>
          <form action="handle-product" method="post">
              
              <div class="form-group">
			    <label for="exampleInputEmail1">Enter Product Name</label>
			    <input type="text" name="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">

			  </div>
			  
			  <div class="form-group">
			    <label for="exampleFormControlTextarea1">Product Description</label>
			    <textarea name="description" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
			  </div>
			  
			  <div class="form-group">
			    <label for="exampleInputEmail1">Enter Product Price</label>
			    <input type="text" name="price" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">

			  </div>
			  
			  <div class="text-center">
			     <a href="${pageContext.request.contextPath }/" class="btn btn-outline-danger">Back</a>
			     <button type="submit" class="btn btn-primary">Add</button>
			  </div>
          
          </form>
        </div>
      </div>
   </div>
</body>
</html>