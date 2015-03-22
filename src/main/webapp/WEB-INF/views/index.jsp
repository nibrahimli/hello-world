<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<h2>${message}</h2>

				
 	<c:if test="${not empty listArticle}">
		<table id="contentsTable" class="table table-striped table-condensed tablesorter">
        	<thead>
        		<tr>
        			<th>Id <span></span></th>
        			<th>Title <span></span></th>
        			<th>Resume <span></span></th>
					<th>Text <span></span></th>        			        		
        		</tr>
        	</thead>
        	<tbody>
				<c:forEach items="${listArticle}" var="article" varStatus="status">
					<tr>
						<td>${article.id}</td>	
						<td>${article.title}</td>
						<td>${article.resume}</td>
						<td>${article.text}</td>
					</tr>
				</c:forEach>
				</tbody>
				</table>
				
				</c:if>
				
				
				<a href="<c:url value="/newArticle" />"> Add new Article </a>
