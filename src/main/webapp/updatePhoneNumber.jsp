<h3> Update Phone Number</h3>

<i>${noValidPhoneNumberError}</i>
<i>${phoneNumberRegistred}</i>

<form method="Post" action="${pageContext.request.contextPath}/updatePhoneNumberServlet">

<label for="newPhoneNumber">New Phone Number</label>
<input type="number" name="newPhoneNumber" id="newPhoneNumber" required>

    <button type="submit">Change</button>

</form>

