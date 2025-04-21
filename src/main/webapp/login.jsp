<h2>Login Page</h2>

<form method="post" action="${pageContext.request.contextPath}/loginInfoServlet">
<b><i>${emptyError}</i></b>
 <b><i>${wrongEmailError}</i></b>
 <b><i>${wrongPasswordError}</i></b>

<br>
<label for="email">Email:</label>
<input type="email" name="email" id="email" required>
<br>
<br>
<label for="password">Password:</label>
<input type="password" name="password" id="password" required>
<br>
<button type="submit">Log In</button>
</form>

<a href="${pageContext.request.contextPath}/email.jsp">
<button type="button">Create New Account</button>
</a>


