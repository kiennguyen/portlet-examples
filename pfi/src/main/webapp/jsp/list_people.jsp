<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2>People</h2>

<c:if test="${not empty list}">
	<table id="people-table" class="bordered-table zebra-striped">
		    <thead>
			    <tr>
			    		<th>Id</th>
							<th>Name</th>
							<th>Address</th>
							<th>Delete</th>
			    </tr>
			  </thead>
		    <tbody>
					<c:forEach var="p" items="${list}">
				    <tr>
								<td><c:out value="${p.id}"></c:out></td>
								<td><c:out value="${p.name}"></c:out></td>
								<td><c:out value="${p.address}"></c:out></td>
								<td><a href="<portlet:actionURL>
														<portlet:param name="action" value="removePeople" />
														<portlet:param name="id" value="${p.id}" />
														</portlet:actionURL>">remove</a></td>
						</tr>
					</c:forEach>
				</tbody>
	</table>
</c:if>
<div>
<a class="btn" href="<portlet:actionURL>
		<portlet:param name="action" value="addPeople" />
	</portlet:actionURL>">Add People</a>
</div>
<br/>
<br/>
<%@ include file="footer.jsp" %>