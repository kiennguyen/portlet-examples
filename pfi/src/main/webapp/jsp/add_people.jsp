<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<br>

<portlet:defineObjects />
<portlet:actionURL var="formAction">
	<portlet:param name="action" value="submitPeople" />
</portlet:actionURL>

<form:form commandName="people_form" method="post"
	action="${formAction}" class="well" align="center">
	<label>Name</label>
	<form:input path="name" class="span3" />
	<span class="help-inline"><font style="color: #C11B17;"><form:errors
		path="name" /></font></span>
	
	<label>Address</label>
	<form:input path="address" class="span3" />
	<span><font style="color: #C11B17;"><form:errors
		path="address" /></font></span>
	
	<input value="AddPeople" class="btn"
		style="float: none; padding-right: 10px; padding-left: 10px;"
		type="submit">
</form:form>
