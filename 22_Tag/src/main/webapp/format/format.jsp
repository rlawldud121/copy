
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>format jsp 영역~~</h1>

${a}
<hr>
<fmt:formatNumber value="${a}"></fmt:formatNumber>
<hr>
<fmt:formatNumber value="${a}" type="currency" currencySymbol="$"></fmt:formatNumber>
<hr>
<fmt:formatNumber value="${b}" />
<hr>
<fmt:formatNumber value="${b}" type="percent" />
<hr>
<fmt:formatNumber value="${b}" pattern="0.00000" /> <%--자리차지--%>
<hr>
<fmt:formatNumber value="${b}" pattern="#.#####" /> <%--자리에 없으면 숫자만 표기--%>
<hr>
<fmt:formatNumber value="${b}" pattern="0,00.000"/>
<hr>
<fmt:formatNumber value="${b}" pattern="#,##.###"/>
<hr>
<fmt:formatNumber value="${c}" pattern="#,##.00"/>
<hr>
${d}
<hr>
<fmt:formatDate value="${d}" />
<hr>
<fmt:formatDate value="${d}" type="date" dateStyle="short"/>
<hr>
<fmt:formatDate value="${d}" type="date" dateStyle="long"/>
<hr>
<fmt:formatDate value="${d}" type="time" timeStyle="short"/>
<hr>
<fmt:formatDate value="${d}" type="date" timeStyle="long"/>
<hr>
<fmt:formatDate value="${d}" type="both" dateStyle="short" timeStyle="long"/>
<hr>
<fmt:formatDate value="${d}" type="both" dateStyle="long" timeStyle="short"/>
<hr>
<fmt:formatDate value="${d}" pattern="yyyy-MM-dd / hh:mm" />
<hr>
<c:forEach items="${snacks}" var="snack" varStatus="st">
    <div>
    ${st.count}
    ${snack.name}
    <fmt:formatNumber value="${snack.price}" pattern="₩#,###.00" ></fmt:formatNumber>
    <fmt:formatDate value="${snack.date}" pattern="yyyy-MM-dd"></fmt:formatDate>
    </div>


</c:forEach>






</body>
</html>
