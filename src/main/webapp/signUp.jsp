<i><h2>Sign Up Page</h2></i>

<h4> Basic Information</h4>
<form method="Post" action="${pageContext.request.contextPath}/newUser">

    <i>${basicDetailsError}</i>

<label for="firstName"> First Name:</label>
<input type="text" name="firstName" id="firstName" required> <br><br>

<label for="lastName"> Last Name:</label>
<input type="text" name="lastName" id="lastName" required> <br><br>

<%--<label for="phoneNumber"> Phone Number:</label>--%>
<%--<input type="tel" name="phoneNumber" id="phoneNumber" required> <br> <br><br>--%>

    <h4> Address </h4>              <i>${addressError}</i>
<label for="Line_1"> Line 1:</label>
<input type="text" name="Line_1" id="Line_1" required> <br><br>

<label for="Line_2"> Line 2:</label>
<input type="text" name="Line_2" id="Line_2" > <br><br>

<label for="Province"> Province:</label>
<input type="text" name="Province" id="Province" required> <br><br>

<label for="District">District:</label>
<input type="text" name="District" id="District" required> <br><br>

<label for="City"> City:</label>
<input type="text" name="City" id="City" required> <br><br>

<label for="zipCode"> Zip Code:</label>
<input type="number" name="zipCode" id="zipCode" required> <br><br><br>

    <button type="reset">Reset</button>     <button type="submit"> Submit </button>
    </form>
