<h3> Update Address</h3>

<b>${incompleteAddressError}<b>
<form method="Post" action="${pageContext.request.contextPath}/updateAddressServlet">

    <label for="Line_1"> Line 1:</label>
    <input type="text" name="Line_1" id="Line_1"> <br><br>

    <label for="Line_2"> Line 2:</label>
    <input type="text" name="Line_2" id="Line_2"> <br><br>

    <label for="Province"> Province:</label>
    <input type="text" name="Province" id="Province"> <br><br>

    <label for="District">District:</label>
    <input type="text" name="District" id="District"> <br><br>

    <label for="City"> City:</label>
    <input type="text" name="City" id="City"> <br><br>

    <label for="zipCode"> Zip Code:</label>
    <input type="number" name="zipCode" id="zipCode"> <br><br><br>
    <button type="submit">Change</button>

</form>

${addressChangeConfirmation}<br>
<i> ${Line_1}
    ${Line_2}
    ${Province}
    ${District}
    ${City}
    ${zipCode}</i>


