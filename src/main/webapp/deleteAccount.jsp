<h2>You Are about to Delete Your Account</h2>
<br>
<h3>Please Enter your Password to Delete Account</h3>
<br>
<i>Once you Delete your account the action cannot be undone</i><br>

<form method="Post" action="${pageContext.request.contextPath}/deleteServlet">

<label for="password1">Password</label>
<input type="password" name="password1" id="password1"><br><br>

<label for="password2">Password</label>
<input type="password" name="password2" id="password2"> <br><br>

    <button type="submit"> Confirm </button><br>

</form>

${emptyError}  ${passwordIncorrect}  ${passwordMismatch}<br>

