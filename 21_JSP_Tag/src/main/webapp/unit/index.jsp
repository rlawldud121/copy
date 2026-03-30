<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Unit Conversion</title>


</head>

<body>

<div class="card">

    <h1>Unit Converter</h1>

    <form action="unit" method="post">

        <input type="number" name="vals" placeholder="숫자를 입력하세요" required
               min="0" step="any"> <select name="unit">
        <option value="cm">cm → inch</option>
        <option value="mm">㎡ → 평</option>
        <option value="cc">℃ → ℉</option>
        <option value="km">km/h → mi/h</option>
    </select>

        <button>변환하기</button>

    </form>

</div>

</body>
</html>