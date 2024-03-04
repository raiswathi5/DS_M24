<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%= request.getAttribute("doctype") %>

<html>
    <head>
        <title>Interesting Picture</title>
    </head>
    <body>
        <% if (!request.getParameter("searchWord").equalsIgnoreCase("Andy")) { %>
        <% if (request.getAttribute("pictureURL") != null) { %>
        <h1>Here is an interesting picture of a <%= request.getParameter("searchWord")%></h1><br>
        <img src="<%= request.getAttribute("pictureURL")%>"><br><br>
        <% } else { %>
        <h1>An interesting picture of a <%= request.getParameter("searchWord")%> could not be found</h1><br>
        <% } %>
        <% } else { %>
        <%  String andyPic = "https://upload.wikimedia.org/wikipedia/commons/0/09/Andrew_Carnegie%2C_by_Theodore_Marceau.jpg" ;%>
        <h1>Easter EGG: Here is an interesting picture of <%= request.getParameter("searchWord")%></h1><br>
        <% for (int i=1; i<=10;i++) {%>
        <img src="<%= andyPic%>" width="100" height="150"> <%= i%> <br><br>
        <% }%>
        <%}%>
        <form action="getAnInterestingPicture" method="GET">
            <label for="letter">Type another word.</label>
            <input type="text" name="searchWord" value="" /><br>
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>

