
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>


    </style>
</head>
<body>


<div class="card" style="background-color: ${unit.cardColor}

    <h1>변환 결과</h1>

    <div class="result">

        ${param.vals}
        <span class="${unit.beforeColor}>${unit.before}"></span> →

        ${unit.R}
        <span class="${unit.afterColor}>${unit.after}"></span>

    </div>

    <form action="index.jsp">
        <button>다시 변환하기</button>
    </form>

</div>
</body>
</html>
