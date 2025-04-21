
<i><h2>Sign Up Page</h2></i>

<h4> Password </h4>
${emptyPasswordError}  <br>

${differentPasswordError}<br><br>

<form method="Post" action="${pageContext.request.contextPath}/passwordS">


<label for="Password">Password </label>
<input type="Password" name="Password" id="Password" required> <br><br>

<label for="confirmPassword">Confirm Password </label>
<input type="Password" name="confirmPassword" id="confirmPassword" required>

    <button type="submit">Confrim</button>  <button type="reset">Reset</button>

</form>