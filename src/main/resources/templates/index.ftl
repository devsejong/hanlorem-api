<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>한글로렘입숨</title>

    <!-- Bootstrap -->
    <link rel="stylesheet"
          href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap.min.css">

    <!--[if lt IE 9]>
    <script src="//cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <div class="row">
        <div class="jumbotron">
            <h1>로렘입숨 for 한글</h1>
            <p>로렘 입숨(lorem ipsum; 줄여서 립숨, lipsum)은 출판이나 그래픽 디자인 분야에서 폰트, 타이포그래피,
                레이아웃 같은 그래픽 요소나 시각적 연출을 보여줄 때 사용하는 표준 채우기 텍스트로, 최종 결과물에 들어가는
                실제적인 문장 내용이 채워지기 전에 시각 디자인 프로젝트 모형의 채움 글로도 이용된다. 이런 용도로 사용할 때 로렘
                입숨을 그리킹(greeking)이라고도 부르며, 때로 로렘 입숨은 공간만 차지하는 무언가를 지칭하는 용어로도
                사용된다.</p>
            <p><a class="btn btn-primary btn-lg"
                  href="https://ko.wikipedia.org/wiki/로렘_입숨https://ko.wikipedia.org/wiki/로렘_입숨"
                  role="button" target="_blank">Learn more</a></p>
        </div>
    </div>
    <div class="row">
        <div class="row">
            <div class="col-xs-12">

                <form class="form-inline" id="loremForm">
                    <div class="form-group">
                        <label for="loremType">타입</label>
                        <select class="form-control" id="loremType"
                                name="loremType">
                            <option value="sentence">문장</option>
                            <option value="paragraph">문단</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="size">갯수</label>
                        <select class="form-control" id="loremSize"
                                name="loremSize">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-default">생성</button>
                </form>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-xs-12">
                <textarea class="form-control" rows="10" id="resultTextArea" readonly></textarea>
            </div>
        </div>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script>
    $("#loremForm").on("submit", function (e) {
        e.preventDefault();
        var loremType = $("#loremType").val();
        var url = "/api";
        if (loremType === "sentence") {
            url += "/sentences";
        } else if (loremType === "paragraph") {
            url += "/paragraphs";
        }

        var count = $("#loremSize").val();
        $.get(url, {count: count}, function (data) {
            $("#resultTextArea").val(data.result);
        });
    });
</script>
</body>
</html>