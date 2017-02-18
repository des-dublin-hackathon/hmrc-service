<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    Hmrc check success.
    <br/>

Employments:<br/>
    <c:forEach items="${hmrcResult.employments}" var="emp">
        ${emp.employerPayeReference}:  GBP ${emp.payFromEmployment}<br>
    </c:forEach>

    <br/>
    Pensions: GBP ${hmrcResult.pensionsAnnuitiesAndOtherStateBenefits.otherPensionsAndRetirementAnnuities}<br/>
    Incapacity: GBP ${hmrcResult.pensionsAnnuitiesAndOtherStateBenefits.incapacityBenefit}<br/>
    Joseekers: GBP ${hmrcResult.pensionsAnnuitiesAndOtherStateBenefits.jobseekersAllowance}<br/>


    Lets move to next step: <a href="/step4">Continue</a>
</body>
</html>