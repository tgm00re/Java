<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title Here</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
        <div class="row my-5">
            <h1>Welcome, <c:out value="${user.firstName}"/>!</h1>
            <a href="/logout">logout</a>
        </div>
        <div class="row text-end">
            <a href="/projects/new">Create Project</a>
        </div>
        <div class="row my-5">
            <h3>All Projects</h3>
            <table class="table">
                <thead>
                  <tr>
                    <th scope="col">Project</th>
                    <th scope="col">Team Lead</th>
                    <th scope="col">Due Date</th>
                    <th scope="col">Actions</th>
                  </tr>
                </thead>
                <tbody>
                    <c:forEach items="${projectList}" var="project">
                        <c:if test="${!user.getProjects().contains(project) && !user.getOwnedProjects().contains(project)}">
                            <tr>
                                <td><a href="/projects/view/${project.id}"><c:out value="${project.title}"/></a></td>
                                <td><c:out value="${project.lead.firstName}"/></td>
                                <td><c:out value="${project.dueDate}"/></td>
                                <td>
                                    <a href="/projects/addmember/${project.id}">Join Project</a>
                                </td>
                            </tr>
                        </c:if>
                        
                    </c:forEach>   
                </tbody>
              </table>
        </div>
        <div class="row my-5">
            <h3>Your Projects</h3>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Project</th>
                    <th scope="col">Lead</th>
                    <th scope="col">Due Date</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${projectList}" var="project">
                        <c:if test="${user.getOwnedProjects().contains(project) || user.getProjects().contains(project)}">
                            <tr>
                                <td><a href="/projects/view/${project.id}"><c:out value="${project.title}"/></a></td>
                                <td><c:out value="${project.lead.firstName}"/></td>
                                <td><c:out value="${project.dueDate}"/></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${project.lead.id == user_id}">
                                            <a href="/projects/delete/${project.id}">Delete</a> |
                                            <a href="/projects/edit/${project.id}">Edit</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="/projects/removemember/${project.id}">Leave Project</a>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:if>           
                    </c:forEach>   
                </tbody>
            </table>
        </div>
    </div> <!-- End of Container -->
</body>
</html>