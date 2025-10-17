<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Reports App</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet" crossorigin="anonymous">
</head>
<body>

	<div class="container mt-4">
		<h3 class="pb-3 pt-3">Report Application</h3>

		<!-- Spring Form -->
		<form:form modelAttribute="search" action="search" method="post">
			<div class="row mb-3">
				<div class="col-md-4">
					<label>Plan Name:</label>
					<form:select path="planName" cssClass="form-select">
						<form:option value="">-Select-</form:option>
						<form:options items="${names}" />
					</form:select>
				</div>

				<div class="col-md-4">
					<label>Plan Status:</label>
					<form:select path="planStatus" cssClass="form-select">
						<form:option value="">-Select-</form:option>
						<form:options items="${statuses}" />
					</form:select>
				</div>

				<div class="col-md-4">
					<label>Gender:</label>
					<form:select path="gender" cssClass="form-select">
						<form:option value="">-Select-</form:option>
						<form:option value="Male">Male</form:option>
						<form:option value="Female">Fe-Male</form:option>
					</form:select>
				</div>
			</div>

			<div class="row mb-3">
				<div class="col-md-6">
					<label>Start Date:</label>
					<form:input path="startDate" type="date" cssClass="form-control" />
				</div>
				<div class="col-md-6">
					<label>End Date:</label>
					<form:input path="endDate" type="date" cssClass="form-control" />
				</div>
			</div>

			<div class="row mb-3">
				<div class="col-md-12">
				<td><a href="/" class="btn btn-secondary">Reset</a></td>
					<input type="submit" value="Search" class="btn btn-primary">
				</div>
			</div>
		</form:form>

		<hr />
		<table class="table table-striped tale-hover">
			<thead>
				<tr>
					<th>S/N:</th>
					<th>Holder Name:</th>
					<th>Gender:</th>
					<th>Plan Name:</th>
					<th>Plan Status:</th>
					<th>Start Date:</th>
					<th>End Date:</th>
					<th>Benefit Amt:</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${plans}" var="plan" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${plan.citizenName}</td>
						<td>${plan.gender}</td>
						<td>${plan.planName}</td>
						<td>${plan.planStatus}</td>
						<td>${plan.planStartDate}</td>
						<td>${plan.planEndDate}</td>
						<td>${plan.benefitAmt}</td>
					</tr>
				</c:forEach>
				<tr>
				<c:if test="${empty plans}">
				 <td colspan="8" style="text-align: center">No Record Found</td>
				</c:if>
				</tr>

			</tbody>
		</table>

		<div class="mt-3">
    <h5>Export :</h5>
    <a href="${pageContext.request.contextPath}/excel" class="btn btn-outline-success me-2">Export Excel</a>
    <a href="${pageContext.request.contextPath}/pdf" class="btn btn-outline-danger">Export PDF</a>
</div>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
</body>
</html>
