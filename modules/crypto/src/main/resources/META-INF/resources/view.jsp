<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="cryptoporlet.caption"/></b>
</p>

<h1> Crypto </h1>
<h1>Message: ${message}</h1>

<liferay-portlet:actionURL var="processActionURL">

</liferay-portlet:actionURL>

<aui:form action="${processActionURL}">
	<aui:input name="firstName" type="text" required="true" placeholder="input-first-name" />
	<aui:input name="age" type="number" />
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
	
	<c:if test="${messageResponse != null}">
		<h2>${messageResponse}</h2>
	</c:if>
</aui:form>