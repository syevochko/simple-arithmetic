<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>

<h2>Simple arithmetic!</h2>

<p>For calculation: <font
        color="green">http://localhost:8080/SimpleArithmetic/SimpleArithmetic/api/calc?x1=12&x2=22</font>

<p>For set expressions: <font color="green">http://localhost:8080/SimpleArithmetic/SimpleArithmetic/api/expression/x1*(x2+x1)</font>

<form action="SimpleArithmetic/api/calc" method="get">
    <p>X1 = <input type="text" name="x1" id="x1"/></p>
    <p>X2 = <input type="text" name="x2" id="x2"/></p>
    <input type="button" value="Calculation" id="btnCalc"/>

    <p>Arithmetic expression: <input type="text" name="expression" id="expression"/></p>
    <input type="button" value="Change expression" id="btnChange"/>
</form>


<script type="text/javascript">

    $('#btnCalc').click(function () {
        var x1 = $('#x1').val();
        var x2 = $('#x2').val();
        if (x1.length == 0 || x2.length == 0) {
            alert("X1 or X2 not defined!");
            return true;
        }

        $.getJSON(
            "SimpleArithmetic/api/calc?x1="+ x1 + "&x2=" + x2,
            function (data) {
                if (data.code == 0) {
                    alert(data.message + data.result.toString());
                } else  {
                    alert(data.status + ": " + data.message);
                }
            }
        );
    });

    $('#btnChange').click(function () {
        var expr = $('#expression').val();
        if (expr.length == 0) {
            alert("Expression not defined!");
            return true;
        }

        $.getJSON(
                "SimpleArithmetic/api/expression/"+ expr,
                function (data) {
                    if (data.code == 0) {
                        alert(data.message);
                    } else  {
                        alert(data.status + ": " + data.message);
                    }
                }
        );
    });

</script>

</body>
</html>
