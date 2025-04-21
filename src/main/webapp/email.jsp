<i><h2>Sign Up Page</h2></i>

<h4> Basic Information</h4>

<h5><b>Please Enter a Valid Email Address  and Phone Number to Register</b></h5> <br>

<i>${emailEmptyError}</i> <br>
<i>${emailExistsError}</i><br>
<i>${phoneExistsError}</i><br>

<form method="Post" action="${pageContext.request.contextPath}/emailS">

      <label for="email" > Email:</label>

      <input type="email" name="email" id="email"> <br><br>

      <label for="phoneNumber"> Phone Number:</label>

      <input type="tel" name="phoneNumber" id="phoneNumber" required> <br> <br>

      <button type="submit"> Submit</button>

</form>