<%--
  Created by IntelliJ IDEA.
  User: Avinash Niyaz
  Date: 2/20/2025
  Time: 12:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>account</title>
</head>
<body>
<h1>Account Details</h1>

<h3>Basic Information</h3>

<b>Email:</b> <i>${email}</i> <br> <br>

<b>First Name:</b>  <i>${firstName}</i> <br> <br>

<b>Last Name:</b> <i> ${lastName}</i> <br> <br>

<b>Phone Number:</b> <i> ${phoneNumber}</i>  <a href="${pageContext.request.contextPath}/updatePhoneNumber.jsp"><button type="button">Update</button></a>    <br> <br>

<b>Address:</b>  <i> ${Line1}
                     ${Line2}
                     ${Province}
                     ${District}
                     ${City}
                     ${zipCode}
                          </i> <a href="${pageContext.request.contextPath}/updateAddress.jsp"><button type="button">Update</button></a><br><br>

${updateConfirmation}

<p>
    ${Add_change}
    <i>
        ${Old_Line_1}
        ${Old_Line_2}
        ${Old_Province}
        ${Old_District}
        ${Old_City}
        ${Old_zipCode}
    </i>
        ${to}

        <i> ${New_Line1}
            ${New_Line2}
            ${New_Province}
            ${New_District}
            ${New_City}
            ${New_zipCode}
        </i>
</p>

<a href="${pageContext.request.contextPath}/deleteAccount.jsp"> <button type="button"> DELETE ACCOUNT</button></a><br>

</body>

</html>
